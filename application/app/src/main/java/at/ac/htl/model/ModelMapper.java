package at.ac.htl.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.concurrent.CompletionException;

public class ModelMapper<T> {
    ObjectMapper mapper = new ObjectMapper();
    Class<? extends T> clazz;

    public ModelMapper(Class<? extends T> clazz) {
        this.clazz = clazz;
    }
    public byte[] toResource(T model) {
        try {
            return mapper.writeValueAsBytes(model);
        } catch (JsonProcessingException e) {
            throw new CompletionException(e);
        }
    }
    public T fromResource(byte[] bytes) {
        try {
            return mapper.readValue(bytes, clazz);
        } catch (IOException e) {
            throw new CompletionException(e);
        }
    }
    public T clone(T model) {
        return fromResource(toResource(model));
    }
}

package at.ac.htl.model;

import java.util.function.Consumer;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.rxjava3.subjects.BehaviorSubject;

@Singleton
public class Store {
    ModelMapper<Model> mapper;
    @Inject
    public Store() {
        subject = BehaviorSubject.createDefault(new Model());
        mapper = new ModelMapper(Model.class);
    }

    public BehaviorSubject<Model> subject;

    public void next(Consumer<Model> recipe) {
        var model = mapper.clone(subject.getValue());
        recipe.accept(model);
        subject.onNext(model);
    }
}


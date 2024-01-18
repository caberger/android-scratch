package at.ac.htl.model;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.rxjava3.subjects.BehaviorSubject;

@Singleton
public class Store {
    @Inject
    Store() {
        store = BehaviorSubject.createDefault(new Model("Hallo"));
    }
    public BehaviorSubject<Model> store;
    public String greeting = "Hello world";
}


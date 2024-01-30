package at.ac.htl.model;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.rxjava3.subjects.BehaviorSubject;

@Singleton
public class Store {
    @Inject
    Store() {
        subject = BehaviorSubject.createDefault(new Model());
    }

    public BehaviorSubject<Model> subject;

}


package at.ac.htl.model;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.hilt.android.qualifiers.ApplicationContext;

@Singleton
public class Store {
    @Inject
    Store() {
    }
    public String greeting = "Hello world";
}


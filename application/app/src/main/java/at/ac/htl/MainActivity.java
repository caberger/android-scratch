package at.ac.htl;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.ComponentActivity;
import androidx.annotation.NonNull;

import javax.inject.Inject;

import at.ac.htl.model.Model;
import at.ac.htl.model.Store;
import at.ac.htl.ui.layout.MainView;
import at.ac.htl.ui.layout.MainViewKt;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends ComponentActivity {
    private static final String TAG = MainActivity.class.getName();
    @Inject
    Store store;

    @Inject
    MainView mainView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainView.setContentView(this);

        var nextModel = new Model();
        nextModel.greeting = "Änderung";
        store.subject.onNext(nextModel);
    }
}

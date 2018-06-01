package com.chris.mytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.chris.mytest.rxjava1.Observable;
import com.chris.mytest.rxjava1.ObservableOnSubscribe;
import com.chris.mytest.rxjava1.Observer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> list = new ArrayList<>();

        Observable.create(new ObservableOnSubscribe<File>() {
            @Override
            public void subscribe(Observer<? super File> observer) {

            }
        }).subscribe(new Observer<File>() {
            @Override
            public void onNext(File file) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }
}

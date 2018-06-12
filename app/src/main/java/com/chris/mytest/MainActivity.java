package com.chris.mytest;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.ArraySet;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.chris.mytest.dagger2.Bus;
import com.chris.mytest.rxjava1.Observable;
import com.chris.mytest.rxjava1.ObservableOnSubscribe;
import com.chris.mytest.rxjava1.Observer;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.inject.Inject;

import dagger.Component;

public class MainActivity extends AppCompatActivity {

    Button btn_dagger;

//    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_dagger = findViewById(R.id.btn_dagger);

//        List<String> list = new ArrayList<>();
//        Set<String> set = new HashSet<>();
//        Set<Integer> set1 = new TreeSet<>();
//        Set<String> set2 = new ArraySet<>();

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

    private void dagger_test() {
        new Bus().engine.start();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_dagger:
                dagger_test();
                break;
            case R.id.btn_download:
                Log.d("mytest","mytest");
                startActivity(new Intent(this, DownLoadActivity.class));
                break;
            default:
                break;
        }
    }


}

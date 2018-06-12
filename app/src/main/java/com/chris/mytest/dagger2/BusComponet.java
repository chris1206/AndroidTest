package com.chris.mytest.dagger2;

import com.chris.mytest.MainActivity;

import dagger.Component;

/**
 * Created by Chris on 2018/6/6.
 */
@Component
public interface BusComponet {
    void inject(Bus bus);
}

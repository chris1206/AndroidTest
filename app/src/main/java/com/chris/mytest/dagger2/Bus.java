package com.chris.mytest.dagger2;

import javax.inject.Inject;

/**
 * Created by Chris on 2018/6/6.
 */

public class Bus {
    @Inject
    public Engine engine;
    public Bus(){
//        DaggerBusComponent.builder().build().inject(this);
    }
}

package com.chris.mytest.dagger2;

import javax.inject.Inject;

/**
 * Created by Chris on 2018/6/6.
 */

public class Engine {
    @Inject
    public Engine(){}

    public void start(){
        System.out.println("引擎发动了");
    }
}

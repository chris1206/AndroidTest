package com.chris.mytest.rxjava1;

import android.support.annotation.NonNull;

/**
 * Created by Chris on 2018/5/28.
 */

public interface Observer<T> {
//    void onSubscribe(@NonNull Disposable d);

    void onNext(@NonNull T t);

    void onError(@NonNull Throwable e);

    void onComplete();
}

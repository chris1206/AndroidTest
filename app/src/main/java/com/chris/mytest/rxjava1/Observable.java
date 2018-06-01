package com.chris.mytest.rxjava1;

/**
 * Created by Chris on 2018/5/28.
 */
public class Observable<T> {

    private ObservableOnSubscribe<T> onSubscribe;

    private Observable (ObservableOnSubscribe<T> onSubscribe){
        this.onSubscribe = onSubscribe;
    }

    public static <T> Observable<T> create(ObservableOnSubscribe<T> onSubscribe){
        return new Observable<>(onSubscribe);
    }

    public void subscribe(Observer<? super T> observer){
        onSubscribe.subscribe(observer);
    }

}

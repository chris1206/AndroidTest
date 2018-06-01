package com.chris.mytest;

import android.support.annotation.NonNull;

import com.chris.mytest.rxjava1.Observable;
import com.chris.mytest.rxjava1.ObservableOnSubscribe;
import com.chris.mytest.rxjava1.Observer;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    /**
     * 通过手写Rxjava，学习rxjava的create创建流程以及高级泛型的用法
     */
    @Test
    public void test_rxjava(){

        ObservableOnSubscribe<String> onSubscribe = new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(Observer<? super String> observer) {
                System.out.println("发送消息啦！");
                observer.onNext("Hello");
                observer.onNext("World!");
            }
        };

        final Observable<String> observable = Observable.create(onSubscribe);

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onNext(@NonNull String s) {
                System.out.println("输出结果:"+s);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        observable.subscribe(observer);

        Observable.create(new ObservableOnSubscribe<Number>() {
            @Override
            public void subscribe(Observer<? super Number> observer) {
                observer.onNext(1);
                observer.onNext(12.2f);
                observer.onNext(1000.0d);
            }
        }).subscribe(new Observer<Number>() {
            @Override
            public void onNext(@NonNull Number number) {
                System.out.println(number.toString());
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

        Observable.create(new ObservableOnSubscribe<File>(){
            @Override
            public void subscribe(Observer<? super File> observer) {
                //PECS原则producer extends consumer super
                observer.onNext(new File("abc.jpg"));
            }
        }).subscribe(new Observer<File>() {
            @Override
            public void onNext(@NonNull File file) {
                System.out.println(file.getAbsoluteFile());
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println(e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });
    }

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    /**
     * ================理解super和extends======================
     */

    class Food{}

    class Fruit extends Food{}
    class Meat extends Food{}

    class Apple extends Fruit{}
    class Banana extends Fruit{}
    class Pork extends Meat{}
    class Beef extends Meat{}

    class RedApple extends Apple{}
    class GreenApple extends Apple{}

    class Plate<T> {

        private T item;
        public Plate(T t){
            this.item = t;
        }
        public T getItem() {
            return item;
        }

        public void setItem(T item) {
            this.item = item;
        }

    }

    @Test
    public void test(){
        //下面这句编译报错可以这样理解Apple is a Fruit,but Apple's Plate is not Fruit's Plate
//      Plate<Fruit> plate = new Plate<Apple>(new Apple());   //Error

        //上界通配符，Plate能装所有的Fruit及Fruit的子类
        Plate<? extends Fruit> plate1 = new Plate<>(new Apple());
//        plate1.setItem(new Apple());  //Error 编译器不通过 无法赋值
//        plate1.setItem(new Fruit());  //Error 无法赋值
        //为什么即使已经指定了Apple类型却还是会报错，是因为编译器只知道容器内是Fruit或者它的子类

        //上界只能从盘中取出，取出来的东西只能放在Fruit以及Fruit的基类中
        Fruit item1 = plate1.getItem();//正确或有效用法
        Object object = plate1.getItem();
//        Apple item = plate1.getItem();  //Error 类型不匹配

        //下界通配符规定了元素最小粒度的下限，既然元素是Fruit以及Fruit类型的基类，
        // 那么往里存的粒度只要比Fruit类型小的都可以
        Plate<? super Fruit> plate3 = new Plate<>(new Fruit());
        Plate<? super Fruit> plate4 = new Plate<>(new Food());
        Object item = plate3.getItem();//如果接收只能用Object类型，但取这个值毫无意义
        //实际定义super下界通配符是为了set()赋值,但必须保证是Fruit以及Fruit的子类型才能编译通过
        plate3.setItem(new Fruit());
        plate3.setItem(new Apple());
        plate3.setItem(new RedApple());

//        plate3.setItem(new Food());//Error
//        plate4.setItem(new Food());//Error
        plate4.setItem(new Apple());
        plate4.setItem(new GreenApple());

    }
}
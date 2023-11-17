package org2.example;

/**
 * description 饿汉式单例，线程安全，非懒加载，容易浪费内存空间，执行效率高
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/3/19-23:04
 */
public class Singleton1 {

    private Singleton1(){}
    private static final Singleton1 instance = new Singleton1();

    public static Singleton1 getInstance(){
        return instance;
    }
}

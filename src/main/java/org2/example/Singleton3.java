package org2.example;

/**
 * description 懒汉式单例，线程安全，不会浪费内存，但是执行效率低
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/3/19-23:20
 */
public class Singleton3 {

    private Singleton3(){}

    private static Singleton3 instance;

    public synchronized static  Singleton3 getInstance(){
        if(instance == null){
            instance =  new Singleton3();
        }

        return instance;
    }
}

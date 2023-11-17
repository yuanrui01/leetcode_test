package org2.example;

/**
 * description 懒汉式单例，线程不安全，懒加载，不会浪费内存空间
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/3/19-23:14
 */
public class Singleton2 {
    private Singleton2(){}
    private static Singleton2 instance;

    public static Singleton2 getInstance(){
        if(instance == null){
            instance = new Singleton2();
        }
        return instance;
    }
}

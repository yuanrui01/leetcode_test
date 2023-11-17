package org2.example;

/**
 * description 静态内部类实现懒汉式，懒加载，线程安全，不浪费空间，执行效率高
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/3/19-23:40
 */
public class Singleton5 {
    private Singleton5(){}

    public static Singleton5 getInstance(){
        return InnerClass.INSTANCE;
    }

    private static class InnerClass{
        private final static Singleton5 INSTANCE = new Singleton5();
    }
}

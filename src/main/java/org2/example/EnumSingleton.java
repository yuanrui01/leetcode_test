package org2.example;

/**
 * description 枚举单例 线程安全 懒加载 不浪费内存 效率高
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/3/19-23:43
 */
public enum EnumSingleton {

    INSTANCE;

    public void doSomething(String str){
        System.out.println(str);
    }
}

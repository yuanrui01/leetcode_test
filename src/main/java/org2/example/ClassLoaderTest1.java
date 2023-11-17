package org2.example;

import java.util.Arrays;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/3/19-18:09
 */
public class ClassLoaderTest1 {

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,6};

        System.out.println(Arrays.toString(a));

        System.out.println(a.getClass().getClassLoader());

        A a1 = new A();

        System.out.println(a1.getClass().getClassLoader());
    }

    private static class A{

    }
}

package com.yuanrui.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/2/26-20:58
 */
public class CountPrime {

    public static void main(String[] args) {

/*        List<Person> bookList = new ArrayList<>();
        bookList.add(new Person("jack","18163138123"));
        bookList.add(new Person("martin",null));
// 空指针异常
        bookList.stream().collect(Collectors.toMap(Person::getName, Person::getPhoneNumber));*/

        //countPrimes(10);

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10; ++i) {
            list.add(i);
        }

        for(int i = 0; i < list.size(); ++i){
            if(list.get(i) == 3){
                list.remove(3);
            }
        }
    }

    public static int countPrimes(int n) {
        boolean[] nPrime = new boolean[n];
        int cnt = 0;
        for(int i = 2; i < n; i++) {
            if(nPrime[i]) continue;
            cnt++;
            for(int j = i; j < n; j+=i) {
                nPrime[j] = true;
            }
        }
        return cnt;
    }
}

class Person {
    private String name;
    private String phoneNumber;
    // getters and setters

    public Person(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
package com.yuanrui.leetcode;

import java.util.Random;
import java.util.function.Consumer;

public class ReverseBits {
    public static void main(String[] args) {
        //reverseBits(43261596);

        test(ReverseBits::defaultOnly);
    }

    static void defaultOnly(String s) {
        switch (s) {
            case "XX" -> System.out.println("XX");
            //case null -> System.out.println("null");
            default -> System.out.println("default");
        }

        int num = 2;
        int result = switch (num) {
            case 1 -> 10;
            case 2 -> 20;
            case 3 -> {
                System.out.println(43432);
                yield 30;
            }
            default -> 40;
        };
        System.out.println(result);
        //yield 30; // This line will cause the error
    }

    static void test(Consumer<String> cs) {
        cs.accept("XX");
        cs.accept("YY");
        try{
            cs.accept(null);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static int reverseBits(int n) {
        int mask = 1;
        int flag1 = 1;
        int flag0 = 0;
        int res = 0;
        for(int i = 0; i < 32; ++i){
            if((mask & n) == 0){
                res |= flag0;
                System.out.print(flag0);
            }else{
                res |= flag1;
                System.out.print(flag1);
            }
            res = res << 1;
            mask <<= 1;
        }
        System.out.println();
        System.out.println(res);

        Random random = new Random();
        random.nextInt(30);
        return res;
    }
    //00000010100101000001111010011100
    //00000010100101000001111010011100
}

class OddScoping {
    static void f(Object o) {
        if (!(o instanceof String s)){
            System.out.println("Not a String! ");
            throw new RuntimeException("sd");
        }

        System.out.println(s.toUpperCase());
    }
}

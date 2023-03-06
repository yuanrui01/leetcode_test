package com.yuanrui.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    public static void main(String[] args) {
        //System.out.println(romanToInt("MCMXCIV"));
        System.out.println(Arrays.toString(intToBytes(-3)));
    }

    public static int romanToInt(String s) {
/*        Map<String,Integer> romanMap = new HashMap<>();

        romanMap.put("IV", 4);
        romanMap.put("IX", 9);
        romanMap.put("XL", 40);
        romanMap.put("XC", 90);
        romanMap.put("CD", 400);
        romanMap.put("CM", 900);

        romanMap.put("I", 1);
        romanMap.put("V", 5);
        romanMap.put("X", 10);
        romanMap.put("L", 50);
        romanMap.put("C", 100);
        romanMap.put("D", 500);
        romanMap.put("M", 1000);*/

        int result = 0;

        while(s.indexOf("IV") != -1){
            result += 4;
            s = s.replaceFirst("IV","");
        }

        while(s.indexOf("IX") != -1){
            result += 9;
            s = s.replaceFirst("IX","");
        }

        while(s.indexOf("XL") != -1){
            result += 40;
            s = s.replaceFirst("XL","");
        }
        while(s.indexOf("XC") != -1){
            result += 90;
            s = s.replaceFirst("XC","");
        }
        while(s.indexOf("CD") != -1){
            result += 400;
            s = s.replaceFirst("CD","");
        }
        while(s.indexOf("CM") != -1){
            result += 900;
            s = s.replaceFirst("CM","");
        }

        while(s.indexOf("I") != -1){
            result += 1;
            s = s.replaceFirst("I","");
        }
        while(s.indexOf("V") != -1){
            result += 5;
            s = s.replaceFirst("V","");
        }
        while(s.indexOf("X") != -1){
            result += 10;
            s = s.replaceFirst("X","");
        }
        while(s.indexOf("L") != -1){
            result += 50;
            s = s.replaceFirst("L","");
        }
        while(s.indexOf("C") != -1){
            result += 100;
            s = s.replaceFirst("C","");
        }
        while(s.indexOf("D") != -1){
            result += 500;
            s = s.replaceFirst("D","");
        }
        while(s.indexOf("M") != -1){
            result += 1000;
            s = s.replaceFirst("M","");
        }


        return result;
    }

    public static byte[] intToBytes(int value ){
        byte[] src = new byte[4];
        src[0] = (byte)(value & 0XFF);
        src[1] =(byte) ((value>>8)& 0XFF);
        src[2] = (byte)((value>>16)&0XFF);
        src[3] =(byte)((value>>24)& 0XFF);
        return src;
    }
}

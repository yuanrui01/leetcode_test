package com.yuanrui.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 43. 字符串相乘
 */
public class Multiply {

    public String multiply(String num1, String num2) {
        List<String> ans = new ArrayList<>();
        String max,min;
        if (num1.length() > num2.length()) {
            max = num1;
            min = num2;
        } else {
            max = num2;
            min = num1;
        }
        int times = 0;
        //  循环小的
        for (int i = min.length() - 1; i >= 0; i--) {
            int single = min.charAt(i) - '0';
            if (single > 0)
                ans.add(singleMulti(max, single) + "0".repeat(times));
            times++;
        }
        String tmp = "0";
        for (String an : ans) {
            tmp = add(tmp, an);
        }
        return tmp;
    }

    public String add(String num1, String num2) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        int i1 = num1.length() - 1;
        int i2 = num2.length() - 1;
        char c1;
        char c2;
        while(i1>=0 && i2>=0) {
            c1 = num1.charAt(i1);
            c2 = num2.charAt(i2);

            int cur = (c1 - '0') + (c2 - '0') + carry;
            if (cur < 10 ) {
                sb.append(cur);
                carry = 0;
            } else {
                sb.append(cur%10);
                carry = cur/10;
            }
            i1--;
            i2--;
        }

        while (i1>=0) {
            c1 = num1.charAt(i1);
            int cur = c1 - '0' + carry;
            if (cur < 10 ) {
                sb.append(cur);
                carry = 0;
            } else {
                sb.append(cur%10);
                carry = cur/10;
            }
            i1--;
        }

        while (i2>=0) {
            c2 = num2.charAt(i2);
            int cur = c2 - '0' + carry;
            if (cur < 10 ) {
                sb.append(cur);
                carry = 0;
            } else {
                sb.append(cur%10);
                carry = cur/10;
            }
            i2--;
        }
        if (carry > 0)
            sb.append(carry);
        return sb.reverse().toString();
    }

    private String singleMulti(String num, int single) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        int i = num.length() - 1;
        char c;
        while(i >= 0) {
            c = num.charAt(i);
            int cur = (c - '0') * single + carry;
            if (cur < 10 ) {
                sb.append(cur);
                carry = 0;
            } else {
                sb.append(cur%10);
                carry = cur/10;
            }
            i--;
        }
        if (carry > 0)
            sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Multiply multiply = new Multiply();

        System.out.println(multiply.multiply("2", "3"));
    }
}

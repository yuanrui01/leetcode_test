package com.yuanrui.leetcode;

/**
 * 67. 二进制求和
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        int ia = a.length() - 1;
        int ib = b.length() - 1;
        char ca;
        char cb;
        while(ia>=0 && ib>=0) {
            ca = a.charAt(ia);
            cb = b.charAt(ib);

            int cur = (ca - '0') + (cb - '0') + carry;
            if (cur == 0) {
                sb.append(0);
            } else if (cur == 1) {
                sb.append('1');
                carry = 0;
            } else if (cur == 2) {
                sb.append('0');
                carry = 1;
            } else if (cur == 3) {
                sb.append('1');
                carry = 1;
            }
            ia--;
            ib--;
        }

        while (ia>=0) {
            ca = a.charAt(ia);
            int cur = ca - '0' + carry;
            if (cur == 0) {
                sb.append(0);
            } else if (cur == 1) {
                sb.append('1');
                carry = 0;
            } else if (cur == 2) {
                sb.append('0');
                carry = 1;
            }
            ia--;
        }

        while (ib>=0) {
            cb = b.charAt(ib);
            int cur = cb - '0' + carry;
            if (cur == 0) {
                sb.append(0);
            } else if (cur == 1) {
                sb.append('1');
                carry = 0;
            } else if (cur == 2) {
                sb.append('0');
                carry = 1;
            }
            ib--;
        }
        if (carry == 1)
            sb.append('1');
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.addBinary("11","1"));
    }
}

package com.yuanrui.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1694. 重新格式化电话号码
 * @author: yuanrui
 */
public class ReformatNumber {

    public static void main(String[] args) {
        String number = "1-23-45 6";

        System.out.println(reformatNumber(number));
    }

    public static String reformatNumber(String number) {
        List<String> ilist = new ArrayList<>();
        number = number.replaceAll("[\s-]", "");
        while (number.length() > 4) {
            ilist.add(number.substring(0,3));
            number = number.substring(3);
        }
        int remainderLen = number.length();

        if (remainderLen == 4) {
            ilist.add(number.substring(0,2));
            ilist.add(number.substring(2));
        } else if (remainderLen > 0){
            ilist.add(number);
        }

        return String.join("-", ilist);
    }
}

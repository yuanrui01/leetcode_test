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
        StringBuilder sb = new StringBuilder();
        number = number.replaceAll("[\s-]", "");
        while (number.length() > 4) {
            sb.append(number.substring(0, 3)).append("-");
            number = number.substring(3);
        }
        int remainderLen = number.length();

        if (remainderLen == 4) {
            sb.append(number.substring(0, 2)).append("-");
            sb.append(number.substring(2));
        } else if (remainderLen > 0){
            sb.append(number);
        }

        String ans = sb.toString();
        if (ans.charAt(ans.length() - 1) == '-')
            return ans.substring(0, ans.length() - 1);
        else
            return ans;
    }
}

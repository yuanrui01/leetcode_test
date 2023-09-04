package com.yuanrui.leetcode;

/**
 * 2259. 移除指定数字得到的最大结果
 * @author: yuanrui
 */
public class RemoveDigit {

    public static void main(String[] args) {
        System.out.println(removeDigit("551",'5'));
    }

    public static String removeDigit(String number, char digit) {
        String ans = null;
        char[] charArray = number.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == digit) {
                String subStr = number.substring(0,i) + number.substring(i+1);
                if (ans == null) {
                    ans = subStr;
                } else {
                    if (subStr.compareTo(ans) > 0)
                        ans = subStr;
                }
            }
        }
        return ans;
    }
}

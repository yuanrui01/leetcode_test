package com.yuanrui.leetcode;

/**
 * 1056. 易混淆数
 * @author: yuanrui
 */
public class ConfusingNumber {
    int[] rotateArr = {0,1,-1,-1,-1,-1,9,-1,8,6};
    public boolean confusingNumber(int n) {
        String str = String.valueOf(n);
        StringBuilder rotateStr = new StringBuilder();
        for (int i = 0; i < str.length(); ++i)
            if (rotateArr[str.charAt(i)-'0'] == -1)
                return false;
            else
                rotateStr.append(rotateArr[str.charAt(i)-'0']);
        return !str.contentEquals(rotateStr.reverse());
    }
}

package com.yuanrui.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * 868. 二进制间距
 */
public class BinaryGap {

    public static void main(String[] args) {
        binaryGap(10);
    }

    public static int binaryGap(int n) {
        String binIntStr = convertToBinaryString(n);
        List<Integer> idxList = new ArrayList<>();
        char[] charArray = binIntStr.toCharArray();
        for (int i = 0; i < binIntStr.length(); ++i)
            if (charArray[i] == '1')
                idxList.add(i);
        int res = 0;
        if (idxList.size() < 2)
            return res;
        for (int i = 0; i < idxList.size() - 1; ++i) {
            res = Math.max(res, idxList.get(i+1) - idxList.get(i));
        }
        return res;
    }

    public static String convertToBinaryString(int n) {
        return Integer.toBinaryString(n);
    }
}

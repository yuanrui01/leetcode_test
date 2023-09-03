package com.yuanrui.leetcode;

/**
 * @author: yuanrui
 */
public class CountSymmetricIntegers {

    public static void main(String[] args) {
        System.out.println(countSymmetricIntegers(1,100));
    }

    public static int countSymmetricIntegers(int low, int high) {
        int ans = 0;
        for (int i = low; i <= high; ++i) {
            if(isSymmetricInteger(i))
                ans++;
        }
        return ans;
    }

    private static boolean isSymmetricInteger(int low) {
        String s = String.valueOf(low);
        if (s.length()%2 != 0)
            return false;
        int len = s.length();
        int forwardSum = 0;
        int backwardSum = 0;

        for (int i = 0; i < len / 2; ++i) {
            forwardSum += Integer.parseInt(s.charAt(i) + "");
            backwardSum += Integer.parseInt(s.charAt(len - i - 1) + "");
        }

        return forwardSum == backwardSum;
    }
}

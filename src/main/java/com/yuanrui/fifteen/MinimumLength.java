package com.yuanrui.fifteen;

public class MinimumLength {

    public int minimumLength(String s) {
        char[] cArr = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while(left < right && cArr[left] == cArr[right]) {
            char c = cArr[left];
            while (left + 1 < right && cArr[left + 1] == c) left++;
            while (left < right - 1 && cArr[right - 1] == c) right--;
            left++;
            right--;
        }
        return right - left + 1;
    }

    public static void main(String[] args) {
        MinimumLength minimumLength = new MinimumLength();

        System.out.println(minimumLength.minimumLength("ca"));
    }
}

package com.yuanrui.fourteen;

/**
 * 1588. 所有奇数长度子数组的和
 * @author: yuanrui
 */
public class SumOddLengthSubarrays {

    public int sumOddLengthSubarrays(int[] arr) {
        int ans = 0;
        int len = arr.length;
        int windowSize = 1;
        while (windowSize <= len) {
            // 求第一个窗口值
            int slideVal = 0;
            for(int i = 0; i < windowSize; ++i)
                slideVal += arr[i];
            ans += slideVal;
            for(int i = 1; i <= len - windowSize; ++i) {
                slideVal = slideVal - arr[i-1] + arr[i+windowSize-1];
                ans += slideVal;
            }

            windowSize += 2;
        }
        return ans;
    }

}

package com.yuanrui.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2160. 拆分数位后四位数字的最小和
 */
public class MinimumSum {

    public static void main(String[] args) {
        System.out.println(minimumSum(2932));
    }


    /**
     * 输入：num = 2932
     * 输出：52
     * 解释：可行的 [new1, new2] 数对为 [29, 23] ，[223, 9] 等等。
     * 最小和为数对 [29, 23] 的和：29 + 23 = 52 。
     * @param num
     */
    public static int minimumSum(int num) {
        int n1 = 0;
        int n2 = 0;
        int factor1 = 1;
        int factor2 = 1;
        boolean flag = true;

        String numStr = String.valueOf(num);
        int[] numArr = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); ++i)
            numArr[i] = Integer.parseInt(numStr.charAt(i)+"");
        Arrays.sort(numArr);
        for (int i = numStr.length() - 1; i >= 0; i--) {
            int number = numArr[i];
            if (number == 0)
                continue;
            if (flag) {
                if (i == 0 && n1 > 0 && n1 > n2)
                    n2 += number * factor2;
                else {
                    n1 += number * factor1;
                    factor1 *= 10;
                    flag = false;
                }
            } else {
                n2 += number * factor2;
                factor2 *= 10;
                flag = true;
            }
        }
        return n1 + n2;
    }

}

package com.yuanrui.leetcode;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/3/12-11:17
 */
public class MaxScore {

    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{-1}));;

    }

    public static int maxScore(int[] nums) {
        int ans = 0;
        Integer[] boxedNums = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(boxedNums, Collections.reverseOrder());
        long sum = 0;
        for(int i = 0; i < boxedNums.length; ++i){
            sum += boxedNums[i];
            if(sum > 0){
                ans++;
            }else{
                return ans;
            }
        }

        return ans;
    }
}

package com.yuanrui.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

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

/*        Arrays.sort(nums,new Comparator<Integer,Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });*/
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

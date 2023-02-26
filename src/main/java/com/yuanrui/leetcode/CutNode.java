package com.yuanrui.leetcode;

import org.omg.CORBA.MARSHAL;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/2/26-5:57
 */
public class CutNode {

    public static void main(String[] args) {
//        int[] p = {0,1,5,8,9,10,17,17,20,24,30};
//
//        long start = System.currentTimeMillis();
//
//        System.out.println(cutnode(p,9));
//
//        long end = System.currentTimeMillis();
//
//        System.out.println(end - start);

/*          int[] nums = {1};
        System.out.println(Arrays.toString(leftRigthDifference(nums)));*/

        System.out.println(Arrays.toString(divisibilityArray("529282143571",4)));
    }
    private static int cutnode(int[] p,int n){
        if(n == 0){
            return 0;
        }

        int q = Integer.MIN_VALUE;

        for (int i = 1; i <= n; ++i){
            int t = p[i] + cutnode(p,n-i);
            q = Math.max(q,t);
        }

        return q;
    }

    public static int[] leftRigthDifference(int[] nums) {
        int[] answer = new int[nums.length];
        int[] leftsum = new int[nums.length];
        int[] rightsum = new int[nums.length];

        leftsum[0] = 0;
        rightsum[nums.length - 1] = 0;

        for(int i = 1; i < nums.length; ++i){
            leftsum[i] = leftsum[i-1] + nums[i-1];
        }

        for(int j = nums.length - 2; j >= 0; --j){
            rightsum[j] = rightsum[j+1] + nums[j+1];
        }

        for (int k = 0; k < nums.length; ++k){
            answer[k] = Math.abs(leftsum[k] - rightsum[k]);
        }

        return answer;
    }

    public static int[] divisibilityArray(String word, int m) {
        int[] div = new int[word.length()];
        int cur = 0;
        for(int i = 0; i < word.length(); ++i){
            int n = word.charAt(i) - '0';
            cur = (cur*10 + n)%m;
            if(cur == 0){
                div[i] = 1;
            }
        }
        return div;
    }

    public static boolean compute(String dividend, int divisor){
        for(int i = 0; i < dividend.length(); ++i){
            if(dividend.charAt(i) != '0'){
                dividend = dividend.substring(i,dividend.length());
                break;
            }
        }
        Stack<Character> stack = new Stack<>() ;
        int remainder = 0;
        int length = dividend.length() ;
        int divisorLength = Integer.toString(divisor).length() ;
        for(int i = dividend.length() - 1 ; i >= 0 ; i --){
            stack.push(dividend.charAt(i) ) ;
        }
        if(length <= divisorLength ){
            remainder = Integer.parseInt( dividend ) % divisor ;
        } else {
            StringBuilder sbDividendTemp = new StringBuilder() ;
            for(int i = 0 ; i < length ; i++){
                sbDividendTemp.append(stack.pop()) ;
                if( Integer.parseInt( sbDividendTemp.toString() ) < divisor ){
                    continue ;
                }
                else {
                    remainder = Integer.parseInt( sbDividendTemp.toString()) % divisor ;
                    sbDividendTemp.delete(0, sbDividendTemp.length()) ;
                    if (remainder != 0 ) {
                        sbDividendTemp.append(remainder);
                    }
                }
            }
        }
        if(remainder == 0 ){
            return true;
        } else{
            return false;
        }
    }
}

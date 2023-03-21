package com.yuanrui.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/3/21-9:15
 */
public class YangTriangle {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> ill = new ArrayList<>();
        for(int i = 1; i <= numRows; ++i){
            List<Integer> il = new ArrayList<>();

            for(int j =0; j < i; ++j){
                if(j == 0 || j == i-1){
                    il.add(1);
                }else{
                    il.add(ill.get(i-2).get(j-1) + ill.get(i-2).get(j));
                }
            }

            ill.add(il);
        }

        return ill;
    }
}

package com.yuanrui.leetcode;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/3/5-11:34
 */
public class FindVaildSplit {

    public static void main(String[] args) {
        String file = "E:\\MyJavaProjects\\LeetCodeTest\\src\\main\\java\\com\\yuanrui\\leetcode\\nums.txt";
        try {
            InputStreamReader nums = new InputStreamReader(new FileInputStream(file),"UTF-8");
            BufferedReader bufferNums = new BufferedReader(nums);
            String line = null;
            while ((line = bufferNums.readLine()) != null){
                System.out.println(line);
                String[] numsArr = line.split(",");
                long start = System.currentTimeMillis();
                findValidSplit(Arrays.asList(numsArr).stream().mapToInt(Integer::valueOf).toArray());
                System.out.println("耗时"+(System.currentTimeMillis() - start));
            }
        } catch (Exception e) {
            e.printStackTrace();
            //throw new RuntimeException(e);
        }
    }

    public static int findValidSplit(int[] nums) {
        List<int[]> tag = new ArrayList<>();
        for(int i = 1; i <= nums.length - 1; ++i){
            int target = nums[i];
            for(int j = 0; j < i; ++j){
                if(gcd(nums[j],target) != 1){
                    tag.add(new int[]{j,i});
                }
            }
        }
        int[][] result = merge(tag);
        if(result.length > 0){
            int spilt = Integer.MAX_VALUE;
            for(int i = 0; i < result.length; ++i){
                spilt = Math.min(result[i][1],spilt);
            }
            if(spilt != nums.length - 1){
                return spilt;
            }
        }
        return -1;
    }

    public static int gcd(int m, int n){
        int t = 0;
        while(n != 0){
            t = m;
            m = n;
            n = t % n;
        }
        return m;
    }

    public static int[][] merge(List<int[]> intervals) {
        if (intervals.size() == 0) {
            return new int[0][2];
        }
        intervals.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.size(); ++i) {
            int L = intervals.get(i)[0], R = intervals.get(i)[1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}

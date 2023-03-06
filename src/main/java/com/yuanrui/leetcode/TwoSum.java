package com.yuanrui.leetcode;

public class TwoSum {

    public static void main(String[] args) {

        int[] numbers = {-1,0};
        int target = -1;

        twoSum(numbers,target);
    }


    public static int[] twoSum(int[] numbers, int target) {
        int rear = -1;
        int front = -1;

        for(int i = numbers.length-1; i >=0 ; --i){
            if(numbers[i] <= target || numbers[i] == 0){
                rear = i;
                break;
            }
        }

        for(int i = rear; i > 0; --i){
            for(int j = 0; j < i; ++j){
                if(numbers[i] + numbers[j] == target){
                    front = i;
                    rear = j;
                    break;
                }
            }
        }

        int[] res = new int[2];
        res[0] = front;
        res[1] = rear;
        return res;
    }
}

package com.yuanrui.leetcode;

/**
 * 2591. 将钱分给最多的儿童
 * @author: yuanrui
 */
public class DistMoney {

    public int distMoney(int money, int children) {
        if (money < children)
            return -1;
        int rest = money - children;
        if (rest == 0)
            return 0;
        int max = rest / 7;
        if (max == 0) {
            if (money == 4&& children == 1)
                return -1;
            else
                return 0;
        } else {
            int mod = rest % 7;
            if (children - max == 1 && mod == 3) {
                return max - 1;
            } else if(max == children && mod != 0) {
                return max - 1;
            } else if(max > children){
                return children - 1;
            } else {
                return max;
            }
        }
    }
}

package com.yuanrui.leetcode;


/**
 * 1812. 判断国际象棋棋盘中一个格子的颜色
 */
public class SquareIsWhite {


    public boolean squareIsWhite(String coordinates) {
        // 初始化为黑色从a1开始
        boolean ans = false;
        char c1 = coordinates.charAt(0);
        char c2 = coordinates.charAt(1);

        if ((c1 - 'a') % 2 != 0)
            ans = !ans;
        if ((c2 - '1') % 2 != 0)
            ans = !ans;
        return ans;
    }
}

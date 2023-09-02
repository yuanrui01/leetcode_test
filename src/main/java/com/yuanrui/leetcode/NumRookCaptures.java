package com.yuanrui.leetcode;

/**
 * 999. 可以被一步捕获的棋子数
 * @author: yuanrui
 */
public class NumRookCaptures {

    public int numRookCaptures(char[][] board) {
        int rookm = -1;
        int rookn = -1;
        for (int i = 0; i < 8; ++i)
            for(int j = 0; j < 8; ++j)
                if (board[i][j] == 'R') {
                    rookm = i;
                    rookn = j;
                }

        int ans = 0;

        //找上面
        for (int i = rookn - 1; i >= 0; --i) {
            char c = board[rookm][i];
            if (c == 'p') {
                ans++;
                break;
            } else if (c == 'B') {
                break;
            }
        }

        //找下面
        for (int i = rookn + 1; i < 8; ++i) {
            char c = board[rookm][i];
            if (c == 'p') {
                ans++;
                break;
            } else if (c == 'B') {
                break;
            }
        }

        //找左边
        for (int i = rookm - 1; i >= 0; --i) {
            char c = board[i][rookn];
            if (c == 'p') {
                ans++;
                break;
            } else if (c == 'B') {
                break;
            }
        }

        //找右边
        for (int i = rookm + 1; i < 8; ++i) {
            char c = board[i][rookn];
            if (c == 'p') {
                ans++;
                break;
            } else if (c == 'B') {
                break;
            }
        }

        return ans;
    }
}

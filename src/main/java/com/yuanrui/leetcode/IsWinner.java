package com.yuanrui.leetcode;

/**
 * 2660. 保龄球游戏的获胜者
 * @author: yuanrui
 */
public class IsWinner {

    public int isWinner(int[] player1, int[] player2) {
        int score1 = 0;
        int score2 = 0;
        for (int i = 0; i < player1.length; ++i) {
            int times = 1;
            while(i - times >= 0 && times <= 3) {
                if (player1[i - times] == 10) {
                    score1 += player1[i];
                    break;
                }
                times++;
            }
            times = 1;
            while(i - times >= 0 && times <= 3) {
                if (player2[i - times] == 10) {
                    score2 += player2[i];
                    break;
                }
                times++;
            }

            score1 += player1[i];
            score2 += player2[i];
        }
        return score1 > score2 ? 1 : (score1 == score2 ? 0 : 2 );
    }
}

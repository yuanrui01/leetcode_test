package com.yuanrui.leetcode;

/**
 * 1275. 找出井字棋的获胜者
 * @author: yuanrui
 */
public class Tictactoe {

    public String tictactoe(int[][] moves) {
        int[][] chess = new int[3][3];

        for (int i = 0; i < moves.length; i++) {
            if (i%2 == 0)
                chess[moves[i][0]][moves[i][1]] = 1;
            else
                chess[moves[i][0]][moves[i][1]] = 2;
        }

        return checkChess(chess);
    }

    private String checkChess(int[][] chess) {
        for (int i = 0; i < 3; ++i) {
            if (chess[i][0] == 1 && chess[i][1] == 1 && chess[i][2] == 1)
                return "A";
        }
        for (int i = 0; i < 3; ++i) {
            if (chess[0][i] == 1 && chess[1][i] == 1 && chess[2][i] == 1)
                return "A";
        }
        if (chess[0][0] == 1 && chess[1][1] == 1 && chess[2][2] == 1)
            return "A";
        if (chess[0][2] == 1 && chess[1][1] == 1 && chess[2][0] == 1)
            return "A";

        for (int i = 0; i < 3; ++i) {
            if (chess[i][0] == 2 && chess[i][1] == 2 && chess[i][2] == 2)
                return "B";
        }
        for (int i = 0; i < 3; ++i) {
            if (chess[0][i] == 2 && chess[1][i] == 2 && chess[2][i] == 2)
                return "B";
        }
        if (chess[0][0] == 2 && chess[1][1] == 2 && chess[2][2] == 2)
            return "B";
        if (chess[0][2] == 2 && chess[1][1] == 2 && chess[2][0] == 2)
            return "B";

        int cnt = 0;
        for (int i =0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (chess[i][j] == 0)
                    cnt++;
            }
        }

        return cnt > 0 ? "Pending" : "Draw";
    }
}

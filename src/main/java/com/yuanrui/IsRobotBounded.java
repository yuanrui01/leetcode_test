package com.yuanrui;

public class IsRobotBounded {
    private int x = 0;
    private int y = 0;
    private final int[] direction = {0,1,2,3}; //0:表示+y, 1:表示+x, 2:表示-y, 3:表示-x

    public boolean isRobotBounded(String instructions) {
        int di = 0;
        // 四段指令之内，机器人还回不来就不存在环
        int i = 0;
        while (i < 4) {
            for(int j = 0; j < instructions.length(); ++j) {
                char c = instructions.charAt(j);
                if (c == 'G')
                    switch (direction[di]) {
                        case 0 -> y++;
                        case 1 -> x++;
                        case 2 -> y--;
                        case 3 -> x--;
                    }
                else if (c == 'L')
                    di = di - 1 < 0 ? 3 : di - 1;
                else if (c == 'R')
                    di = di + 1 == 4 ? 0 : di + 1;
            }
            i++;
            if(x == 0 && y == 0)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

        IsRobotBounded isRobotBounded = new IsRobotBounded();
        System.out.println(isRobotBounded.isRobotBounded("LLGRL"));
    }
}

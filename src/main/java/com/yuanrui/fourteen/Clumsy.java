package com.yuanrui.fourteen;

import java.util.ArrayList;
import java.util.List;

/**
 * 1006. 笨阶乘
 * @author: yuanrui
 */
public class Clumsy {

    public int clumsy(int n) {
        List<Integer> list = new ArrayList<>();
        int i = n;
        boolean flag = true;
        while(i > 0) {
            int tmp = 0;
            tmp = i--;
            if (i > 0)
                tmp = tmp * i--;
            if (i > 0)
                tmp = tmp / i--;
            if (i > 0) {
                if (flag)
                    tmp = tmp + i--;
                else
                    tmp = tmp - i--;
                flag = false;
            }
            list.add(tmp);
        }

        int ans = list.get(0);
        for(int j = 1; j < list.size(); ++j)
            ans -= list.get(j);
        return ans;
    }

    public static void main(String[] args) {

        Clumsy clumsy = new Clumsy();

        System.out.println(clumsy.clumsy(12));
    }
}

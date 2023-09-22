package com.yuanrui.leetcode;

/**
 * @author: yuanrui
 */
public class BrowserHistory {

    String[] histories;
    int curIndex;
    int end;

    public BrowserHistory(String homepage) {
        histories = new String[5001];
        histories[0] = homepage;
        curIndex = 0;
        end = 0;
    }

    public void visit(String url) {
        histories[++curIndex] = url;
        end = curIndex;
    }

    public String back(int steps) {
        if (curIndex - steps < 0)
            curIndex = 0;
        else
            curIndex -= steps;
        return histories[curIndex];
    }

    public String forward(int steps) {
        if (curIndex + steps > end)
            curIndex = end;
        else
            curIndex += steps;
        return histories[curIndex];
    }
}

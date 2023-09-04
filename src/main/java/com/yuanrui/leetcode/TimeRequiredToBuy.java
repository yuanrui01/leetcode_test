package com.yuanrui.leetcode;


/**
 * 2073. 买票需要的时间
 */
public class TimeRequiredToBuy {


    public static void main(String[] args) {
        int[] tickets = {5, 1, 1, 1};
        int k = 0;
        System.out.println(timeRequiredToBuy(tickets, k));
    }

    /**
     * 输入：tickets = [2,3,2], k = 2
     * 输出：6
     * 解释：
     * - 第一轮，队伍中的每个人都买到一张票，队伍变为 [1, 2, 1] 。
     * - 第二轮，队伍中的每个都又都买到一张票，队伍变为 [0, 1, 0] 。
     * 位置 2 的人成功买到 2 张票，用掉 3 + 3 = 6 秒。
     * @param tickets
     * @param k
     */
    public static int timeRequiredToBuy(int[] tickets, int k) {
        int ans = 0;
        int len = tickets.length;
        if (len == 1)
            return tickets[0];
        int i = 0;
        while (true) {
            if (tickets[i] > 0) {
                // 如果当前用户还没买完
                tickets[i]--;
                ans++;
            }
            if (tickets[k] == 0)
                break;
            i = (i+1)%len;
        }
        return ans;
    }
}

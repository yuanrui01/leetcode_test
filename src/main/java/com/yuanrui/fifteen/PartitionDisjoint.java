package com.yuanrui.fifteen;

/**
 * 915. 分割数组
 */
public class PartitionDisjoint {

    public int partitionDisjoint(int[] nums) {
        int length = nums.length;
        int[] leftStat = new int[length];
        int[] rightStat = new int[length];

        // 对于leftStat每个值表示从左往右累计的最大值
        leftStat[0] = nums[0];
        for (int i = 1; i < length - 1; i++)
            leftStat[i] = Math.max(nums[i], leftStat[i - 1]);

        // 对于rightStat每个值表示从右往左累计的最小值
        rightStat[length - 1] = nums[length - 1];
        for (int j = length - 2; j >= 1; --j )
            rightStat[j] = Math.min(nums[j], rightStat[j + 1]);

        for (int i = 0; i < length - 1; ++i) {
            if (leftStat[i] < rightStat[i+1])
                return i + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        PartitionDisjoint partitionDisjoint = new PartitionDisjoint();
        int[] nums = {1,1,1,0,6,12};
        System.out.println(partitionDisjoint.partitionDisjoint(nums));
    }
}

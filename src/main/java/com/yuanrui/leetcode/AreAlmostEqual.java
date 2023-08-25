package com.yuanrui.leetcode;

/**
 * 1790. 仅执行一次字符串交换能否使两个字符串相等
 * 给你长度相等的两个字符串 s1 和 s2 。一次 字符串交换 操作的步骤如下：
 * 选出某个字符串中的两个下标（不必不同），并交换这两个下标所对应的字符。
 * 如果对 其中一个字符串 执行 最多一次字符串交换 就可以使两个字符串相等，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 *
 * 输入：s1 = "bank", s2 = "kanb"
 * 输出：true
 * 解释：例如，交换 s2 中的第一个和最后一个字符可以得到 "bank"
 * 示例 2：
 *
 * 输入：s1 = "attack", s2 = "defend"
 * 输出：false
 * 解释：一次字符串交换无法使两个字符串相等
 * 示例 3：
 *
 * 输入：s1 = "kelb", s2 = "kelb"
 * 输出：true
 * 解释：两个字符串已经相等，所以不需要进行字符串交换
 * 示例 4：
 *
 * 输入：s1 = "abcd", s2 = "dcba"
 * 输出：false
 */
public class AreAlmostEqual  {

    public static void main(String[] args) {
        String s1 = "caa", s2 = "aaz";
        System.out.println(areAlmostEqual(s1, s2));
    }

    public static boolean areAlmostEqual(String s1, String s2) {
        int length = s1.length();
        int mismatchCount = 0;
        int[] num = new int[4];
        int k = 0;

        for (int i = 0; i < length; ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                mismatchCount++;
                if (k < 4) {
                    num[k++] = s1.charAt(i);
                    num[k++] = s2.charAt(i);
                }
            }
            if (mismatchCount > 2)
                break;
        }
        if (mismatchCount == 0) {
            return true;
        } else if (mismatchCount == 2) {
            return num[0] == num[3] && num[1] == num[2];
        } else {
            return false;
        }
    }
}

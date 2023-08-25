package com.yuanrui.leetcode;

/**
 * 2525. 根据规则将箱子分类
 * 给你四个整数 length ，width ，height 和 mass ，分别表示一个箱子的三个维度和质量，请你返回一个表示箱子 类别 的字符串。
 * 如果满足以下条件，那么箱子是 "Bulky" 的：
 * 箱子 至少有一个 维度大于等于 104 。
 * 或者箱子的 体积 大于等于 109 。
 * 如果箱子的质量大于等于 100 ，那么箱子是 "Heavy" 的。
 * 如果箱子同时是 "Bulky" 和 "Heavy" ，那么返回类别为 "Both" 。
 * 如果箱子既不是 "Bulky" ，也不是 "Heavy" ，那么返回类别为 "Neither" 。
 * 如果箱子是 "Bulky" 但不是 "Heavy" ，那么返回类别为 "Bulky" 。
 * 如果箱子是 "Heavy" 但不是 "Bulky" ，那么返回类别为 "Heavy" 。
 * 注意，箱子的体积等于箱子的长度、宽度和高度的乘积。
 */
public class CategorizeBox {

    public static void main(String[] args) {
        long l1 = 2909;
        long result = l1*3968*3272;
        System.out.println(result);
    }

    /**
     * 输入：length = 1000, width = 35, height = 700, mass = 300
     * 输出："Heavy"
     * 解释：
     * 箱子没有任何维度大于等于 104 。
     * 体积为 24500000 <= 109 。所以不能归类为 "Bulky" 。
     * 但是质量 >= 100 ，所以箱子是 "Heavy" 的。
     * 由于箱子不是 "Bulky" 但是是 "Heavy" ，所以我们返回 "Heavy" 。
     * @param length
     * @param width
     * @param height
     * @param mass
     * @return
     */
    public String categorizeBox(int length, int width, int height, int mass) {

        int dim1 = 10000;
        int dim2 = 1000000000;
        long lFactor = 1L;
        boolean isHeavy = mass >= 100;
        boolean isBulky = (length >= dim1 || width >= dim1 || height >= dim1) || lFactor*length * width * height >= dim2;

        if (isHeavy && isBulky) {
            return "Both";
        } else if(isHeavy && !isBulky) {
            return "Heavy";
        } else if(isBulky && !isHeavy) {
            return "Bulky";
        } else {
            return "Neither";
        }
    }
}

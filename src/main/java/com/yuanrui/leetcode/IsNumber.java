package com.yuanrui.leetcode;

/**
 * 65. 有效数字
 * @author: yuanrui
 */
public class IsNumber {

    public static void main(String[] args) {
        IsNumber isNumber = new IsNumber();

        System.out.println(isNumber.isNumber(".1"));
    }

    public boolean isNumber(String s) {
        s = s.toLowerCase();
        int eIdx = s.indexOf('e');
        if (eIdx > -1) {
            return eIdx != 0 && isIntegerOfFloat(s.substring(0, eIdx)) && isInteger(s.substring(eIdx));
        }
        int dotIdx = s.indexOf('.');
        if (dotIdx > -1) {
            if (dotIdx == (s.length() - 1))
                return false;
            else if (dotIdx == 0) {
                return postDot(s.substring(dotIdx+1));
            } else return preDot(s.substring(0, dotIdx)) && postDot(s.substring(dotIdx + 1));
        }


        return isInteger(s);
    }

    private boolean preDot(String s) {
        if (s.charAt(0) == '-' || s.charAt(0) == '+')
            s = s.substring(1);
        for (int i = 0; i < s.length(); i++)
            if (!(s.charAt(i) >= '0' && s.charAt(i) <= '9'))
                return false;
        return true;
    }

    private boolean postDot(String s) {
        return isPositiveInteger(s);
    }

    private boolean isPositiveInteger(String s) {
        if (s.isEmpty())
            return false;
        if (s.charAt(0) == '+')
            s = s.substring(1);
        if (s.isEmpty())
            return false;
        for (int i = 0; i < s.length(); i++)
            if (!(s.charAt(i) >= '0' && s.charAt(i) <= '9'))
                return false;
        return true;
    }

    private boolean isInteger(String s) {
        if (s.isEmpty())
            return false;
        if (s.charAt(0) == '-' || s.charAt(0) == '+')
            s = s.substring(1);
        if (s.isEmpty())
            return false;
        for (int i = 0; i < s.length(); i++)
            if (!(s.charAt(i) >= '0' && s.charAt(i) <= '9'))
                return false;
        return true;
    }

    private boolean isIntegerOfFloat(String s) {
        if (s.isEmpty())
            return false;
        if (s.charAt(0) == '-' || s.charAt(0) == '+')
            s = s.substring(1);
        if (s.isEmpty())
            return false;
        for (int i = 0; i < s.length(); i++)
            if (!((s.charAt(i) >= '0' && s.charAt(i) <= '9') || s.charAt(i) == '.'))
                return false;
        return true;
    }
}

package com.yuanrui.leetcode;

/**
 * 65. 有效数字
 * @author: yuanrui
 */
public class IsNumber {

    public static void main(String[] args) {
        IsNumber isNumber = new IsNumber();
        System.out.println(isNumber.isNumber("+.E3"));
    }

    public boolean isNumber(String s) {
        if (s.equals("."))
            return false;
        int eIdx = -1;
        for (int i = 0; i < s.length(); ++i)
            if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                eIdx = i;
                break;
            }
        if (eIdx > -1)
            return eIdx != 0 && isIntegerOfFloat(s.substring(0, eIdx)) && isInteger(s.substring(eIdx+1));
        int dotIdx = s.indexOf('.');
        if (dotIdx > -1)
            if (dotIdx < s.length() - 1 && (s.charAt(dotIdx+1) == '-' || s.charAt(dotIdx+1) == '+'))
                return false;
            else if (dotIdx == 0)
                return postDot(s.substring(dotIdx+1));
            else if (dotIdx == s.length() - 1)
                return isInteger(s.substring(0,dotIdx));
            else
                return preDot(s.substring(0, dotIdx)) && postDot(s.substring(dotIdx + 1));


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
        if (s.isEmpty())
            return true;
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
        if (s.equals(".") || s.isEmpty())
            return false;
        int countDot = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.') {
                countDot++;
                continue;
            }
            if (!(s.charAt(i) >= '0' && s.charAt(i) <= '9'))
                return false;
        }
        return countDot <= 1;
    }
}

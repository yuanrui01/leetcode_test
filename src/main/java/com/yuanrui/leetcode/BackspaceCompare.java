package com.yuanrui.leetcode;

import java.util.Stack;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/4/9-16:27
 */
public class BackspaceCompare {

    public static void main(String[] args) {
        backspaceCompare("ab#c", "ab#c");
    }

    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> charStack1 = new Stack<>();
        Stack<Character> charStack2 = new Stack<>();
        String sTrim = "";
        String tTrim = "";

        for(int i = 0; i < s.length(); ++i){
            char c = s.charAt(i);
            if(c != '#'){
                charStack1.push(c);
            }else if(!charStack1.isEmpty()){
                charStack1.pop();
            }
        }
        if (!charStack1.isEmpty()){
            sTrim = charStack1.toString();
        }

        for(int i = 0; i < t.length(); ++i){
            char c = t.charAt(i);
            if(c != '#'){
                charStack2.push(c);
            }else if(!charStack2.isEmpty()){
                charStack2.pop();
            }
        }
        if (!charStack2.isEmpty()){
            tTrim = charStack2.toString();
        }

        return sTrim.equals(tTrim);
    }
}

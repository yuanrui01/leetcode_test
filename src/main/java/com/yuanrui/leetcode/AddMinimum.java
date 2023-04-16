package com.yuanrui.leetcode;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/4/16-11:10
 */
public class AddMinimum {

    public static void main(String[] args) {
        System.out.println(addMinimum("aaabcb"));
        //System.out.println(addMinimum("aaa"));
        //System.out.println(addMinimum("abc"));
    }

    public static int addMinimum(String word) {
        int cnt = 0;
        while(word.length() != 0){
            if(word.startsWith("abc")){
                word = word.replaceFirst("abc", "");
            }else if(word.startsWith("ab")){
                word = word.replaceFirst("ab", "");
                cnt++;
            }else if (word.startsWith("bc")){
                word = word.replaceFirst("bc", "");
                cnt++;
            }else if (word.startsWith("ac")){
                word = word.replaceFirst("ac", "");
                cnt++;
            }else{
                if (word.startsWith("a")){
                    word = word.replaceFirst("a", "");
                    cnt = cnt + 2;
                }else if (word.startsWith("b")){
                    word = word.replaceFirst("b", "");
                    cnt = cnt + 2;
                }else if (word.startsWith("c")){
                    word = word.replaceFirst("c", "");
                    cnt = cnt + 2;
                }
            }
        }

        return cnt;
    }
}

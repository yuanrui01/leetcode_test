package com.yuanrui.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 804. 唯一摩尔斯密码词
 */
public class UniqueMorseRepresentations {

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> result = new HashSet<>();
        String[] morseArr = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        for (String word : words) {
            char[] charArray = word.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (char c : charArray)
                sb.append(morseArr[c - 'a']);
            result.add(sb.toString());
        }

        return result.size();
    }
}

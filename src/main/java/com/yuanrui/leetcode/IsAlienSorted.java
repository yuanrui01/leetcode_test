package com.yuanrui.leetcode;

public class IsAlienSorted {

    public static void main(String[] args) {
        String[] words = {"word","world","row"};
        String order = "worldabcefghijkmnpqstuvxyz";

        isAlienSorted(words, order);
    }


    public static boolean isAlienSorted(String[] words, String order) {
        if (words.length == 1)
            return true;
        int[] alienOrder = new int[27];
        char[] orderArray = order.toCharArray();
        for (int i = 0; i < orderArray.length; ++i) {
            alienOrder[orderArray[i] - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; ++i) {
            if (!goodOrder(words[i], words[i+1], alienOrder))
                return false;
        }
        return true;
    }

    private static boolean goodOrder(String word1, String word2, int[] alienOrder) {
        if (word1.equals(word2))
            return true;
        int word1Len = word1.length();
        int word2Len = word2.length();
        int k = 0;
        while (k < word1Len && k < word2Len) {
            if (alienOrder[word1.charAt(k) - 'a'] < alienOrder[word2.charAt(k) - 'a'])
                return true;
            else if (alienOrder[word1.charAt(k) - 'a'] > alienOrder[word2.charAt(k) - 'a'])
                return false;
            k++;
        }
        return word1Len <= word2Len;
    }


}

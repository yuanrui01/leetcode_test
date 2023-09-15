package com.yuanrui.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 1410. HTML 实体解析器
 * @author: yuanrui
 */
public class EntityParser {

    public static String entityParser(String text) {
        Deque<Integer> andStack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int textLen = text.length();
        text.replace("32","sfsds");
        for (int i = 0; i < textLen; ++i) {
            int k = i;
            while (i < text.length() && text.charAt(i) != '&' && text.charAt(i) != ';')
                i++;
            sb.append(text.substring(k, Math.min(i + 1, textLen)));
            if (i == textLen)
                break;
            if (text.charAt(i) == '&')
                andStack.push(i);
            else if (text.charAt(i) == ';' && !andStack.isEmpty()) {
                int pop = andStack.pop();
                if (i - pop <= 7) {
                    String sub = text.substring(pop, i);
                    int len = sb.length();
                    switch (sub) {
                        case "&quot" -> sb.replace(len - 6, len, "\"");
                        case "&apos" -> sb.replace(len - 6, len, "'");
                        case "&amp" -> sb.replace(len - 5, len, "&");
                        case "&gt" -> sb.replace(len - 4, len, ">");
                        case "&lt" -> sb.replace(len - 4, len, "<");
                        case "&frasl" -> sb.replace(len - 7, len, "/");
                    }
                }
            }
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        String text = "&amp; is an HTML entity but &ambassador; is not.";

        System.out.println(entityParser(text));
    }
}

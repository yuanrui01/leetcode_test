package com.yuanrui.leetcode;

import java.util.Stack;

/**
 * 1410. HTML 实体解析器
 * @author: yuanrui
 */
public class EntityParser {

    public static String entityParser(String text) {
        Stack<Integer> andStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); ++i) {
            sb.append(text.charAt(i));
            if (text.charAt(i) == '&')
                andStack.push(i);
            else if (text.charAt(i) == ';' && !andStack.isEmpty()) {
                Integer pop = andStack.pop();
                if (i - pop <= 7) {
                    String sub = text.substring(pop, i);
                    int len = sb.length();
                    if (sub.equals("&quot")) {
                        sb.replace(len - 6, len, "\"");
                    } else if (sub.equals("&apos")) {
                        sb.replace(len - 6, len, "'");
                    } else if (sub.equals("&amp")) {
                        sb.replace(len - 5, len, "&");
                    } else if (sub.equals("&gt")) {
                        sb.replace(len - 4, len, ">");
                    } else if (sub.equals("&lt")) {
                        sb.replace(len - 4, len, "<");
                    } else if (sub.equals("&frasl")) {
                        sb.replace(len - 7, len, "/");
                    }
                }
            }
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        String text = "and I quote: &quot;...&quot;";

        System.out.println(entityParser(text));
    }
}

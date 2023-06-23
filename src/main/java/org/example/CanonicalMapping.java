package org.example;

import java.util.*;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/5/20-21:48
 */
public class CanonicalMapping {
    private static final int SIZE = 20;
    static void showKeys(Map<String, String> ms) {
        List<String> sl = new ArrayList<>(ms.keySet());
        Collections.sort(sl);
        System.out.println(sl);
    }

    public static void main(String[] args) {
        String[] saveKeys = new String[SIZE];

        Map<String, String> wm = new WeakHashMap<>();

        for (int i = 0; i < SIZE; ++i) {
            String key = String.format("%03d", i);
            String value = Integer.toString(i);

            if (i % 3 == 0) {
                saveKeys[i] = key;
            }
            wm.put(key, value);
        }
        showKeys(wm);
        System.gc();
        showKeys(wm);
    }
}

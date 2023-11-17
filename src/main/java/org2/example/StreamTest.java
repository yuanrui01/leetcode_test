package org2.example;

import java.util.Arrays;
import java.util.List;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/4/13-21:49
 */
public class StreamTest {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        boolean b = list.stream()
                .anyMatch(
                        e -> {
                            System.err.println(e);
                            return e > 3;
                        }
                );
        System.err.println(b);


    }
}

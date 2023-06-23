package org.example;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date ${DATE}-${TIME}
 */
public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Set<String> sSet = new HashSet<>();
        sSet = list.stream()
            .collect(
                Collectors.collectingAndThen(
                    Collectors.toCollection(
                        () -> new TreeSet<>( Comparator.comparing( s -> s.length() ) )
                    )
                    , HashSet::new
                )
        );
    }
}
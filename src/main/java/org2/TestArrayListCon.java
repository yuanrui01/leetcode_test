package org2;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestArrayListCon {

    // ArrayList - (15,20)
    // CopyOnWriteArrayList - (15,20)
    // synchronizedList - (15,20)
    public static void main(String[] args) {
        List<Integer> ids = List.of(1, 1000, 2000, 3000, 4000, 5000, 6000, 7000);
        //List<Integer> result = Collections.synchronizedList(new ArrayList<>());
        List<Integer> result = new CopyOnWriteArrayList();
        long start = Instant.now().toEpochMilli();
        CompletableFuture<Void> allOf = CompletableFuture.allOf(ids.stream().map(i -> CompletableFuture.runAsync(() -> {
            for (int j = i; j < i + 200; j++)
                result.add(j);
        })).toArray(CompletableFuture[]::new));
        allOf.join();
        long end = Instant.now().toEpochMilli();
        System.out.println("consume (" + (end - start) + ")ms");
        System.out.println(result);
        System.out.println(result.size());
    }
}

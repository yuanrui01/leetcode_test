package org2;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class TestArrayListCon2 {

    public static void main(String[] args) {
        List<Integer> ids = List.of(1, 1000, 2000, 3000, 4000, 5000, 6000, 7000);
        List<Integer> result = Collections.synchronizedList(new ArrayList<>());
        //List<Integer> result = new ArrayList<>();
        long start = Instant.now().toEpochMilli();
        List<CompletableFuture<List<Integer>>> collect = ids.stream().map(i -> CompletableFuture.supplyAsync(() -> {
            List<Integer> subResult = new ArrayList<>();
            for (int j = i; j < i + 200; j++)
                subResult.add(j);
            return subResult;
        })).toList();
        for (CompletableFuture<List<Integer>> listCompletableFuture : collect)
            result.addAll(listCompletableFuture.join());
        long end = Instant.now().toEpochMilli();
        System.out.println("consume (" + (end - start) + ")ms");
        System.out.println(result);
        System.out.println(result.size());
    }
}

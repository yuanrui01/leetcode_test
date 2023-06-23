package org.example;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date ${DATE}-${TIME}
 */
public class Main {

    static class IntGenerator implements Supplier<Integer> {
        private int current = 0;
        @Override
        public synchronized Integer get() {
            System.out.println(Thread.currentThread().getName());;
            return current++;
        }
    }
    public static void main(String[] args) {
/*        List<Integer> x =
                Stream.generate(new IntGenerator())
                        .limit(100)
                        .parallel()
                        .collect(Collectors.toList());
        System.out.println(x);*/

        CompletableFuture<Integer> c = new CompletableFuture<>();
        c.complete(9);
        showr(c);
        //
    }

    public static void showr(CompletableFuture<?> c) {
        try{
            System.out.println(c.get());
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
package org.example;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date ${DATE}-${TIME}
 */
public class Main {

    // legion commit
    // legion commit1
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

        /*CompletableFuture<Integer> c = new CompletableFuture<>();
        c.complete(9);
        showr(c);*/
        //

        String s = "1";

        System.out.println(s.substring(1));
    }

    public static void showr(CompletableFuture<?> c) {
        try{
            System.out.println(c.get());
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // a b c d e f111 dssada
    // dsdasd
    // djlmxcnx
    // f3 commit1
    // f3 commit2
}
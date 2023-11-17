package org2.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/5/21-22:08
 */
public class ParallelStreamPuzzle2 {

    public static final Deque<String> trace =
            new ConcurrentLinkedDeque<>();
    static class IntGenerator implements Supplier<Integer> {
        private AtomicInteger current = new AtomicInteger();;

        @Override
        public Integer get() {
            trace.add(current.get() + ": " +
                    Thread.currentThread().getName());
            return current.getAndIncrement();
        }
    }

    public static void main(String[] args) throws IOException {
        List<Integer> x =
                Stream.generate(new IntGenerator())
                        .limit(10)
                        .parallel()
                        .collect(Collectors.toList());
        System.out.println(x);
        Files.write(Paths.get("PSP2.txt"), trace);

//        Executors.newCachedThreadPool().submit();
    }
}

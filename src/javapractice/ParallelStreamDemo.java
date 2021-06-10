package javapractice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.Collectors;

//https://stackoverflow.com/questions/21163108/custom-thread-pool-in-java-8-parallel-stream
public class ParallelStreamDemo {
    public static void main(String[] args) {

        //How to run parallelStream in a specific fork-join pool instead of commonPool
        final int parallelism = 4;
        ForkJoinPool forkJoinPool = null;
        List<Integer> numbers = getNumbers();
        try {
            forkJoinPool = new ForkJoinPool(parallelism);
            ForkJoinTask<List<String>> submit = forkJoinPool.submit(new Callable<List<String>>() {
                @Override
                public List<String> call() {
                    return numbers.parallelStream().map(String::valueOf).collect(Collectors.toList());
                }
            });
            System.out.println(submit.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            if (forkJoinPool != null) {
                forkJoinPool.shutdown();
            }
        }
    }

    private static List<Integer> getNumbers() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        return numbers;
    }
}

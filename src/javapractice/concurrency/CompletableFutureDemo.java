package javapractice.concurrency;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.*;
import java.util.stream.Collectors;

public class CompletableFutureDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 3, 4);
        list.stream()
                .map(num -> CompletableFuture.supplyAsync(() -> num))
                .map(cf -> cf.thenApply(n -> n * n))
                .map(CompletableFuture::join)
                .forEach(System.out::println);
    }

    List test() {
        List<String> res = new ArrayList<>();
        return res.stream().distinct().collect(Collectors.toList());
    }

}

package javapractice.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class Reduce {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        final Optional<Integer> reduce = numbers.stream()
                .filter(x -> x % 2 == 0)
                .reduce((integer, integer2) -> (integer + integer2));


    }
}

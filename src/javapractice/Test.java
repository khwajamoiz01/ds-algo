package javapractice;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Test {
    public static void main(String[] args) {
        new ArrayList<String>().stream().map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return null;
            }
        }).filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return false;
            }
        }).forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {

            }
        });
        //also see supplier
    }
}

package javapractice.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//https://stackoverflow.com/a/26684710/5055762
//TODO check stream advantage
public class MapAndFlatMap {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("k h w a j a");
        list.add("m o i z");
        Stream<String> mapStream = list.stream().map(new Function<String, String>() {
            @Override
            public String apply(String s) {
                //trim or some other logic
                return s.replace(" ", "");
            }
        });
        System.out.println(mapStream.collect(Collectors.toList()));
        Stream<String> flatMapStream = list.stream().flatMap(new Function<String, Stream<String>>() {
            @Override
            public Stream<String> apply(String s) {
                //return Stream.empty() if you wants to send zero values,
                return Stream.of(s.split(" "));
            }
        });
        System.out.println(flatMapStream.collect(Collectors.toList()));
    }
}

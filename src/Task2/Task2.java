package Task2;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Task2 {

    public static void main(String[] args) {

        String input = "yourapp the quick yourapp brown fox jumps yourapp over the lazy yourapp dog";
        List<String>list = new ArrayList<>(Collections.singleton("yourapp the quick yourapp brown fox jumps yourapp over the lazy yourapp dog"));
                list.stream()
                        .flatMap(line -> Stream.of(input.split(" ")))
                        .collect(Collectors.toMap(key -> key, val -> 1, Integer::sum))
                        .entrySet().stream()
                        .sorted((e1, e2) -> {
                            int val = e1.getValue().compareTo(e2.getValue()) * -1;
                            if (val == 0) {
                                val = e1.getKey().compareTo(e2.getKey());
                            }
                            return val;
                        })
                        .forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));

            }

        }


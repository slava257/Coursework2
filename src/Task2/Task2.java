package Task2;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Task2 {
    public static void main(String[] args) {

        String input = "yourapp the quick brown fox jumps over the lazy dog";
        Arrays.stream(input.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((s,c)-> System.out.println(s +" "+ c));

    }
}

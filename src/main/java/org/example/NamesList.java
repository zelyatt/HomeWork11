package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NamesList {


    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Adam");
        names.add("Liza");
        names.add("Piotr");
        names.add("Lesia");
        names.add("Fred");

        sortedNames(names).stream().forEach(name -> System.out.println(name));
        System.out.println(namesWithIndex(names));
        String[] numbers = {"1, 2, 0", "4, 5"};

        sortNumbers(numbers);
        generateNumbers();
    }


    private static String namesWithIndex(List<String> names) {
        String results = IntStream.range(0, names.size()).filter(i -> i % 2 == 0)
                .mapToObj(i -> (i + 1) + ". " + names.get(i))
                .collect(Collectors.joining(", "));
        return results;
    }

    private static List<String> sortedNames(List<String> names) {
        List<String> result = names.stream()
                .map(name -> name.toUpperCase())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        return result;
    }
    private static String sortNumbers(String[] numbers){
        String collectNumbers = Arrays.stream(numbers).flatMap(str -> Arrays.stream(str.split(", ")))
                .map(str -> Integer.parseInt(str)).sorted().map(i -> i.toString()).collect(Collectors.joining(", "));
        System.out.println(collectNumbers);
        return collectNumbers;
    }
    private static void generateNumbers (){
        long c = 11;
        long a = 25214903917L;
        long m = (long) Math.pow(2, 48);

        Stream.iterate(0L, x-> (a * x + c) % m).limit(10).forEach(x -> System.out.println(x));

    }

}

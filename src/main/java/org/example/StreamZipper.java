package org.example;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamZipper {

    public static void main(String[] args) {
        Stream<Integer> firstStream = Stream.of( 2, 3, 2, 3, 4);
        Stream<Integer> secondStream = Stream.of( 6, 7, 8,3);

        zip(firstStream, secondStream)
                .forEach(System.out::println);
    }

    public static <T> Stream<T> zip(Stream<? extends T> first, Stream<? extends T> second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException("Streams cannot be null");
        }

        Object[] firstArray = first.toArray();
        Object[] secondArray = second.toArray();

        return IntStream.range(0, Math.min(firstArray.length, secondArray.length))
                .mapToObj(i -> (T) firstArray[i])
                .flatMap(i -> Stream.of((T) firstArray[(int) i], (T) secondArray[(int) i]))
                .filter(t -> t != null);
    }
}

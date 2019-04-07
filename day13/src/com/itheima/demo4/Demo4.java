package com.itheima.demo4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo4 {
    public static void main(String[] args) {

    }

    private static void method02() {
        List<String> list = Stream.of("10", "20", "30", "40", "50").collect(Collectors.toList());
        Set<String> set = Stream.of("10", "20", "30", "40", "50").collect(Collectors.toSet());

        Object[] objects = Stream.of("10", "20", "30", "40", "50").toArray();
        String[] array = Stream.of("10", "20", "30", "40", "50").toArray(String[]::new);
    }

    private static void method01() {
        String[] arr = {"10", "20", "30", "40", "50", "60", "70"};
        Stream.of(arr).parallel().forEach(System.out::println);

        Collection<String> col = new ArrayList<>();
        Stream<String> stream = col.parallelStream();
    }
}

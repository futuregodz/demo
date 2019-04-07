package com.itheima.demo1;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Demo1 {
    // 需求: 定义一个方法,用来判断一个字符串是否符合某一个条件
    public static boolean method1(String str, Predicate<String> predicate) {
        return predicate.test(str);
    }

    // 需求:定义一个方法,用来判断一个字符串是否同时符合2个条件
    public static boolean method2(String str,Predicate<String> predicate) {
        return predicate.test(str) && predicate.test(str);
    }

    // 需求:定义一个方法,用来判断一个字符串是否同时符合2个条件 and
    public static boolean method3(String str, Predicate<String> one,Predicate<String> two) {
        return one.and(two).test(str);
    }

    // 需求:定义一个方法,用来判断一个字符串是否符合2个条件之一 or
    public static boolean method4(String str, Predicate<String> one, Predicate<String> two) {
        return one.or(two).test(str);
    }

    // 需求:定义一个方法,用来判断一个字符串是否符合某个条件取反
    public static boolean method5(String str, Predicate<String> predicate) {
        return predicate.negate().test(str);
    }

    public static ArrayList<String> method6(String[] array, Predicate<String> one, Predicate<String> two) {
        ArrayList<String> list = new ArrayList<>();
        for (String str : array) {
            boolean flag = one.and(two).test(str);
            if (flag) {
                list.add(str);
            }
        }
        return list;
    }


    public static void main(String[] args) {
        /*
        练习：集合信息筛选
        数组当中有多条“姓名+性别”的信息如下，请通过Predicate接口的拼装将符合要求的字符串筛选到集合ArrayList中，
        需要同时满足两个条件：
            1. 必须为女生；
            2. 姓名为4个字。
         */
        String[] array = { "迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男", "赵丽颖,女" };
        ArrayList<String> list = method6(array, str1 -> "女".equals(str1.split(",")[1]),str2 -> str2.split(",")[0].length() == 4);
        System.out.println(list);

    }

    private static void method04() {
        // 需求: 调用一个方法,判断str的长度是否大于5或者是否包含"World"
        String str = "Hello World";
        System.out.println(method4(str, str1 -> str1.length() > 5, str2 -> str2.contains("World"))); // true

        // 需求: 调用一个方法,判断str的长度是否不大于5
        System.out.println(method5(str, str1 -> str1.length() > 5));  // false
        System.out.println(method5(str, str1 -> str1.contains("World")));  // false
    }

    private static void method03() {
        // 需求: 调用一个方法,判断str的长度是否大于5并且是否包含"World"
        String str = "Hello World";
        System.out.println(method2(str, str1 -> str1.length() > 5 && str1.contains("World"))); // true
        System.out.println(method3(str, str1 -> str1.length() > 5, str2 -> str2.contains("Worlds")));  // false
    }

    private static void method02() {
        // 调用method1方法,判断str的长度是否大于5
        String str = "Hello World";
        System.out.println(method1(str, str1 -> str1.length() > 5));
        // 调用method1方法,判断str的是否包含World字符串
        System.out.println(method1(str, str2 -> str2.contains("World")));
    }

    private static void method01() {
        Integer[] integers = Stream.of("90", "80", "70").map(Integer::parseInt).toArray(Integer[]::new);
        Stream.of(integers).forEach(System.out::println);
    }
}

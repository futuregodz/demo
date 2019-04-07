package com.itheima.demo2;

import java.util.function.Function;

public class Demo2 {

    // 需求:定义一个方法,可以把一种数据类型的数据转换为另一种数据类型的数据
    public static Integer method1(String str, Function<String, Integer> function) {
        return function.apply(str);
    }

    // 需求:定义一个方法,可以把String类型的数字字符串转换为Integer类型,然后再把Integer类型的数扩大10倍之后变成String类型
    public static String method2(String str, Function<String, Integer> one, Function<Integer, String> two) {
        return one.andThen(two).apply(str);
    }

    // 需求: 定义一个方法,把字符串转换为int类型,需要经过三次转换
    public static int method3(String str,Function<String,String> one,Function<String,Integer> two,Function<Integer,Integer> three) {
        return one.andThen(two).andThen(three).apply(str);
    }


    public static void main(String[] args) {
        /*练习：自定义函数模型拼接
            请使用Function进行函数模型的拼接，按照顺序需要执行的多个函数操作为：
                1. 将字符串截取数字年龄部分，得到字符串；
                2. 将上一步的字符串转换成为int类型的数字；
                3. 将上一步的int数字累加100，得到结果int数字。*/
        String str = "赵丽颖,20";
        int i1 = method3(str, str1 -> str1.split(",")[1], Integer::valueOf, i -> i += 100);
        System.out.println(i1);

    }

    private static void method01() {
        String str = "100";
        System.out.println(method1(str, Integer::valueOf) + 1);  // 101
        System.out.println(method2(str, Integer::valueOf, i -> String.valueOf(i * 10)) + 1);  // 10001
    }
}

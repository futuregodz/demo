package src1.com.itheima.demo3;

import java.util.function.Function;

/*
Function 接口: 转换接口
    1.java.util.function.Function<T,R>接口用来根据一个类型的数据得到另一个类型的数据，前者称为前置条件，后者称为后置条件。
    有进有出，所以称为“函数Function”。
        T:代表被转换的数据的数据类型
        R:代表转换之后的数据的数据类型
   2.抽象方法:
        R apply(T t)，根据类型T的参数获取类型R的结果
        类型转换,至于如何转换得看Lambda表达式
 */
public class Demo3 {

    // 需求:定义一个方法,可以把一种数据类型的数据转换为另一种数据类型的数据
    public static Integer method1(Function<String,Integer> function,String str){
        Integer i = function.apply(str);
        return i;
    }

    // 需求:定义一个方法,可以把String类型的数字字符串转换为Integer类型,然后再把Integer类型的数扩大10倍之后变成String类型
    public static String method2(String str,Function<String,Integer> one,Function<Integer,String> two){

/*        // String类型的数字字符串转换为Integer类型
        Integer i = one.apply(str);

        // 把Integer类型的数扩大10倍
//        i = i * 10;

        // 把Integer类型变成String类型
        String apply = two.apply(i*10);*/
        String apply = one.andThen(two).apply(str);//

        return apply;
    }

    // 需求: 定义一个方法,把字符串转换为int类型,需要经过三次转换
    public static int method3(String str,Function<String,String> one,Function<String,Integer> two,Function<Integer,Integer> three){
        Integer apply = one.andThen(two).andThen(three).apply(str);
        return apply;
    }

    public static int method4(String str,Function<String,String> one,Function<String,Integer> two){
        Integer apply = one.andThen(two).apply(str);
        return apply;
    }

    public static void main(String[] args) {

        /*
            练习：自定义函数模型拼接
            请使用Function进行函数模型的拼接，按照顺序需要执行的多个函数操作为：
                1. 将字符串截取数字年龄部分，得到字符串；
                2. 将上一步的字符串转换成为int类型的数字；
                3. 将上一步的int数字累加100，得到结果int数字。
         */
        String str = "赵丽颖,20";

        int num = method3(str,str1->str1.split(",")[1],str2->Integer.valueOf(str2),i->i+100);
        System.out.println(num);

        int num2 = method4(str,str1->str1.split(",")[1],str2->Integer.valueOf(str2));
        System.out.println(num2+100);


    }

    private static void method02() {
        String str = "100";

        String newStr = method2(str,str1->Integer.valueOf(str1),i->String.valueOf(i*10));// 1000 "1000"
        System.out.println(newStr+1);// 10001
    }

    private static void method01() {
        String str = "100";

        Integer i = method1(str1->Integer.valueOf(str1),str);
        System.out.println(i+1);// 101
    }
}

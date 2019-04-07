package src1.com.itheima.demo2;

import java.util.ArrayList;
import java.util.function.Predicate;

/*
常用函数式接口: Predicate(判断接口)  Function(转换接口)
Stream流:  思想,介绍常用方法(filter,count,limit,skip,concat,forEach,map)

调用函数式接口的抽象方法就会执行Lambda表达式的解决方案

Predicate<T>(判断接口):
    1.有时候我们需要对某种类型的数据进行判断，从而得到一个boolean值结果。这时可以使用java.util.function.Predicate<T>接口。
    2.抽象方法:
        boolean test(T t)

        test方法是用来判断传入的对象是否符合指定条件
        指定条件在Lambda表达式中指定
    3.默认方法:
        既然是条件判断，就会存在与、或、非三种常见的逻辑关系
        默认方法：and
        默认方法：or
        默认方法：negate

 */
public class Demo2 {

    // 需求: 定义一个方法,用来判断一个字符串是否符合某一个条件
    public static boolean method1(String str, Predicate<String> predicate){
        // 进行判断
        boolean flag = predicate.test(str);// 判断str是否符合指定条件
        return flag;
    }

    // 需求:定义一个方法,用来判断一个字符串是否同时符合2个条件 and
    public static boolean method2(String str,Predicate<String> one,Predicate<String> two){
//        boolean flag = one.test(str) && two.test(str);
        // 优化
        boolean flag = one.and(two).test(str);
        return flag;
    }

    // 需求:定义一个方法,用来判断一个字符串是否符合2个条件之一 or
    public static boolean method3(String str,Predicate<String> one,Predicate<String> two){
//        boolean flag = one.test(str) || two.test(str);
        // 优化
        boolean flag = one.or(two).test(str);
        return flag;
    }

    // 需求:定义一个方法,用来判断一个字符串是否符合某个条件取反
    public static boolean method4(String str, Predicate<String> predicate){
        // 进行判断
//        boolean flag = !predicate.test(str);// 判断str是否符合指定条件
        boolean flag = predicate.negate().test(str);
        return flag;
    }

    public static ArrayList<String> method5(String[] arr, Predicate<String> one, Predicate<String> two){

        ArrayList<String> list = new ArrayList<>();

        for (String e : arr) {
            boolean flag = one.and(two).test(e);
            if(flag == true){
                list.add(e);
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

        ArrayList<String> list = method5(array, e1 -> "女".equals(e1.split(",")[1]), e2 -> e2.split(",")[0].length() == 4);
        System.out.println(list);

    }



    private static void method02() {
        String str = "Hello World";

        // 需求: 调用一个方法,判断str的长度是否大于5并且是否包含"World"
        boolean res = method1(str, str1 -> str1.length() > 5 && str1.contains("World"));
        System.out.println(res);// true

        boolean res4 = method4(str, str1 -> str1.length() > 5 && str1.contains("World"));
        System.out.println(res4);// flase


        /*boolean res2 = method2(str, str1 -> str1.length() > 5, str2 -> str2.contains("World"));
        System.out.println(res2);// true*/

      /*  boolean res3 = method3(str, str1 -> str1.length() > 5, str2 -> str2.contains("World"));
        System.out.println(res3);//true*/
    }

    private static void method01() {
        String str = "Hello World";

        // 调用method1方法,判断str的长度是否大于5
//        boolean res1 = method1(str,(String str1)->{ return str.length() > 5;});
        boolean res1 = method1(str,str1->str.length() > 5);
        if(res1 == true){
            System.out.println("str的长度大于5");
        }else{
            System.out.println("str的长度不大于5");

        }

        // 调用method1方法,判断str的是否包含World字符串
        boolean res2 = method1(str, str2 -> str2.contains("World"));
        if(res2==true){
            System.out.println("包含");
        }else{
            System.out.println("不包含");
        }
    }
}

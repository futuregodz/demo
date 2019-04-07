package src1.com.itheima.demo4;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Stream流:
    1.全新的Stream概念，用于解决已有集合类库既有的弊端。
    2.对比传统方式和Stream方法操作集合
    3.Stream流:
        0.概述:流式思想类似于工厂车间的“生产流水线”。
        1.特点:
            1.Stream流是单向的,不能重复使用   重点
            2.Stream流不能存储数据
            3.Stream流具有延迟性      重点
            4.Steam流不会修改源数据    重点

        3.Stream流方法的分类  重点
            - 终结方法：返回值类型不再是Stream接口自身类型的方法，因此不再支持类似StringBuilder那样的链式调用。本小节中，终结方法包括count和forEach方法。
            - 延迟方法：返回值类型仍然是Stream接口自身类型的方法，因此支持链式调用。（除了终结方法外，其余方法均为延迟方法。）
        4.使用步骤:
            通常包括三个基本步骤：获取一个数据源（source）→ 数据转换→执行操作获取想要的结果，
            每次转换原有 Stream 对象不改变，返回一个新的 Stream 对象（可以有多次转换），这就允许对其操作可以像链条一样排列，变成一个管道
        5.使用Stream流:
            1.获取流的方式:
                - 所有的Collection集合都可以通过stream默认方法获取流；
                - Stream接口的静态方法of可以获取数组对应的流。
            2.Stream流常用方法:  终结方法(返回值类型不是Stream),延迟方法(返回值类型为Stream)
                1.过滤的方法: filter  延迟方法
                    可以通过filter方法将一个流转换成另一个子集流。方法签名：
                    Stream<T> filter(Predicate<? super T> predicate);
                    该接口接收一个Predicate函数式接口参数（可以是一个Lambda或方法引用）作为筛选条件

                2.统计个数：count  终结方法
                    long count();

                3.取用前几个：limit  延迟方法
                    limit方法可以对流进行截取，只取用前n个。方法签名：
                        Stream<T> limit(long maxSize);
                    参数是一个long型，如果集合当前长度大于参数则进行截取；否则不进行操作。

                4.逐一处理：forEach  终结方法
                    1.该方法并不保证元素的逐一消费动作在流中是被有序执行的。
                    2.void forEach(Consumer<? super T> action);

                5.跳过前几个：skip  延迟方法
                    如果希望跳过前几个元素，可以使用skip方法获取一个截取之后的新流：
                    Stream<T> skip(long n);
                    如果流的当前长度大于n，则跳过前n个；否则将会得到一个长度为0的空流。
                6.映射：map
                    如果需要将流中的元素映射到另一个流中，可以使用map方法。方法签名：
                    <R> Stream<R> map(Function<? super T, ? extends R> mapper);
                    该接口需要一个Function函数式接口参数，可以将当前流中的T类型数据转换为另一种R类型的流。

                7.组合：concat  延迟方法
                    如果有两个流，希望合并成为一个流，那么可以使用Stream接口的静态方法concat：
                    static <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b)
       总结:
        延迟:
             Stream<T> filter(Predicate<? super T> predicate);
             Stream<T> limit(long maxSize);
             Stream<T> skip(long n);
             Stream<R> map(Function<? super T, ? extends R> mapper);
             Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b)
         终结:
            long count();
            void forEach(Consumer<? super T> action);
并发流:
通过非并发流转换并发流:
    Stream<E> parallel();

直接获取并发流
    在通过集合获取流时，也可以直接调用parallelStream方法来直接获取支持并发操作的流。方法定义为：
        default Stream<E> parallelStream() {...}

收集Stream结果
对流操作完成之后，如果需要将其结果进行收集，例如获取对应的集合、数组等，如何操作？
收集到集合中
Stream流提供collect方法，
     <R, A> R collect(Collector<? super T, A, R> collector);
其参数需要一个java.util.stream.Collector<T,A, R>接口对象来指定收集到哪种集合中。
    幸运的是，java.util.stream.Collectors类提供一些方法，可以作为Collector接口的实例：
    - public static <T> Collector<T, ?, List<T>> toList()：转换为List集合。
    - public static <T> Collector<T, ?, Set<T>> toSet()：转换为Set集合。

 */
public class Demo4 {
    public static void main(String[] args) {
        ArrayList<String> one = new ArrayList<>();

        one.add("迪丽热巴");
        one.add("宋远桥");
        one.add("苏星河");
        one.add("石破天");
        one.add("石中玉");
        one.add("老子");
        one.add("庄子");
        one.add("洪七公");

//        1. 第一个队伍只要名字为3个字的成员姓名；
//        2. 第一个队伍筛选之后只要前3个人；// 宋远桥 苏星河 石破天
        Stream<String> stream1 = one.stream().filter(str1 -> str1.length() == 3).limit(3);
//        stream1.forEach(System.out::println);

        // 把stream1中的元素存储到list集合中
//        List<String> list = stream1.collect(Collectors.toList());
//        System.out.println(list);

        // 把stream1中的元素存储到Set集合中
//        Set<String> set = stream1.collect(Collectors.toSet());
//        System.out.println(set);

        // 把stream1中的元素存储到数组中
        Object[] obj = stream1.toArray();
        System.out.println(Arrays.toString(obj));


/*        题目

        请通过Stream流的方式，将下面数组当中的元素添加（收集）到List集合当中：

        解答*/
        String[] array = { "Java", "Groovy", "Scala", "Kotlin" };

        List<String> list = Stream.of(array).collect(Collectors.toList());
        System.out.println(list);




     /*  List<Integer> list = new ArrayList<>();
        Stream<Integer> stream1 = list.stream();// 非并发流
        Stream<Integer> stream2 = list.parallelStream();// 并发流*/


        // 通过非并发流转换并发流
/*        Stream<Integer> stream = Stream.of(10, 20, 30, 40, 50).parallel();
        stream.forEach(System.out::println);*/

//        Stream<Integer> stream = Stream.of(10, 20, 30, 40, 50);
//        stream.forEach(System.out::println);

    }

    private static void method08() {
    /*
        现在有两个ArrayList集合存储队伍当中的多个成员姓名，要求使用传统的for循环（或增强for循环）依次进行以下若干操作步骤：
        1. 第一个队伍只要名字为3个字的成员姓名；
        2. 第一个队伍筛选之后只要前3个人；// 宋远桥 苏星河 石破天
        3. 第二个队伍只要姓张的成员姓名；
        4. 第二个队伍筛选之后不要前2个人；//  张天爱 张二狗
        5. 将两个队伍合并为一个队伍；
        6. 根据姓名创建Person对象；
        7. 打印整个队伍的Person对象信息

     */
        // Stream流方式:
        //第一支队伍
        ArrayList<String> one = new ArrayList<>();

        one.add("迪丽热巴");
        one.add("宋远桥");
        one.add("苏星河");
        one.add("石破天");
        one.add("石中玉");
        one.add("老子");
        one.add("庄子");
        one.add("洪七公");

        //第二支队伍
        ArrayList<String> two = new ArrayList<>();
        two.add("古力娜扎");
        two.add("张无忌");
        two.add("赵丽颖");
        two.add("张三丰");
        two.add("尼古拉斯赵四");
        two.add("张天爱");
        two.add("张二狗");

//        1. 第一个队伍只要名字为3个字的成员姓名；
//        2. 第一个队伍筛选之后只要前3个人；// 宋远桥 苏星河 石破天
        Stream<String> stream1 = one.stream().filter(str1 -> str1.length() == 3).limit(3);

//        3. 第二个队伍只要姓张的成员姓名；
//        4. 第二个队伍筛选之后不要前2个人；//  张天爱 张二狗
        Stream<String> stream2 = two.stream().filter(str1 -> str1.startsWith("张")).skip(2);

//        5. 将两个队伍合并为一个队伍；
        Stream.concat(stream1, stream2).map(Person::new).forEach(System.out::println);

//        Stream<String> stream3 = Stream.concat(stream1, stream2);

//        6. 根据姓名创建Person对象；
//        7. 打印整个队伍的Person对象信息
//        stream3.map(str->new Person(str)).forEach(System.out::println);
//        stream3.map(Person::new).forEach(System.out::println);
    }

    private static void method07() {
        // 传统方式:
        //第一支队伍
        ArrayList<String> one = new ArrayList<>();

        one.add("迪丽热巴");
        one.add("宋远桥");
        one.add("苏星河");
        one.add("石破天");
        one.add("石中玉");
        one.add("老子");
        one.add("庄子");
        one.add("洪七公");

        //第二支队伍
        ArrayList<String> two = new ArrayList<>();
        two.add("古力娜扎");
        two.add("张无忌");
        two.add("赵丽颖");
        two.add("张三丰");
        two.add("尼古拉斯赵四");
        two.add("张天爱");
        two.add("张二狗");

//        1. 第一个队伍只要名字为3个字的成员姓名；
        ArrayList<String> oneList1 = new ArrayList<>();
        for (String e1 : one) {
            if (e1.length() == 3) {
                oneList1.add(e1);
            }
        }
//        2. 第一个队伍筛选之后只要前3个人；
        ArrayList<String> oneList2 = new ArrayList<>();
        for (int i = 0; i <= 2; i++) {
            oneList2.add(oneList1.get(i));
        }

//        3. 第二个队伍只要姓张的成员姓名；
        ArrayList<String> twoList1 = new ArrayList<>();
        for (String e2 : two) {
            if (e2.startsWith("张")) {
                twoList1.add(e2);
            }
        }
//        4. 第二个队伍筛选之后不要前2个人；
        ArrayList<String> twoList2 = new ArrayList<>();
        for (int i = 2; i < twoList1.size(); i++) {
            twoList2.add(twoList1.get(i));
        }


//        5. 将两个队伍合并为一个队伍；
        ArrayList<String> newList = new ArrayList<>();
        for (String e1 : oneList2) {
            newList.add(e1);
        }

        for (String e2 : twoList2) {
            newList.add(e2);
        }

//        6. 根据姓名创建Person对象；
        ArrayList<Person> listP = new ArrayList<>();
        for (String e : newList) {
            Person p = new Person(e);
            listP.add(p);
        }

//        7. 打印整个队伍的Person对象信息
        for (Person p : listP) {
            System.out.println(p);
        }
        /*
            Person{name='宋远桥'}
            Person{name='苏星河'}
            Person{name='石破天'}
            Person{name='张天爱'}
            Person{name='张二狗'}
         */
    }

    private static void method06() {
        String[] arr = {"10", "20", "30", "40", "50", "60", "70"};

        // 需求: 把arr数组中的元素转换为int类型,输出打印
        // 流的解决方式:
//        Stream.of(arr).map(str->Integer.valueOf(str)).forEach(System.out::println);


        String[] arr2 = {"张三,10", "张三,20", "张三,30", "张三,40", "张三,50", "张三,60", "张三,70"};
        /*
               1. 将字符串截取数字年龄部分，得到字符串；
                2. 将上一步的字符串转换成为int类型的数字；
                3. 将上一步的int数字累加100，得到结果int数字。
         */
        Stream<String> stream1 = Stream.of(arr2).map(str1 -> str1.split(",")[1]);
        Stream<Integer> stream2 = stream1.map(str -> Integer.valueOf(str));
        Stream<Integer> stream3 = stream2.map(i -> i + 100);
        stream3.forEach(System.out::println);
    }

    private static void method05() {
        List<String> list = new ArrayList<>();

        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");

        // 获取流,跳过前面2个元素
//        list.stream().skip(2).forEach(System.out::println);//3
//        list.stream().skip(6).forEach(System.out::println);
/*        long count = list.stream().skip(6).count();
        System.out.println(count);//0*/
    }

    private static void method04() {
        List<String> list = new ArrayList<>();

        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");


        // 截取前3个元素
//        Stream<String> limit = list.stream().limit(3);
//        System.out.println(limit.count());
//        System.out.println(count);//3

        // 截取前3个元素并打印出来
        list.stream().limit(3).forEach(System.out::println);

//        list.stream().parallel().limit(3).forEach(System.out::println);

        Integer[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        Stream.of(arr).parallel().forEach(System.out::println);


        // 过滤之后,只留下姓张的元素,并计算有多少个
//        long size = list.stream().filter(str -> str.startsWith("张")).count();// 得到一个新的流 ,流中的元素是姓张的元素
//        System.out.println(size);//3
    }

    private static void method03() {
        // 获取Collection集合对应的流
        Collection<String> col = new ArrayList<>();
        Stream<String> stream1 = col.stream();

        List<String> list = new ArrayList<>();
        Stream<String> stream2 = list.stream();

        Set<String> set = new HashSet<>();
        Stream<String> stream3 = set.stream();

        // 获取Map集合对应的流 : 获取所有键对应的流,获取所有值对应的流,获取所有键值对对象对应的流
        Map<String, String> map = new HashMap<>();

        Stream<String> keySteam = map.keySet().stream();

        Stream<String> valueStream = map.values().stream();

        Stream<Map.Entry<String, String>> entryStream = map.entrySet().stream();


        // 获取数据对应的流
        String[] arr = new String[4];
        Stream<String> streamArr = Stream.of(arr);
    }

    private static void method02() {
    /*
    试想一下，如果希望对集合中的元素进行筛选过滤：
        1. 将集合A根据条件一过滤为子集B；
        2. 然后再根据条件二过滤为子集C。

     */
        // 传统方式: 每一次过滤都得创建一个新的集合,并且需要遍历,然后再判断
        // 想要过滤,必须循环遍历
        // 循环遍历:方式
        // 目的: 过滤
        // 能不能直接过滤,不需要通过循环遍历????? --->函数式编程  Stream流
        List<String> list = new ArrayList<>();

        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");

   /*     // 将list集合过滤出姓张的元素存储到另一个集合中
        List<String> list1 = new ArrayList<>();// 存储的是姓张的元素
        for (String e1 : list) {
            if(e1.startsWith("张")){
                list1.add(e1);
            }
        }

        // 将过滤出姓张的集合之后,再过滤出长度为3的元素,将其存储到一个集合中
        List<String> list2 = new ArrayList<>();
        for (String e2 : list1) {
            if(e2.length() == 3){
                list2.add(e2);
            }
        }
//        System.out.println(list2);// [张无忌, 张三丰]

        // 遍历打印出list2中的元素
        for (String s : list2) {
            System.out.println(s);
        }*/

        // Stream流的方式完成以上需求
//        list.stream().filter(str1->str1.startsWith("张")).filter(str2->str2.length()==3).forEach(str3->System.out.println(str3));
        // 获取流          按条件过滤得到一个新的流            按条件过滤又得到一个新的流         遍历出新的流中的元素
//        list.stream().filter(str1->str1.startsWith("张")).filter(str2->str2.length()==3).forEach(System.out::println);

//       Stream<String> stream = list.stream();// (张无忌,周芷若,赵敏,张强,张三丰)
//        Stream<String> stream1 = stream.filter(str1 -> str1.startsWith("张"));// (张无忌,张强,张三丰)   延迟方法
//        Stream<String> stream2 = stream1.filter(str2 -> str2.length() == 3);// (张无忌,张三丰)   延迟方法
//        stream2.forEach(System.out::println);// 终结

        // 错误的,因为流不能重复使用
/*        Stream<String> stream = list.stream();// (张无忌,周芷若,赵敏,张强,张三丰)
        Stream<String> stream1 = stream.filter(str1 -> str1.startsWith("张"));// (张无忌,张强,张三丰)
        Stream<String> stream2 = stream.filter(str2 -> str2.length() == 3);// (张无忌,张三丰)
        stream.forEach(System.out::println);*/

        // 验证Stream流具有延迟性 -->Lambda表达式
        list.stream().filter(str1 -> {
            System.out.println("执行了吗");
            return str1.startsWith("张");
        }).filter(str2 -> str2.length() == 3).forEach(str3 -> System.out.println(str3));

        System.out.println(list);

        // 类似工厂的流水线: 如果整个流水线没有搭建好,就不会开工
        // Stream流的操作其实就是搭建一套函数模型,只有模型搭建好了,才可以去执行,如果没有搭建好,就不会执行
        // 什么情况下才算搭建好??
        // 需要有终结方法
    }

    private static void method01() {
        // 传统方式: 目的遍历list集合中的元素,但是必须通过循环
        // 目的:遍历是目的
        // 方式:循环是遍历的方式

        List<String> list = new ArrayList<>();

        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");

        for (String name : list) {
            System.out.println(name);
        }
        System.out.println("============");

        // 流的方式:遍历  不需要通过循环,直接遍历
        // 函数式编程: 注重的是做什么,而不是依赖对象
//        list.stream().forEach(str->System.out.println(str));
        list.stream().forEach(System.out::println);
    }
}

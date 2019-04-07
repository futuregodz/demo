package src1.com.itheima.demo1;
/*
函数式接口:
    概述: 接口中有且仅有一个抽象方法
    特点: 函数式接口可以使用@FunctionalInterface注解标识

Lambda表达式:
    1.特点:具有延迟性--->执行(当调用接口抽象方法的时候才会执行Lambda表达式中的解决方案)
    2.Lambda表达式作为方法的参数和返回值
        函数式接口作为方法的参数类型
        函数式接口作为方法的返回值类型

方法引用:
    1.格式: 使用2个冒号::来引入方法
    2.什么场景下可以使用方法引用替换Lambda表达式
        当Lambda表达式指定的解决方案已经存在另一个方法中,这个时候就可以使用方法引用把该方法引过来替换Lambda表达式
        当Lambda表达式指定的解决方案就是调用另一个方法,这个时候就可以使用方法引用把该方法引过来替换Lambda表达式

    3.怎么使用:
        通过对象引入成员方法: 对象名::方法名
        通过类名引入静态方法: 类名::静态方法名
        通过super引入父类方法: super::父类方法名
        通过this引入本类方法:  this::本类方法名

        类的构造引用: 类名::new
        数组的构造引用: 数组类型::new

常用函数式接口:
    Supplier<T> 接口: 生产接口   只出不进
        抽象方法  T get(); 获取一个对象

    Consumer<T> 接口: 消费接口   只进不出
        抽象方法: void accept(T t);
        默认方法: Consumer<T> andThen(Consumer<? super T> after)


 */
public class Demo1 {
}

package stream;

import java.util.Random;
import java.util.stream.Stream;

/**
 * 中间流操作
 */
public class StreamDemo3 {

    public static void main(String[] args) {
        String str = "my name is 007";
        //map
        //把每个单词的长度打印出来
        Stream.of(str.split(" ")).map(String::length).forEach(System.out::println);
        //长度大于2的
        Stream.of(str.split(" ")).filter(s->s.length()>2).map(String::length).forEach(System.out::println);

        //flatMap A->B属性（是个集合），最终得到所有A元素里面的所有B属性集合
        //intStream/longStream并不是Stream的子类，所以要进行装箱boxed
        Stream.of(str.split(" ")).flatMap(s->s.chars().boxed()).forEach(
                i-> System.out.println((char)i.intValue())
        );

        //peek 用于debug 是个中间操作，和forEach是终止操作
        System.out.println("------peek--------");
        Stream.of(str.split(" ")).peek(System.out::println).forEach(System.out::println);

        //limit使用，主要用于无限流
        new Random().ints().filter(i->i<1000&&i>100).limit(10).forEach(System.out::println);
    }

}

package stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 终止操作
 */
public class StreamDemo4 {

    public static void main(String[] args) {
        String str = "my name is 007";
        //并行流操作 结果为乱序
        str.chars().parallel().forEach(i-> System.out.print((char)i));
        //使用ForEachOrdered保证顺序
        str.chars().parallel().forEachOrdered(i-> System.out.print((char)i));
        //收集到list
        List<String> collect = Stream.of(str.split(" ")).collect(Collectors.toList());
        System.out.println(collect);

        //使用reduce拼接字符串
        Optional<String> letters = Stream.of(str.split(" ")).reduce((s1, s2) -> s1 + "|" + s2);
        System.out.println(letters.orElse(""));
        //带初始值的reduce
        String reduce = Stream.of(str.split(" ")).reduce("",(s1, s2) -> s1 + "|" + s2);
        //计算所有单词的总长度
        Integer length = Stream.of(str.split(" ")).map(String::length).reduce(0, (s1, s2) -> s1 + s2);
        System.out.println(length);
        //max的使用
        Optional<String> max = Stream.of(str.split(" ")).max(Comparator.comparingInt(String::length));
        System.out.println(max.get());
        //使用findFirst短路操作
        OptionalInt first = new Random().ints().findFirst();
        System.out.println(first.getAsInt());
    }

}

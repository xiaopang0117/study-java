package lambda;

import java.util.function.Function;

/**
 * 级联表达式和柯里化
 * 柯里化：把多个参数的函数转换为只有一个参数的函数
 * 柯里化的目的：函数标准化
 * 高阶函数：返回函数的函数
 */
public class CurryDemo {

    public static void main(String[] args) {
        //实现了x+y的级联表达式
        //x -> y -> x + y; => x=y=x+y;
        Function<Integer, Function<Integer,Integer>> function = x -> y -> x + y;
        Integer sum = function.apply(2).apply(2);
        System.out.println(sum);

        //x -> y -> z->x+y+z 柯里化
        Function<Integer, Function<Integer,Function<Integer,Integer>>> fff = x -> y -> z->x+y+z;
        System.out.println(fff.apply(2).apply(3).apply(4));

    }
}

package lambda;

import javax.print.DocFlavor;
import java.util.function.*;

/**
 * 方法引用
 */
class Dog {

    private String name = "哮天犬";
    /**
     * 默认10斤食物
     */
    private int food = 10;

    public Dog() {

    }

    /**
     * 带参数的构造函数
     * @param name
     */
    public Dog(String name){
        this.name = name;
    }

    /**
     * 狗叫
     * @param dog
     */
    public static void bark(Dog dog){
        System.out.println(dog.name+"叫了");
    }

    /**
     * 吃狗粮
     * JDK默认会把当前实例传入非静态方法，参数名为this,第一个参数
     * @param num
     * @return 还剩多少斤
     */
    public int eat(Dog this,int num){
        System.out.println("吃了"+num+"斤狗粮");
        this.food -= num;
        return this.food;
    }

    @Override
    public String toString() {
        return this.name;
    }
}


public class MethodReferenceDemo {

    public static void main(String[] args) {
        Dog dog = new Dog();
        //方法引用
        Consumer<String> consumer = System.out::println;
        consumer.accept("789");

        //静态方法的方法引用（类名+方法名）
        Consumer<Dog> consumer1 = Dog::bark;
        consumer1.accept(dog);

        //非静态方法(对象实例的方法引用)
        //Function<Integer, Integer> function = dog::eat;
        //一元函数
        //UnaryOperator<Integer> function = dog::eat;
        //System.out.println("还剩下"+function.apply(5)+"斤");
        IntUnaryOperator function = dog::eat;
        System.out.println("还剩下"+function.applyAsInt(2)+"斤");
        //使用类名来方法引用
        BiFunction<Dog,Integer,Integer> function1 = Dog::eat;
        System.out.println("还剩下"+function1.apply(dog,2)+"斤");

        //无参构造函数的方法引用
        Supplier<Dog> supplier = Dog::new;
        System.out.println("创建了新对象："+supplier.get());

        //带参数的构造函数的方法引用
        Function<String,Dog> function2 = Dog::new;
        System.out.println("创建了新对象"+function2.apply("旺财"));
    }
}

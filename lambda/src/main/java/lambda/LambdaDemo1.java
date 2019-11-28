package lambda;

@FunctionalInterface
interface Interface1 {
    //唯一接口
    int doubleNum(int i);
    //默认实现的方法
    default int add(int x,int y){
        return x + y;
    }
}

public class LambdaDemo1 {

    public static void main(String[] args) {
        Interface1 i1 = (i) -> i*2;

        System.out.println(i1.add(3,7));
        //常见的写法
        Interface1 i2 = i -> i*2;

        Interface1 i3 = (int i) -> i*2;
        //多层需要return
        Interface1 i4 = (int i) -> {
            return i * 2;
        };
    }

}

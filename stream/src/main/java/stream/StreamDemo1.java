package stream;

import java.util.stream.IntStream;

/**
 * stream流
 */
public class StreamDemo1 {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        //外部迭代
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        System.out.println("结果为:"+sum);

        //使用stream的内部迭代
        //map就是中间操作(返回stream的操作)
        //sum就是中止操作(返回结果、副作用)
        int sum2 = IntStream.of(nums).map(i->i*2).sum();
        System.out.println("结果为:"+sum2);

        int sum3 = IntStream.of(nums).map(StreamDemo1::doubleNum).sum();
        System.out.println("结果为"+sum3);

        IntStream.of(nums).map(StreamDemo1::doubleNum);
        System.out.println("惰性求值就是终止操作没有调用的情况下，中间操作不会执行");
    }

    public static int doubleNum(int i) {
        System.out.println("执行了乘以2");
        return i * 2;
    }

}

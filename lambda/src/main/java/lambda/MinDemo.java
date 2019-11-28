package lambda;


import java.util.stream.IntStream;

public class MinDemo {

    public static void main(String[] args) {
        int[] nums = {33,55,-55,90,-666,30};
        //命令式编程
        int min = Integer.MAX_VALUE;
        for(int i: nums){
            if( i < min ){
                min = i;
            }
        }
        System.out.println(min);
        //jdk8 函数式编程
        int i = IntStream.of(nums).min().getAsInt();
        System.out.println(i);

    }

}

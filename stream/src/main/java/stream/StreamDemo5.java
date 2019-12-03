package stream;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * 并行流
 */
public class StreamDemo5 {

    public static void main(String[] args) {
        //输出结果每条数据间隔三秒一行一行打印
        //IntStream.range(1,100).peek(StreamDemo5::debug).count();
        //输出结果每隔三秒打印一批数据
        //调用parallel产生一个并行流
        //IntStream.range(1,100).parallel().peek(StreamDemo5::debug).count();

        //能否实现先并行后串行
        //多次调用后者覆盖前者
//        IntStream.range(1,100)
//                //调用parallel并行流
//                .parallel().peek(StreamDemo5::debug)
//                //调用sequential串行流
//                .sequential().peek(StreamDemo5::debug2)
//                .count();
        //并行流使用的线程池:ForkJoinPool.commonPool
        //默认的线程数时当前机器的cpu个数
        //使用这个属性可以修改默认的线程数
//        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","20");
////        IntStream.range(1,100)
////                //调用parallel并行流
////                .parallel().peek(StreamDemo5::debug)
////                .count();
        //使用自己的线程池，不使用默认线程池,防止任务被阻塞
        ForkJoinPool forkJoinPool = new ForkJoinPool(20);
        forkJoinPool.submit(
                ()->{IntStream.range(1,100)
                //调用parallel并行流
                .parallel().peek(StreamDemo5::debug)
                .count();}
        );
        forkJoinPool.shutdown();
        //防止主线程退出 结果未打印
        synchronized (forkJoinPool) {
            try {
                forkJoinPool.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void debug(int i) {
        System.out.println(Thread.currentThread().getName()+"debug"+i);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void debug2(int i) {
        System.err.println("debug"+i);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

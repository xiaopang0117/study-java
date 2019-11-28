package lambda;

public class ThreadDemo {

    public static void main(String[] args) {
        Thread target = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("ok");
            }
        });
        target.start();

        //jdk8 lambda
        //它怎么知道实现哪个接口
        new Thread(() -> System.out.println("ok")).start();
    }
}

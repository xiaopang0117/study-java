package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * 变量引用
 */
public class VarDemo {

    public static void main(String[] args) {
        String str = "我们的时间";
        //str = ""; 不能再重新赋值了 java是值传递
        Consumer<String> consumer = s-> System.out.println(str+s);
        consumer.accept("1211");

        List<String> list = new ArrayList<>();
        //list = null list更改内容不做变更
        Consumer<String> consumerList = s-> System.out.println(str+s);
        consumerList.accept("1211");
    }

}

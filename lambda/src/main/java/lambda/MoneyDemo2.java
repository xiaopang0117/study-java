package lambda;

/**
 * 函数实现
 */
import java.text.DecimalFormat;
import java.util.function.Function;

class MyMoney2 {
    private final int money;

    public MyMoney2(int money) {
        this.money = money;
    }
    //函数接口
    public void printMoney(Function<Integer,String> moneyFormat) {
        System.out.println("我的存款:"+moneyFormat.apply(this.money));
    }
}


public class MoneyDemo2 {

    public static void main(String[] args) {
        MyMoney2 me = new MyMoney2(9999999);
        Function<Integer, String> integerStringFunction = i -> new DecimalFormat("#,###").format(i);
        //函数接口链式操作
        me.printMoney(integerStringFunction.andThen(s->"人民币"+s));
        
    }
}

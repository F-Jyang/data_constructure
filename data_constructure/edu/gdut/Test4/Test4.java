package edu.gdut.Test4;

/*	有一个函数式接口Calculator，包含单一的calculate()抽象方法，另外还包括两个默认方法，定义如下：
@FunctionalInterface
public interface Calculator{
		public abstract double calculate(int a, int b);
		public default int subtract(int a, int b){
			return a – b;
}
public default int add(int a,int b){
	return a + b;
}
}
编写程序，使用Lambda表达式实现calculate()方法，使该方法可以计算a^2+b^2。
在测试类中，定义一个public int binaryOperate(int a, int b, Calculator operator)方法
传递Lambda表达式给operator，得到a和b的计算结果。

 */
public class Test4 {
    public static void main(String[] args) {
//        int num=binaryOperate(1, 2, new Calculator() {
//            @Override
//            public double calculate(int a, int b) {
//                return Math.pow(a,2)+Math.pow(b,2);
//            }
//        });
        int num=binaryOperate(2, 2, (a,b)->Math.pow(a,2)+Math.pow(b,2));
        System.out.println(num);
    }
    public static int binaryOperate(int a, int b, Calculator operator){
        return (int) operator.calculate(a,b);
    }
}

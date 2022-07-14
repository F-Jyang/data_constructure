package edu.gdut.Test2;

import edu.gdut.Test1.IntSequence;
import edu.gdut.Test1.RandomIntSequence;

/*
2.	设计一个名为SequenceTest的类，
在其中编写一个static方法用于计算一个整数序列前n个整数的平均值，方法签名如下：
public static double average(IntSequence seq,int n)
在main方法中编写代码通过RandomIntSequence的方法获得前10个随机整数，并计算它们的平均值。

 */
public class SequenceTest {
    public static void main(String[] args) {
        RandomIntSequence ramdom=new RandomIntSequence();
        double average=SequenceTest.average(ramdom,10);
        System.out.println(average);

    }
    public static double average(IntSequence seq, int n){
        if (n>0) {
            double avg = 0;
            for (int i = 0; i < n; i++) {
                seq= new RandomIntSequence();
                seq.hasNext();
                avg += seq.next();
            }
            return avg / n;
        }else return 0;
    }
}

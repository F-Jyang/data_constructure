package edu.gdut.Test1;
/*1.
设计一个名为IntSequence的接口表示整数序列，
该接口包括boolean hasNext()和int next()两个方法。
定义一个名为RandomIntSequence的类实现该接口，
期中包含一个private整型变量n。
在hasNext()方法中随机生成一个两位整数，
存储到变量n中，然后返回ture，在next()方法中返回n的值。
 */
public interface IntSequence {
    boolean hasNext();
    int next();
}

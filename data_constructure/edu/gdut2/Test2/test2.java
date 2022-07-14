package edu.gdut2.Test2;

import java.util.ArrayList;
import java.util.Iterator;

public class test2 {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("java");
        //replaceAll()方法
        list.replaceAll(String::toUpperCase);
        //for循环
        for (int i = 0; i < list.size(); i++) {
            String s=list.get(i).toUpperCase();
            System.out.println(s);
        }
        //迭代器
        Iterator<String> iterator=list.iterator();
        while (iterator.hasNext()){
            String next=iterator.next().toUpperCase();
            System.out.println(next);
        }
    }
}

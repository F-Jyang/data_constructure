package edu.gdut.Test3;

/*
3.设计一个Position类，该类有x和y两个成员变量表示坐标。
要求该类实现Comparable接口的CompareTo方法，
实现比较两个Position对象到原点（0，0）的距离之差。
 */
public class Position implements Comparable<Position> {
    public static void main(String[] args) {
        Position p1=new Position(1,2);
        Position p2=new Position(1,3);
        int sum=p1.compareTo(p2);
        System.out.println(sum);
    }

    int x, y;

    public Position() {
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Position o) {
        double distance = Math.pow(this.x, 2) + Math.pow(this.y, 2) - Math.pow(o.x, 2) - Math.pow(o.y, 2);
        if (distance > 0) return 1;
        else if(distance<0)return -1;
        else return 0;
    }
}

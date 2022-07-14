package edu.gdut.Test1;

public class RandomIntSequence implements IntSequence {
//    public static void main(String[] args) {
//        RandomIntSequence r1=new RandomIntSequence();
//        r1.hasNext();
//        System.out.println(r1.next());
//    }
    private int n;

    @Override
    public boolean hasNext() {
        n= (int)(Math.random()*100);
        return true;
    }

    @Override
    public int next() {
        return n;
    }
}

package game;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("猜测一个在0-100中的数字的游戏");
        System.out.println("请输入 1 开始游戏：");
        int start= sc.nextInt();
        while (start==1){
            int sum=0;
            System.out.println("游戏开始！");
            System.out.println("请输入一个 0-100 的数字：");
            int ans= (int) (Math.random()*100);
            while(true){
                int guess=sc.nextInt();
                sum++;
                if(guess>ans){
                    System.out.println("你输入的数字太大啦！");
                }else if(guess<ans){
                    System.out.println("你输入的数字太小啦！");
                }
                if(guess==ans){
                    System.out.println("恭喜你猜对了，你一共猜了"+sum+"次！");
                    break;
                }
            }
            System.out.println("继续游戏请输入 1 ，退出游戏请输入 0 ：");
            start= sc.nextInt();
        }
        System.out.println("游戏退出！");
    }
}

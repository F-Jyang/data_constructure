package game;

import game.game.BgObj;
import game.game.PlanObj;
import game.game.ShellObj;
import game.util.GameUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameWin extends JFrame {
    static int state = 0;

    Image offScreenImage = null;

    //移动背景
    BgObj bgObj = new BgObj(GameUtils.bgImg, 0, -800, 2);

    //我方飞机对象
    PlanObj planeObj = new PlanObj(GameUtils.planeImg, 50,100, 5, 10, 0, this);

    //子弹对象
    ShellObj shellObj = new ShellObj(GameUtils.shellImg, 50,100, 25, 30, 5, this);

    public void launch() {
        //设置窗口可见
        this.setVisible(true);
        //设置窗口大小
        this.setSize(400, 800);
        //设置窗口位置
        this.setLocationRelativeTo(null);
        //设置窗口标题
        this.setTitle("飞机大战");

        //添加一个鼠标点击事件
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (state == 0 && e.getButton() == 1) {
                    state = 1;
                    repaint();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        while (true) {
            repaint();
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void paint(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = createImage(400, 800);
        }
        Graphics gImage = offScreenImage.getGraphics();
        gImage.fillRect(0, 0, 400, 800);
        if (state == 0) {
            gImage.drawImage(GameUtils.bgImg, 0, 0, null);
            gImage.drawImage(GameUtils.exploreImg, 210, 200, null);
            gImage.drawImage(GameUtils.bossImg, 50, 100, null);
            gImage.setColor(Color.YELLOW);
            gImage.setFont(new Font("仿宋", Font.BOLD, 30));
            gImage.drawString("点击开始游戏", 100, 650);
        } else if (state == 1) {
//          g.drawImage(GameUtils.bgImg, 0, 0, null);
            bgObj.paintSelf(gImage);
            planeObj.paintSelf(gImage);
            shellObj.paintSelf(gImage);

        }
        g.drawImage(offScreenImage, 0, 0, null);
    }

    public static void main(String[] args) {
        GameWin gameWin = new GameWin();
        gameWin.launch();
    }
}

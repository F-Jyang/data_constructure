package game.game;

import game.GameWin;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PlanObj extends GameObj{
    public PlanObj(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    public PlanObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
        this.frame.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                PlanObj.super.x=e.getX()-40;
                PlanObj.super.y=e.getY()-25;
            }
        });
    }

    public PlanObj() {
    }
}

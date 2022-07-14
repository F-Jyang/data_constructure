package game.game;

import game.GameWin;

import java.awt.*;

public class ShellObj extends GameObj{
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public ShellObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    public ShellObj() {
        super();
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        y-=speed;
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}

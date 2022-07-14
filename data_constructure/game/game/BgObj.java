package game.game;

import game.GameWin;

import java.awt.*;

public class BgObj extends GameObj{

    public BgObj(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    public BgObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    public BgObj() {
    }
}

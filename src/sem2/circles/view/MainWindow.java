package sem2.circles.view;

import sem2.common.CanvasRepaintListener;
import sem2.common.Interactable;
import sem2.common.MainCanvas;
import sem2.common.Sprite;
import sem2.circles.sprites.Background;
import sem2.circles.sprites.Ball;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame implements CanvasRepaintListener {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    private static final String TITLE = "Circles";
    private static final int DEFAULT_COUNT_SPRITES = 5;
    private static final int MAX_COUNT_SPRITES = 15;

    private Sprite[] sprites = new Sprite[DEFAULT_COUNT_SPRITES];
    private Interactable sprites_[];

    public MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle(TITLE);

        MainCanvas canvas = new MainCanvas(this);
        add(canvas);

        sprites[0] = new Background(0,0);
        for (int i = 1; i < sprites.length; i++) {
            sprites[i] = new Ball(10, 0);
        }

        setVisible(true);
    }

    @Override
    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) {
        update(canvas,deltaTime);
        render(canvas, g);
    }

    private void update(MainCanvas canvas, float deltaTime) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }
    private  void render(MainCanvas canvas, Graphics g) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas, g);
        }
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}

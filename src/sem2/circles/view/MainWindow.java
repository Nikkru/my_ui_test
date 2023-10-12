package sem2.circles.view;

import sem2.circles.exceptions.BallsOverflowException;
import sem2.common.CanvasRepaintListener;
import sem2.common.Interactable;
import sem2.common.MainCanvas;
import sem2.common.Sprite;
import sem2.circles.sprites.Background;
import sem2.circles.sprites.Ball;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MainWindow extends JFrame implements CanvasRepaintListener, Thread.UncaughtExceptionHandler {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    private static final String TITLE = "Circles";
    private static final int DEFAULT_COUNT_SPRITES = 5;
    public final int MAX_COUNT_SPRITES = 15;

    private static Random rnd = new Random();
//    private Sprite[] sprites = new Sprite[DEFAULT_COUNT_SPRITES];
    private Interactable sprites_[];
    private int countSprites;

    public MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle(TITLE);

        initSprites();
        MainCanvas canvas = new MainCanvas(this);
        add(canvas);
        addMouseListener(new MouseListener(this));

//        sprites[0] = new Background(0,0);
//        for (int i = 1; i < sprites.length; i++) {
//            sprites[i] = new Ball(10, 0);
//        }

        setVisible(true);
    }

    private void initSprites() {
        sprites_ = new Interactable[MAX_COUNT_SPRITES];
        sprites_[0] = new Background(0,0);
        countSprites = 1;
        for (int i = 0; i < DEFAULT_COUNT_SPRITES; i++) {
            addSprite(rnd.nextInt(WINDOW_WIDTH), rnd.nextInt(WINDOW_HEIGHT));
        }
    }
    public void addSprite(int x, int y) {
        if (countSprites >= MAX_COUNT_SPRITES) {
            throw new BallsOverflowException();
        }
        sprites_[countSprites++] = new Ball(x, y);
    }

    public void removeSprite() {
        if (countSprites <= 1) {
            return;
        }
        countSprites--;
    }

    @Override
    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) {
        update(canvas,deltaTime);
        render(canvas, g);
    }

    private void update(MainCanvas canvas, float deltaTime) {
        for (int i = 0; i < countSprites; i++) {
            sprites_[i].update(canvas, deltaTime);
        }
    }
    
    private  void render(MainCanvas canvas, Graphics g) {
        for (int i = 0; i < countSprites; i++) {
            sprites_[i].render(canvas, g);
        }
    }

    public static void main(String[] args) {
        new MainWindow();
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if (e instanceof BallsOverflowException) {
            e.fillInStackTrace();
        }
    }
}

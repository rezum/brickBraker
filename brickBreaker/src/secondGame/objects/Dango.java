package secondGame.objects;
import secondGame.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.Timer;


import static javax.imageio.ImageIO.read;

public class Dango extends gameObjects {


    private int vx;
    private int vy;
    private int R = 2;
    private boolean isMoving;
    private Rectangle bounds = new Rectangle(this.x, this.y, img.getWidth(), img.getHeight());
    private int lives;
    private int points;
    private int score;
    private int enemylives;
    private boolean isAlive;
    private int spawnX;
    private int spawnY;
    private boolean win;
    int time =0;
    Timer myTime = new Timer();
    Youwin goal;
    public static ArrayList<gameObjects> objects;
    private boolean stop;


    public Dango(int x, int y, int vx, int vy, BufferedImage img) {
        super(x,y,img);
        this.vx= vx;
        this.vy = vy;
        this.spawnX = x;
        this.spawnY = y;
        this.isMoving = false;
        this.lives = 4;
        this.points = 0;
        Map.objects.add(this);
        this.isAlive = true;
        this.win = false;
        this.stop = false;
        this.enemylives = 1;
       // this.bounds = new Rectangle(x,y,this.img.getWidth(),this.img.getHeight());
    }


    public void update(){
        move();
        updateBounds();
        if (lives > 0) {
            if(y > 740) {

                this.x = spawnX;
                this.y = spawnY;
                System.out.println(this);
                System.out.println(spawnX);
                System.out.println(spawnY);
            }
        }
        checkCollision(this);
        lostLife();

//        if (lives == 0){
//            System.exit(0);
//        }

    }


    public void move(){
        x += vx;
        y += vy;
        if (x < 30) vx = -vx;
        if (y < 0) vy = -vy;
        if (x > 1210) vx = -vx;
        //if (y > 485) isAlive = false;
        isMoving = true;

    }

    public int getLives(){
        return lives;
    }

    public int getPoints(){
        return points;
    }

    public int getEnemyLives() {
        return enemylives;
    }

    public void setScore(int x) {
        this.score= x;
    }

    public void scorePoint(){
        points +=score;
    }

    public void lostLife(){
        if (y == 740){
            lives -= 1;
            isAlive = false;
        }
    }

    public void getStop(){
        stop = true;
    }

    public Rectangle getBounds() {
        return this.bounds;
    }

    public void updateBounds() {
        this.bounds = new Rectangle(this.x, this.y, img.getWidth(), img.getHeight());
    }

    public void checkCollision(Dango dango){
        gameObjects objs;
        Rectangle bounds = dango.getBounds();
        for (int i =0; i< Map.objects.size();i++){
            objs = Map.objects.get(i);
            if (bounds.intersects(objs.getBounds())){
                handle(objs);
            }
        }
    }

    public void handle (gameObjects obj){
        if (obj instanceof PurpleBrick){
            if (this.isMoving) {
                vy = -vy;
                setScore(2);
                scorePoint();
                Map.objects.remove(obj);
            } else vx = -vx;
        }
        if (obj instanceof PinkBrick){
            if (this.isMoving) {
                vy = -vy;
                setScore(8);
                scorePoint();
                Map.objects.remove(obj);
            } else vx = -vx;
        }
        if (obj instanceof BlueBrick){
            if (this.isMoving) {
                vy = -vy;
                setScore(10);
                scorePoint();
                Map.objects.remove(obj);
            } else vx = -vx;
        }
        if (obj instanceof GreenBrick){
            if (this.isMoving) {
                vy = -vy;
                setScore(4);
                scorePoint();
                Map.objects.remove(obj);
            } else vx = -vx;
        }
        if (obj instanceof EvilBrick){
            if (this.isMoving) {
                vy = -vy;
                setScore(-2);
                scorePoint();
                Map.objects.remove(obj);
            } else vx = -vx;
        }
        if (obj instanceof Goal){
            if (this.isMoving) {
                enemylives -= 1;
                goal = new Youwin();
                goal.init();
                Map.objects.remove(obj);
            }


        }
        if (obj instanceof UnbreakableWall){
            if (this.isMoving) {
                vy = -vy;

            } else vx = -vx;
        }
        if (obj instanceof Border){
            if (this.isMoving) {
                vy = -vy;
            } else vx = -vx;

        }
        if (obj instanceof Katch){
            if (this.isMoving) {
                vy = -vy;

            }
        }

    }

    public void endScreen(gameObjects obj){

        //Map.objects.removeAll(objects);
        JFrame end = new JFrame("LOLOOOOOLOOLO");
        goal = new Youwin();
        goal.init();

        end.setSize(GameWorld.SCREEN_WIDTH, GameWorld.SCREEN_HEIGHT + 30);
        end.setResizable(false);
        end.setLocationRelativeTo(null);

        end.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        end.setVisible(true);

       // System.exit(0);
    }




    public void drawImage(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        AffineTransform Dango = AffineTransform.getTranslateInstance(x,y);
        g2.drawImage(this.img, Dango, null);

    }


}

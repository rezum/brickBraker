package secondGame;

import secondGame.objects.BlueBrick;
import secondGame.objects.PinkBrick;
import secondGame.objects.UnbreakableWall;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Katch extends gameObjects{


    private boolean RightPressed;
    private boolean LeftPressed;
    private final int R = 5;
    private int vx;
    private int vy;
    //private int angle;
    private Rectangle bounds;// = new Rectangle(this.x, this.y, img.getWidth(),img.getHeight());
    ArrayList<gameObjects>  objects = new ArrayList<>();

    public Katch(int x, int y, BufferedImage img){

        super( x, y , img);
        this.bounds = new Rectangle(x,y,this.img.getWidth(),this.img.getHeight());
        Map.objects.add(this);
    }

    public Rectangle getBounds(){
        return this.bounds;
    }

    public void updateBounds(){
        this.bounds = new Rectangle(this.x, this.y, img.getWidth(),img.getHeight());
    }


    public void checkCollision(Katch katch) {
        gameObjects obj;
        Rectangle kbounds = katch.getBounds();
        for (int i=0; i<Map.objects.size(); i++) {
            obj = Map.objects.get(i);
            if (kbounds.intersects(obj.getBounds())) {
                handle(obj);
            }
        }
    }


    public void handle(gameObjects obj) {
        if (obj instanceof UnbreakableWall) {
            if (this.LeftPressed) {
                this.x += vx;
                this.y += vx;
            }
            if (this.RightPressed) {
                this.x -= vx;
                this.y -= vx;
            }

        }
    }

    private void checkBorder() {
        if (x < 10) {
            x = 10;
        }
        if (x > 1170) {
            x = 1170;
        }
        if (x >=GameWorld.WORLD_WIDTH - 30) {
            x = GameWorld.WORLD_WIDTH - 30;
        }
        if (y < 100) {
            y = 100;
        }
        if (y >= GameWorld.WORLD_HEIGHT - 30) {
            y = GameWorld.WORLD_HEIGHT - 30;
        }
    }


    void toggleRightPressed() {
        this.RightPressed = true;
    }

    void toggleLeftPressed() {
        this.LeftPressed = true;
    }


    void unToggleRightPressed() {
        this.RightPressed = false;
    }

    void unToggleLeftPressed() {
        this.LeftPressed = false;
    }


    public void update() {

        if (this.LeftPressed) {
            this.moveLeft();
            updateBounds();
        }
        if (this.RightPressed) {
            this.moveRight();
            updateBounds();
        }
        checkCollision(this);
    }


    private void moveLeft() {
        vx = R;
        vy = 0;
        x -= vx;
        y -= vy;
        checkBorder();
        updateBounds();
    }

    private void moveRight() {
        vx = R;
        vy = 0;
        x += vx;
        y += vy;
        checkBorder();
        updateBounds();
    }



    public void drawImage(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        AffineTransform katch = AffineTransform.getTranslateInstance(x,y);
        g2.drawImage(this.img, katch, null);

    }


}

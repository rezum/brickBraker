package secondGame;

import java.awt.image.BufferedImage;
import java.awt.*;
import java.util.ArrayList;



public abstract class gameObjects {

    protected int x;
    protected int y;
    protected BufferedImage img;
    public static ArrayList<gameObjects> objects = new ArrayList<>();
    protected Rectangle r;
    private Rectangle bounds;

    public gameObjects(int x, int y, BufferedImage img){
        this.x = x;
        this.y = y;
        this.img = img;
        this.bounds = new Rectangle(this.x, this.y, img.getWidth(),img.getHeight());
    }

    public Rectangle getBounds( ){
        return this.bounds;
    }

    public void updateBounds(){
        this.bounds = new Rectangle(this.x, this.y, img.getWidth(),img.getHeight());
    }

    public int getX(){ //to get position in x
        return this.x;
    }

    public int getY(){ // to get position in y
        return this.y;
    }

    public void drawImage(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(img, x, y, null);
    }
}

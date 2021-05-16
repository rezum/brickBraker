package secondGame.objects;

import secondGame.gameObjects;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DangoTrio extends gameObjects {

    private JFrame jf;
    private Graphics2D buffer;

    private Rectangle bounds;


    public DangoTrio(int x, int y, BufferedImage img){

        super(x,y,img);
        this.bounds = new Rectangle(x, y, this.img.getWidth(), this.img.getHeight());
        objects.add(this);
    }


}
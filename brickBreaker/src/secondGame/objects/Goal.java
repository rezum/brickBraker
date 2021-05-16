package secondGame.objects;

import secondGame.gameObjects;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Goal extends gameObjects{

    private JFrame jf;
    private Graphics2D buffer;

    private Rectangle bounds;


    public Goal(int x, int y, BufferedImage img){

        super(x,y,img);
        this.bounds = new Rectangle(x, y, this.img.getWidth(), this.img.getHeight());
        objects.add(this);
    }

}

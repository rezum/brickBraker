package secondGame.objects;

import secondGame.gameObjects;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Border extends gameObjects {

    private Rectangle bounds;

    public Border(int x, int y, BufferedImage img){

        super(x,y,img);
        this.bounds = new Rectangle(x, y, this.img.getWidth(), this.img.getHeight());
        objects.add(this);
    }
}

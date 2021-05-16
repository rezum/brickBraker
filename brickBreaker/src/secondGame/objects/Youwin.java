package secondGame.objects;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import static javax.imageio.ImageIO.read;

public class Youwin {

    public static final int SCREEN_WIDTH = 1300;
    public static final int SCREEN_HEIGHT = 750;

    public static final int WORLD_WIDTH = 1800;
    public static final int WORLD_HEIGHT = 1000;

    private BufferedImage end;

    public Youwin() {

    }

    public void init(){
        try {
            end = read(new File("resources/end.png"));
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }


    public void drawImage (Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

        for (int i = 0; i < WORLD_WIDTH / end.getWidth() + 1; i++) {
            for (int j = 0; j < WORLD_HEIGHT / end.getHeight() + 1; j++) {

                g2.drawImage(end, i * end.getWidth(), j * end.getHeight(), null);
            }
        }

    }



}

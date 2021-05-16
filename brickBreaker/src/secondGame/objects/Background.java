package secondGame.objects;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import static javax.imageio.ImageIO.read;

public class Background {


    public static final int WORLD_WIDTH = 1800;
    public static final int WORLD_HEIGHT = 1000;

    private BufferedImage background_image;

    public Background() {

    }

    public void init(){
        try {
            background_image = read(new File("resources/Background.png"));
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }


    public void drawImage (Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

        for (int i = 0; i < WORLD_WIDTH / background_image.getWidth() + 1; i++) {
            for (int j = 0; j < WORLD_HEIGHT / background_image.getHeight() + 1; j++) {

                g2.drawImage(background_image, i * background_image.getWidth(), j * background_image.getHeight(), null);
            }
        }


    }



}

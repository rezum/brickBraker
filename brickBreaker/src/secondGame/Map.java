package secondGame;

import secondGame.objects.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import static javax.imageio.ImageIO.read;

public class Map{


    BufferedImage wall, pinkbrick, bluebrick, greenbrick, purplebrick,border,border2, goal, dangotrio,dangotrio2, evilpink, evilblue, evilpurple, evilgreen;
    public static ArrayList<gameObjects> objects = new ArrayList<>();
    public static ArrayList<gameObjects> switches = new ArrayList<>();
    int time =0;
    Timer myTime = new Timer();


    Map(){

    }

    private void UnbreakableWalls(){

        for (int i=15 ; i < 1210; i+=70) {
            objects.add(new UnbreakableWall(i,0, wall));
        }
    }


    private void PinkBricks(){
        for (int i=100; i<260; i+=40) {
            objects.add(new PinkBrick(390,i, pinkbrick));
            objects.add(new PinkBrick(840,i, pinkbrick));
        }

        objects.add(new EvilBrick(390,140, evilpink));
        objects.add(new EvilBrick(840,140, evilpink));
        objects.add(new EvilBrick(390,180, evilpink));
        objects.add(new EvilBrick(840,180, evilpink));

        objects.add(new PinkBrick(465,60,pinkbrick));
        objects.add(new PinkBrick(465,260,pinkbrick));
        objects.add(new PinkBrick(765,60,pinkbrick));
        objects.add(new PinkBrick(765,260,pinkbrick));
        objects.add(new PinkBrick(540,30,pinkbrick));
        objects.add(new PinkBrick(540,300,pinkbrick));
        objects.add(new PinkBrick(615,30,pinkbrick));
        objects.add(new PinkBrick(615,300,pinkbrick));
        objects.add(new PinkBrick(690,30,pinkbrick));
        objects.add(new PinkBrick(690,300,pinkbrick));

    }

    private void BlueBricks(){

        for (int i=60; i<280; i+=40) {
            objects.add(new BlueBrick(540,i, bluebrick));
            objects.add(new BlueBrick(690,i, bluebrick));
        }
        for (int i=100; i<260; i+=40) {
            objects.add(new BlueBrick(465,i, bluebrick));
            objects.add(new BlueBrick(765,i, bluebrick));
        }

        objects.add(new EvilBrick(540,60,evilblue));
        objects.add(new EvilBrick(690,60,evilblue));
        objects.add(new EvilBrick(540,260,evilblue));
        objects.add(new EvilBrick(690,260,evilblue));

        objects.add(new BlueBrick(615,60,bluebrick));
        objects.add(new BlueBrick(615,260,bluebrick));
    }

    private void GreenBricks() {

        for (int i = 100; i < 260; i += 40) {
            objects.add(new GreenBrick(315, i, greenbrick));
            objects.add(new GreenBrick(915, i, greenbrick));
        }

        objects.add(new GreenBrick(390,60,greenbrick));
        objects.add(new GreenBrick(390,260,greenbrick));
        objects.add(new GreenBrick(840,60,greenbrick));
        objects.add(new GreenBrick(840,260,greenbrick));
        objects.add(new GreenBrick(765,30,greenbrick));
        objects.add(new GreenBrick(765,300,greenbrick));
        objects.add(new GreenBrick(465,30,greenbrick));
        objects.add(new GreenBrick(465,300,greenbrick));
        objects.add(new GreenBrick(540,330,greenbrick));
        objects.add(new GreenBrick(615,330,greenbrick));
        objects.add(new GreenBrick(690,330,greenbrick));

    }

    private void PurpleBricks(){

        for (int i = 100; i < 260; i += 40) {
            objects.add(new PurpleBrick(240, i, purplebrick));
            objects.add(new PurpleBrick(165, i, purplebrick));
            objects.add(new PurpleBrick(90, i, purplebrick));
            objects.add(new PurpleBrick(990, i, purplebrick));
            objects.add(new PurpleBrick(1065, i, purplebrick));
            objects.add(new PurpleBrick(1140, i, purplebrick));
        }

        objects.add(new EvilBrick(165,100,evilpurple));
        objects.add(new EvilBrick(1065,100,evilpurple));
        objects.add(new EvilBrick(165,220,evilpurple));
        objects.add(new EvilBrick(1065,220,evilpurple));

    }

    private void DangoTrios(){
        switches.add(new DangoTrio(620,100, dangotrio));
    }
    private void DangoTrios2(){
        switches.add(new DangoTrio(620,100, dangotrio2));
    }
    private void GOAL(){
        objects.add(new Goal(620,100, goal));
    }

    private void Border() {
        for (int i = 15; i < 750; i += 60) {
            switches.add(new Border(5, i, border));
            switches.add(new Border(1265, i, border));
        }
    }

    private void Border2(){
        for (int i=15; i<750; i+=60) {
            switches.add(new Border(5,i, border2));
            switches.add(new Border(1265,i, border2));
        }
    }

    TimerTask task = new TimerTask(){
        public void run(){
            time++;
            switches.clear();
                if (time == (time / 2) * 2 ) {
                    DangoTrios2();
                    Border2();

                }
                else {
                    DangoTrios();
                    Border();
                }
            }
    };



    public void start(){
        myTime.scheduleAtFixedRate(task,0,1000);
    }


    public void init(){

        try {

            goal = read(new File("resources/goal.png"));
            wall = read (new File("resources/unbreakable.png"));
            pinkbrick = read (new File("resources/pinkbrick.png"));
            bluebrick = read (new File("resources/bluebrick.png"));
            greenbrick = read (new File("resources/greenbrick.png"));
            purplebrick = read (new File("resources/purplebrick.png"));
            dangotrio = read( new File("resources/dangotrio.gif"));
            dangotrio2 = read( new File("resources/dangotrio2.png"));
            border = read (new File("resources/border.png"));
            border2 = read (new File("resources/border2.png"));
            evilpink = read(new File("resources/evilpink.png"));
            evilblue = read(new File("resources/evilblue.png"));
            evilpurple = read(new File("resources/evilpurple.png"));
            evilgreen = read(new File("resources/evilgreen.png"));
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }

        Border();
        PinkBricks();
        UnbreakableWalls();
        BlueBricks();
        GreenBricks();
        PurpleBricks();
        DangoTrios();
        start();
        GOAL();

    }

    void drawImage(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

        for (int i=0; i<objects.size(); i++) {
            objects.get(i).drawImage(g2);
        }

        for (int i = 0 ; i< switches.size(); i++) {
            switches.get(i).drawImage(g2);
        }
    }
}

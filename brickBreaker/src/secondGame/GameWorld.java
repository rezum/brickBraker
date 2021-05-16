package secondGame;

import secondGame.objects.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.awt.event.KeyEvent;

import static javax.imageio.ImageIO.read;



public class GameWorld extends JPanel{

    public static final int SCREEN_WIDTH = 1300;
    public static final int SCREEN_HEIGHT = 750;

    public static final int WORLD_WIDTH = 1300;
    public static final int WORLD_HEIGHT = 750;
    private Katch p1;

    private BufferedImage world;
    private BufferedImage end;
    private Graphics2D buffer;
    private JFrame jf;
    private JFrame menu;

    private Background bg;
    private Map map;

    private Dango dango;

    private Menu menu2;
    private Youwin win;
    private Goal winend;

    private boolean deez = false;





    public static void main(String[] args) {

//        StartFrame start = new StartFrame();

        GameWorld game = new GameWorld();
        game.play();

//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new CLayout();
//            }
//        });


    }
//


    public void play(){
        Thread x;
        System.out.println("play");
        //GameWorld game = new GameWorld();

        this.init();
        try {

            while (true) {

                this.p1.update(); //update bun
                this.dango.update();
                this.repaint(); //redraw game
                Thread.sleep(1000 / 144);


            }
        } catch (InterruptedException ignored) {
        }
    }



    public void init() {

        this.jf = new JFrame("dango");



        this.world = new BufferedImage(GameWorld.WORLD_WIDTH, GameWorld.WORLD_HEIGHT, BufferedImage.TYPE_INT_RGB);
        BufferedImage player = null, dango1= null , dango2 =null, healthpic= null, end = null;

        try {
            System.out.println(System.getProperty("user.dir"));
            player = read(new File("resources/dangomove.png"));
            dango1 = read(new File("resources/dango.png"));
            dango2 = read(new File("resources/dango2.png"));
            healthpic = read(new File("resources/dangotiny.png"));
            end = read(new File("resources/end.png"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        bg= new Background();
        bg.init();

        map= new Map();
        map.init();

        win = new Youwin();
        win.init();




        p1 = new Katch(580, 630, player);

        dango = new Dango(595, 570,-1,-2, dango1);


        Controls bc1 = new Controls(p1, KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT);


        this.jf.setLayout(new BorderLayout());
        this.jf.add(this);
        this.jf.addKeyListener(bc1);

        this.jf.setSize(GameWorld.SCREEN_WIDTH, GameWorld.SCREEN_HEIGHT + 30);
        this.jf.setResizable(false);
        jf.setLocationRelativeTo(null);

        this.jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.jf.setVisible(true);
    }






    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        buffer = world.createGraphics();
        super.paintComponent(g2);


        this.bg.drawImage(buffer);
        this.map.drawImage(buffer);
        this.dango.drawImage(buffer);
       // this.win.drawImage(buffer);

        this.p1.drawImage(buffer);
        g2.drawImage(world,0,0,null);

        g2.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        g2.setColor(Color.PINK);
        g2.drawString("Lives :" + this.dango.getLives(), 100, 545);
        g2.drawString("Score : " + this.dango.getPoints(), 100, 585);


        g2.setFont(new Font("TimesRoman", Font.PLAIN, 100));
        if (this.dango.getLives() == 0) {
            g2.drawString("GAME OVER", 350, 505 );

        }
        if (this.dango.getEnemyLives() == 0) {

            g2.drawString("YOU WON", 370, 505 );

            this.win.drawImage(buffer);

            g2.drawImage(end, 0,0,null);

        }


    }
}

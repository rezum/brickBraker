package secondGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controls implements KeyListener {


    private Katch b1;
    private final int up;
    private final int down;
    private final int right;
    private final int left;

    public Controls(Katch b1, int up, int down, int left, int right){
        this.b1 = b1;
        this.up = up;
        this.down = down;
        this.right = right;
        this.left = left;
    }


    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int keyPressed = ke.getKeyCode();

        if (keyPressed == left) {
            this.b1.toggleLeftPressed();
        }
        if (keyPressed == right) {
            this.b1.toggleRightPressed();
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        int keyReleased = ke.getKeyCode();

        if (keyReleased  == left) {
            this.b1.unToggleLeftPressed();
        }
        if (keyReleased  == right) {
            this.b1.unToggleRightPressed();
        }
    }
}

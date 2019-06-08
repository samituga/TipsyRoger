package org.academiadecodigo.murlogs.tipsyRoger.GameObjects.Characters.Playable;

import org.academiadecodigo.murlogs.tipsyRoger.GameObjects.Characters.Character;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Player extends Character implements KeyboardHandler {

    private int drunkenLvl;
    private Picture player;
    private int keyPressed;
    private int iterator;
    private boolean touchingGround;

    public Player(int drunkenLvl) {
        this.drunkenLvl = drunkenLvl;
    }

    public void init() {
        player = new Picture(20, 20, "Roger_Smith.png");
        setKeyboard();
    }

    @Override
    public void draw() {
        player.draw();
    }

    public void isTouchingGround() {
        this.touchingGround = true;
    }

    private boolean pressingRight;
    private boolean pressingLeft;

    @Override
    public void move() {
        if (!super.colliding) {
            player.translate(0, 1);
        }

        if (pressingRight) {
            player.translate(2, 0);
        }
        if (pressingLeft) {
            player.translate(-2, 0);
        }

        try {
            Thread.sleep(13);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setKeyboard() {
        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent rightReleased = new KeyboardEvent();
        rightReleased.setKey(KeyboardEvent.KEY_RIGHT);
        rightReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent leftReleased = new KeyboardEvent();
        leftReleased.setKey(KeyboardEvent.KEY_LEFT);
        leftReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(right);
        keyboard.addEventListener(left);
        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
        keyboard.addEventListener(rightReleased);
        keyboard.addEventListener(leftReleased);


    }

    @Override
    public int y() {
        return player.getY();
    }

    @Override
    public int x() {
        return player.getX();
    }

    @Override
    public int yToHeight() {
        return player.getY() + player.getHeight();
    }

    @Override
    public int xToWidth() {
        return player.getX() + player.getWidth();
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
            pressingRight = true;
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {
            pressingLeft = true;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
            pressingRight = false;
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {
            pressingLeft = false;
        }
    }

    @Override
    public void attack() {

    }

}

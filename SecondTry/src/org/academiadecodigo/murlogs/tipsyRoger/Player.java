package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Player extends Colidable implements KeyboardHandler {

    private Rectangle roger = new Rectangle(20, 20, 50, 50);
    private int speed;
    private int drunkenLvl;

    private boolean pressingRight;
    private boolean pressingLeft;
    private boolean pressingUp;
    private boolean pressingDown;


    public void init() {
        draw();
        setKeyboard();
    }

    public void move() {
        speed = 1;

        if (pressingRight && !super.rightCollision) {
            roger.translate(speed, 0);
        }
        if (pressingLeft && !super.leftCollision) {
            roger.translate(-speed, 0);
        }
        if (pressingUp && !super.topCollision) {
            roger.translate(0, -speed);
        }
        if (pressingDown && !super.botCollision) {
            roger.translate(0, speed);
        }

        try {
            Thread.sleep(7);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void drinkBottle(int vol, Bottle bottle) {
        if (this.checkColision(bottle) && !bottle.getDrinked()){
            this.drunkenLvl += vol;
            System.out.println(drunkenLvl);
            bottle.deleteBottle();
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

        KeyboardEvent upReleased = new KeyboardEvent();
        upReleased.setKey(KeyboardEvent.KEY_UP);
        upReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent downReleased = new KeyboardEvent();
        downReleased.setKey(KeyboardEvent.KEY_DOWN);
        downReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(right);
        keyboard.addEventListener(left);
        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
        keyboard.addEventListener(rightReleased);
        keyboard.addEventListener(leftReleased);
        keyboard.addEventListener(upReleased);
        keyboard.addEventListener(downReleased);


    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                pressingRight = true;
                break;
            case KeyboardEvent.KEY_LEFT:
                pressingLeft = true;
                break;
            case KeyboardEvent.KEY_UP:
                pressingUp = true;
                break;
            case KeyboardEvent.KEY_DOWN:
                pressingDown = true;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                pressingRight = false;
                break;
            case KeyboardEvent.KEY_LEFT:
                pressingLeft = false;
                break;
            case KeyboardEvent.KEY_UP:
                pressingUp = false;
                break;
            case KeyboardEvent.KEY_DOWN:
                pressingDown = false;
        }
    }


    @Override
    public void draw() {
        roger.draw();
    }

    @Override
    public int x() {
        return roger.getX();
    }

    @Override
    public int y() {
        return roger.getY();
    }

    @Override
    public int xToWidth() {
        return x() + roger.getWidth();
    }

    @Override
    public int yToHeight() {
        return y() + roger.getHeight();
    }
}

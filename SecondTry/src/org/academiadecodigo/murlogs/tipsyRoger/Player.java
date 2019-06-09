package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player extends Character implements KeyboardHandler {

    private Picture roger = new Picture(20, 20, "Roger_Smith.png");
    private int speed;
    private int drunkenLvl;

    private boolean pressingRight;
    private boolean pressingLeft;
    private boolean pressingUp;
    private boolean pressingDown;
    private boolean pressingSpace;
    private boolean moveRight;
    private boolean moveLeft;
    private boolean moveUp;
    private boolean moveDown;
    private int iterator;

    public void init() {
        draw();
        setKeyboard();
    }

    public void predictMovements(Walls walls) {
        if (predictRightCollision(walls)) {
            moveRight = false;
        }
        if (predictLeftCollision(walls)) {
            moveLeft = false;
        }
        if (predictTopCollision(walls)) {
            moveUp = false;
        }
        if (predictBotCollision(walls)) {
            moveDown = false;
        }
    }

    @Override
    public void move() {
        speed = 1;

        if (pressingRight && moveRight) {
            roger.translate(speed, 0);
        }
        if (pressingLeft && moveLeft) {
            roger.translate(-speed, 0);
        }
        if (pressingUp && moveUp) {
            roger.translate(0, -speed);
        }
        if (pressingDown && moveDown) {
            roger.translate(0, speed);
        }

        moveUp = true;
        moveDown = true;
        moveLeft = true;
        moveRight = true;

        try {
            Thread.sleep(7);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isAttacking() {
        iterator++;
        if (pressingSpace && iterator > 50 && drunkenLvl > 10) {
            iterator = 0;
            drunkenLvl -= 10;
            return true;
        }
        return false;
    }

    @Override
    public Puke attack() {
        return new Puke(new Picture(xToWidth(), y() + (roger.getHeight() / 2), "bullet.png"));
    }

    public void drinkBottle(int vol, Bottle bottle) {
        if (this.checkCollision(bottle) && !bottle.getDrinked()) {
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

        KeyboardEvent space = new KeyboardEvent();
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

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

        KeyboardEvent spaceReleased = new KeyboardEvent();
        spaceReleased.setKey(KeyboardEvent.KEY_SPACE);
        spaceReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(right);
        keyboard.addEventListener(left);
        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
        keyboard.addEventListener(space);
        keyboard.addEventListener(rightReleased);
        keyboard.addEventListener(leftReleased);
        keyboard.addEventListener(upReleased);
        keyboard.addEventListener(downReleased);
        keyboard.addEventListener(spaceReleased);


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
                break;
            case KeyboardEvent.KEY_SPACE:
                pressingSpace = true;
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
                break;
            case KeyboardEvent.KEY_SPACE:
                pressingSpace = false;
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

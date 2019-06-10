package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Player extends Character implements KeyboardHandler {

    private Picture roger;
    private int speed;
    private int drunkenLvl = 50;
    private boolean dead;

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


    public Player(Picture roger) {
        super(roger);
        this.roger = super.picture;
    }

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
        if (!dead) {
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
        }

    }

    public boolean isAttacking() {
        if (!dead) {
            iterator++;
            if (pressingSpace && iterator > 50 && drunkenLvl > 10) {
                iterator = 0;
                drunkenLvl -= 10;
                return true;
            }
        }
        return false;
    }

    @Override
    public Puke attack(Directions direction) {
        String imageSource = "bullet.png";
        switch (direction) {
            case LEFT:
                return new Puke(new Picture(x(), yToHeight() / 2, imageSource));
            case UP:
                return new Puke(new Picture(xToWidth() / 2, y(), imageSource));
            case DOWN:
                return new Puke(new Picture(xToWidth() / 2, yToHeight(), imageSource));
            default:
                return new Puke(new Picture(xToWidth(), y() + (roger.getHeight() / 2), imageSource));
        }
    }

    public void drinkBottle(int vol, Bottle bottle) {
        if (this.checkCollision(bottle) && !bottle.getDrinked()) {
            this.drunkenLvl += vol;
            System.out.println(drunkenLvl);
            bottle.deleteBottle();
        }
        if(drunkenLvl > 100){
            this.dead = true;
            System.out.println("You drunk like a horse! game over");
        }
    }

    public void touchEnemy() {
        this.dead = true;
    }

    public void hitten(){
        this.dead = true;
    }

    public boolean isDead() {
        return dead;
    }

    public Directions lastKeyPressed(Directions direction) {
        switch (direction) {
            case LEFT:
                return Directions.LEFT;
            case DOWN:
                return Directions.DOWN;
            case UP:
                return Directions.UP;
        }
        return Directions.RIGHT;
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
                lastKeyPressed(Directions.RIGHT);
                break;
            case KeyboardEvent.KEY_LEFT:
                pressingLeft = true;
                lastKeyPressed(Directions.LEFT);
                break;
            case KeyboardEvent.KEY_UP:
                lastKeyPressed(Directions.UP);
                pressingUp = true;
                break;
            case KeyboardEvent.KEY_DOWN:
                lastKeyPressed(Directions.DOWN);
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


}

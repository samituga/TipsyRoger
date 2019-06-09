package org.academiadecodigo.murlogs.tipsyRoger.GameObjects.Characters.Playable;

import org.academiadecodigo.murlogs.tipsyRoger.GameObjects.Bottles;
import org.academiadecodigo.murlogs.tipsyRoger.GameObjects.Characters.Character;
import org.academiadecodigo.murlogs.tipsyRoger.Map;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player extends Character implements KeyboardHandler {

    private int drunkenLvl;
    private Picture player;
    private int speed;
    private boolean pressingRight;
    private boolean pressingLeft;
    private boolean pressingUp;
    private boolean pressingDown;
    private boolean pressingSpace;


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

    public boolean canMove(Map map) {
        if (pressingLeft && x() + speed < map.xToWidth() &&
                xToWidth() + speed > map.xToWidth() &&
                y() < map.y() &&
                yToHeight() > map.y()) {
            return false;
        }
        return true;
    }

    public void move() {
        speed = 1;

        if (pressingRight) {
            player.translate(speed, 0);
        }
        if (pressingLeft) {
            player.translate(-speed, 0);
        }
        if (pressingUp) {
            player.translate(0, -speed);
        }
        if (pressingDown) {
            player.translate(0, speed);
        }
    }

    public void drinkBottle(int vol, Bottles bottle) {
        if (this.isColliding(bottle) && !bottle.getBottleDrinked()) {
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

        KeyboardEvent attack = new KeyboardEvent();
        attack.setKey(KeyboardEvent.KEY_SPACE);
        attack.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

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

        KeyboardEvent attackReleased = new KeyboardEvent();
        attackReleased.setKey(KeyboardEvent.KEY_SPACE);
        attackReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(right);
        keyboard.addEventListener(left);
        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
        keyboard.addEventListener(attack);
        keyboard.addEventListener(rightReleased);
        keyboard.addEventListener(leftReleased);
        keyboard.addEventListener(upReleased);
        keyboard.addEventListener(downReleased);
        keyboard.addEventListener(attackReleased);


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
    public void attack() {

    }

}

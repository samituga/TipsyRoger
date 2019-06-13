package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class PlayerA extends Player implements KeyboardHandler {

    PlayerA(Picture playerA) {
        super(playerA);
    }

    private Picture currentPicture = new Picture();

    @Override
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

        KeyboardEvent lAttack = new KeyboardEvent();
        lAttack.setKey(KeyboardEvent.KEY_L);
        lAttack.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);


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

        KeyboardEvent lAttackReleased = new KeyboardEvent();
        lAttackReleased.setKey(KeyboardEvent.KEY_L);
        lAttackReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);


        keyboard.addEventListener(right);
        keyboard.addEventListener(left);
        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
        keyboard.addEventListener(lAttack);

        keyboard.addEventListener(rightReleased);
        keyboard.addEventListener(leftReleased);
        keyboard.addEventListener(upReleased);
        keyboard.addEventListener(downReleased);
        keyboard.addEventListener(lAttackReleased);

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                pressingRight = true;
                lastDirection = Directions.RIGHT;
                break;
            case KeyboardEvent.KEY_LEFT:
                pressingLeft = true;
                lastDirection = Directions.LEFT;
                break;
            case KeyboardEvent.KEY_UP:
                lastDirection = Directions.UP;
                pressingUp = true;
                break;
            case KeyboardEvent.KEY_DOWN:
                lastDirection = Directions.DOWN;
                pressingDown = true;
                break;
            case KeyboardEvent.KEY_L:
                pressingAttack = true;
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
            case KeyboardEvent.KEY_L:
                pressingAttack = false;
        }
    }

    @Override
    public void showDrunkenLvl() {
        if (drunkenLvl <= 10) {
            currentPicture.delete();
            currentPicture = drunkenLvlPicture.get(0);
            currentPicture.draw();
            return;

        }
        if (drunkenLvl <= 20) {
            currentPicture.delete();
            currentPicture = drunkenLvlPicture.get(1);
            currentPicture.draw();
            return;
        }
        if (drunkenLvl <= 30) {
            currentPicture.delete();
            currentPicture = drunkenLvlPicture.get(2);
            currentPicture.draw();
            return;
        }
        if (drunkenLvl <= 40) {
            currentPicture.delete();
            currentPicture = drunkenLvlPicture.get(3);
            currentPicture.draw();
            return;
        }
        if (drunkenLvl <= 50) {
            currentPicture.delete();
            currentPicture = drunkenLvlPicture.get(4);
            currentPicture.draw();
            return;
        }
        if (drunkenLvl <= 60) {
            currentPicture.delete();
            currentPicture = drunkenLvlPicture.get(5);
            currentPicture.draw();
            return;
        }
        if (drunkenLvl <= 70) {
            currentPicture.delete();
            currentPicture = drunkenLvlPicture.get(6);
            currentPicture.draw();
            return;
        }
        if (drunkenLvl <= 80) {
            currentPicture.delete();
            currentPicture = drunkenLvlPicture.get(7);
            currentPicture.draw();
            return;
        }
        if (drunkenLvl <= 90) {
            currentPicture.delete();
            currentPicture = drunkenLvlPicture.get(8);
            currentPicture.draw();
            return;
        }
        if (drunkenLvl <= 100) {
            currentPicture.delete();
            currentPicture = drunkenLvlPicture.get(9);
            currentPicture.draw();
        }
    }
}

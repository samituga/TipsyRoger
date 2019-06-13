package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class PlayerB extends Player implements KeyboardHandler {


    PlayerB(Picture playerB) {
        super(playerB);
    }

    private Picture currentPicture = new Picture();

    private boolean painted1;
    private boolean painted2;
    private boolean painted3;
    private boolean painted4;
    private boolean painted5;
    private boolean painted6;
    private boolean painted7;
    private boolean painted8;
    private boolean painted9;
    private boolean painted10;


    @Override
    public void setKeyboard() {

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent wUp = new KeyboardEvent();
        wUp.setKey(KeyboardEvent.KEY_W);
        wUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent sDown = new KeyboardEvent();
        sDown.setKey(KeyboardEvent.KEY_S);
        sDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent dRight = new KeyboardEvent();
        dRight.setKey(KeyboardEvent.KEY_D);
        dRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent aLeft = new KeyboardEvent();
        aLeft.setKey((KeyboardEvent.KEY_A));
        aLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent xAttack = new KeyboardEvent();
        xAttack.setKey(KeyboardEvent.KEY_X);
        xAttack.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);


        KeyboardEvent wUpReleased = new KeyboardEvent();
        wUpReleased.setKey(KeyboardEvent.KEY_W);
        wUpReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent sDownReleased = new KeyboardEvent();
        sDownReleased.setKey(KeyboardEvent.KEY_S);
        sDownReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent aLeftReleased = new KeyboardEvent();
        aLeftReleased.setKey(KeyboardEvent.KEY_A);
        aLeftReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent dRightReleased = new KeyboardEvent();
        dRightReleased.setKey(KeyboardEvent.KEY_D);
        dRightReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent xAttackReleased = new KeyboardEvent();
        xAttackReleased.setKey(KeyboardEvent.KEY_X);
        xAttackReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);


        keyboard.addEventListener(wUp);
        keyboard.addEventListener(aLeft);
        keyboard.addEventListener(dRight);
        keyboard.addEventListener(sDown);
        keyboard.addEventListener(xAttack);

        keyboard.addEventListener(wUpReleased);
        keyboard.addEventListener(sDownReleased);
        keyboard.addEventListener(aLeftReleased);
        keyboard.addEventListener(dRightReleased);
        keyboard.addEventListener(xAttackReleased);

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_D:
                pressingRight = true;
                lastDirection = Directions.RIGHT;
                break;
            case KeyboardEvent.KEY_A:
                pressingLeft = true;
                lastDirection = Directions.LEFT;
                break;
            case KeyboardEvent.KEY_W:
                lastDirection = Directions.UP;
                pressingUp = true;
                break;
            case KeyboardEvent.KEY_S:
                lastDirection = Directions.DOWN;
                pressingDown = true;
                break;
            case KeyboardEvent.KEY_X:
                pressingAttack = true;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_D:
                pressingRight = false;
                break;
            case KeyboardEvent.KEY_A:
                pressingLeft = false;
                break;
            case KeyboardEvent.KEY_W:
                pressingUp = false;
                break;
            case KeyboardEvent.KEY_S:
                pressingDown = false;
                break;
            case KeyboardEvent.KEY_X:
                pressingAttack = false;
        }
    }

    @Override
    public void showDrunkenLvl() {
        if (drunkenLvl <= 10) {
            currentPicture.delete();
            currentPicture = drunkenLvlPicture.get(10);
            currentPicture.draw();
            return;

        }
        if (drunkenLvl <= 20) {
            currentPicture.delete();
            currentPicture = drunkenLvlPicture.get(11);
            currentPicture.draw();
            return;
        }
        if (drunkenLvl <= 30) {
            currentPicture.delete();
            currentPicture = drunkenLvlPicture.get(12);
            currentPicture.draw();
            return;
        }
        if (drunkenLvl <= 40) {
            currentPicture.delete();
            currentPicture = drunkenLvlPicture.get(13);
            currentPicture.draw();
            return;
        }
        if (drunkenLvl <= 50) {
            currentPicture.delete();
            currentPicture = drunkenLvlPicture.get(14);
            currentPicture.draw();
            return;
        }
        if (drunkenLvl <= 60) {
            currentPicture.delete();
            currentPicture = drunkenLvlPicture.get(15);
            currentPicture.draw();
            return;
        }
        if (drunkenLvl <= 70) {
            currentPicture.delete();
            currentPicture = drunkenLvlPicture.get(16);
            currentPicture.draw();
            return;
        }
        if (drunkenLvl <= 80) {
            currentPicture.delete();
            currentPicture = drunkenLvlPicture.get(17);
            currentPicture.draw();
            return;
        }
        if (drunkenLvl <= 90) {
            currentPicture.delete();
            currentPicture = drunkenLvlPicture.get(18);
            currentPicture.draw();
            return;
        }
        if (drunkenLvl <= 100) {
            currentPicture.delete();
            currentPicture = drunkenLvlPicture.get(19);
            currentPicture.draw();
        }
    }
}


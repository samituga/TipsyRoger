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
        player.draw();
        setKeyboard();
    }

    public void isTouchingGround() {
        this.touchingGround =true;
    }

    @Override
    public void move() {

        if (!touchingGround) {
            player.translate(0, 1);
        }
        switch (keyPressed) {
            case KeyboardEvent.KEY_LEFT:
                player.translate(-2, 0);
                iterator++;
                if (iterator == 10) {
                    iterator = 0;
                    keyPressed = -1;
                }
                break;
            case KeyboardEvent.KEY_RIGHT:
                player.translate(2, 0);
                iterator++;
                if (iterator == 10) {
                    iterator = 0;
                    keyPressed = -1;
                }
                break;
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



        keyboard.addEventListener(right);
        keyboard.addEventListener(left);
        keyboard.addEventListener(up);
        keyboard.addEventListener(down);


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
        keyPressed = keyboardEvent.getKey();
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }

    @Override
    public void attack() {

    }


}

package org.academiadecodigo.murlogs.moveRectangle;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class SomeRectangle implements KeyboardHandler {

    private Rectangle rectangle;
    private Keyboard keyboard;
    private int keyPressed;
    private int iterator;

    public void init() {
        rectangle = new Rectangle(0, 0, 100, 100);
        rectangle.draw();
        keyboardKeys();
    }


    public void keyboardKeys() {
        keyboard = new Keyboard(this);


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


    public void moveRectangle() {
        rectangle.translate(0, 2);
        switch (keyPressed) {
            case KeyboardEvent.KEY_LEFT:
                rectangle.translate(-2, 0);
                iterator++;
                if (iterator == 10) {
                    iterator = 0;
                    keyPressed = -1;
                }
                break;
            case KeyboardEvent.KEY_RIGHT:
                rectangle.translate(2, 0);
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

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        keyPressed = keyboardEvent.getKey();
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }


    public int getX() {
        return rectangle.getX();
    }

    public int getY() {
        return rectangle.getY();
    }
}

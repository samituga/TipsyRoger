package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu implements KeyboardHandler {
    private boolean pressEnter;
    private boolean pressEsc;
    private boolean pressDown;
    private boolean pressUp;
    private Picture menu = new Picture(0, 0, "image.png");
    private Picture help = new Picture(0, 0, "help.png");
    private Rectangle upPointer = new Rectangle(430, 465, 397, 114);
    private Rectangle downPointer = new Rectangle(568, 575, 120, 72);


    public void start() {
        setKeyboard();
        createMenu();
        upPointer.setColor(Color.GREEN);
        downPointer.setColor(Color.GREEN);
        pressUp = true;
        while (true) {
            if (pressUp) {
                upPointer.draw();
                downPointer.delete();
            }

            if (pressDown) {
                upPointer.delete();
                downPointer.draw();
            }

            if (pressEnter && pressDown) {

                inHelp();
            }

            if (pressEnter && pressUp) {
                deleteAll();
                break;
            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private void deleteAll() {
        help.delete();
        menu.delete();
        upPointer.delete();
        downPointer.delete();
    }

    private void inHelp() {
        deleteMenu();
        createHelp();
        while (true) {
            if (pressEsc) {
                deleteHelp();
                createMenu();
                downPointer.draw();
                break;
            }

            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private void createMenu() {
        menu.draw();
    }

    private void createHelp() {
        help.draw();
    }

    private void deleteMenu() {
        menu.delete();
    }

    private void deleteHelp() {
        help.delete();
    }

    private void setKeyboard() {

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent enter = new KeyboardEvent();
        enter.setKey(KeyboardEvent.KEY_ENTER);
        enter.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent esc = new KeyboardEvent();
        esc.setKey(KeyboardEvent.KEY_ESC);
        esc.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(enter);
        keyboard.addEventListener(esc);
        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_ENTER:
                pressEnter = true;
                pressEsc = false;
                break;
            case KeyboardEvent.KEY_ESC:
                pressEsc = true;
                pressEnter = false;
                break;
            case KeyboardEvent.KEY_UP:
                pressUp = true;
                pressDown = false;
                break;
            case KeyboardEvent.KEY_DOWN:
                pressDown = true;
                pressUp = false;
                break;
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}

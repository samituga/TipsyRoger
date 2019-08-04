package org.academiadecodigo.murlogs.tipsyRoger.game;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu implements KeyboardHandler {

    private boolean inMenu = true;
    private boolean pressEnter;
    private boolean pressEsc;
    private boolean pressDown;
    private boolean pressUp;
    private Sound menuSong = new Sound("/assets//music/menuSong.wav");
    private Picture menu = new Picture(0, 0, "assets/image.png");
    private Picture help = new Picture(0, 0, "assets/Help.png");
    private Picture winner = new Picture(0, 0, "assets/WinnerScreen.png");
    private Rectangle upPointer = new Rectangle(430, 465, 397, 114);
    private Rectangle downPointer = new Rectangle(568, 575, 120, 72);
    private Rectangle winnerPointer = new Rectangle(315, 475, 570, 110);


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
            }
        }

    }

    public void winnerScreen(String path) {
        inMenu = false;
        pressEsc = false;
        pressUp = false;
        pressDown = false;
        pressEnter = false;
        boolean winnersreen = true;
        setKeyboard();
        Picture picture = new Picture(800, 50, path);
        while (winnersreen) {
            winner.draw();
            winnerPointer.setColor(Color.GREEN);
            winnerPointer.draw();
            picture.draw();
            if (pressEnter) {
                inMenu = true;
                winner.delete();
                winnerPointer.delete();
                winnersreen = false;


            }
        }
    }

    public boolean getPressEnter() {
        setKeyboard();
        return pressEnter;
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
                pressUp = false;
                pressDown = true;
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
        menuSong.loopIndef();
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

        KeyboardEvent exit = new KeyboardEvent();
        exit.setKey(KeyboardEvent.KEY_Q);
        exit.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent enterReleased = new KeyboardEvent();
        enterReleased.setKey(KeyboardEvent.KEY_ENTER);
        enterReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent upReleased = new KeyboardEvent();
        upReleased.setKey(KeyboardEvent.KEY_UP);
        upReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent downReleased = new KeyboardEvent();
        downReleased.setKey((KeyboardEvent.KEY_DOWN));
        downReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(enter);
        keyboard.addEventListener(esc);
        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
        keyboard.addEventListener(exit);

        keyboard.addEventListener(enterReleased);
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
                if (inMenu) {
                    pressDown = true;
                    pressUp = false;
                }
                break;
            case KeyboardEvent.KEY_Q:
                if (!inMenu) {
                    System.exit(1);
                }
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_ENTER:
                pressEnter = false;
                break;
            case KeyboardEvent.KEY_DOWN:
                pressDown = false;
                break;
            case KeyboardEvent.KEY_UP:
                pressUp = false;
                break;
            case KeyboardEvent.KEY_ESC:
                pressEsc = false;
                break;

        }
    }

    public Sound getMenuSong() {
        return menuSong;
    }
}
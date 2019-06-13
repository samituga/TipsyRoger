package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import javax.swing.border.StrokeBorder;
import java.security.Key;
import java.util.LinkedList;

public abstract class Player extends Character {

    private Picture roger;
    private int speed;
    protected int drunkenLvl = 50;
    protected boolean pressingRight;
    protected boolean pressingLeft;
    protected boolean pressingUp;
    protected boolean pressingDown;
    protected boolean pressingAttack;
    protected boolean moveRight;
    protected boolean moveLeft;
    protected boolean moveUp;
    protected boolean moveDown;
    protected int iterator;
    private int drunkenIterator;
    protected Directions lastDirection;
    protected boolean looser;
    protected LinkedList<Picture> drunkenLvlPicture = new LinkedList<>();

    public void addDrunkenLvlBar() {
        drunkenLvlPicture.add(new Picture(10, 10, "1.png"));
        drunkenLvlPicture.add(new Picture(10, 10, "2.png"));
        drunkenLvlPicture.add(new Picture(10, 10, "3.png"));
        drunkenLvlPicture.add(new Picture(10, 10, "4.png"));
        drunkenLvlPicture.add(new Picture(10, 10, "5.png"));
        drunkenLvlPicture.add(new Picture(10, 10, "6.png"));
        drunkenLvlPicture.add(new Picture(10, 10, "7.png"));
        drunkenLvlPicture.add(new Picture(10, 10, "8.png"));
        drunkenLvlPicture.add(new Picture(10, 10, "9.png"));
        drunkenLvlPicture.add(new Picture(10, 10, "10.png"));
        drunkenLvlPicture.add(new Picture(900, 10, "1.png"));
        drunkenLvlPicture.add(new Picture(900, 10, "2.png"));
        drunkenLvlPicture.add(new Picture(900, 10, "3.png"));
        drunkenLvlPicture.add(new Picture(900, 10, "4.png"));
        drunkenLvlPicture.add(new Picture(900, 10, "5.png"));
        drunkenLvlPicture.add(new Picture(900, 10, "6.png"));
        drunkenLvlPicture.add(new Picture(900, 10, "7.png"));
        drunkenLvlPicture.add(new Picture(900, 10, "8.png"));
        drunkenLvlPicture.add(new Picture(900, 10, "9.png"));
        drunkenLvlPicture.add(new Picture(900, 10, "10.png"));

    }

    public void looseDrunkenLvl() {
        drunkenIterator++;
        System.out.println(drunkenIterator);
        if (drunkenIterator > 40) {
            drunkenIterator = 0;
            drunkenLvl--;
        }
    }

    public Player(Picture roger) {
        super(roger);
        this.roger = super.picture;
    }

    public abstract void showDrunkenLvl();


    public abstract void setKeyboard();

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
            if (pressingAttack && iterator > 50 && drunkenLvl > 10) {
                iterator = 0;
                drunkenLvl -= 5;
                return true;
            }
        }
        return false;
    }

    @Override
    public Puke attack(Directions direction) {
        if (direction == null) {
            direction = Directions.RIGHT;
        }
        String imageSource = "puke.png";
        switch (direction) {
            case LEFT:
                return new Puke(new Picture(x(), y() + (picture.getHeight() / 2), imageSource), this, lastDirection);
            case UP:
                return new Puke(new Picture(x() + (picture.getWidth() / 2), y(), imageSource), this, lastDirection);
            case DOWN:
                return new Puke(new Picture(x() + (picture.getWidth() / 2), yToHeight(), imageSource), this, lastDirection);
            default:
                return new Puke(new Picture(xToWidth(), y() + (roger.getHeight() / 2), imageSource), this, lastDirection);
        }
    }

    public void drinkBottle(int vol, Bottle bottle) {
        if (this.checkCollision(bottle) && !bottle.getDrinked()) {
            this.drunkenLvl += vol;
            System.out.println(drunkenLvl);
            bottle.deleteBottle();
        }
        if (drunkenLvl > 100) {
            this.dead = true;
            System.out.println("You drunk like a horse! game over");
        }
    }

    public void touchEnemy() {
        System.out.println("DEAD");
        this.dead = true;
    }

    public void hitten() {
        this.dead = true;
    }

    public void setLooser() {
        this.looser = true;
    }

    public Directions getLastDirection() {
        return lastDirection;
    }
}

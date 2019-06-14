package org.academiadecodigo.murlogs.tipsyRoger.characters.Player;

import org.academiadecodigo.murlogs.tipsyRoger.characters.Character;
import org.academiadecodigo.murlogs.tipsyRoger.game.Directions;
import org.academiadecodigo.murlogs.tipsyRoger.gameObjects.Bottle;
import org.academiadecodigo.murlogs.tipsyRoger.gameObjects.Puke;
import org.academiadecodigo.murlogs.tipsyRoger.gameObjects.Walls;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;

public abstract class Player extends Character {

    protected Picture roger;
    protected Picture reverted;
    protected int drunkenLvl;
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
    protected LinkedList<Picture> drunkenLvlPicture = new LinkedList<>();
    protected boolean inGame;


    public Player(Picture roger, Picture reverted) {
        super(roger);
        this.reverted = reverted;
        this.roger = super.picture;
        inGame = true;
        drunkenLvl = 50;
    }


    public void addDrunkenLvlBar() {
        drunkenLvlPicture.add(new Picture(900, 10, "assets/1.png"));
        drunkenLvlPicture.add(new Picture(900, 10, "assets/2.png"));
        drunkenLvlPicture.add(new Picture(900, 10, "assets/3.png"));
        drunkenLvlPicture.add(new Picture(900, 10, "assets/4.png"));
        drunkenLvlPicture.add(new Picture(900, 10, "assets/5.png"));
        drunkenLvlPicture.add(new Picture(900, 10, "assets/6.png"));
        drunkenLvlPicture.add(new Picture(900, 10, "assets/7.png"));
        drunkenLvlPicture.add(new Picture(900, 10, "assets/8.png"));
        drunkenLvlPicture.add(new Picture(900, 10, "assets/9.png"));
        drunkenLvlPicture.add(new Picture(900, 10, "assets/10.png"));
        drunkenLvlPicture.add(new Picture(10, 10, "assets/1.png"));
        drunkenLvlPicture.add(new Picture(10, 10, "assets/2.png"));
        drunkenLvlPicture.add(new Picture(10, 10, "assets/3.png"));
        drunkenLvlPicture.add(new Picture(10, 10, "assets/4.png"));
        drunkenLvlPicture.add(new Picture(10, 10, "assets/5.png"));
        drunkenLvlPicture.add(new Picture(10, 10, "assets/6.png"));
        drunkenLvlPicture.add(new Picture(10, 10, "assets/7.png"));
        drunkenLvlPicture.add(new Picture(10, 10, "assets/8.png"));
        drunkenLvlPicture.add(new Picture(10, 10, "assets/9.png"));
        drunkenLvlPicture.add(new Picture(10, 10, "assets/10.png"));

        Picture playerA = new Picture(10, 10, "assets/deadpool.png");
        Picture playerB = new Picture(900, 10, "assets/RogerSmith.png");
        playerA.draw();
        playerB.draw();
    }

    public void looseDrunkenLvl() {
        drunkenIterator++;
        if (drunkenIterator > 40) {
            drunkenIterator = 0;
            drunkenLvl--;
        }
        if (drunkenLvl <= 0) {
            dead = true;
        }
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
        int speed = 1;
        if (!dead) {

            if (pressingRight && moveRight) {
                roger.translate(speed, 0);
                reverted.translate(speed, 0);
            }
            if (pressingLeft && moveLeft) {
                roger.translate(-speed, 0);
                reverted.translate(-speed, 0);
            }
            if (pressingUp && moveUp) {
                roger.translate(0, -speed);
                reverted.translate(0, -speed);
            }
            if (pressingDown && moveDown) {
                roger.translate(0, speed);
                reverted.translate(0, speed);
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
        String imageSource = "assets/puke.png";
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
            bottle.deleteBottle();
        }
        if (drunkenLvl > 100) {
            this.dead = true;
        }
    }

    public void touchEnemy() {
        this.dead = true;
    }

    public void hitten() {
        this.dead = true;
    }

    public Directions getLastDirection() {
        return lastDirection;
    }

    public void setInGame() {
        this.inGame = false;
    }
}

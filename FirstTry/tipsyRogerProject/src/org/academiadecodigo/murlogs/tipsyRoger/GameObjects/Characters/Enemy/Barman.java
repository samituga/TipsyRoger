package org.academiadecodigo.murlogs.tipsyRoger.GameObjects.Characters.Enemy;


import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Barman extends Enemy {

    Rectangle barmanRectangle;
    Picture barmanPicture;


    public Barman(Picture picture) {
        this.barmanPicture = picture;
    }

    @Override
    public void move() {
        super.move();
    }

    @Override
    public void attack() {
        super.attack();
    }

    @Override
    public void setDead() {
        super.setDead();
    }

    @Override
    public boolean isDead() {
        return super.isDead();
    }

    @Override
    public void draw() {
        barmanPicture.draw();
    }

    @Override
    public int y() {
        return (int) barmanPicture.getY();
    }

    @Override
    public int x() {
        return (int) barmanPicture.getX();
    }

    @Override
    public int yToHeight() {
        return (int) (barmanPicture.getX() + barmanPicture.getHeight());
    }

    @Override
    public int xToWidth() {
        return (int) (barmanPicture.getY() + barmanPicture.getWidth());
    }
}


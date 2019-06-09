package org.academiadecodigo.murlogs.tipsyRoger.GameObjects.Characters.Enemy;


import org.academiadecodigo.murlogs.tipsyRoger.GameObjects.Weapon;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Drunken extends Enemy {


    Picture drunkenPicture;

    public Drunken(Picture picture) {
        this.drunkenPicture = picture;
    }

    @Override
    public void move() {
        super.move();
    }

    @Override
    public Weapon attack() {
        super.attack();
        return null;
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
        super.draw();
    }

    @Override
    public int y() {
        return super.y();
    }

    @Override
    public int x() {
        return super.x();
    }

    @Override
    public int yToHeight() {
        return super.yToHeight();
    }

    @Override
    public int xToWidth() {
        return super.xToWidth();
    }
}

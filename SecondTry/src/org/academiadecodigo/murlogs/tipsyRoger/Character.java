package org.academiadecodigo.murlogs.tipsyRoger;


import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Character extends Colidable {

    protected Picture picture;
    protected boolean moveRight = true;
    protected boolean moveLeft = true;
    protected boolean moveUp = true;
    protected boolean moveDown = true;

    Character(Picture picture){
        this.picture = picture;
    }

    protected boolean dead;

    public abstract void move();
    public abstract Puke attack(Directions direction);

    public boolean isDead() {
        return dead;
    }

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
    public void draw() {
        picture.draw();
    }

    @Override
    public int x() {
        return picture.getX();
    }

    @Override
    public int y() {
        return picture.getY();
    }

    @Override
    public int xToWidth() {
        return x() + picture.getWidth();
    }

    @Override
    public int yToHeight() {
        return y() + picture.getHeight();
    }
}

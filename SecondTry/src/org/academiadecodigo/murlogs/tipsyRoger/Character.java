package org.academiadecodigo.murlogs.tipsyRoger;


import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Character extends Colidable {

    protected Picture picture;

    Character(Picture picture){
        this.picture = picture;
    }

    protected boolean dead;

    public abstract void move();
    public abstract Puke attack(Directions direction);


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

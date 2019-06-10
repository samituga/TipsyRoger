package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Puke extends Colidable {

    private Picture puke;
    private Character owner;
    private int iterator;
    private boolean destroyed;
    private Directions directions;

    Puke(Picture puke, Character owner, Directions directions) {
        this.puke = puke;
        this.owner = owner;
        this.directions = directions;
    }

    public void move() {

        switch (directions) {
            case LEFT:
                puke.translate(-4, 0);
                break;
            case UP:
                puke.translate(0, -4);
                break;
            case DOWN:
                puke.translate(0, 4);
                break;
            default:
                puke.translate(4, 0);

        }
    }

    public boolean isDestroyed() {
        iterator += 1;
        if (iterator > 30 || destroyed) {
            puke.delete();
            destroyed = true;
            return true;
        }
        return false;
    }

    public Character getOwner() {
        return owner;
    }

    @Override
    public void draw() {
        puke.draw();
    }

    public boolean hit(Character character) {
        if (this.checkCollision(character)) {
            destroyed = true;
            return true;
        }
        return false;
    }

    @Override
    public int x() {
        return puke.getX();
    }

    @Override
    public int y() {
        return puke.getY();
    }

    @Override
    public int xToWidth() {
        return x() + puke.getWidth();
    }

    @Override
    public int yToHeight() {
        return y() + puke.getHeight();
    }
}

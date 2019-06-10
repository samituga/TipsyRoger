package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Puke extends Colidable {

    private Picture puke;
    private int iterator;
    private boolean destroyed;

    Puke(Picture puke) {
        this.puke = puke;
    }

    public void move(Directions directions) {
        switch (directions) {
            case LEFT:
                puke.translate(-3, 0);
                break;
            case UP:
                puke.translate(0, -3);
                break;
            case DOWN:
                puke.translate(0, 3);
                break;
            default:
                puke.translate(3, 0); // TODO: 2019-06-09 Accept Directions

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

    @Override
    public void draw() {
        puke.draw();
    }

    public boolean hit(Enemy enemy) {
        if (this.checkCollision(enemy)) {
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

package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Bottle extends Colidable {


    private Picture bottle;
    private int vol;
    private boolean drinked;
    private int iterator;

    public Bottle(Picture bottle, int vol) {
        this.bottle = bottle;
        this.vol = vol;
    }

    public void deleteBottle() {
        bottle.delete();
        drinked = true;
    }

    public void respawnBottle() {
        iterator++;
        System.out.println(iterator);
        if (iterator > 1500){
            iterator = 0;
            drinked = false;
            bottle.draw();
        }

    }


    @Override
    public void draw() {
        bottle.draw();
    }

    @Override
    public int x() {
        return bottle.getX();
    }

    @Override
    public int y() {
        return bottle.getY();
    }

    @Override
    public int xToWidth() {
        return x() + bottle.getWidth();
    }

    @Override
    public int yToHeight() {
        return y() + bottle.getHeight();
    }

    public int getVol() {
        return vol;
    }

    public boolean getDrinked() {
        return drinked;
    }
}

package org.academiadecodigo.murlogs.tipsyRoger.GameObjects;


import org.academiadecodigo.murlogs.tipsyRoger.Colidable;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Bottles extends Colidable {

    private BottleTypes bottleTypes;
    private Picture bottlePic;
    private Rectangle bottleRectangle;
    private int vol;
    private boolean bottleDrinked;

    public Bottles(BottleTypes bottleTypes, Picture picture, int vol) {
        this.bottleTypes = bottleTypes;
        this.bottlePic = picture;
        this.vol = vol;
    }

    public void deleteBottle() {
        bottlePic.delete();
        bottleDrinked = true;
    }

    @Override
    public void draw() {
        bottlePic.draw();
    }

    @Override
    public int y() {
        return bottlePic.getY();
    }

    @Override
    public int x() {
        return bottlePic.getX();
    }

    @Override
    public int yToHeight() {
        return bottlePic.getY() + bottlePic.getHeight();
    }

    @Override
    public int xToWidth() {
        return bottlePic.getX() + bottlePic.getWidth();
    }

    public int getVol() {
        return vol;
    }

    public boolean getBottleDrinked() {
        return bottleDrinked;
    }
}

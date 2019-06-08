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

    public Bottles(BottleTypes bottleTypes, Rectangle rectangle, int vol) {
        this.bottleTypes = bottleTypes;
        this.bottleRectangle = rectangle;
        this.vol = vol;
    }

    public void deleteBottle(){
        System.out.println("sdfsdiudiuvcuvhuvdfusvfs");
        bottleRectangle.delete();
        bottleDrinked = true;
    }

    @Override
    public void draw() {
        bottleRectangle.draw();
    }

    @Override
    public int y() {
        return bottleRectangle.getY();
    }

    @Override
    public int x() {
        return bottleRectangle.getX();
    }

    @Override
    public int yToHeight() {
        return bottleRectangle.getY() + bottleRectangle.getHeight();
    }

    @Override
    public int xToWidth() {
        return bottleRectangle.getX() + bottleRectangle.getWidth();
    }

    public int getVol() {
        return vol;
    }

    public boolean getBottleDrinked(){
        return bottleDrinked;
    }
}

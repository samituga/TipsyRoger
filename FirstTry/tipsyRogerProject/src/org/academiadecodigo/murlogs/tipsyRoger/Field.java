package org.academiadecodigo.murlogs.tipsyRoger;


import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Field extends Colidable {

    Rectangle outerRectangle = new Rectangle(10, 300, 1200, 600); //1900, 1060


    public void setOuterRectangle(Rectangle outerRectangle) {
        // this.outerRectangle = outerRectangle;
    }


    @Override
    public void draw() {
        outerRectangle.draw();
    }

    @Override
    public int y() {
        return outerRectangle.getY();
    }

    @Override
    public int x() {
        return outerRectangle.getX();
    }

    @Override
    public int yToHeight() {
        return outerRectangle.getY() + outerRectangle.getHeight();
    }

    @Override
    public int xToWidth() {
        return outerRectangle.getX() + outerRectangle.getWidth();
    }


}

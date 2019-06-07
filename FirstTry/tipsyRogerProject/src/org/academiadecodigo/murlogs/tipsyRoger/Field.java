package org.academiadecodigo.murlogs.tipsyRoger;


import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Field {

    Rectangle outerRectangle = new Rectangle(0, 0, 1000, 500);


    public void setOuterRectangle(Rectangle outerRectangle) {
        // this.outerRectangle = outerRectangle;
    }

    public int outerRectangleY() {
        return outerRectangle.getY();
    }

    public int outerRectangleX() {
        return outerRectangle.getX();
    }

    public int outerRectangleHeight() {
        return outerRectangle.getHeight();
    }

    public int outerRectangleWidth() {
        return outerRectangle.getWidth();
    }

}

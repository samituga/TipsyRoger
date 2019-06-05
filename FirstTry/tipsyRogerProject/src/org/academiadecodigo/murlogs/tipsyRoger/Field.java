package org.academiadecodigo.murlogs.tipsyRoger;


import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Field implements Drawable {

    Rectangle rectangle;



    @Override
    public void rectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }



    private int rectangleY(){
        return rectangle.getY();
    }

    private int rectangleX(){
        return rectangle.getX();
    }

}

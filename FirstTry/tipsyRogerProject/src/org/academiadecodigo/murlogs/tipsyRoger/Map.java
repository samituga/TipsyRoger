package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Map extends Colidable {

    private Rectangle rectangle;

    Map(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    @Override
    public void draw() {
        rectangle.fill();
    }

    @Override
    public int x() {
        return rectangle.getX();
    }

    @Override
    public int y() {
        //System.out.println("map y is: " + rectangle.getY());
        return rectangle.getY();
    }

    @Override
    public int xToWidth() {
        //System.out.println("map xToWidth is: " + (rectangle.getX() + rectangle.getWidth()));
        return (x() + rectangle.getWidth());
    }

    @Override
    public int yToHeight() {
        //System.out.println("map yToHeight is: " + (rectangle.getY() + rectangle.getHeight()));
        return (y() + rectangle.getHeight());
    }

}

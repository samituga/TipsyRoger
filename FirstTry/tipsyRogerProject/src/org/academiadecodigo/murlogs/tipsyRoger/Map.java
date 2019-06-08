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
        return rectangle.getY();
    }

    @Override
    public int xToWidth() {
        return (x() + rectangle.getWidth());
    }

    @Override
    public int yToHeight() {
        return (y() + rectangle.getHeight());
    }

}

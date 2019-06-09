package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Walls extends Colidable {

    private Rectangle wall;

    Walls(Rectangle wall) {
        this.wall = wall;
    }

    @Override
    public void draw() {
        wall.setColor(Color.RED);
        wall.fill();
    }

    @Override
    public int x() {
        return wall.getX();
    }

    @Override
    public int y() {
        return wall.getY();
    }

    @Override
    public int xToWidth() {
        return (x() + wall.getWidth());
    }

    @Override
    public int yToHeight() {
        return (y() + wall.getHeight());
    }



}

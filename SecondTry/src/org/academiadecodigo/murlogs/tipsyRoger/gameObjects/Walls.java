package org.academiadecodigo.murlogs.tipsyRoger.gameObjects;

import org.academiadecodigo.murlogs.tipsyRoger.game.Colidable;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Walls extends Colidable {

    private Rectangle wall;

    public Walls(Rectangle wall) {
        this.wall = wall;
    }


    @Override
    public void draw() {
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

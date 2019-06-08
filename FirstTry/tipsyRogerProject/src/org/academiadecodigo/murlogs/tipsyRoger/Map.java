package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Map {

    private Field field = new Field();
    private int width = 50;
    private int height = 50;

    Rectangle rectangle = new Rectangle(xToWidth(), yToHeight(), width, height);

    public void drawRectangle() {
        rectangle.fill();
    }


    public int autoY() {
        return yToHeight() - height;
    }

    public int autoX() {
        return xToWidth() - width;
    }

    public int xToWidth() {
        return field.xToWidth();
    }

    public int yToHeight() {
        return field.yToHeight();
    }


}

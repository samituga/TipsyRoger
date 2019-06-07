package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Map {
    private Field field = new Field();
    private int width = field.outerRectangleWidth();
    private int height = 50;

    Rectangle rectangle = new Rectangle(0, autoY(), width, height);

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
        return field.outerRectangleX() + field.outerRectangleWidth();
    }

    public int yToHeight() {
        return field.outerRectangleY() + field.outerRectangleHeight();
    }

}

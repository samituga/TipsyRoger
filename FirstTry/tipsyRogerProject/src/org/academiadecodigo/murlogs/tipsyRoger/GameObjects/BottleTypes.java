package org.academiadecodigo.murlogs.tipsyRoger.GameObjects;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public enum BottleTypes {
    BEER(10, 150, 150, 20, 20),
    WATER(-10, 150, 150, 20, 20),
    VODKA(20, 150, 150, 20, 20);

    private int vol;
    Rectangle rectangle;

    BottleTypes(int vol, int x, int y, int width, int height) {
        this.vol = vol;
        this.rectangle = new Rectangle(x, y, width, height);

    }


}

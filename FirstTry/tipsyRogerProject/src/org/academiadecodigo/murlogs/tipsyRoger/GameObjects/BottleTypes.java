package org.academiadecodigo.murlogs.tipsyRoger.GameObjects;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public enum BottleTypes {
    BEER(10),
    WATER(-10),
    VODKA(20);

    private int vol;
    private Picture bottle;


    BottleTypes(int vol) {
        this.vol = vol;
    }

    public static Bottles bottlesFactory(int x, int y) {
        int width = 10;
        int height = 30;

        int randomNumber = (int) (Math.random() * BottleTypes.values().length);
        BottleTypes bottleTypes = BottleTypes.values()[randomNumber];

        switch (bottleTypes) {
            case BEER:
                return new Bottles(BEER, new Picture(x, y, "beersmall.png"), 10);
            case VODKA:
                return new Bottles(VODKA, new Picture(x, y, "vodkasmall.png"), 30);
            case WATER:
                return new Bottles(WATER, new Picture(x, y, "watersmall.png"), -10);
        }
        return null;
    }


}

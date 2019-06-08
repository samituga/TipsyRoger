package org.academiadecodigo.murlogs.tipsyRoger.GameObjects;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public enum BottleTypes {
    BEER(10),
    WATER(-10),
    VODKA(20);

    private int vol;

    BottleTypes(int vol) {
        this.vol = vol;
    }

    public static Bottles bottlesFactory() {
        int width = 10;
        int height = 30;
        int randomNumber = (int) (Math.random() * BottleTypes.values().length);
        BottleTypes bottleTypes = BottleTypes.values()[randomNumber];

        switch (bottleTypes) {
            case BEER:
                return new Bottles(BEER, new Rectangle(100, 100, width, height), 10);
            case VODKA:
                return new Bottles(VODKA, new Rectangle(100, 100, width, height), 30);
            case WATER:
                return new Bottles(WATER, new Rectangle(100, 100, width, height), -10);
        }
        return null;
    }


}

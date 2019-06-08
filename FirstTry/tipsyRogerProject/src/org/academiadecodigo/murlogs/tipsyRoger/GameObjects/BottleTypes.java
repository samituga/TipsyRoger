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

    public static Bottles bottlesFactory() {
        int width = 10;
        int height = 30;
        int randomNumber = (int) (Math.random() * BottleTypes.values().length);
        BottleTypes bottleTypes = BottleTypes.values()[randomNumber];

        switch (bottleTypes){
            case BEER:
                return new Bottles(BEER, new Rectangle(100, 100, width, height), 10);
            case VODKA:
                return new Bottles(VODKA, new Rectangle(100, 100, width, height), 30);
            case WATER:
                return new Bottles(WATER, new Rectangle(100, 100, width, height), -10);
        }
        System.out.println("shit");
        return null;
    }


}

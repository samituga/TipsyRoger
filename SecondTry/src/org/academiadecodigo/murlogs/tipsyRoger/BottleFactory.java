package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.NoSuchElementException;

public enum BottleFactory {
    BEER(10),
    VODKA(30),
    WATER(-10);

    private int vol;

    BottleFactory(int vol) {
        this.vol = vol;
    }

    public static Bottle spawnBottle(int x, int y) {
        int randomNumber = (int) (Math.random() * BottleFactory.values().length);
        BottleFactory bottleFactory = BottleFactory.values()[randomNumber];

        switch (bottleFactory) {
            case BEER:
                return new Bottle(new Picture(x, y, "beer.png"), bottleFactory.vol);
            case VODKA:
                return new Bottle(new Picture(x, y, "vodka.png"), bottleFactory.vol);
            case WATER:
                return new Bottle(new Picture(x,y, "water.png"), bottleFactory.vol);
        }
        throw new NoSuchElementException();
    }
}

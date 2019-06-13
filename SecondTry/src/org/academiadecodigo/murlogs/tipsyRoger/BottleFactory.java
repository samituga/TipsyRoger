package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.NoSuchElementException;

public enum BottleFactory {
    BEER(5),
    VODKA(15),
    WATER(-5);

    private int vol;

    BottleFactory(int vol) {
        this.vol = vol;
    }

    public static Bottle spawnBottle(int x, int y) {

        int randomNumber = (int) (Math.random() * BottleFactory.values().length);
        BottleFactory bottleFactory = BottleFactory.values()[randomNumber];

        switch (bottleFactory) {
            case BEER:
                return new Bottle(new Picture(x, y, "assets/beer.png"), bottleFactory.vol);
            case VODKA:
                return new Bottle(new Picture(x, y, "assets/vodka.png"), bottleFactory.vol);
            case WATER:
                return new Bottle(new Picture(x, y, "assets/water.png"), bottleFactory.vol);
        }
        throw new NoSuchElementException();
    }

}

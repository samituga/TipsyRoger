package org.academiadecodigo.murlogs.tipsyRoger.GameObjects;


import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Bottles {

    private BottleTypes bottleTypes;
    private int drunkenLvl;
    private Picture bottlePic;
    private Rectangle bottleRectangle;

    public Bottles(BottleTypes bottleTypes) {
        this.bottleTypes = bottleTypes;
    }

    public Bottles getNewBottle() {
        int random = (int) (Math.random() * BottleTypes.values().length);
        BottleTypes bottleTypes = BottleTypes.values()[random];


        switch (bottleTypes) {
            case BEER:
                System.out.println("dsd");
                return new Bottles(BottleTypes.BEER);

            case VODKA:
                System.out.println("dsdds");
                return new Bottles(BottleTypes.VODKA);

            case WATER:
                System.out.println("sfgdsb");
                return new Bottles(BottleTypes.WATER);

            default:
                System.out.println("something went wrong");

        }
        return null;
    }

    public void init() {

        getNewBottle();
        bottleTypes.rectangle.draw();



        //bottlePic.draw();
    }

    public void drink() {

    }


}

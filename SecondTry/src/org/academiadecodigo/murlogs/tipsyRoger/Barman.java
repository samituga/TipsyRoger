package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Barman extends Enemy {

    private Picture barman;
    private int iterator;

    Barman(Picture barman){
        super(barman);
        this.barman = barman;
    }

    @Override
    public void move() {
        super.move();
    }


    @Override
    public Puke attack(Directions directions) {
        return new Puke(new Picture(x(), y(), "vodka.png"), this, Directions.DOWN);
    }
}

package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Barman extends Enemy {

    private Picture barman;

    Barman(Picture barman){
        super(barman);
        this.barman = barman;
    }

    @Override
    public void move() {
        super.move();
    }

    public Weapon attack(){
        return new Weapon(new Picture(x() + (barman.getWidth()/2), yToHeight(), "beer.png"));
    }
}

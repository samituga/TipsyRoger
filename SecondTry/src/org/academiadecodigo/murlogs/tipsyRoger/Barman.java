package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Barman extends Enemy {

    private Picture barman;
    private int iterator;
    private int randomMove;

    Barman(Picture barman) {
        super(barman);
        this.barman = barman;
    }

    @Override
    public void move() {
        int speed = 1;
        if (!dead) {

            iterator++;

            if (iterator > 50) {
                randomMove = (int) (Math.random() * 2);
                iterator = 0;
            }


            switch (randomMove) {
                case 0:
                    if (barman.getY() > 0 && barman.getX() == 1100) {
                        barman.translate(0, -speed);
                        break;
                    }
                    if(barman.getY()> 150 && barman.getX() == 1101){
                        barman.translate(0, -speed);
                        break;
                    }
                    if(barman.getY()> 300  && barman.getX() == 1102){
                        barman.translate(0, -speed);
                        break;
                    }
                    if(barman.getY()>  450 && barman.getX() == 1103){
                        barman.translate(0, -speed);
                        break;
                    }
                case 1:
                    if (barman.getY() < 150 && barman.getX() == 1100) {
                        barman.translate(0, speed);
                        break;
                    }
                    if (barman.getY() < 300 && barman.getX() == 1101) {
                        barman.translate(0, speed);
                        break;
                    }
                    if (barman.getY() < 450 && barman.getX() == 1102) {
                        barman.translate(0, speed);
                        break;
                    }
                    if (barman.getY() < 600 && barman.getX() == 1103) {
                        barman.translate(0, speed);
                        break;
                    }
            }

        }
    }


    @Override
    public Puke attack(Directions directions) {
        return new Puke(new Picture(x(), y(), "vodka.png"), this, Directions.LEFT);
    }
}

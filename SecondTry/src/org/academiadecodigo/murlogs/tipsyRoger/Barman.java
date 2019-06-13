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

            if (iterator > 40) {
                randomMove = (int) (Math.random() * 2);
                iterator = 0;
            }


            switch (randomMove) {
                case 0:
                    if (barman.getY() >= 425 && barman.getX() == 1103) {
                        barman.translate(0, -speed);
                        break;
                    }
                    if (barman.getY() >= 275 && barman.getX() == 1102) {
                        barman.translate(0, -speed);
                        break;
                    }
                    if (barman.getY() >= 125 && barman.getX() == 1101) {
                        barman.translate(0, -speed);
                        break;
                    }
                    if (barman.getY() >= 20 && barman.getX() == 1100) {
                        barman.translate(0, -speed);
                        break;
                    }

                    barman.translate(0, speed);
                    break;

                case 1:
                    if (barman.getY() <= 105 && barman.getX() == 1100) {
                        barman.translate(0, speed);
                        break;
                    }
                    if (barman.getY() <= 250 && barman.getX() == 1101) {
                        barman.translate(0, speed);
                        break;
                    }
                    if (barman.getY() <= 400 && barman.getX() == 1102) {
                        barman.translate(0, speed);
                        break;
                    }
                    if (barman.getY() <= 550 && barman.getX() == 1103) {
                        barman.translate(0, speed);
                        break;
                    }

                    barman.translate(0, -speed);
                    break;
            }

        }
    }


    @Override
    public Puke attack(Directions directions) {
        return new Puke(new Picture(x(), y(), "assets/vodka.png"), this, Directions.LEFT);
    }
}

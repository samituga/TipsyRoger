package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Drunken extends Enemy {

    Picture drunken;
    private int iterator;
    private int randomMove;
    Directions directions;


    Drunken(Picture drunken) {
        super(drunken);
        this.drunken = super.picture;
    }


    public int getIterator() {
        return iterator;
    }

    @Override
    public Puke attack(Directions directions) {
        return new Puke(new Picture(x(), y(), "bullet.png"), this, Directions.LEFT);
    }

    @Override
    public void move() {
        int speed = 1;
        if (!dead) {

            iterator++;

            if (iterator > 50) {
                randomMove = (int) (Math.random() * Directions.values().length);
                iterator=0;
            }

            Directions directions = Directions.values()[randomMove];

            switch (directions) {
                case RIGHT:
                    drunken.translate(speed, 0);
                    break;
                case LEFT:
                    drunken.translate(-speed, 0);
                    break;
                case UP:
                    drunken.translate(0, -speed);
                    break;
                case DOWN:
                    drunken.translate(0, speed);
                    break;
                default:
                    System.out.println("shit happened");
            }

        }
    }
}









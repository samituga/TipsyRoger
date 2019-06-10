package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Drunken extends Enemy {

    Picture drunken;
    private int iterator;
    Directions directions;


    Drunken(Picture drunken) {
        super(drunken);
        this.drunken = super.picture;
    }


    public int getIterator() {
        return iterator;
    }

    @Override
    public void move() {
        int speed = 3;
        if (!dead) {
            int randomMove = (int) (Math.random() * Directions.values().length);
            Directions directions = Directions.values()[randomMove];

            iterator++;

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
                iterator = 0;
            }

        }




        @Override
        public Puke attack (Directions directions){
            return new Puke(new Picture(x(), y(), "bullet.png"), this, Directions.LEFT);
        }

    }


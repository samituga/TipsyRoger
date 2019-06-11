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


    @Override
    public void predictMovements(Walls walls) {
        super.predictMovements(walls);
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
            System.out.println("r " + moveRight + " l " + moveLeft + " u " + moveUp + " d " + moveDown);
            switch (directions) {
                case RIGHT:
                    if(moveRight) {
                        drunken.translate(speed, 0);
                        moveDown = true;
                        moveUp = true;
                        moveLeft = true;
                        moveRight = true;
                    }
                    break;
                case LEFT:
                    if (moveLeft) {
                        drunken.translate(-speed, 0);
                        moveDown = true;
                        moveUp = true;
                        moveLeft = true;
                        moveRight = true;
                    }
                    break;
                case UP:
                    if (moveUp) {
                        drunken.translate(0, -speed);
                        moveDown = true;
                        moveUp = true;
                        moveLeft = true;
                        moveRight = true;
                    }
                    break;
                case DOWN:
                    if (moveDown) {
                        drunken.translate(0, speed);
                        moveDown = true;
                        moveUp = true;
                        moveLeft = true;
                        moveRight = true;
                    }
                    break;
                default:
                    System.out.println("shit happened");
            }

        }
    }
}









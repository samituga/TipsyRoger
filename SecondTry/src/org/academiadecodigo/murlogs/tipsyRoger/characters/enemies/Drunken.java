package org.academiadecodigo.murlogs.tipsyRoger.characters.enemies;

import org.academiadecodigo.murlogs.tipsyRoger.game.Directions;
import org.academiadecodigo.murlogs.tipsyRoger.gameObjects.Puke;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Drunken extends Enemy {

    private Picture drunken;
    private int iterator;
    private int randomMove;


    public Drunken(Picture drunken) {
        super(drunken);
        this.drunken = super.picture;
    }


    @Override
    public Puke attack(Directions directions) {
        return new Puke(new Picture(x(), y(), "assets/puke.png"), this, Directions.LEFT);
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
                    if(moveRight) {
                        drunken.translate(speed, 0);
                    }
                    break;
                case LEFT:
                    if (moveLeft) {
                        drunken.translate(-speed, 0);
                    }
                    break;
                case UP:
                    if (moveUp) {
                        drunken.translate(0, -speed);
                    }
                    break;
                case DOWN:
                    if (moveDown) {
                        drunken.translate(0, speed);
                    }
                    break;
            }

        }
    }
}









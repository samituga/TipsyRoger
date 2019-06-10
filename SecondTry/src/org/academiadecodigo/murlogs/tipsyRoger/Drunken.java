package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Drunken extends Enemy {

    Picture drunken;

    Drunken(Picture drunken) {
        super(drunken);
        this.drunken = super.picture;
    }


    @Override
    public void move() {
        int speed = 3;
        if (!dead) {
            int randomMove = (int) (Math.random() * 4);
            switch (randomMove) {
                case 0:
                    drunken.translate(speed, 0);
                    break;
                case 1:
                    drunken.translate(-speed, 0);
                    break;
                case 2:
                    drunken.translate(0, -speed);
                    break;
                case 3:
                    drunken.translate(0, speed);
                    break;
                default:
                    System.out.println("shit happened");
            }
            try {
                Thread.sleep(8);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    @Override
    public Puke attack(Directions directions) {
        return super.attack(directions);
    }
}

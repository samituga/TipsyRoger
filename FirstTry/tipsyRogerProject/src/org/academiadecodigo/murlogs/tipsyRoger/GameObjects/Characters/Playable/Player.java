package org.academiadecodigo.murlogs.tipsyRoger.GameObjects.Characters;

public class Player extends Character {

    private int drunkenLvl;


    public void puke() {
        if (drunkenLvl < 0) {

        }

    }

    public void jump() {

    }

    @Override
    public void move() {

    }

    @Override
    public void attack() {

    }

    @Override
    public boolean isDead() {

        if (drunkenLvl <= 0) {
            this.setDead();

        }
    }

    @Override
    public void setDead() {
        super.setDead();
    }



}

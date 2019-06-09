package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Weapon extends Colidable {

    private Picture weapon;

    Weapon(Picture weapon){
        this.weapon = weapon;
    }


    @Override
    public void draw() {
        weapon.draw();
    }

    public void move(){
        weapon.translate(0, 3);
    }

    @Override
    public int x() {
        return weapon.getX();
    }

    @Override
    public int y() {
        return weapon.getY();
    }

    @Override
    public int xToWidth() {
        return x() + weapon.getWidth();
    }

    @Override
    public int yToHeight() {
        return y() + weapon.getHeight();
    }


}

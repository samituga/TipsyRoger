package org.academiadecodigo.murlogs.tipsyRoger.GameObjects;

import org.academiadecodigo.murlogs.tipsyRoger.Colidable;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Weapon extends Colidable {

    private Picture weapon;


    public Weapon(Picture weapon) {
        this.weapon = weapon;
    }

    public void move(){
        weapon.translate(0, 3);
    }

    @Override
    public void draw() {
        weapon.draw();
    }

    @Override
    public int y() {
        return weapon.getY();
    }

    @Override
    public int x() {
        return weapon.getX();
    }

    @Override
    public int yToHeight() {
        return y() + weapon.getHeight();
    }

    @Override
    public int xToWidth() {
        return x() + weapon.getWidth();
    }
}

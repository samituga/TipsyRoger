package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Weapon extends Colidable {

    private Picture weapon;
    private boolean destroyed;

    Weapon(Picture weapon){
        this.weapon = weapon;
    }


    @Override
    public void draw() {
        weapon.draw();
    }

    public boolean isDestroyed(){
        if(destroyed){
            weapon.delete();
            return true;
        }
        return false;
    }

    public boolean hit(Player player){
        if(this.checkCollision(player)){
            destroyed = true;
            return true;
        }
        return false;
    }

    public void move(){
        weapon.translate(0, 2);
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

    public void setDestroyed() {
        this.destroyed = true;
    }
}

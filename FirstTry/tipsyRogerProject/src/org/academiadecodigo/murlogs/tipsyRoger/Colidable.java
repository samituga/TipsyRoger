package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.murlogs.tipsyRoger.GameObjects.Bottles;

public abstract class Colidable {

    protected boolean colliding;

    // TODO: 2019-06-07 seperate method so the player can colide with the ground

    public boolean isColliding(Colidable colidable) {
        if (x() < colidable.xToWidth() &&
                xToWidth() > colidable.x() &&
                y() < colidable.yToHeight() &&
                yToHeight() > colidable.y()) {
            if (colidable instanceof Bottles || this instanceof Bottles){
                return true;
            }
            colliding = true;
            return colliding;
        }
        colliding = false;
        return colliding;
    }


    public abstract void draw();

    public abstract int y();

    public abstract int x();

    public abstract int yToHeight();

    public abstract int xToWidth();
}

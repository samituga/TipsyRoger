package org.academiadecodigo.murlogs.tipsyRoger;

public abstract class Colidable {

    protected boolean colliding;

    public abstract void draw();

    public abstract int y();

    public abstract int x();

    public abstract int yToHeight();

    public abstract int xToWidth();

    // TODO: 2019-06-07 seperate method so the player can colide with the ground


    public boolean isColliding(Colidable colidable) {
        if (x() < colidable.xToWidth() &&
                xToWidth() > colidable.x() &&
                y() < colidable.yToHeight() &&
                yToHeight() > colidable.y()) {
            colliding = true;
            return colliding;
        }
        colliding = false;
        return colliding;
    }

}

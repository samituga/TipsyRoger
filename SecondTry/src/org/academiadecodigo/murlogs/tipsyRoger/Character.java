package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Character extends Colidable {
    private boolean dead;

    public abstract void move();
    public abstract Puke attack();


}

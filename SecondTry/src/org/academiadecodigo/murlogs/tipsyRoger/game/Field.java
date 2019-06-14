package org.academiadecodigo.murlogs.tipsyRoger.game;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Field {
    private Picture map;

    public Field(Picture map) {
        this.map = map;
    }

    public void draw() {
        map.draw();
    }
}

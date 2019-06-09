package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Field {
    private Picture map;

    Field (Picture map) {
        this.map = map;
    }

    public void draw() {
        map.draw();
    }
}

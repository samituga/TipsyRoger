package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Game {

    Field field = new Field();

    public void createField() {
        field.rectangle(new Rectangle(10, 10, 1900, 1060));
        field.rectangle.draw();
    }

}

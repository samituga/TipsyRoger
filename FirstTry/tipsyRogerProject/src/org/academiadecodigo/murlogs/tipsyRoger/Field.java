package org.academiadecodigo.murlogs.tipsyRoger;


import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Field {

    Picture outerRectangle;

    Field(Picture picture) {
        outerRectangle = picture;
    }

    public void draw() {
        outerRectangle.draw();
    }

    public static int y() {
        return 10;
    }

    public static int x() {
        return 10;
    }

    public static int yToHeight() {
        return y() + 1200;
    }

    public static int xToWidth() {
        return x() + 720;
    }


}

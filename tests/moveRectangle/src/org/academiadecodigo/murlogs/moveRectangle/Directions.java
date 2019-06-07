package org.academiadecodigo.murlogs.moveRectangle;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public enum  Directions {
    RIGHT,
    LEFT;


    public void move(Rectangle rectangle, Directions directions){
        switch (directions){
            case RIGHT:
                rectangle.translate(0, 1);
                break;
            case LEFT:
                rectangle.translate(0, -1);
        }
    }


}

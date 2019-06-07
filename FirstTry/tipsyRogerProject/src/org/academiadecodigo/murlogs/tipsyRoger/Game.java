package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.murlogs.tipsyRoger.GameObjects.Characters.Playable.Player;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Game {

    private Player player;
    private Field field = new Field();
    private Map map = new Map();

    Game(Player player){
        this.player = player;
    }

    public void createField() {
        field.setOuterRectangle(new Rectangle(10, 10, 1700, 850));
        field.outerRectangle.draw();
    }

    public void init() {
        createField();
        map.drawRectangle();
        player.init();

        while (true){
            player.move();
        }
    }



}

package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.murlogs.tipsyRoger.GameObjects.Bottles;
import org.academiadecodigo.murlogs.tipsyRoger.GameObjects.Characters.Playable.Player;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Game {

    private Player player;
    private Bottles bottles;
    private Field field = new Field();
    private Map map = new Map();

    Game(Player player, Bottles bottles){
        this.player = player;
        this.bottles = bottles;
    }


    public void createField() {
        field.setOuterRectangle(new Rectangle(10, 10, 800, 400)); // 1700, 850
        field.outerRectangle.draw();
    }

    public void init() {

        createField();
        map.drawRectangle();
        player.init();
        bottles.init();

        while (true){
            player.move();
        }

    }



}

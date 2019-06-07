package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.murlogs.tipsyRoger.GameObjects.Characters.Playable.Player;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Game {

    private Player player;
    Field field = new Field();

    Game(Player player){
        this.player = player;
    }

    public void createField() {
        field.rectangle(new Rectangle(10, 10, 1900, 1060));
        field.rectangle.draw();
    }

    public void init() {
        createField();
        player.init();

        while (true){
            player.move();
        }
    }



}

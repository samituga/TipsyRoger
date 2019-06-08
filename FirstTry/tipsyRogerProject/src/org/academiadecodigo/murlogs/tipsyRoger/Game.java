package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.murlogs.tipsyRoger.GameObjects.BottleTypes;
import org.academiadecodigo.murlogs.tipsyRoger.GameObjects.Bottles;
import org.academiadecodigo.murlogs.tipsyRoger.GameObjects.Characters.Playable.Player;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.LinkedList;

public class Game {

    private Player player;
    private Bottles bottles;
    private Field field = new Field();
    private Map map = new Map();

    Game(Player player) {
        this.player = player;
    }

    LinkedList<Colidable> colidables = new LinkedList<>();


    public void createField() {
        field.setOuterRectangle(new Rectangle(10, 10, 800, 400)); // 1700, 850
        field.outerRectangle.draw();
    }

    public void init() {

        createField();
        map.drawRectangle();
        player.init();
        colidables.add(player);
        colidables.add(BottleTypes.bottlesFactory());

        while (true) {
            for (Colidable colidable : colidables){
                colidable.draw();
            }
            player.move();
        }

    }


}

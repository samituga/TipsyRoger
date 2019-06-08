package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.murlogs.tipsyRoger.GameObjects.BottleTypes;
import org.academiadecodigo.murlogs.tipsyRoger.GameObjects.Bottles;
import org.academiadecodigo.murlogs.tipsyRoger.GameObjects.Characters.Playable.Player;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;

public class Game {

    private Player player;

    Game(Player player) {
        this.player = player;
    }

    LinkedList<Colidable> colidables = new LinkedList<>();


    public void createMap() {
        colidables.add(new Map(new Rectangle(30, 200, 100, 20)));
        colidables.add(new Map(new Rectangle(40, 400, 100, 30)));
    }

    public void init() {
        createMap();
        Field field = new Field(new Picture(Field.x(), Field.y(), "tileMapDiagram1.png"));
        field.draw();

        player.init();
        colidables.add(player);
        colidables.add(BottleTypes.bottlesFactory());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (Colidable colidable : colidables) {
            colidable.draw();
        }
        while (true) {
            for (Colidable colidable : colidables) {
                if (!(colidable instanceof Player)) {
                    continue;
                }
                for (int i = 0; i < colidables.size(); i++) {
                    if (colidable.equals(colidables.get(i))) { // Comparing player with himself
                        continue;
                    }
                    if (colidables.get(i) instanceof Map) {
                        Map newMap = (Map) colidables.get(i);
                        if (!player.canMove(newMap)) {
                            continue;
                        }
                    }
                    if (!(colidables.get(i) instanceof Map)) {
                        player.move();
                    }
                    if (colidables.get(i) instanceof Bottles) {
                        Player player1 = (Player) colidable;
                        Bottles bottles1 = (Bottles) colidables.get(i);
                        player1.drinkBottle(bottles1.getVol(), bottles1);
                        continue;
                    }
                    if (colidable.isColliding(colidables.get(i))) {
                        break;
                    }
                }
            }
        }
    }
}

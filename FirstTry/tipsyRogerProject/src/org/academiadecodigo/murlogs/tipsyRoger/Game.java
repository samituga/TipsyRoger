package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.murlogs.tipsyRoger.GameObjects.BottleTypes;
import org.academiadecodigo.murlogs.tipsyRoger.GameObjects.Bottles;
import org.academiadecodigo.murlogs.tipsyRoger.GameObjects.Characters.Playable.Player;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;

public class Game {

    private Player player;
    private Bottles bottles;
    private Field field;
    private Map map;

    Game(Player player) {
        this.player = player;
    }

    LinkedList<Colidable> colidables = new LinkedList<>();


    public void init() {
        map = new Map(new Rectangle(10, 300, 800, 100));
        field = new Field(new Picture(Field.x(), Field.y(), "tileMapDiagram1.png"));
        field.draw();

        player.init();
        colidables.add(map);
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
            player.move();
            for (Colidable colidable : colidables) {
                for (int i = 0; i < colidables.size(); i++) {
                    if (colidables.get(i) instanceof Bottles && colidable instanceof Player) {
                        Player player1 = (Player) colidable;
                        Bottles bottles1 = (Bottles) colidables.get(i);
                        player1.drinkBottle(bottles1.getVol(), bottles1);
                        continue;
                    }
                    if (colidable instanceof Bottles || colidables.get(i) instanceof Bottles) {
                        continue;
                    }
                    if (colidable.equals(colidables.get(i))) {
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

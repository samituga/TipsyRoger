package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;

public class Game {

    private Player tipsy;

    Game(Player tipsy) {
        this.tipsy = tipsy;
    }

    LinkedList<Walls> wallsLinkedList = new LinkedList<>();
    LinkedList<Bottle> bottleLinkedList = new LinkedList<>();
    LinkedList<Puke> pukeLinkedList = new LinkedList<>();

    //LinkedList<Enemies> enemiesLinkedList = new LinkedList<Enemies>();


    public void init() {
        Field map = new Field(new Picture(0, 0, "LootHunter_Tileset.png"));
        map.draw();
        tipsy = new Player();
        wallsLinkedList.add(new Walls(new Rectangle(300, 300, 100, 100)));
        wallsLinkedList.add(new Walls(new Rectangle(32, 332, 193, 50)));
        wallsLinkedList.add(new Walls(new Rectangle(132, 632, 193, 50)));
        bottleLinkedList.add(BottleFactory.spawnBottle(200, 200));
    }

    public void start() {
        for (Walls walls : wallsLinkedList) {
            walls.draw();
        }

        for (Bottle bottle : bottleLinkedList) {
            bottle.draw();
        }
        tipsy.init();

        while (true) {
            if (tipsy.isAttacking()) {
                pukeLinkedList.add(tipsy.attack());
            }
            for (Puke puke : pukeLinkedList) {
                if (!puke.isDestroyed()){
                    puke.draw();
                    puke.move();
                }

            }
            for (Walls walls : wallsLinkedList) {
                tipsy.predictMovements(walls);
            }
            tipsy.move();
            System.out.println("X: " + tipsy.x() + "Y: " + tipsy.y());
            for (Bottle bottle : bottleLinkedList) {
                tipsy.drinkBottle(bottle.getVol(), bottle);
            }
            try {
                Thread.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

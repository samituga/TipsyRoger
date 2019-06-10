package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;


public class Game {

    private Player roger;

    private LinkedList<Walls> wallsLinkedList = new LinkedList<>();
    private LinkedList<Bottle> bottleLinkedList = new LinkedList<>();
    private LinkedList<Puke> pukeLinkedList = new LinkedList<>();
    private LinkedList<Enemy> enemiesLinkedList = new LinkedList<>();
    private LinkedList<NPC> npcLinkedList = new LinkedList<>();
    private LinkedList<NPCQuiz> npcQuizLinkedList = new LinkedList<>();


    public void init() {

        Field map = new Field(new Picture(0, 0, "LootHunter_Tileset.png"));
        map.draw();
        roger = new Player(new Picture(30, 30, "Roger_Smith.png"));
        wallsLinkedList.add(new Walls(new Rectangle(300, 300, 100, 100)));
        wallsLinkedList.add(new Walls(new Rectangle(32, 332, 193, 50)));
        wallsLinkedList.add(new Walls(new Rectangle(132, 632, 193, 50)));
        bottleLinkedList.add(BottleFactory.spawnBottle(200, 200));
        bottleLinkedList.add(BottleFactory.spawnBottle(230, 240));
        //enemiesLinkedList.add(new Drunken(new Picture(350, 305, "Roger_Smith.png")));
        //npcLinkedList.add(new NPC(new Picture(300, 150, "Roger_Smith.png")));
    }

    public void start() {

        for (Enemy enemies : enemiesLinkedList) {
            enemies.draw();
        }

        for (Walls walls : wallsLinkedList) {
            walls.draw();
        }

        for (Bottle bottle : bottleLinkedList) {
            bottle.draw();
        }
        for (NPC npc : npcLinkedList) {
            npc.draw();
        }

        roger.init();

        while (true) {
            for (Walls walls : wallsLinkedList) {
                roger.predictMovements(walls);
            }
            roger.move();

            for (Bottle bottle : bottleLinkedList) {
                roger.drinkBottle(bottle.getVol(), bottle); // TODO: 2019-06-09 Eliminar da linked list
            }

            for (NPC npc : npcLinkedList) {
                if (roger.checkCollision(npc)) {
                    npc.delete();
                    npcLinkedList.remove(npc);
                    npcQuizLinkedList.add(npc.speak());
                    for (NPCQuiz npcQuiz : npcQuizLinkedList){
                        npcQuiz.quizTextGenerator();
                        npcQuiz.draw();
                    }
                }
            }
            for (Enemy enemy : enemiesLinkedList) {

                // TODO: 10/06/2019  check enemy move
                if (roger.checkCollision(enemy)) {
                    roger.touchEnemy();
                }
                enemy.move();
            }

            //System.out.println("X: " + roger.x() + " Y: " + roger.y());
            if (roger.isAttacking()) {
                pukeLinkedList.add(roger.attack(roger.getLastDirection()));
            }
            for (Puke puke : pukeLinkedList) {
                if (!puke.isDestroyed()) {
                    puke.draw();
                    puke.move(roger.getLastDirection());
                    for (Enemy enemy : enemiesLinkedList) {
                        if (puke.hit(enemy)) {
                            enemy.hitten();
                            enemiesLinkedList.remove(enemy);
                            break;
                        }
                    }
                    continue;
                }
                pukeLinkedList.remove(puke);
            }
            try {
                Thread.sleep(9);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

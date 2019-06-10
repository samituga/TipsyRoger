package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;


public class Game {

    private Player roger;


    private LinkedList<Walls> wallsLinkedList = new LinkedList<>();
    private LinkedList<Bottle> bottleLinkedList = new LinkedList<>();
    private LinkedList<Puke> playerPukeLinkedList = new LinkedList<>();
    private LinkedList<Puke> enemiesPukeLinkedList = new LinkedList<>();
    private LinkedList<Enemy> enemiesLinkedList = new LinkedList<>();
    private LinkedList<NPC> npcLinkedList = new LinkedList<>();
    private LinkedList<NPCQuiz> npcQuizLinkedList = new LinkedList<>();
    /*Game(Player roger) {
        this.roger = roger;
    }*/

    public void init() {

        Field map = new Field(new Picture(0, 0, "LootHunter_Tileset.png"));
        map.draw();
        roger = new Player(new Picture(30, 30, "Roger_Smith.png"));
        wallsLinkedList.add(new Walls(new Rectangle(300, 300, 100, 100)));
        wallsLinkedList.add(new Walls(new Rectangle(32, 332, 193, 50)));
        wallsLinkedList.add(new Walls(new Rectangle(132, 632, 193, 50)));
        bottleLinkedList.add(BottleFactory.spawnBottle(200, 200));
        bottleLinkedList.add(BottleFactory.spawnBottle(230, 240));
        enemiesLinkedList.add(new Barman(new Picture(350, 305, "Roger_Smith.png")));
        enemiesLinkedList.add(new Barman(new Picture(400, 400, "Roger_Smith.png")));
        enemiesLinkedList.add(new Barman(new Picture(450, 400, "Roger_Smith.png")));
        enemiesLinkedList.add(new Barman(new Picture(500, 400, "Roger_Smith.png")));
        enemiesLinkedList.add(new Barman(new Picture(550, 400, "Roger_Smith.png")));
        enemiesLinkedList.add(new Drunken(new Picture(600, 500, "enemytester.png")));
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
            for (Enemy enemy : enemiesLinkedList) {

                // TODO: 10/06/2019  check enemy move
                if (roger.checkCollision(enemy)) {
                    roger.touchEnemy();
                }
                enemy.move();
                if (enemy.canAttack()) {
                    enemiesPukeLinkedList.add(enemy.attack(Directions.LEFT));
                }
            }

            //System.out.println("X: " + roger.x() + " Y: " + roger.y());
            if (roger.isAttacking()) {
                playerPukeLinkedList.add(roger.attack(roger.getLastDirection()));
            }
            for (Puke puke : playerPukeLinkedList) {
                if (puke.getOwner() == roger) {
                    if (!puke.isDestroyed()) {
                        puke.draw();
                        puke.move();
                        for (Enemy enemy : enemiesLinkedList) {
                            if (puke.hit(enemy)) {
                                enemy.hitten();
                                puke.isDestroyed();
                                enemiesLinkedList.remove(enemy);
                                playerPukeLinkedList.remove(puke); // TODO: 2019-06-10 Check if necessary
                                break;
                            }
                        }
                        continue;
                    }
                    playerPukeLinkedList.remove(puke);
                }
            }
            for (int i = enemiesPukeLinkedList.size() - 1; i >= 0 ; i--) {
                if (!enemiesPukeLinkedList.get(i).isDestroyed()) {
                    enemiesPukeLinkedList.get(i).move();
                    enemiesPukeLinkedList.get(i).draw();
                    if (enemiesPukeLinkedList.get(i).hit(roger)) {
                        roger.hitten();
                        enemiesPukeLinkedList.remove(i);
                        System.out.println("Roger Dead");
                        break;
                    }
                    if (enemiesPukeLinkedList.get(i).getIterator() > 100) {
                        enemiesPukeLinkedList.get(i).isDestroyed();
                        enemiesPukeLinkedList.remove(i);
                    }
                    continue;
                }
                //enemiesPukeLinkedList.remove(i);
            }
            try {
                Thread.sleep(9);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


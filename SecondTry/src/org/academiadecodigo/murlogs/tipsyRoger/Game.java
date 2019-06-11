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

        Menu menu = new Menu();

        menu.start();

        Field map = new Field(new Picture(0, 0, "roger02.jpg"));
        map.draw();
        createWalls();
        roger = new Player(new Picture(100, 120, "Roger_Smith.png"));


        bottleLinkedList.add(BottleFactory.spawnBottle(200, 200));
        bottleLinkedList.add(BottleFactory.spawnBottle(230, 240));
        bottleLinkedList.add(BottleFactory.spawnBottle(300, 300));
        enemiesLinkedList.add(new Barman(new Picture(1100, 305, "Roger_Smith.png")));
        enemiesLinkedList.add(new Barman(new Picture(1125, 250, "Roger_Smith.png")));
        enemiesLinkedList.add(new Barman(new Picture(1075, 300, "Roger_Smith.png")));
        //enemiesLinkedList.add(new Barman(new Picture(200, 100, "Roger_Smith.png")));
        //enemiesLinkedList.add(new Barman(new Picture(300, 200, "Roger_Smith.png")));
        enemiesLinkedList.add(new Drunken(new Picture(600, 575, "enemytester.png")));
        //enemiesLinkedList.add(new Drunken(new Picture(600, 200, "enemytester.png")));
        npcLinkedList.add(new NPC(new Picture(100, 200, "npctesting.png")));
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

            for (NPC npc : npcLinkedList) {
                roger.predictMovementsNPC(npc);
            }
            if (roger.isReachable() && !roger.isTakenQuiz()) {
                npcQuizLinkedList.add(roger.getQuiz());
            }

            for (NPCQuiz quiz : npcQuizLinkedList) {
                quiz.draw();
            }

            for (Bottle bottle : bottleLinkedList) {
                roger.drinkBottle(bottle.getVol(), bottle); // TODO: 2019-06-09 Eliminar da linked list
            }
            for (Enemy enemy : enemiesLinkedList) {

                // TODO: 10/06/2019  check enemy move
                if (roger.checkCollision(enemy)) {
                    roger.touchEnemy();
                }
                for (Walls walls : wallsLinkedList) {
                    enemy.predictMovements(walls);
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

            for (int i = enemiesPukeLinkedList.size() - 1; i >= 0; i--) {
                if (!enemiesPukeLinkedList.get(i).isDestroyed()) {
                    enemiesPukeLinkedList.get(i).move();
                    enemiesPukeLinkedList.get(i).draw();
                    if (enemiesPukeLinkedList.get(i).hit(roger)) {
                        roger.hitten();
                        enemiesPukeLinkedList.remove(i);
                        System.out.println("Roger Dead");
                        break;
                    }
                    if (enemiesPukeLinkedList.get(i).getIterator() > 200) {
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


    public void createWalls() {

        wallsLinkedList.add(new Walls(new Rectangle(240, 200, 108, 68)));
        wallsLinkedList.add(new Walls(new Rectangle(277, 158, 60, 60)));
        wallsLinkedList.add(new Walls(new Rectangle(178, 225, 60, 60)));
        wallsLinkedList.add(new Walls(new Rectangle(272, 288, 60, 60)));
        wallsLinkedList.add(new Walls(new Rectangle(356, 217, 60, 60)));
        wallsLinkedList.add(new Walls(new Rectangle(732, 204, 119, 68)));
        wallsLinkedList.add(new Walls(new Rectangle(682, 225, 55, 60)));
        wallsLinkedList.add(new Walls(new Rectangle(771, 155, 60, 60)));
        wallsLinkedList.add(new Walls(new Rectangle(857, 218, 60, 60)));
        wallsLinkedList.add(new Walls(new Rectangle(767, 283, 60, 60)));
        wallsLinkedList.add(new Walls(new Rectangle(489, 443, 110, 70)));
        wallsLinkedList.add(new Walls(new Rectangle(432, 465, 60, 60)));
        wallsLinkedList.add(new Walls(new Rectangle(520, 400, 60, 60)));
        wallsLinkedList.add(new Walls(new Rectangle(520, 520, 60, 60)));
        wallsLinkedList.add(new Walls(new Rectangle(600, 453, 60, 60)));
        wallsLinkedList.add(new Walls(new Rectangle(1010, 163, 50, 380)));
        wallsLinkedList.add(new Walls(new Rectangle(1010, 163, 170, 75)));
        wallsLinkedList.add(new Walls(new Rectangle(1020, 443, 160, 100)));
        wallsLinkedList.add(new Walls(new Rectangle(54, 1, 1145, 60)));
        wallsLinkedList.add(new Walls(new Rectangle(0, 0, 50, 480)));
        wallsLinkedList.add(new Walls(new Rectangle(0, 220, 40, 200)));
        wallsLinkedList.add(new Walls(new Rectangle(0, 420, 20, 50)));
        wallsLinkedList.add(new Walls(new Rectangle(0, 470, 15, 70)));
        wallsLinkedList.add(new Walls(new Rectangle(0, 540, 10, 60)));
        wallsLinkedList.add(new Walls(new Rectangle(0, 600, 7, 75)));
        wallsLinkedList.add(new Walls(new Rectangle(1140, 100, 59, 140)));
        wallsLinkedList.add(new Walls(new Rectangle(1160, 240, 39, 140)));
        wallsLinkedList.add(new Walls(new Rectangle(1170, 380, 29, 140)));
        wallsLinkedList.add(new Walls(new Rectangle(1175, 520, 24, 155)));
        wallsLinkedList.add(new Walls(new Rectangle(0, 675, 1200, 0)));
    }

}


package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;


public class Game {


    private Menu menu = new Menu();
    private LinkedList<Player> playersLinkedList;
    private LinkedList<Walls> wallsLinkedList;
    private LinkedList<Bottle> bottleLinkedList;
    private LinkedList<Puke> playerPukeLinkedList;
    private LinkedList<Puke> enemiesPukeLinkedList;
    private LinkedList<Enemy> enemiesLinkedList;

    public void init() {
        playersLinkedList = new LinkedList<>();
        wallsLinkedList = new LinkedList<>();
        bottleLinkedList = new LinkedList<>();
        playerPukeLinkedList = new LinkedList<>();
        enemiesPukeLinkedList = new LinkedList<>();
        enemiesLinkedList = new LinkedList<>();


        menu.start();


        Field map = new Field(new Picture(0, 0, "newBar.jpg"));
        map.draw();
        createWalls();

        //playersLinkedList.add(new PlayerA(new Picture(140, 500, "RogerSmith.png")));
        //playersLinkedList.add(new PlayerB(new Picture(140, 80, "deadpool.png")));
        bottleLinkedList.add(BottleFactory.spawnBottle(200, 200));
        bottleLinkedList.add(BottleFactory.spawnBottle(230, 240));
        bottleLinkedList.add(BottleFactory.spawnBottle(300, 300));
        enemiesLinkedList.add(new Barman(new Picture(1100, 60, "barman.png")));
        enemiesLinkedList.add(new Barman(new Picture(1101, 185, "barman.png")));
        enemiesLinkedList.add(new Barman(new Picture(1102, 335, "barman.png")));
        enemiesLinkedList.add(new Barman(new Picture(1103, 485, "barman.png")));
        enemiesLinkedList.add(new Drunken(new Picture(600, 575, "drunken.png")));
        enemiesLinkedList.add(new Drunken(new Picture(600, 300, "drunken.png")));
    }

    public void winnerCaller(String path) {
        menu.winnerScreen(path);
        if (menu.getPressEnter()) {
            init();
            start();

        }
    }

    private void clearLists() {
        playersLinkedList.clear();
        playerPukeLinkedList.clear();
        wallsLinkedList.clear();
        bottleLinkedList.clear();
        enemiesLinkedList.clear();
        enemiesPukeLinkedList.clear();
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

        for (Player player : playersLinkedList) {
            player.draw();
            player.setKeyboard();
        }

        while (true) {
            for (Walls walls : wallsLinkedList) {
                for (Player player : playersLinkedList) {
                    player.predictMovements(walls);
                }
            }
            for (Player player : playersLinkedList) {
                player.move();
            }
            for (Bottle bottle : bottleLinkedList) {
                for (Player player : playersLinkedList) {
                    player.drinkBottle(bottle.getVol(), bottle);
                }
            }
            for (Enemy enemy : enemiesLinkedList) {

                for (Player player : playersLinkedList) {
                    if (player.checkCollision(enemy)) {
                        player.touchEnemy();
                        clearLists();
                        if (player instanceof PlayerA) {
                            winnerCaller("deadpool.png");
                        }
                    }
                }
                for (Walls walls : wallsLinkedList) {
                    enemy.predictMovements(walls);
                }
                enemy.move();
                if (enemy.canAttack()) {
                    enemiesPukeLinkedList.add(enemy.attack(Directions.LEFT));
                }
            }

            for (Player player : playersLinkedList) {
                //System.out.println("X " + player.x() + "  Y " + player.y());
                if (player.isAttacking()) {
                    playerPukeLinkedList.add(player.attack(player.getLastDirection()));
                }
            }

            for (Puke puke : playerPukeLinkedList) {

                if (puke.isDestroyed()) {
                    playerPukeLinkedList.remove(puke);
                    continue;
                }
                puke.draw();
                puke.move();
                for (Enemy enemy : enemiesLinkedList) {
                    if (puke.hit(enemy)) {
                        enemy.hitten();
                        puke.isDestroyed();
                        enemiesLinkedList.remove(enemy);
                        playerPukeLinkedList.remove(puke);
                        break;
                    }
                }
            }
            try {
                for (int i = enemiesPukeLinkedList.size() - 1; i >= 0; i--) {
                    if (enemiesPukeLinkedList.get(i).isDestroyed()) {
                        enemiesPukeLinkedList.remove(i);
                    }
                    if (!enemiesPukeLinkedList.get(i).isDestroyed()) {
                        enemiesPukeLinkedList.get(i).move();
                        enemiesPukeLinkedList.get(i).draw();
                        for (Player player : playersLinkedList) {

                            if (enemiesPukeLinkedList.get(i).hit(player)) {
                                player.hitten();
                                enemiesPukeLinkedList.remove(i);
                                clearLists();
                                if (player instanceof PlayerA) {
                                    winnerCaller("deadpoolWinner.png");
                                }
                                winnerCaller("RogerSmithWin.png");

                            }


                            if (enemiesPukeLinkedList.get(i).isDestroyed()) {
                                enemiesPukeLinkedList.remove(i);
                            }
                        }
                    }

                }
            } catch (IndexOutOfBoundsException e) {
                System.err.println(e.getMessage());
            }

            try {
                Thread.sleep(9);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void createWalls() {
        wallsLinkedList.add(new Walls(new Rectangle(203, 142, 37, 20)));
        wallsLinkedList.add(new Walls(new Rectangle(115, 202, 37, 20)));
        wallsLinkedList.add(new Walls(new Rectangle(203, 245, 37, 20)));
        wallsLinkedList.add(new Walls(new Rectangle(293, 202, 37, 20)));
        wallsLinkedList.add(new Walls(new Rectangle(163, 159, 120, 70)));
        wallsLinkedList.add(new Walls(new Rectangle(423, 507, 37, 20)));
        wallsLinkedList.add(new Walls(new Rectangle(510, 446, 37, 20)));
        wallsLinkedList.add(new Walls(new Rectangle(510, 561, 37, 20)));
        wallsLinkedList.add(new Walls(new Rectangle(599, 507, 37, 20)));
        wallsLinkedList.add(new Walls(new Rectangle(467, 470, 120, 70)));
        wallsLinkedList.add(new Walls(new Rectangle(728, 202, 37, 20)));
        wallsLinkedList.add(new Walls(new Rectangle(902, 202, 37, 20)));
        wallsLinkedList.add(new Walls(new Rectangle(812, 142, 37, 20)));
        wallsLinkedList.add(new Walls(new Rectangle(812, 142, 37, 20)));
        wallsLinkedList.add(new Walls(new Rectangle(812, 253, 37, 20)));
        wallsLinkedList.add(new Walls(new Rectangle(771, 164, 120, 70)));
        wallsLinkedList.add(new Walls(new Rectangle(177, 419, 37, 10)));
        wallsLinkedList.add(new Walls(new Rectangle(109, 473, 37, 25)));
        wallsLinkedList.add(new Walls(new Rectangle(252, 473, 37, 25)));
        wallsLinkedList.add(new Walls(new Rectangle(177, 521, 37, 25)));
        wallsLinkedList.add(new Walls(new Rectangle(151, 430, 85, 50)));
        wallsLinkedList.add(new Walls(new Rectangle(442, 191, 37, 25)));
        wallsLinkedList.add(new Walls(new Rectangle(588, 191, 37, 25)));
        wallsLinkedList.add(new Walls(new Rectangle(511, 136, 37, 10)));
        wallsLinkedList.add(new Walls(new Rectangle(511, 240, 37, 25)));
        wallsLinkedList.add(new Walls(new Rectangle(486, 146, 85, 50)));
        wallsLinkedList.add(new Walls(new Rectangle(810, 420, 37, 10)));
        wallsLinkedList.add(new Walls(new Rectangle(741, 473, 37, 25)));
        wallsLinkedList.add(new Walls(new Rectangle(885, 473, 37, 25)));
        wallsLinkedList.add(new Walls(new Rectangle(809, 523, 37, 25)));
        wallsLinkedList.add(new Walls(new Rectangle(787, 432, 85, 50)));
        wallsLinkedList.add(new Walls(new Rectangle(60, 0, 1080, 65)));
        wallsLinkedList.add(new Walls(new Rectangle(0, 0, 60, 100)));
        wallsLinkedList.add(new Walls(new Rectangle(0, 100, 50, 100)));
        wallsLinkedList.add(new Walls(new Rectangle(0, 200, 40, 100)));
        wallsLinkedList.add(new Walls(new Rectangle(0, 300, 30, 100)));
        wallsLinkedList.add(new Walls(new Rectangle(0, 400, 20, 100)));
        wallsLinkedList.add(new Walls(new Rectangle(0, 500, 10, 100)));
        wallsLinkedList.add(new Walls(new Rectangle(0, 600, 5, 75)));
        wallsLinkedList.add(new Walls(new Rectangle(0, 675, 1200, 0)));
        wallsLinkedList.add(new Walls(new Rectangle(1140, 0, 60, 100)));
        wallsLinkedList.add(new Walls(new Rectangle(1150, 100, 50, 100)));
        wallsLinkedList.add(new Walls(new Rectangle(1160, 200, 40, 100)));
        wallsLinkedList.add(new Walls(new Rectangle(1170, 300, 30, 100)));
        wallsLinkedList.add(new Walls(new Rectangle(1180, 400, 20, 100)));
        wallsLinkedList.add(new Walls(new Rectangle(1190, 500, 10, 100)));
        wallsLinkedList.add(new Walls(new Rectangle(1195, 600, 5, 75)));
        wallsLinkedList.add(new Walls(new Rectangle(1000, 65, 55, 100)));
        wallsLinkedList.add(new Walls(new Rectangle(1010, 165, 55, 100)));
        wallsLinkedList.add(new Walls(new Rectangle(1020, 265, 55, 100)));
        wallsLinkedList.add(new Walls(new Rectangle(1030, 365, 55, 100)));
        wallsLinkedList.add(new Walls(new Rectangle(1040, 465, 55, 100)));
        wallsLinkedList.add(new Walls(new Rectangle(1050, 565, 55, 110)));


    }
}
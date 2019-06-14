package org.academiadecodigo.murlogs.tipsyRoger.game;

import org.academiadecodigo.murlogs.tipsyRoger.characters.Player.Player;
import org.academiadecodigo.murlogs.tipsyRoger.characters.Player.PlayerA;
import org.academiadecodigo.murlogs.tipsyRoger.characters.Player.PlayerB;
import org.academiadecodigo.murlogs.tipsyRoger.characters.enemies.Barman;
import org.academiadecodigo.murlogs.tipsyRoger.characters.enemies.Drunken;
import org.academiadecodigo.murlogs.tipsyRoger.characters.enemies.Enemy;
import org.academiadecodigo.murlogs.tipsyRoger.gameObjects.Bottle;
import org.academiadecodigo.murlogs.tipsyRoger.gameObjects.BottleFactory;
import org.academiadecodigo.murlogs.tipsyRoger.gameObjects.Puke;
import org.academiadecodigo.murlogs.tipsyRoger.gameObjects.Walls;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;


public class Game {

    private Sound gameSong = new Sound("/assets/music/gameSong.wav");
    private Sound deadpoolSong = new Sound("/assets/music/deadpoolWins.wav");
    private Sound rogerSong = new Sound("/assets/music/rogerWins.wav");
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
        menu.getMenuSong().stop();
        gameSong.play(true);

        Field map = new Field(new Picture(0, 0, "assets/newBar.jpg"));
        map.draw();
        createWalls();

        playersLinkedList.add(new PlayerA(new Picture(65, 600, "assets/RogerSmith.png"), new Picture(65, 600, "assets/RogerSmithReverted.png")));
        playersLinkedList.add(new PlayerB(new Picture(95, 80, "assets/deadpool.png"), new Picture(95,80, "assets/deadpoolReverted.png")));
        enemiesLinkedList.add(new Barman(new Picture(1100, 60, "assets/barman.png")));
        enemiesLinkedList.add(new Barman(new Picture(1101, 185, "assets/barman.png")));
        enemiesLinkedList.add(new Barman(new Picture(1102, 335, "assets/barman.png")));
        enemiesLinkedList.add(new Barman(new Picture(1103, 485, "assets/barman.png")));
        enemiesLinkedList.add(new Drunken(new Picture(900, 70, "assets/drunken.png")));
        enemiesLinkedList.add(new Drunken(new Picture(900, 575, "assets/drunken.png")));
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
        deadpoolSong.stop();
        rogerSong.stop();


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
            player.addDrunkenLvlBar();
            player.setKeyboard();
        }
        int iterator = 0;
        try {


            while (true) {
                iterator++;
                if (iterator >= 320) {
                    iterator = 0;
                    int randomX = (int) (Math.random() * 500 + 300);
                    int randomY = (int) (Math.random() * 100 + 300);
                    bottleLinkedList.add(BottleFactory.spawnBottle(randomX, randomY));
                    bottleLinkedList.getLast().draw();
                }

                for (Walls walls : wallsLinkedList) {
                    for (Player player : playersLinkedList) {
                        player.predictMovements(walls);
                    }
                }
                for (Player player : playersLinkedList) {
                    if (player.isDead() && player instanceof PlayerA) {
                        playersLinkedList.getLast().setInGame();
                        playersLinkedList.getFirst().setInGame();
                        gameSong.stop();
                        deadpoolSong.loopIndef();
                        clearLists();
                        winnerCaller("assets/deadpoolWinner.png");
                    }
                    if (player.isDead() && player instanceof PlayerB) {
                        playersLinkedList.getFirst().setInGame();
                        playersLinkedList.getLast().setInGame();
                        gameSong.stop();
                        rogerSong.loopIndef();
                        clearLists();
                        winnerCaller("assets/RogerSmithWin.png");
                    }
                    player.move();
                    player.showDrunkenLvl();
                    player.looseDrunkenLvl();


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
                                }


                                if (enemiesPukeLinkedList.get(i).isDestroyed()) {
                                    enemiesPukeLinkedList.remove(i);
                                }
                            }
                        }

                    }
                } catch (IndexOutOfBoundsException e) {
                }

                try {
                    Thread.sleep(9);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }catch (NullPointerException e){
            for (int i = 0; i < 20 ; i++) {
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
package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.LinkedList;

public class Game {

    private Player tipsy;

    Game(Player tipsy) {
        this.tipsy = tipsy;
    }

    LinkedList<Walls> wallsLinkedList = new LinkedList<Walls>();
    LinkedList<Bottle> bottleLinkedList = new LinkedList<Bottle>();
    //LinkedList<Enemies> enemiesLinkedList = new LinkedList<Enemies>();


    public void init() {
        tipsy = new Player();
        wallsLinkedList.add(new Walls(new Rectangle(300, 300, 100, 100)));
        bottleLinkedList.add(BottleFactory.spawnBottle(200, 200));
    }

    public void start() {
        for (Walls walls : wallsLinkedList){
            walls.draw();
        }

        for (Bottle bottle: bottleLinkedList){
            bottle.draw();
        }
        tipsy.init();

        while (true){
            tipsy.move();
            for (Walls walls : wallsLinkedList){
                tipsy.predictBotCollision(walls);
                tipsy.predictRightColision(walls);
                tipsy.predictTopCollision(walls);
                tipsy.predictLeftColision(walls);
            }
            for (Bottle bottle : bottleLinkedList){
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

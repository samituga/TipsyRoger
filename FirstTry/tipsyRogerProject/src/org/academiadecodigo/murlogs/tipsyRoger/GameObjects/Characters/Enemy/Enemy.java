package org.academiadecodigo.murlogs.tipsyRoger.GameObjects.Characters.Enemy;

import jdk.jfr.consumer.RecordedClass;
import org.academiadecodigo.murlogs.tipsyRoger.Colidable;
import org.academiadecodigo.murlogs.tipsyRoger.GameObjects.Characters.Character;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class Enemy extends Character {

    EnemyTypes enemyTypes;
    Picture enemyPicture;
    private int speed;


    public void deleteEnemy() {
        enemyPicture.delete();
        setDead();
    }

    @Override
    public void move() {
        speed = 1;
        int randomMove = (int) (Math.random() * (2 - 1) + 1);
        while (true) {

            enemyPicture.translate(randomMove, randomMove);
            try {
                Thread.sleep(8);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }


    @Override
    public void attack() {
    }

    @Override
    public void setDead() {
        super.setDead();
    }

    @Override
    public boolean isDead() {
        return super.isDead();
    }

    @Override
    public void draw() {
    }

    @Override
    public int y() {
        return enemyPicture.getY();
    }

    @Override
    public int x() {
        return enemyPicture.getX();
    }

    @Override
    public int yToHeight() {
        return enemyPicture.getY() + enemyPicture.getHeight();
    }

    @Override
    public int xToWidth() {
        return enemyPicture.getX() + enemyPicture.getWidth();
    }
}

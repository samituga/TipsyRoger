package org.academiadecodigo.murlogs.tipsyRoger.GameObjects.Characters.Enemy;

import org.academiadecodigo.murlogs.tipsyRoger.Colidable;
import org.academiadecodigo.murlogs.tipsyRoger.GameObjects.Characters.Character;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Enemy extends Character {

    private Rectangle enemyRectangle;
    EnemyTypes enemyTypes;
    Picture enemyPicture;


    public void deleteEnemy(){
        enemyPicture.delete();
        setDead();
    }

    @Override
    public void move() {

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

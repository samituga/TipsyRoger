package org.academiadecodigo.murlogs.tipsyRoger.characters.enemies;

import org.academiadecodigo.murlogs.tipsyRoger.characters.Character;
import org.academiadecodigo.murlogs.tipsyRoger.game.Directions;
import org.academiadecodigo.murlogs.tipsyRoger.gameObjects.Puke;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Enemy extends Character {

    private Picture enemy;

    public Enemy(Picture enemy) {
        super(enemy);
        this.enemy = super.picture;
    }

    public void hitten() {
        enemy.delete();
        this.dead = true;
    }


    public boolean canAttack() {
        double randomNumber = Math.random();
        if (randomNumber < 0.005){
            return true;
        }
        return false;
    }

    public abstract Puke attack(Directions directions);
}


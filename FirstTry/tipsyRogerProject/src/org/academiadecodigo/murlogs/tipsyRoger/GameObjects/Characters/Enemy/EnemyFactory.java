package org.academiadecodigo.murlogs.tipsyRoger.GameObjects.Characters.Enemy;

public class EnemyFactory {


    public static Enemy enemy() {
        EnemyTypes[] enemies = EnemyTypes.values();

        int randomNumber = (int) (Math.random() * enemies.length);


        switch (enemies[randomNumber]) {
            case BARMAN:
                return new Barman();
            case DRUNKEN:
                return new Drunken();
            default:
                return new Drunken();
        }
    }
}

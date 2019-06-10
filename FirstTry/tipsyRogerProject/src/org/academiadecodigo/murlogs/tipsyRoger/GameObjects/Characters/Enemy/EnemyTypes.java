package org.academiadecodigo.murlogs.tipsyRoger.GameObjects.Characters.Enemy;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public enum EnemyTypes {
    DRUNKEN,
    BARMAN,
    CHINELO_MAMA;


    public static Enemy enemyFactory(int x, int y) {

        int randomNumber = (int) (Math.random() * EnemyTypes.values().length);
        EnemyTypes enemyTypes = EnemyTypes.values()[randomNumber];


        switch (enemyTypes) {
            case BARMAN:
                return new Barman(new Picture(x, y, "enemytester.png"));
            case DRUNKEN:
                return new Drunken(new Picture(x, y, "enemytester.png"));
            default:
                return new Drunken(new Picture(x, y, "enemytester.png"));
        }
    }


}

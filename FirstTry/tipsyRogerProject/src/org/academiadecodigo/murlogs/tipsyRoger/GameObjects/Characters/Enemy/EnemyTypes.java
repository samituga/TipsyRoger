package org.academiadecodigo.murlogs.tipsyRoger.GameObjects.Characters.Enemy;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public enum EnemyTypes {
    DRUNKEN,
    BARMAN,
    CHINELO_MAMA;

    Rectangle rectangle;


    public static Enemy enemyFactory() {
        int width = 20;
        int height = 50;

        int randomNumber = (int) (Math.random() * EnemyTypes.values().length);
        EnemyTypes enemyTypes = EnemyTypes.values()[randomNumber];


        switch (enemyTypes) {
            case BARMAN:
                return new Barman(new Rectangle(200, 200, width, height));
            case DRUNKEN:
                return new Drunken(new Rectangle(300, 300, width, height));
            default:
                return new Drunken(new Rectangle(300, 300, width, height));
        }
    }


}

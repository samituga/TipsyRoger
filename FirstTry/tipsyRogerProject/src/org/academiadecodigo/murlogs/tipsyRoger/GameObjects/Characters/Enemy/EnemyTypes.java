package org.academiadecodigo.murlogs.tipsyRoger.GameObjects.Characters.Enemy;

public enum EnemyTypes {
    DRUNKEN("Drunken"),
    BARMAN("Barman"),
    CHINELO_MAMA("Chinelo Mama");

    private String name;


    EnemyTypes(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }
}

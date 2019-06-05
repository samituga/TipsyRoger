package org.academiadecodigo.murlogs.tipsyRoger.GameObjects;

public enum  BottleTypes {
    BEER(10),
    WATER(-10),
    VODKA(20);

    private int vol;

    BottleTypes(int vol){
        this.vol = vol;
    }


}

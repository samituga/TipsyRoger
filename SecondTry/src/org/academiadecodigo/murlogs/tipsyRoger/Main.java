package org.academiadecodigo.murlogs.tipsyRoger;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(new Player());

        game.init();
        game.start();
    }
}

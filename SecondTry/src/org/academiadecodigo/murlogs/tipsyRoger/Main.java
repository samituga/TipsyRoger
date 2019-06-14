package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.murlogs.tipsyRoger.game.Game;

public class Main {

    public static void main(String[] args) {
        try {


            Game game = new Game();


            game.init();
            game.start();
        } catch (NullPointerException e) {

        }
    }
}

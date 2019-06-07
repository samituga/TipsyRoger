package org.academiadecodigo.murlogs.tipsyRoger;


import org.academiadecodigo.murlogs.tipsyRoger.GameObjects.Characters.Playable.Player;

public class Main {
    public static void main(String[] args) {

        Game game = new Game(new Player(50));

        game.init();
    }
}

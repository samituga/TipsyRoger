package org.academiadecodigo.murlogs.tipsyRoger;


import org.academiadecodigo.murlogs.tipsyRoger.GameObjects.BottleTypes;
import org.academiadecodigo.murlogs.tipsyRoger.GameObjects.Bottles;
import org.academiadecodigo.murlogs.tipsyRoger.GameObjects.Characters.Playable.Player;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Main {
    public static void main(String[] args) {


        Game game = new Game(new Player(50));

        game.init();

    }
}

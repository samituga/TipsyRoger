package org.academiadecodigo.murlogs.tipsyRoger;


import org.academiadecodigo.murlogs.tipsyRoger.GameObjects.BottleTypes;
import org.academiadecodigo.murlogs.tipsyRoger.GameObjects.Bottles;
import org.academiadecodigo.murlogs.tipsyRoger.GameObjects.Characters.Playable.Player;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Main {
    public static void main(String[] args) {

<<<<<<< HEAD
        Game game = new Game(new Player(50));
=======
        Game game = new Game(new Player(), new Bottles(BottleTypes.BEER));
>>>>>>> 4bbd463ce602bf158535b6af2e63d89d7164f1f3

        game.init();

    }
}

package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class NPC extends Character {

    private boolean takenQuiz = false;
    private boolean correctAnswer;
    NPCtext npcText;


    public NPC(Picture picture) {
        super(picture);
    }

    public Text speak() {

        if(takenQuiz == false){
            takenQuiz = true;
            return npcText.quizTextGenerator();
        }
        return null;
    }

    public boolean isCorrect() {
        //give power up
        return correctAnswer == true; //not okay!!!!
        //acrescentar if statement se quisermos power down
    }


    public void powerUp() {

    }

    @Override
    public Puke attack(Directions direction) {
        return null;
    }

    @Override
    public void move() {

    }


}


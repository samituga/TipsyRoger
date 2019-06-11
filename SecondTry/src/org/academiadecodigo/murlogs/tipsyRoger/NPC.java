package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class NPC extends Colidable {

    private Picture npc;
    private boolean takenQuiz;
    private boolean correctAnswer;

    public NPC(Picture npc) {

        this.npc = npc;
    }


    /*public NPCQuiz speak() {

        if (!takenQuiz) {
            takenQuiz = true;
            return new NPCQuiz();
        }
        return null;
    }*/

    public boolean isCorrect() {
        //give power up
        return correctAnswer == true; //not okay!!!!
        //acrescentar if statement se quisermos power down
    }


    public void powerUp() {

    }

    public void delete() {
        npc.delete();
    }

    @Override
    public void draw() {
        npc.draw();
    }

    @Override
    public int x() {
        return npc.getX();
    }

    @Override
    public int y() {
        return npc.getY();
    }

    @Override
    public int xToWidth() {
        return x() + npc.getWidth();
    }

    @Override
    public int yToHeight() {
        return y() + npc.getHeight();
    }
}


package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class NPC extends Character {

    private boolean quizAvaiable;
    private boolean correctAnswer;


    public NPC(Picture picture) {
        super(picture);
    }

    public static NPC npc(int x, int y) {
        return new NPC(new Picture(x, y, "npctesting.png"));
    }

    public void speak() {

        if (!quizAvaiable) {

            quizAvaiable = true;
            int randomQuiz = (int) Math.random() * 5;

            switch (randomQuiz) {
                case 0:
                    System.out.println("Is the whisky alcool volume higher than 50%?");
                    break;
                case 1:
                    System.out.println("Can you puke so hard that you pass out?");
                    break;
                case 2:
                    System.out.println("Can you fill fill a bathtub with 50 oranges?");
                    break;
                case 3:
                    System.out.println("");
                    break;
                case 4:
                    System.out.println("");
                    break;
                default:
                    System.out.println("");
            }

        }

        System.out.println("You really are drunk, i already gave you the quiz!");

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


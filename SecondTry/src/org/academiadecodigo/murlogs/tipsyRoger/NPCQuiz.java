package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.simplegraphics.graphics.Text;


public class NPCQuiz extends Colidable {

    Text text;


    public void quizTextGenerator() {
        int randomGenerator = (int) (Math.random() * 0);

        switch (randomGenerator) {
            case 0:
                text = new Text(310, 170, "Is the whisky alcool volume higher than 50%?");
                return;
        }
        text = new Text(310, 170, "Is the whisky alcool volume higher than 50%?");
    }


    @Override
    public void draw() {
        text.draw();
    }

    @Override
    public int x() {
        return text.getX();
    }

    @Override
    public int y() {
        return text.getY();
    }

    @Override
    public int xToWidth() {
        return x() + text.getWidth();
    }

    @Override
    public int yToHeight() {
        return y() + text.getHeight();
    }
}

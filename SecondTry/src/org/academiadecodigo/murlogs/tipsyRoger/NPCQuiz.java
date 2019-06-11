package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class NPCQuiz extends Colidable {
    Rectangle rectangleYes;
    Rectangle rectangleNo;
    Rectangle rectangle;
    Picture picture;
    Text text;


    public NPCQuiz() {
        rectangle = new Rectangle(50, 110, 290,25);
        //picture = new Picture(50, 100, "bubble.png");
        text = this.quizTextGenerator();
        rectangleYes = new Rectangle(170, 150, 30, 30 );
        rectangleNo = new Rectangle(130, 150,30,30);


    }

    public Text quizTextGenerator() {
        int randomGenerator = (int) (Math.random() * 0);

        switch (randomGenerator) {
            case 0:
                return new Text(50, 110, "Is the whisky alcool volume higher than 50%?");

        }
        return new Text(310, 170, "Is the whisky alcool volume higher than 50%?");
    }


    @Override
    public void draw() {
        rectangle.setColor(Color.WHITE);
        rectangle.fill();
        rectangleYes.setColor(Color.WHITE);
        rectangleYes.fill();
        rectangleNo.setColor(Color.WHITE);
        rectangleNo.fill();
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

    public Text getText() {
        return text;
    }
}

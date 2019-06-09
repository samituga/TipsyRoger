package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.simplegraphics.graphics.Text;


public class NPCtext{

    Text text;


    public NPCtext(Text text) {
        this.text = text;
    }

    public Text quizTextGenerator(){
        int randomGenerator = (int)(Math.random()*0);
        switch (randomGenerator){
            case 0:
                return new Text(310,170,"Is the whisky alcool volume higher than 50%?");
        }
        return new Text(310,170,"Is the whisky alcool volume higher than 50%?");
    }
}

package org.academiadecodigo.murlogs.moveRectangle;


public class Main {
    public static void main(String[] args) {


        KeyboardKeys keyboardKeys = new KeyboardKeys();

        SomeRectangle someRectangle = new SomeRectangle();

        someRectangle.init();

        while (true){
            someRectangle.moveRectangle();
        }

    }
}

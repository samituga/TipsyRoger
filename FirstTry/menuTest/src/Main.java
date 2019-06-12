public class Main {

    public static void main(String[] args) {

        Menu menu = new Menu();
        Help help = new Help();

        menu.createRectangle();
        help.createHelp();


        while (true) {
            menu.move();


            //Help help = new Help();
            //if (menu.)
            //help.createHelp();
        }

    }
}

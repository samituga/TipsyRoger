import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu implements KeyboardHandler {

    private Menu menu;
    private Help help = new Help();
    private Keyboard keyboard;
    private boolean pressingUp;
    private boolean pressingDown;
    private boolean pressingEnter;
    private boolean pressingEsc;


    Rectangle screen = new Rectangle(0, 0, 1280, 720);
    Picture backgroundPhoto = new Picture(10, 10, "Alien.png");
    Picture tipsyImage = new Picture(90, 30, "TipsyImage.png");
    Picture rogerImage = new Picture(850, 30, "RogerImage.png");
    Picture playPhoto = new Picture(470, 500, "PlayGameImage.png");
    Picture helpPhoto = new Picture(610, 615, "HelpImage.png");
    Rectangle pointerPlayGame = new Rectangle(470, 500, 397, 114);
    Rectangle pointerHelp = new Rectangle(610, 615, 120, 72);


    public void createRectangle() {

        setKeyboard();
        screen.draw();
        screen.setColor(Color.BLUE);
        backgroundPhoto.draw();
        tipsyImage.draw();
        rogerImage.draw();
        playPhoto.draw();
        helpPhoto.draw();
        pointerPlayGame.setColor(Color.GREEN);
        pointerHelp.setColor(Color.GREEN);
        pointerPlayGame.draw();
    }


    public void move() {

        System.out.println("aksdfnaspodk");
        if (pressingUp) {
            pointerPlayGame.draw();
            pointerHelp.delete();
        }
        if (pressingDown) {
            pointerHelp.draw();
            pointerPlayGame.delete();
        }
        if (pressingEnter) {
            if (!pressingDown) {

            }
            help.createHelp();
        }
        if (pressingEsc) {
            help.deleteHelp();
            createRectangle();
        }

    }

    public void setKeyboard() {

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent enter = new KeyboardEvent();
        enter.setKey(KeyboardEvent.KEY_ENTER);
        enter.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent esc = new KeyboardEvent();
        esc.setKey(KeyboardEvent.KEY_ESC);
        esc.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(enter);
        keyboard.addEventListener(esc);
        keyboard.addEventListener(up);
        keyboard.addEventListener(down);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_UP:
                pressingUp = true;
                pressingDown = false;
                break;
            case KeyboardEvent.KEY_DOWN:
                pressingDown = true;
                pressingUp = false;
                break;
            case KeyboardEvent.KEY_ENTER:
                pressingEnter = true;
                pressingEsc = false;
                break;
            case KeyboardEvent.KEY_ESC:
                pressingEsc = true;
                pressingEnter = false;
                break;

        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}

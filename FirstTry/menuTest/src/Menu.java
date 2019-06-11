import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu implements KeyboardHandler {

    private Help help = new Help();
    private Keyboard keyboard;
    private boolean pressingUp = true;
    private boolean pressingDown;
    private boolean pressingEnter;
    private boolean pressingEsc;


    Rectangle screen = new Rectangle(0, 0, 1280, 720);
    Picture backgroundPhoto = new Picture(0, 0, "Background.png");
    Rectangle pointerPlayGame = new Rectangle(470, 500, 397, 114);
    Rectangle pointerHelp = new Rectangle(610, 615, 120, 72);


    public void createRectangle() {

        setKeyboard();
        screen.draw();
        screen.setColor(Color.BLUE);
        backgroundPhoto.draw();
        pointerPlayGame.setColor(Color.GREEN);
        pointerHelp.setColor(Color.GREEN);
        pointerPlayGame.draw();
    }

    public void deleteRectangle () {

        screen.delete();
        backgroundPhoto.delete();
        pointerPlayGame.delete();
        pointerHelp.delete();

    }


    public void move() {

        if (pressingDown) {
            System.out.println("you moma");
            pointerHelp.draw();
            pointerPlayGame.delete();
        }
        if (pressingUp) {
            System.out.println("you momy");
            pointerPlayGame.draw();
            pointerHelp.delete();
        }

        if (pressingEnter) {
            if (!pressingDown) {

            }
            System.out.println("you dad");
            help.createHelp();
            deleteRectangle();
            pointerHelp.delete();
            pointerPlayGame.delete();
        }
        if (pressingEsc) {
            System.out.println("you dady");
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
                //pressingEsc = false;
                //pressingDown = false;
                //pressingUp = false;
                break;
            case KeyboardEvent.KEY_ESC:
                pressingEsc = true;
                //pressingEnter = false;
                pressingUp = false;
                break;

        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameOver {

    public static void main(String[] args) {


        Rectangle screen = new Rectangle(0, 0, 1280, 720);
        screen.draw();

        Picture gameOverBackground = new Picture(0, 0, "GameOverBackground.jpg");
        gameOverBackground.draw();

        Picture gameOver = new Picture(220, 440, "GameOver.png");
        gameOver.draw();

    }

}

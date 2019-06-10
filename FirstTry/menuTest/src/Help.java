import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Help{

        Rectangle screen = new Rectangle(0, 0, 1280, 720);
        Picture helpBackground = new Picture(0, 0, "Alien.png");
        Picture arrowUp = new Picture(500, 420, "direction up 2.png");
        Picture arrowLeft = new Picture(485, 515, "direction left 2.png");
        Picture arrowRight = new Picture(490, 585, "direction right 2.png");
        Picture arrowDown = new Picture(505, 330, "direction down 2.png");
        Picture spaceBar = new Picture(390, 635, "direction spaceBar.png");
        Picture textMoveUP = new Picture(700, 400, "text moveUp.png");
        Picture textMoveDown = new Picture(700, 320, "text moveDown.png");
        Picture textMoveLeft = new Picture(700, 480, "text moveLeft.png");
        Picture textMoveRight = new Picture(700, 560, "text moveRight.png");
        Picture textSpaceBar = new Picture(700, 640, "text spaceBar.png");

        public void createHelp () {
            screen.draw();
            helpBackground.draw();
            arrowUp.draw();
            arrowLeft.draw();
            arrowRight.draw();
            arrowDown.draw();
            spaceBar.draw();
            textMoveUP.draw();
            textMoveDown.draw();
            textMoveLeft.draw();
            textMoveRight.draw();
            textSpaceBar.draw();

        }

        public void deleteHelp () {
            screen.delete();
            helpBackground.delete();
            arrowUp.delete();
            arrowLeft.delete();
            arrowRight.delete();
            arrowDown.delete();
            spaceBar.delete();
            textMoveUP.delete();
            textMoveDown.delete();
            textMoveLeft.delete();
            textMoveRight.delete();
            textSpaceBar.delete();
        }

}

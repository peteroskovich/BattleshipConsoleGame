import java.util.Arrays;
import java.util.Scanner;


public class Test extends Util {
    public static void main(String[] args) {
        GameField gameField1 = new GameField("Player 1");
        GameField gameField2 = new GameField("Player 2");
        // pre-setup the coordinates of ship to make a faster gameplay
        int[][] c1 = {{1, 1, 1, 1, -1, -1, -1, 1, -1, 1}, {-1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, {-1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, {-1, -1, 1, -1, -1, -1, -1, -1, -1, 1}, {-1, -1, -1, -1, -1, 1, 1, -1, -1, -1}, {-1, 1, 1, -1, -1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, {1, 1, -1, -1, 1, -1, -1, 1, 1, 1}};
        int[][] c2 = {{1, 1, 1, 1, -1, -1, -1, 1, -1, 1}, {-1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, {-1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, {-1, -1, 1, -1, -1, -1, -1, -1, -1, 1}, {-1, -1, -1, -1, -1, 1, 1, -1, -1, -1}, {-1, 1, 1, -1, -1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, {1, 1, -1, -1, 1, -1, -1, 1, 1, 1}};

        gameField1.setPlayerField(c1);
        gameField2.setPlayerField(c2);

        Battleship battleship = new Battleship(gameField1, gameField2);

    }
}

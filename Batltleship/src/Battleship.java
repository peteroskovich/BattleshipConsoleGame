import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.Scanner;


public class Battleship {
    // field of First player
    private GameField player1Field;
    // field second First player
    private GameField player2Field;

    // boolean check for the condition while the game is on
    private boolean gameIsOn(int check[][]) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (check[i][j] == 1)
                    return true;
            }
        }

        return false;

        //write conditions for ending the battle
    }


    // who is playing  now (true - player1, false - player2)
    public boolean isPlayer1;
    // logic to continue Player1's turn

    private static int[] parseCoordinare(String str) {
        int[] arr = Arrays.stream(str.substring(0, str.length()).split(","))
                .map(String::trim).mapToInt(Integer::parseInt).toArray();
        return arr;
    }

    private void gameMove(Scanner scannedCoordinate) {
        System.out.println("Enter coordinates for hitting x,y");
        Scanner scanner1 = new Scanner(System.in);
    }

    public void printField(int[][] playerField) {
        for (int[] x : playerField) {
            for (int y : x) {
                if (y == -1)
                    System.out.print("⬜" + " ");
                if (y == 1)
                    System.out.print("⬜" + " ");
                if (y == -2)
                    System.out.print("X" + " ");
            }
            System.out.println();
        }
    }

    // single constructor
    // internally checks that both fields are filled
    // also, the values of all fields are initialized
    public Battleship(GameField player1Field, GameField player2Field) {

        System.out.println("Play player 1:");
        System.out.println("Enter coordinate for hit x,y");
        Scanner scanner1 = new Scanner(System.in);
        String scannerShip = scanner1.nextLine();
        int[][] field1 = player1Field.getPlayerField();
        int[][] field2 = player2Field.getPlayerField();
      // boolean isPlayer=isPlayer1;
      // isPlayer=true;

        while (gameIsOn(player1Field.getPlayerField()) && gameIsOn(player2Field.getPlayerField())) {

            while (makeMove(scannerShip)) {
                System.out.println("First field");
                printField(field1);
                System.out.println("Second field");
                printField(field2);

                if (!isPlayer1) {

                    System.out.println("Play player 2:");
                    hit(field2, parseCoordinare(scannerShip));
                    printField(field2);
                } else {
                    System.out.println("Play player 1:");
                    hit(field1, parseCoordinare(scannerShip));
                    printField(field1);
                }


                System.out.println("Enter coordinate for hit x,y");
                scannerShip = scanner1.nextLine();
            }
        }
        if (!gameIsOn(player1Field.getPlayerField())) {
            System.out.println("Player 2 win");
        } else {
            System.out.println("Player 1 win");
        }
// insert completed fields, logically check the number of completed ships
    }

// runs the game loop while gameIsOn = true


    // returns true if userInput is a valid input. Returns false if userInput is an invalid input
    // first argument true if it's the first player's turn, false if it's the second player's turn
    private boolean makeMove(String userInput) {
        // on true let the first player move on false to the second
        //check userInput for move logic
        if (!checkCoordinates(userInput))
            return false;
        String[] stringCoordinate = userInput.split("[,;]+");

        int[] hitCoordinate = new int[stringCoordinate.length];
        for (int i = 0; i < stringCoordinate.length; i++) {
            hitCoordinate[i] = Integer.parseInt(stringCoordinate[i]);
        }
        for (int i : hitCoordinate) {
            if (i > 9 || i < 0)
                return false;
        }
        return true;
    }

    public static boolean checkCoordinates(String userInput) {

        int correctNumberOfCoordinates;
        correctNumberOfCoordinates = 2;
        String[] string = userInput.split("[,;]+");
        return string.length == correctNumberOfCoordinates;
    }

    // Performs a hit on the cell
    // Displays the message either "Missed!" or "Hit" or "Drunk".
    // In case of sinking, decrements the number of ships afloat
    // Transfers the right to move to another player if the blow was "Missed!"
    private void hit(int[][] playerField, int[] hitCoordinate) {
        // TODO
        if (playerField[hitCoordinate[0]][hitCoordinate[1]] == -1 || playerField[hitCoordinate[0]][hitCoordinate[1]] == 0) {
            if (!isPlayer1) {
                isPlayer1 = true;
            } else
                isPlayer1 = false;
            System.out.println("Miss!");


        }
        if (playerField[hitCoordinate[0]][hitCoordinate[1]] == 1) {
            System.out.println("Hit!");
            isPlayer1 = true;

        }

        if (playerField[hitCoordinate[0]][hitCoordinate[1]] == 1 && !shipSank(playerField, hitCoordinate)) {
            System.out.println("Sink");

        }

    }

    // true - if the impact sank the ship
    // false - if the impact did not sink the ship
    private boolean shipSank(int[][] playerField, int[] hitCoordinate) {

        playerField[hitCoordinate[0]][hitCoordinate[1]] = -2;
        int dx, dy;
        int x = hitCoordinate[0];
        int y = hitCoordinate[1];
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                dx = x + i;
                dy = y + j;
                if ((dx >= 0) & (dx < 10) & (dy >= 0) & (dy < 10) && (playerField[dx][dy] == 1)) {
                    count++;

                }
            }
        }

        return count >= 1;

    }
}

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameField extends Util {
    private String playerName;


    // ship: 1
    // ship aureole: 0
    // empty space: -1
    // attacked cell: -2
    private int[][] playerField;

    // set to true when the arrangePlayerField() method completes
    // field is initialized with empty space (-1)

    private void arrangeShip(int shipSize, Scanner scannedCoordinate) {

        System.out.println("Enter coordinate in format (x,y;x,y;...) of " + shipSize + " size ship - ");
        String scannerShip = scannedCoordinate.nextLine();

        //     checkArrangeShip(scannerShip, scannedCoordinate, shipSize);
        checkerShip(scannerShip, scannedCoordinate, shipSize);
        arrangePlayerField(playerField, parseShipCoordinates(checkArrangeShip(scannerShip, scannedCoordinate, shipSize), shipSize));
        printField();
    }

    //creates playerField fills -1
    public GameField(String playerName) {
        playerField = new int[10][10];
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++)
                playerField[i][j] = -1;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int[][] getPlayerField() {
        return playerField;
    }

    public void setPlayerField(int[][] c) {
        this.playerField = c;
    }




    // Arranges all ships for this field
    public void arrangePlayerField(int[][] playerField, int[][] inn) {
        int x;
        int y;
        int j = 0;

        for (int i = 0; i < inn.length; i++) {
            x = inn[i][j];
            y = inn[i][j + 1];
            playerField[x][y] = 1;

            // first arrangeShip check and then arranges if all tests pass

            // asks for coordinates and replaces values with ship coordinates
        }
    }

    // Displays the field on the screen

    public void printFirstField() {
        System.out.println("The format of the field is ");
        System.out.println("  0 1 2 3 4 5 6 7 8 9 ");
        System.out.println("0 - - - - - - - - - - ");
        System.out.println("1 - - - - - - - - - - ");
        System.out.println("2 - - - - - - - - - - ");
        System.out.println("3 - - - - - - - - - - ");
        System.out.println("4 - - - - - - - - - - ");
        System.out.println("5 - - - - - - - - - - ");
        System.out.println("6 - - - - - - - - - - ");
        System.out.println("7 - - - - - - - - - - ");
        System.out.println("8 - - - - - - - - - - ");
        System.out.println("9 - - - - - - - - - - ");
    }

    public void printField() {
        for (int[] x : playerField) {
            for (int y : x) {
                if (y == -1)
                    System.out.print("⬜" + " ");
                if (y == 1)
                    System.out.print("\uD83D\uDEE5" + " ");
            }
            System.out.println();
        }
    }

    private void checkerShip(String shipScanString, Scanner sc, int shipSize) {

        while (!checkShip(parseShipCoordinates(shipScanString, shipSize), shipSize)) {
            System.out.println("Wrong ship coordinates");
            System.out.println("Repeat coordinate of " + shipSize + " size ship - ");
            shipScanString = sc.nextLine();
        }


    }

    private String checkArrangeShip(String shipScanString, Scanner sc, int shipSize) {
        while (!checkAround(parseShipCoordinates(shipScanString, shipSize), playerField)) {
            System.out.println("Enters the aureole of the ship ");
            System.out.println("Repeat coordinate of " + shipSize + " - ");
            shipScanString = sc.nextLine();

        }


        return shipScanString;
    }

  public boolean checkAround1(int x, int y, int[][] playerField) {

        int dx, dy;

        if ((x >= 0) & (x < 10) & (y >= 0) & (y < 10) && ((playerField[x][y] == -1) || (playerField[x][y] == 2))) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    dx = x + i;
                    dy = y + j;
                    if ((dx >= 0) & (dx < 10) & (dy >= 0) & (dy < 10) && (playerField[dx][dy] == 1)) {
                        return false;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean checkAround(int[][] inn, int[][] playerField) {
        int x;
        int y;
        boolean check = true;
        int dx, dy;

        for (int I = 0; I < inn.length && check; I++) {

            int Y = 0;
            x = inn[I][Y];
            y = inn[I][Y + 1];

            if (!checkAround1(x, y, playerField)) {
                check = false;
            }
        }
        return check;
    }


}

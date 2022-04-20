import java.util.Scanner;

import static java.lang.Integer.parseInt;


// Class with useful static methods
public class Util {

    // Parse one coordinate (x,y)
    public static int[] parseCoordinate(String inputCoordinate) {
        int[] in = new int[2];
        String[] string = inputCoordinate.split(",");

// Create array of float for each pair of coordinate

        for (int i = 0; i <= 1; i++) {
            in[i] = parseInt(string[i]);
        }
        // TODO
        return in;
    }


    // Parse coordinates of ship (x1,y1; xn, yn)
    public static int[][] parseShipCoordinates(String shipCoordinates, int shipSize) {
        int[][] inn = new int[shipSize][2];
        String[] string = shipCoordinates.split("[,;]+");
        if (string.length < shipSize * 2) {
            int n = 0;
            for (int i = 0; i < string.length; i++)
                for (int y = 0; y < string.length / 2; y++) {
                    inn[i][y] = parseInt(string[n]);
                    n++;
                }
        }

// Create array of float for each pair of coordinate
        else {
            int n = 0;
            for (int i = 0; i < shipSize; i++)
                for (int y = 0; y < 2; y++) {
                    inn[i][y] = parseInt(string[n]);
                    n++;
                }
        }
        return inn;
    }


    // checks ship coordinates for validity
    // (verifies that the number of coordinates matches the size of the ship and checks each one separately
    // x,y coordinate for validity)
    // Checks if the coordinates are a valid ship
    // for a valid ship, one coordinate must always be the same
    // and the second coordinate should increase by one

    public static boolean checkShip(int[][] shipCoordinates, int shipSize) {
        if (shipCoordinates.length < shipSize) {
            int x;
            x = (shipSize * 2) - shipCoordinates.length;
            System.out.println("Not enough coordinate , enter  " + x + " coordinates moore ");
            return false;
        }

        for (int[] shipCoordinate : shipCoordinates) {
            for (int i : shipCoordinate) {
                if (i > 9 || i < 0)
                    return false;
            }
        }


        switch (shipSize) {
            case 4: {

                //if x coordinate are the same add in y
                if (shipCoordinates[0][0] == shipCoordinates[1][0] && shipCoordinates[0][1] + 1 == shipCoordinates[1][1] && shipCoordinates[1][1] + 1 == shipCoordinates[2][1] && shipCoordinates[2][1] + 1 == shipCoordinates[3][1])
                    return true;

                    //if y are identical
                else
                    return shipCoordinates[0][1] == shipCoordinates[1][1] && shipCoordinates[0][0] + 1 == shipCoordinates[1][0] && shipCoordinates[1][0] + 1 == shipCoordinates[2][0] && shipCoordinates[2][0] + 1 == shipCoordinates[3][0];
            }
            case 3: {
                if (shipCoordinates[0][0] == shipCoordinates[1][0] && shipCoordinates[0][1] + 1 == shipCoordinates[1][1] && shipCoordinates[1][1] + 1 == shipCoordinates[2][1])
                    return true;
                    //if y are identical
                else
                    return shipCoordinates[0][1] == shipCoordinates[1][1] && shipCoordinates[0][0] + 1 == shipCoordinates[1][0] && shipCoordinates[1][0] + 1 == shipCoordinates[2][0];
            }
            case 2: {
                if (shipCoordinates[0][0] == shipCoordinates[1][0] && shipCoordinates[0][1] + 1 == shipCoordinates[1][1])
                    return true;
                    //if y are identical
                else
                    return shipCoordinates[0][1] == shipCoordinates[1][1] && shipCoordinates[0][0] + 1 == shipCoordinates[1][0];
            }
            case 1: {
                return true;

            }
        }
        // check on one increasing  constant
        //check on one increasing coordinates
        return false;
    }

    //returns true if the ship is vertical and false if it is horizontal

    public static boolean verticalOrHorizontal(int[][] shipCoordinates) {
        return shipCoordinates[0][0] == shipCoordinates[1][0] || shipCoordinates[0][1] + 1 == shipCoordinates[1][1];
    }
}

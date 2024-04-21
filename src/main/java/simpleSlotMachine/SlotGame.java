package simpleSlotMachine;

import java.util.ArrayList;
import java.util.Random;

public class SlotGame {
    ArrayList<SlotMachine> screen = new ArrayList<>();
    int dimension;
    Icon icon = new Icon();
    int [][] result;
    Player player = new Player();


    SlotGame(int dimension) {
        this.dimension = dimension;
        result = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                screen.add(new SlotMachine(j, i));
            }
        }
    }
    public String toString() {
        String ret = "";
        Random random = new Random();
        for (int i = 0; i < dimension; i++){
            for (int j = 0; j < dimension; j++){
                int randomNumber = random.nextInt(5) + 1 -1;
                result[i][j] = randomNumber;
                ret += icon.getIcon().get(randomNumber);

            }
            ret += "\n";
        }
        return ret;
    }
    public int jackPot(){
        int count = 0;
        // Check rows
        for (int row = 0; row < result.length; row++) {
            if (allEqual(result[row])) {
                count++;
            }
        }

        // Check columns
        for (int col = 0; col < result[0].length; col++) {
            int[] column = new int[result.length];
            for (int row = 0; row < result.length; row++) {
                column[row] = result[row][col];
            }
            if (allEqual(column)) {
                count++;
            }
        }

        // Check main diagonal
        int[] mainDiagonal = new int[result.length];
        for (int i = 0; i < result.length; i++) {
            mainDiagonal[i] = result[i][i];
        }
        if (allEqual(mainDiagonal)) {
            count++;
        }

        // Check anti-diagonal
        int[] antiDiagonal = new int[result.length];
        for (int i = 0; i < result.length; i++) {
            antiDiagonal[i] = result[i][result.length - 1 - i];
        }
        if (allEqual(antiDiagonal)) {
            count++;
        }

        return count;
    }

    public static boolean allEqual(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[0]) {
                return false;
            }
        }
        return true;
    }
}

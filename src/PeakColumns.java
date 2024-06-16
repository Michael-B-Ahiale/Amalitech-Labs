import java.util.Scanner;

public class PeakColumns {
    public static void main(String[] args) {
        Scanner matrixInput = new Scanner(System.in);

        // Input th matrix dimensions
        System.out.println("Input the number of rows:");
        int rowNum = matrixInput.nextInt();
        System.out.println("Input the number of columns:");
        int colNum = matrixInput.nextInt();


        int[][] userMatrix = new int[rowNum][colNum];

        // Input matrix elements
        System.out.println("Input matrix elements:");
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                userMatrix[i][j] = matrixInput.nextInt();
            }

        }

        // Find and display peak-columns
        findAndDisplayPeakColumns(userMatrix);
    }



    public static void findAndDisplayPeakColumns(int[][] matrix) {
        boolean foundPeak = false;
        for (int i = 0; i < matrix.length; i++) {
            // Initialize max values for each row and set maximum element to the first element in first row
            int rowMax = matrix[i][0];
            int colIndexOfMax = 0;

            // The max element in a row
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > rowMax) {
                    rowMax = matrix[i][j];
                    colIndexOfMax = j;
                }
            }

            // Checking to see if row max is the minimum element in its column
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == rowMax) {
                    //boolean with a default condition that the rowMax is the minimum element
                    boolean isMinInColumn = true;
                    for (int k = 0; k < matrix.length; k++) {
                        if (matrix[k][j] < rowMax) {
                            isMinInColumn = false;
                            break;
                        }
                    }

                    if (isMinInColumn) {
                        System.out.println("(" + (i +1)+ ", " + (j +1)+ ") " +"= " +rowMax);
                        foundPeak=true;
                    }
                }
            }
        }
        if (!foundPeak) {
            System.out.println("No peak values found in the matrix.");
        }
    }
}

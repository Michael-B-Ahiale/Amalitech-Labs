import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner inputs = new Scanner(System.in);

        try {
            // Get dimensions for the matrices
            int rowsA = getMatrixDimension(inputs, "Input the number of rows for the first matrix:");
            int columnsA = getMatrixDimension(inputs, "Input the number of columns for the first matrix (and rows for the second matrix):");
            int columnsB = getMatrixDimension(inputs, "Input the number of columns for the second matrix:");

            // Create matrices with appropriate dimensions
            int[][] matrixA = new int[rowsA][columnsA];
            int[][] matrixB = new int[columnsA][columnsB];
            int[][] resultMatrix = new int[rowsA][columnsB];

            // Populate matrices with user input
            populateMatrix(inputs, matrixA, "Enter values for matrix A:");
            populateMatrix(inputs, matrixB, "Enter values for matrix B:");

            // Check if matrices can be multiplied
            if (matrixA[0].length != matrixB.length) {
                throw new IllegalArgumentException("Number of columns of matrix A must equal number of rows of matrix B.");
            }

            // Multiply matrices and store result
            multiplyMatrices(matrixA, matrixB, resultMatrix);

            // Display the result matrix
            displayMatrix(resultMatrix, "Result Matrix:");

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            inputs.close();
        }
    }


    // Gets the dimension for a matrix (rows or columns) from the user.

    private static int getMatrixDimension(Scanner inputs, String prompt) {
        System.out.println(prompt);
        return inputs.nextInt();
    }


    // Populates a matrix with values provided by the user.

    private static void populateMatrix(Scanner inputs, int[][] matrix, String prompt) {
        System.out.println(prompt);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = inputs.nextInt();
            }
        }
    }


    //Multiplies two matrices and stores the result in the result matrix.

    private static void multiplyMatrices(int[][] matrixA, int[][] matrixB, int[][] resultMatrix) {
        int rowsA = matrixA.length;
        int columnsA = matrixA[0].length;
        int columnsB = matrixB[0].length;

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < columnsB; j++) {
                for (int k = 0; k < columnsA; k++) {
                    resultMatrix[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
    }


    //Displays a matrix with a given title.

    private static void displayMatrix(int[][] matrix, String title) {
        System.out.println(title);
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("|");
        }
    }
}

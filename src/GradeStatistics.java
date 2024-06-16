
import java.util.Scanner;

public class GradeStatistics {
    public static void main(String[] args) {
        try (Scanner inputVals = new Scanner(System.in)) {
            System.out.println();
            System.out.println("Provide student grades separated by spaces:");
            System.out.println();
            String grades = inputVals.nextLine();
            String[] gradeString = grades.split(" ");

            // Convert to an array of integers
            int[] gradeInt = convertToIntArray(gradeString);

            System.out.println();
            System.out.println("Values:");
            System.out.println();


            // Calculate and print statistics
            printStatistics(gradeInt);

            // Calculate grade distribution
            int[] stats = calculateGradeDistribution(gradeInt);


            // Display bar graph
            displayBarGraph(stats);
        }
    }

    //Method to convert string array to int array
    private static int[] convertToIntArray(String[] gradeString) {
        int[] gradeInt = new int[gradeString.length];
        for (int i = 0; i < gradeString.length; i++) {
            gradeInt[i] = Integer.parseInt(gradeString[i]);
        }
        return gradeInt;
    }

    //private method to handle the grade statistics (max, min, average)
    private static void printStatistics(int[] gradeInt) {
        int minGrade = gradeInt[0];
        int maxGrade = gradeInt[0];
        int gradeSum = 0;

        for (int grade : gradeInt) {
            if (grade < minGrade) {
                minGrade = grade;
            }
            if (grade > maxGrade) {
                maxGrade = grade;
            }
            gradeSum += grade;
        }

        double gradeAverage = (double) gradeSum / gradeInt.length;
        String formattedAverage = String.format("%.6f", gradeAverage);

        System.out.println("The minimum grade is: " + minGrade);
        System.out.println("The maximum grade is: " + maxGrade);
        System.out.println("The average grade is: " + formattedAverage);
    }

    //Method to handle grade distribution into intervals of 20
    private static int[] calculateGradeDistribution(int[] gradeInt) {
        int[] stats = new int[5];

        for (int score : gradeInt) {
            if (score > 80) {
                stats[4]++;
            } else if (score >= 61 && score <= 80) {
                stats[3]++;
            } else if (score >= 41 && score <= 60) {
                stats[2]++;
            } else if (score >= 21 && score <= 40) {
                stats[1]++;
            } else if (score >= 0 && score <= 20) {
                stats[0]++;
            }
        }

        return stats;
    }

    //private method to handle the graph display logic
    private static void displayBarGraph(int[] stats) {
        System.out.println("\nGraph:");
        System.out.println();
        System.out.println();

        //Find the max bar height
        int maxBarHeight = 0;
        for (int stat : stats) {
            //update the maxBarHeight if the current stat value is greater
            if (stat > maxBarHeight) maxBarHeight = stat;
        }

        for (int i = maxBarHeight; i >= 1; i--) {
            System.out.print(i + " > ");
            for (int stat : stats) {
                if (stat >= i) {
                    System.out.print(" ####### ");
                } else {
                    System.out.print("         ");
                }
            }
            System.out.println();
        }

        System.out.print("    +");
        for (int j = 0; j < stats.length; j++) {
            System.out.print("--------+");
        }
        System.out.println();
        System.out.println("    I 0-20   I  21-40 I  41-60 I 61-80  I 81-100 I");
    }
}

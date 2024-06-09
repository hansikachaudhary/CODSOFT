import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Unique Grade Calculator!");
        System.out.println("========================================");
        System.out.println("Please enter the marks obtained in each subject (out of 100):");

        int subjectCount = 5;
        int[] marks = new int[subjectCount];
        String[] subjectNames = {"Math", "java", "English", "oops", "DBMS"};

        for (int i = 0; i < subjectCount; i++) {
            System.out.print("Enter marks for " + subjectNames[i] + ": ");
            marks[i] = scanner.nextInt();
        }

        int totalMarks = calculateTotalMarks(marks);
        double averagePercentage = calculateAveragePercentage(totalMarks, subjectCount);
        char grade = calculateGrade(averagePercentage);

        System.out.println("\n--- Results ---");
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    private static int calculateTotalMarks(int[] marks) {
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }
        return totalMarks;
    }

    private static double calculateAveragePercentage(int totalMarks, int subjectCount) {
        return (double) totalMarks / subjectCount;
    }

    private static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}

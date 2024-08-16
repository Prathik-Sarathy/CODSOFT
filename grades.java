import java.util.*;
public class grades 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = scanner.nextInt();
        if (numberOfSubjects <= 0) 
        {
            System.out.println("Number of subjects must be greater than 0.");
            return;
        }
        int totalMarks = 0;
        int[] marks = new int[numberOfSubjects];
        for (int i = 0; i < numberOfSubjects; i++) 
        {
            System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
            marks[i] = scanner.nextInt();
            if (marks[i] < 0 || marks[i] > 100) 
            {
                System.out.println("Marks must be between 0 and 100.");
                return;
            }
            totalMarks += marks[i];
        }
        double averagePercentage = (double) totalMarks / numberOfSubjects;
        String grade = getGrade(averagePercentage);
        System.out.printf("Total Marks: %d%n", totalMarks);
        System.out.printf("Average Percentage: %.2f%%%n", averagePercentage);
        System.out.println("Grade: " + grade);
        scanner.close();
    }
    private static String getGrade(double averagePercentage) 
    {
        if (averagePercentage >= 90) 
        {
            return "A+";
        } 
        else if (averagePercentage >= 80) 
        {
            return "A";
        } 
        else if (averagePercentage >= 70) 
        {
            return "B+";
        } 
        else if (averagePercentage >= 60) 
        {
            return "B";
        } 
        else if (averagePercentage >= 50) 
        {
            return "C+";
        } 
        else if (averagePercentage >= 40) 
        {
            return "C";
        } 
        else 
        {
            return "D";
        }
    }
}

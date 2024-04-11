import java.util.Scanner;
public class Main 
{
    
    public static void main(String[] args) 
    
    {


        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter marks obtained in subject 1: ");
        int subject1 = scanner.nextInt();
        System.out.print("Enter marks obtained in subject 2: ");
        int subject2 = scanner.nextInt();
        System.out.print("Enter marks obtained in subject 3: ");
        int subject3 = scanner.nextInt();
        int total_marks = subject1 + subject2 + subject3; 
        int num_subjects = 3; 
        double average_percentage = (double) total_marks / (num_subjects * 100) * 100;
        char grade;
        if (average_percentage >= 90) 
        {
            grade = 'A';
        } 
        else if (average_percentage >= 80) 
        {
            grade = 'B';
        } 
        else if (average_percentage >= 70) 
        {
            grade = 'C';
        } 
        else if (average_percentage >= 60) 
        {
            grade = 'D';
        } 
        else 
        {
            grade = 'F';
        }
    
        System.out.printf("Total Marks: %d%n", total_marks);
        System.out.printf("Average Percentage: %.2f%%%n", average_percentage);
        System.out.printf("Grade: %c%n", grade);
    }
}
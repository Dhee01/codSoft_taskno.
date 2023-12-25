import java.util.Scanner;

 class studentResult
{
    public static void main (String[]args)
    {
        Scanner Scanner = new Scanner(System.in);

        // Input Take marks obtained (out of 100) in each subject.
        System.out.println("Enter marks obtained in each subject (out of 100):");

        // Assuming three subject for demonstration purposes
        System.out.println("Subject 1: ");
        int subject1Marks = Scanner.nextInt();

        System.out.println("Subject 2: ");
        int subject2Marks = Scanner .nextInt();

        System.out.println("Subject 3: ");
        int subject3Marks = Scanner .nextInt();

        // Calculate Total Marks: Sum up the marks obtained in all subjects.
        int totalMarks = subject1Marks + subject2Marks + subject3Marks;

        // Calculate Average Percentage: Divide the total marks by the total number of subjects to get the average Percentage.
        int numberofsubject = 3;
        double averagePercentage = (double) totalMarks / (3 * 100) * 100;

        // Grade calculation: Assign grades based on the average percentage achieved.
        char grade;
        if (averagePercentage >= 90) 
        {
            grade = 'A';
        }
        else if (averagePercentage >= 80)
        {
            grade = 'B';
        }         
        else if (averagePercentage >= 70)
        {
            grade = 'C';
        }
        else if (averagePercentage >= 60)
        {
            grade = 'D';
        }
        else 
        {
            grade = 'F';
        }

        // Display Results: Show the total marks average Peacentage and the corresponding grade to the user.
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        Scanner.close(); 
    }
}
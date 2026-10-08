import java.util.Scanner;

class Student 
{
    String studentName;
    String rollNumber;
    double marks;
    String courseName;
    int courseCredits;
    public Student(String studentName, String rollNumber, double marks, String courseName, int courseCredits)
 {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }
    public double calculateFee() 
    {
        return courseCredits * 1500.0;
    }
    public boolean checkEligibility() 
    {
        return marks >= 50.0;
    }
    public double calculateScholarship(double totalFee) 
    {
        if (marks >= 85.0) 
        {
            return totalFee * 0.20; 
        } else if (marks >= 70.0 && marks <= 84.0)
       {
            return totalFee * 0.10; 
        } 
        else
     {
            return 0.0; 
        }
    }
    public double calculateFinalFee(double totalFee, double scholarship)
   {
        return totalFee - scholarship;
    }
    public void displayDetails()
 {
        boolean eligible = checkEligibility();
        System.out.println("Student Name: " + studentName);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Course Name: " + courseName);
        System.out.println("Course Credits: " + courseCredits);
        System.out.println("Eligibility: " + (eligible ? "Eligible" : "Not Eligible"));

        if (eligible)
     {
            double totalFee = calculateFee();
            double scholarship = calculateScholarship(totalFee);
            double finalFee = calculateFinalFee(totalFee, scholarship);
            System.out.println("Total Course Fee: Rs. " + totalFee);
            System.out.println("Scholarship Amount: Rs. " + scholarship);
            System.out.println("Final Fee to Pay: Rs. " + finalFee);
        }
    }
    public static void main(String[] args)
   {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Roll Number: ");
        String roll = scanner.nextLine();
        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.print("Enter Course Name: ");
        String course = scanner.nextLine();
        System.out.print("Enter Course Credits: ");
        int credits = scanner.nextInt();
        Student student = new Student(name, roll, marks, course, credits);
        if (student.checkEligibility()) 
        {
            System.out.println("\n Registration Details");
            student.displayDetails();
        }
         else 
        {
            System.out.println("\nStudent Name: " + student.studentName);
            System.out.println("Eligibility: Not Eligible");
            System.out.println("Message: Sorry, you are not eligible for registration due to insufficient marks.");
        }

        scanner.close();
    }
}
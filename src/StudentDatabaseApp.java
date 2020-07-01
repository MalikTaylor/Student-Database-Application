
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public  class StudentDatabaseApp {
	
	private static Student student;
	private static Scanner scanner = new Scanner(System.in);
	

	
	static void CreateStudent() {
		
		System.out.println("Welcome!" + "\n");
		
		//Student Name
		System.out.print("Enter Student First name: ");
		String firstName = scanner.next();
		System.out.print("Enter Student First name: ");
		String middleName = scanner.next();
		System.out.print("Enter Student Last name: ");
		String lastName = scanner.next();
		
		student = new Student();//Create a new student Object
		
		student.SetName(firstName, middleName,lastName); // Assign a name for the student Object
		
		student.studentList.add(student); // Add student to our database
		
		System.out.println("\n" + firstName + " has been added to the system.");
		
		student.CreateStudentID(firstName);
	}
	
	
	
	private static void TermSelect() {
		//Student Term Year
		System.out.println("\nTerm Year:\n [1] Freshman\n [2] Sophomore\n [3] Junior\n [4] Senior");
		System.out.print("Enter students term year: ");
		
		switch(scanner.nextInt()) {
			case (1): 
				student.termYear = ("Freshman");
				break;
			case (2): 
				student.termYear = ("Sophomore");
				break;
			case (3):
				student.termYear = ("Junior");
				break;
			case (4):
				student.termYear = ("Senior");
				break;
			default:
				System.out.println("Invalid Selection");
				TermSelect();
		}
		
		
	}
	static void MenuSelect() {
		
		//if(enrolledInAClass == true) display [4] View student's courses
		System.out.println("\nChoose an Option:\n [1] Enroll\n [2] View Tuition Balance\n [3] Pay Tuition Balance\n [4]View Students\n [5]Add Student");
		System.out.print("Selection: ");
		int menuSelect = scanner.nextInt();
		switch(menuSelect) {
			case 1:
				Enroll();
				break;
			case 2:
				student.getCostOfTuition();
				MenuSelect();
			case 3:
				PayTuition();
				break;
			case 4:
				for(Student s: student.studentList) {
					System.out.println(s.firstName.toString());
				}
				MenuSelect();
			case 5:
				CreateStudent();
								
			default:
				System.out.println("Invalid Selection");
				MenuSelect();
		}
	}
	static void Enroll(){	
		System.out.println("\n" + "Courses to Enroll in:" + "\n" + " [1]History 101"+ "\n" + " [2]Mathmatics 101" + "\n" 
		+ " [3]English 101" + "\n" + " [4]Chemistry 101" + "\n" + " [5]Computer Science 101" + "\n " + "[Q]Quit\n");
		
		System.out.print("Enter a course to enroll in: ");
		
		for(int i = 1; i > 0; i++) {
			String selectedCourse = scanner.next();
			
			switch(selectedCourse) {
				case "1":
				case "History 101":
					student.EnrollInCourse("History 101");
					
					break;
				case "2":
				case "Mathmatics 101":
					student.EnrollInCourse("Mathmatics 101");
					
					break;
				case "3":
				case "English 101":
					student.EnrollInCourse("English 101");
					
					break;
				case "4":
				case "Chemistry 101":
					student.EnrollInCourse("Chemistry 101");
					
					break;
				case "5":
				case "Computer Science 101":
					student.EnrollInCourse("Computer Science 101");
					
					break;
				case "Q":
				case "q":
					System.out.println("\n" + "Your courses:" + "\n" + student.coursesEnrolledIn.size());
					MenuSelect();
				default:
					System.out.println("Invalid Selection");
					break;
			}		
			Enroll();		
		}
	}
	
	private static void PayTuition(){
		
		if(student.costOfTuition > 0) {
			System.out.println("\n" + student.firstName+"'s " + "total cost for tuition: " + student.costOfTuition);
			
			System.out.println("What is " + student.firstName+"'s " + "payment amount");
			
			double paymentAmount = scanner.nextDouble();
			double remainingBalance =  student.costOfTuition - paymentAmount;
			System.out.println(student.firstName+"'s " + "remaining balance: " + remainingBalance);
		}else {
			System.out.println("\n" + "You have no balance to pay.");
		}
		
		
		MenuSelect();
	}
	
	public static void main(String[] args) {		
			CreateStudent();
			TermSelect();
			MenuSelect();		
	}
}

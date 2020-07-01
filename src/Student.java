import java.util.ArrayList;

public class Student {
	
	public static ArrayList<Student> studentList = new ArrayList<Student>();
	public ArrayList<String> coursesEnrolledIn = new ArrayList<String>();
	
	public String name, name_Full;
	
	public String firstName, middleName,lastName;
	public char sex;
	public String birthDate;
	public String termYear;
	public String phoneNum;
	public String ID;
	public double costOfTuition;
	public String courseName;
	public int courseCost;
	
	//public int[] coursePrices = {200, 300, 500, 300, 600};
	
	static int initialStartingID = 100000;
	
	public String GetName() {
		return name;
	}

	public void SetName(String firstName, String middleName,String lastName) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		
		name = firstName + " " + lastName;	
		name_Full = firstName + " " + middleName +  " " + lastName;
	}
	
	public String getTermYr() {
		return termYear;
	}
	
	public void SetTermYr(String termYear) {
		this.termYear = termYear;
	}
	
	public String getPhoneNum() {
		return phoneNum;
	}
	
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	public double getCostOfTuition() {
		return costOfTuition;
	}
	
	public void setCostOfTuition(double costOfClass) {
		costOfTuition += costOfClass;
	}
	
	public void CreateStudentID(String studentFirstName){
		ID = "" + firstName.charAt(0) + initialStartingID;
		System.out.println("\nStudent's issued ID: " + ID);		
		initialStartingID ++;	
	}
	
	public void EnrollInCourse(String courseEntered) {
		courseName = courseEntered;
		
		if(coursesEnrolledIn.contains(courseEntered)) {
			System.out.println("\n" + "You're already enrolled in this course.");
		}
		else{
			coursesEnrolledIn.add(courseEntered);
			//courseEntered.cost
			setCostOfTuition(500);
			System.out.println( "Your total tuition fees: " + costOfTuition);
			System.out.println("\n" + "You've been enrolled in " + courseEntered);
		}	
	}
	
	public void PayTuition(double amount){
		if(costOfTuition > 0) {
			costOfTuition -=  amount;
			System.out.println(firstName+"'s " + "remaining balance: " + costOfTuition);
		}else {
			System.out.println("\n" + "You have no balance to pay.");
		}
	}
}



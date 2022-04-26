package Parametrized_Constructor_Overloading;

public class Student {

		String name;
		int age;
		char section;
		char gender;
		int subject1, subject2, subject3;
		int total, avg;
		
//		for student s1 and s4
		public Student(String n, int a, char s, char g, int sub1, int sub2, int sub3) {
			name=n;
			age=a;
			section=s;
			gender=g;
			subject1=sub1;
			subject2=sub2;
			subject3=sub3;
		}
		
//		for student s2 and s3
		public Student(String n, int a, char s, char g, int sub2, int sub3) {
			name=n;
			age=a;
			section=s;
			gender=g;
			subject2=sub2;
			subject3=sub3;
		}
		void display(){
			total = subject1 + subject2 + subject3;
			avg = total / 3;
			System.out.println("Student_Name: "+name+", Age: "+age+", Section: "+section+", Gender: "+gender+", Subject_1: "+subject1+", Subject_2: "+subject2+", Subject_3: "+subject3+", Total: "+total+", Average: "+avg+"%");
		}
		

	public static void main(String[] args) {
		Student s1=new Student("Rohan", 15, 'A', 'M', 20, 30, 40);
		Student s2=new Student("Suman", 16, 'B', 'F', 35, 70);
		Student s3=new Student("Anubhav", 17, 'C', 'M', 37, 81);
		Student s4=new Student("Ronali", 18, 'D', 'F', 56, 31, 92);
		s1.display();  
	    s2.display(); 
	    s3.display();  
	    s4.display();
	    
	}

}
	
package Test_Method_Cons_String;

import java.util.Scanner;

class Grade_Revision{
	String name;
	int bas;
	int expn;
	double inc;
	double nbas;
	
	public Grade_Revision() {
		name = "";
		bas = 0;
		expn = 0;
		inc = 0.0;
	    nbas = 0.0;	
	}
	
	public void accept() {
		Scanner sc = new Scanner (System.in);
		System.out.print("Enter Name: ");
		name = sc.nextLine();
		System.out.print("Enter Basic Salary: ");
		bas = sc.nextInt();
		System.out.print("Enter Experience: ");
		expn = sc.nextInt();
	}
	
	public void increment() {
		if (expn <= 3) {
			inc = 1000 + (bas * 0.1);
		}
		else if(expn <= 5) {
			inc = 3000 + (bas * 0.12);
		}
		else if(expn <= 10) {
			inc = 5000 + (bas * 0.15);
		}
		else {
			inc = 8000 + (bas * 0.2);
		}
		nbas = inc + bas;
	}
	
	void display() {
		System.out.println("\nName of Employee: "+name);
		System.out.println("Basic Salary: "+bas);
		System.out.println("Experience of Employee: "+expn);
		System.out.println("Increment in Salary: "+inc);
		System.out.println("New Basic Salary: "+nbas);
		}
	
}

public class Question_2 {

	public static void main(String[] args) {
		Grade_Revision gr = new Grade_Revision();
		gr.accept();
		gr.increment();
		gr.display();

	}

}

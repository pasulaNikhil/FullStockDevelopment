package Test_Method_Cons_String;
import java.util.Scanner;

public class Question_4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	       System.out.print("Enter a Sentence: ");
	       String str = sc.nextLine();
	       String word = "" + str.charAt(0);
	       int len = str.length();
	       
	       for (int i = 0; i < len; i++) {
	           char pt = str.charAt(i);      
	           if (pt == ' ')               
	               word += str.charAt(i + 1);
	       }
	       System.out.println("New Word: " + word);
	}
}

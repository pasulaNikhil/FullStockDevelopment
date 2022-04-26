package Test_Method_Cons_String;

import java.util.Scanner;

public class Question_3 {

	public static void main(String[] args) {
		
		String s;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter The Text You Want to Modify: ");
        s = sc.nextLine();
        s = s.toUpperCase();
//        System.out.println(s);
        int l = s.length();
        int count = 0;
        for (int i = 0; i < l-1; i++) {
        	if (s.charAt(i) == s.charAt(i+1))
        		count ++;
        }
        System.out.println("Your Modified Text is: "+s+"\nAnd double letter sequence is: "+count);

	}

}

package q2_validation_of_an_Email_ID;
import java.util.*;
import java.util.regex.*;
public class EmailValidate {
public static void main(String[] args) {

List<String> emails = new ArrayList<String>();

for (String value : emails) 

System.out.println("The Email address " + value + " is " + (isValidEmail(value) ? "valid" : "invalid"));

System.out.println("enter the Email id:");
Scanner sc = new Scanner(System.in);
String input = sc.nextLine();
System.out.println("The Email address " + input + " is " + (isValidEmail(input) ? "valid" : "invalid"));

}


public static boolean isValidEmail(String email) { String regex = "^(.+)@(.+)$";

Pattern pattern = Pattern.compile(regex); 
Matcher matcher = pattern.matcher(email);
return matcher.matches();


}

}
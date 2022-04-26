package q1_string_to_other_datatypes;
import java.util.Scanner;

public class StringToOtherDatatype {
	public static int toInt(String s) {
		return Integer.parseInt(s);
	}

	public static Integer toInteger(String s) {
		return Integer.valueOf(s);
	}

	public static long tolong(String s) {
		return Long.parseLong(s);
	}

	public static Long toLong(String s) {
		return Long.valueOf(s);
	}

	public static double todouble(String s) {
		return Double.parseDouble(s);
	}

	public static Double toDouble(String s) {
		return Double.valueOf(s);
	}

	public static char[] toCharArray(String s) {
		return s.toCharArray();
	}

	public static byte[] toByteArray(String s) {
		return s.getBytes();
	}

	public static boolean toboolean(String s) {
		return Boolean.parseBoolean(s);
	}

	public static Boolean toBoolean(String s) {
		return Boolean.valueOf(s);
	}

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in); //System.in is a standard input stream  
		System.out.print("Enter a string: ");  
		String str= sc.nextLine();              //reads string 
		System.out.println("To primitive int: " + toInt(str));
		System.out.println("To Integer Wrapper type: " + toInteger(str));
		System.out.println("To primitive long: " + tolong(str));
		System.out.println("To Long Wrapper type: " + toLong(str));
		System.out.println("To primitive double: " + todouble(str));
		System.out.println("To Double Wrapper type: " + toDouble(str));
		System.out.println("To CharArry: " + toCharArray(str));
		System.out.println("To ByteArry: " + toByteArray(str));
		System.out.println("To primitive boolean: " +toboolean(str) );
		System.out.println("To Boolean Wrapper type: " + toBoolean(str));
		sc.close();
		
		
		   

	}

}

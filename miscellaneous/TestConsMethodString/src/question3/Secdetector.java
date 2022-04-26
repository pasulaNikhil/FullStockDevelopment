package question3;

import java.util.Scanner;
public class Secdetector {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter string: ");
        String s = in.nextLine();
        String str = s.toUpperCase();
        int count = 0;
        int len = str.length();
        
        for (int i = 0; i < len - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1))
                count++;
        }
        
        System.out.println("Double Letter Sequence Count = " + count);
        in.close();
    }
} 
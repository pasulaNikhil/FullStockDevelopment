package Access_Modifiers.Package_2;

import Access_Modifiers.Package_1.M;
import Access_Modifiers.Package_1.N;

// for class: N
class K extends N{
	public void test1() {
		new K().methodPublic();
		new K().methodProtected();
		}
}

public class Y extends M{
		public static void main(String args[]) {
		 
             //		 for all the methods of class: M
            System.out.println("\n");
            new Y().methodPublic();
            new Y().methodProtected();
            
            //       for all the methods of class: N
            System.out.println("\n");
            new K().test1();
            
            //       for all the variables from class: X
            System.out.println("\nVariables from Class: X");
            System.out.println("long variable: "+new X().l1);
            System.out.println("float variable: "+new X().f1);
            System.out.println("char variable: "+new X().ch);
            System.out.print("private variable accessing through public method: ");
            new X().methodPublic();        
          }
}

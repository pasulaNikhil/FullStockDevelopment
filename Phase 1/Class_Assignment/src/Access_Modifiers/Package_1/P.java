package Access_Modifiers.Package_1;

public class P{
	public void methodPublic(){     // public method
		System.out.println("public method from Class: P");
		methodPrivate();
		methodDefault();
	}
	protected void methodProtected(){   // protected method
		System.out.println("protected method from Class: P");
	}
	void methodDefault(){    //default method
		System.out.println("default method from Class: P");
//		methodPrivate();
	}
	private void methodPrivate(){
		System.out.println("private method of class: P");
	}
	
public static void main(String args[]) {
//		for printing all the values present in M
		System.out.println("Variables of Class: M from Class: P");
		System.out.println("deafault variable: "+new M().l);
		System.out.println("protected valriable: "+new M().num1);
		
//		for printing all the values present in N
		System.out.println("\nVariables of Class: N from Class: P");
		System.out.println("protected variable: "+new N().ln);
		System.out.println("public variable: "+new N().in);
		System.out.println("default variable: "+new N().dn);
		
//		calling all the methods form class: M
		System.out.println("\n");
		new M().methodPublic();
		}
}

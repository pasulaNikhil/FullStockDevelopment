package Access_Modifiers.Package_1;
public class N {
	
	  protected long ln = 54545; 
	  public int in = 4;
	  double dn = 545645;

	public void methodPublic(){     // public method
//		methodPrivate();
		System.out.println("public method from class: N");
		methodPrivate();
		methodDefault();
	}
	
	protected void methodProtected(){ 
		System.out.println("protected method from class: N");// protected method
		
	}
	
	void methodDefault(){    //default method
		System.out.println("default method from Class: N");
//		methodPrivate();
	}
	
	private void methodPrivate(){
//		System.out.println("Class N: ln " + ln);
//		System.out.println("Class N: in " + in);
//		System.out.println("Class N: dn " + dn);
		System.out.println("private method of class: N");

		
	}
}

package Access_Modifiers.Package_1;

public class M {
	
	private  int i = 2; 
	long l = 64564454; 
	protected float num1=5.5f;

	public void methodPublic(){     // public method
		System.out.println("public method from Class: M");
		methodPrivate();
		methodDefault();	
	}
	
	protected void methodProtected(){   // protected method
		System.out.println("protected method from Class: M");
	}
	
	void methodDefault(){    //default method
		System.out.println("default method from Class: M");
//		methodPrivate();
	}
	
	private void methodPrivate(){
		System.out.println ("Private Variable accessing by an Public Method: "+i);
		System.out.println("private method of class: M");	
		
	}

}

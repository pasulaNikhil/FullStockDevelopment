package package1;

public class M {

	private int y= 10;   //private variable
	long k = 1000;       // default variable
	protected float z= 33;
	
	public void methodPublic(){     // public method
		System.out.println("Class M: methodPublic");
		methodPrivate();
	}
	
	protected void methodProtected(){   // protected method
		System.out.println("Class M: methodProtected");
		methodPrivate();
	}
	
	void methodDefault(){    //default method
		System.out.println("Class M: methodDefault");
		methodPrivate();
	}
	
	private void methodPrivate(){     // private method
		System.out.println("Value of private int y: "+ y);
		System.out.println("Value of long k: "+ k);
		System.out.println("Value of float z: "+ z);
	}
}
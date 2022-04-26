package package1;

public class N {

	protected long y = 10;   //private variable
	public int k = 1000;       // public variable
	double z= 33;
	
	public void methodPublic(){     // public method
		System.out.println("Class N: methodPublic");
		methodPrivate();
	}
	
	protected void methodProtected(){   // protected method
		System.out.println("Class N: methodProtected");
		methodPrivate();
	}
	
	void methodDefault(){    //default method
		System.out.println("Class N: methodDefault");
		methodPrivate();
	}
	
	private void methodPrivate(){     // private method
		System.out.println("Value of long y: "+ y);
		System.out.println("Value of int: "+ k);
		System.out.println("Value of double: "+ z);
	}
}
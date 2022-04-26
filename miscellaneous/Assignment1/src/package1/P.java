package package1;

public class P {
	public static void main(String args[]) {
		callFromClassMN();
		 
	}

	public static void callFromClassMN() {
		System.out.println("Class P: calling");
		new M().methodPublic();
		new M().methodProtected();
		new M().methodDefault(); 
		new N().methodPublic();
		new N().methodProtected();
		new N().methodDefault();
	}

}
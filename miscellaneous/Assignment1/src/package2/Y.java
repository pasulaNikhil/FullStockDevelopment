package package2;
import package1.N;
import package1.M;
public class Y extends N {
	public static void main(String args[]) {
		new M().methodPublic();
	//	new M().methodProtected();
	//	new M().methodDefault();
		new N().methodPublic();
	//	new N().methodProtected();
	//	new N().methodDefault();
		new X().methodPublic(); 
		System.out.println("Class X: Value of default long bb: "+ new X().bb);
		System.out.println("Class X: Value of protected float pf: "+ new X().pf);
		System.out.println("Class X: Value of public char d: "+ new X().d);
		
	}
}
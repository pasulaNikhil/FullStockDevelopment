package package2;
import package1.N;
import package1.M;
import package1.P;

public class Z extends M {
	public static void main (String args[]) {
		new M().methodPublic();
	//	new M().methodProtected();
	//	new M().methodDefault();
		new N().methodPublic();
	//	new N().methodProtected();
	//	new N().methodDefault();
		new P().callFromClassMN();
		new X().methodPublic();
	}
	

}

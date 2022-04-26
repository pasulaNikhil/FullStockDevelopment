package abstractCode;

abstract class Mnc{
	abstract void m1();
	abstract void m2();
	Mnc(){}
	void meth() {}
}

abstract class Infosys extends Mnc{
	void m1() {
		System.out.println("method m1 inside Infosys");
	}
}
class Hello extends Infosys{
	@Override
	void m1() {
		System.out.println("I am inside Hello m1");
	}
	@Override
	void m2() {
		System.out.println("I am inside Hello m2");
	}
	void meth() {
		System.out.println("method inside Hello");
	}
}

public class AbstractMnc{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mnc hello = new Hello();
		hello.m1();
		hello.m2();
		hello.meth();
		Infosys info = new Hello();
		info.m1();
		info.m2();
		info.meth();	
	}
}


package Inheritance_Multilevel;

class product{
	int id = 78;
	String name = "Amul";
	void display() {
		System.out.println(id+" "+name);
	}
	
	
}
class A extends product{
	int count = 50;
	String catagory = "butter";
	void display() {
		System.out.println(id+" "+name+" "+ " "+count+" "+ catagory );
	}
}

class B extends product{
	int count = 90;
	String catagory = "Milk";
	void display() {
		System.out.println(id+" "+name+" "+ " "+count+" "+ catagory );
	}
}

class C extends product{
	int count = 56;
	String catagory = "Choco";
	void display() {
		System.out.println(id+" "+name+" "+ " "+count+" "+ catagory );
	}
}

class subA extends A{
	int price = 30;
	void totalprice() {
		int b = count * price;
		System.out.println(id+" "+name+" "+ catagory+" total price: "+b);
	}
}

class subB extends B{
	int price = 10;
	void totalprice() {
		int b = count * price;
		System.out.println(id+" "+name+" "+ catagory+" total price: "+b);
	}
}

public class Inheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		product p = new product();
		p.display();
		A a = new A();
		a.display();
		subA aa = new subA();
		aa.totalprice();
		B b = new B();
		b.display();
		subB bb = new subB();
		bb.totalprice();
		C c = new C();
		c.display();

	}

}

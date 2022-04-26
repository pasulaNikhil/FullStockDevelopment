package assignment23feb;
class product{
	int id=78;
	String name="Amul";
	void display() {
		System.out.println(id+" "+name);
	}
	
}
class A extends product{
	int count=50;
	String catagory="butter";
	void display() {
		System.out.println(id+" "+name+" "+ " "+count+" "+ catagory );
	}
}
class subA extends A{
	int price=30;
	void totalprice() {
		int tp;
		tp=count*price;
		
		System.out.println(id+" "+name+" "+ catagory+" total price: "+tp);
	}
}
class B extends product{
	int count=90;
	String catagory="Milk";
	void display() {
		System.out.println(id+" "+name+" "+ " "+count+" "+ catagory );
	}
}
class subB extends B{
	int price=10;
	void totalprice() {
		int tp;
		tp=count*price;
		
		System.out.println(id+" "+name+" "+ catagory+" total price: "+tp);
	}
}
class C extends product{
	int count=56;
	String catagory="choco";
	void display() {
		System.out.println(id+" "+name+" "+ " "+count+" "+ catagory );
	}
}
public class Assignment {

	public static void main(String[] args) {
		product p=new product();
		p.display();
		A a=new A();
		a.display();
		subA SA = new subA();
		SA.totalprice();
		B b=new B();
		b.display();
		subB SB = new subB();
		SB.totalprice();
		C c=new C();
		c.display();

	}

}

package assignment2;


class Cons{
	
	int side, len, br;
	double rad;
	
	Cons(){
		System.out.println("This is default constructor");
	}
	
	Cons(int d) {
		side = d;
		System.out.println("Area of Square: " + d*d);
	}
	Cons(int a, int b) {
		len = a;
		br = b;
		System.out.println("area of Rectangle: " + a*b);
	}
	Cons(double j) {
		rad = j;
		System.out.println("Area of Circle: " + 3.142 * j * j);
	}
	
	void square(float x)
    {
        System.out.println("the area of the square is "+Math.pow(x, 2)+" sq units");
    }
    void rect(float x, float y)
    {
        System.out.println("the area of the rectangle is "+x*y+" sq units");
    }
    void circle(double x)
    {
        double z = 3.14 * x * x;
        System.out.println("the area of the circle is "+z+" sq units");
    }
    
    void area(double d, double e) {
    	System.out.println("Area of Rhombus: " + ( d * e ) / 2);
    }
    void area(int base, int height) {
    	System.out.println("Area of Triangle: " + ( base * height ) / 2);
    }
}

public class ConstructorMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cons d = new Cons();
		Cons sq = new Cons(2);
		Cons r = new Cons(11, 12);
		Cons c = new Cons(2.5);
		Cons ob = new Cons();
		   ob.square(5);
		   ob.rect(11,12);
		   ob.circle(2.5);
		   ob.area(2.0, 4.0);
		   ob.area(2, 4);
	}

}
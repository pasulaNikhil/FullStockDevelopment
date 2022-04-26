package Constructor_Method_Overloading;

class Cons{
	
	int side, len, br;
	double rad;
	
	Cons(){
		System.out.println("This is default constructor for calculating Areas");
	}
	
	Cons(int d) {
		side = d;
	}
	Cons(int a, int b) {
		len = a;
		br = b;
	}
	Cons(double j) {
		rad = j;
	}
	
	void square(float x)
    {
        System.out.println("Area of the square: "+Math.pow(x, 2)+" sq units");
    }
    void rect(float x, float y)
    {
        System.out.println("Area of the rectangle: "+x*y+" sq units");
    }
    void circle(double x)
    {
        double z = 3.14 * x * x;
        System.out.println("Area of the circle: "+z+" sq units");
    }
    
    void area(double d, double e) {
    	System.out.println("Area of Rhombus: " + ( d * e ) / 2 + " sq units");
    }
    void area(int base, int height) {
    	System.out.println("Area of Triangle: " + ( base * height ) / 2 + " sq units");
    }
}

public class ConstructorMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cons d = new Cons();
		Cons sq = new Cons(2);
		Cons r = new Cons(11, 12);
		Cons c = new Cons(2.5);
		   sq.square(sq.side);
		   r.rect(r.br, r.len);
		   c.circle(c.rad);
		   d.area(2.0, 4.0);
		   d.area(2, 4);
	}

}

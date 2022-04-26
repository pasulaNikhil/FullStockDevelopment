package assignment1;

public class calculate {
	int cal(int x, int y)
    {
        return (x + y);
    }
	float cal(float x)
    {
        return (3.14f*x*x);
    }
	int cal (int x, long y)
    {
        return (int) (x*y);
    }
	public static void main(String args[])
    {
		calculate s = new calculate();
        System.out.println("Sum: "+s.cal(10, 20));
        System.out.println("Area of Circule: "+s.cal(10));
        System.out.println("Area of Rectangle: "+s.cal(10, 20));
    }

}

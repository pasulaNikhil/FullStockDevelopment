package Method_Overloading;

public class MethodOverloading {
	public int calculate(int a, int b, int ignore) {
		return (int) (a + b);
	}
	public float calculate(float r) {
		return (float) (3.14*r*r);
	}
	public int calculate(int a, int b) {
		return a*b;
	}
	
	public static void main(String[] args) {
		MethodOverloading m = new MethodOverloading();
		System.out.println("\nSum of two numbers: "+ m.calculate(2, 4, 0));
		System.out.println("\nArea of Circle: "+m.calculate(5));
		System.out.println("\nArea of Rectangle: "+m.calculate(4, 5));
		}
}

package q4_multitype_return;

public class MethodOverloading {
	public void area(int b,int h)
    {
         System.out.println("Area of Triangle : "+(0.5*b*h));
    }
    public void area(int r) 
    {
         System.out.println("Area of Circle : "+(3.14*r*r));
    }

    public static void main(String args[])
   {

    	MethodOverloading ob=new MethodOverloading();
       ob.area(10,12);
       ob.area(5);  
   }
}




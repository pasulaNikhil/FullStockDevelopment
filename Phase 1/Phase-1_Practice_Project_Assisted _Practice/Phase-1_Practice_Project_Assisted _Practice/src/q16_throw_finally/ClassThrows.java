package q16_throw_finally;

public class ClassThrows {
	void Division() throws ArithmeticException
    {
        int a=45,b=0,rs;
        	rs = a / b;
        System.out.print("\n\tThe result is : " + rs);
    }
     public static void main(String[] args)
    {
    	 ClassThrows T = new ClassThrows();
         try
        {
            T.Division();
        }
        catch(ArithmeticException Ex)
        {
            System.out.print("\n\tError : " + Ex.getMessage());
        }
        System.out.print("\n\tEnd of program.");
    }

}

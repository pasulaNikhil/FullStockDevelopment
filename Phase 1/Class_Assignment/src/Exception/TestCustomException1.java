package Exception;
import java.util.*;

class SalaryException extends Exception  
{  
    public SalaryException (String str)  
    {  
        // calling the constructor of parent Exception  
        super(str);  
    }  
}  
    
// class that uses custom exception SalaryException  
public class TestCustomException1  
{  
  
    // method to check the salary  
    static void validate (int salary) throws SalaryException{    
       if(salary < 2100){  
  
        // throw an object of user defined exception  
        throw new SalaryException("you need to work hard");    
    }  
       else if (salary >= 2100 && salary <= 5000) {
    	   throw new SalaryException("your salary is somehow good");
       }
       else {   
    	   throw new SalaryException("salary is very good");  
        }   
     }    
  
    // main method  
    public static void main(String args[])  
    {  
        try  
        {  
        	System.out.print("Enter the Salary: ");
        	Scanner sc= new Scanner(System.in);
        	int a = sc.nextInt();
            // calling the method   
            validate(a);  
        }  
        catch (SalaryException ex)  
        {  
            System.out.println("Caught the exception");  
    
            // printing the message from InvalidAgeException object  
            System.out.println("Exception occured: " + ex);  
        }  
  
        System.out.println("rest of the code...");    
    }  
}  
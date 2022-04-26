package Test_Method_Cons_String;
import java.util.Scanner;

class FruitJuice{
	int product_code;
	String flavour;
	String pack_type;
	int pack_size;
	int product_price;
	
//	initialization of the product details
	public FruitJuice() {
        product_code = 0;
        flavour = "";
        pack_type = "";
        pack_size = 0;
        product_price = 0;
    }
//	taking input of the products from user
    
    public void input() {
        Scanner sc = new Scanner(System.in);
  
        System.out.print("Enter The Flavour: ");
        flavour = sc.nextLine();
        
        System.out.print("Enter The Pack Type: ");
        pack_type = sc.nextLine();
        
        System.out.print("Enter The Product Code: ");
        product_code = sc.nextInt();
        
        System.out.print("Enter The Pack Size: ");
        pack_size = sc.nextInt();
        
        System.out.print("Enter The Product Price: ");
        product_price = sc.nextInt();
        
    }
//    discount on price by reducing 10 from the price
    
    public void discount() {
        product_price -= 10;
    }
    
//    displaying all the values
    
    public void display() {
        System.out.println("\nProduct Code: " + product_code);
        System.out.println("Flavour: " + flavour);
        System.out.println("Pack Type: " + pack_type);
        System.out.println("Pack Size: " + pack_size + " ml");
        System.out.println("Product Price: " + product_price+" Rs");
    }
}

public class Question_1 {

	public static void main(String[] args) {
		FruitJuice fj = new FruitJuice();
        fj.input();
        fj.discount();
        fj.display();

	}

}

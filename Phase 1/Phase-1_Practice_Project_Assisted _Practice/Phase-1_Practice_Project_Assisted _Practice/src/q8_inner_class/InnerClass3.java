package q8_inner_class;

abstract class AnonymousInnerClass {
	   public abstract void display();
	}


	public class InnerClass3 {

	public static void main(String[] args) {
	AnonymousInnerClass i = new AnonymousInnerClass() {

	         public void display() {
	            System.out.println("Anonymous Inner Class");
	         }
	      };
	      i.display();
	   }
	}
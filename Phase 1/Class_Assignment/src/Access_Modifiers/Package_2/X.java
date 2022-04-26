package Access_Modifiers.Package_2;

public class X {

	 private  int i1 = 5;
	 long l1 = 45545;
	 protected float f1 = 4.2f;
	 public char ch = 'B'; 
	 
	 public void methodPublic() {
		 methodPrivate();
	 }
	 
	 private void methodPrivate(){  
		 System.out.println(i1);
	 } 

}

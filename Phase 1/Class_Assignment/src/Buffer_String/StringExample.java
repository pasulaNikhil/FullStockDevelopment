package Buffer_String;

public class StringExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
			StringBuffer sb = new StringBuffer("Started Java "); 
			sb.append("Phase1");        //now original string is changed  
			System.out.println(sb); 
			
			sb.delete(2,5);  
			System.out.println(sb);
			
			sb.replace(5,10,"Python ");  
			System.out.println(sb);
			
			sb.insert(5,"language after word started ");     //now original string is changed  
			System.out.println(sb);
			
			sb.reverse();
			System.out.println(sb);
			
			sb.charAt(9);
			System.out.println(sb);
	}

}

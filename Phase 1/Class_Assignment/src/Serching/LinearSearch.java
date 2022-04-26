package Serching;

import java.util.Scanner;

public class LinearSearch {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		
		System.out.print("Enter key to be search from the list: ");
		System.out.println("\nSelect from this list: ");
		int[] array={10,20,30,40,50,60,70,80,90,100};
		
		for (int element: array) {
            System.out.println(element);
        }
		
        int key=sc.nextInt();
		for(int i=0;i<array.length;i++){
			
			if(array[i] == key){
				System.out.println("element found at position: "+i);
			}
			
		}

	}

}
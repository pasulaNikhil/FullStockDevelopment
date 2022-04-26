package Collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public class LinkedList1 {
    public static void main(String a[]){
 
        LinkedList<String> ll = new LinkedList<String>();
        
        ll.add("May");
        ll.add("June");
        ll.add("July");
        ll.add("August");
        ll.add("April"); 
        ll.add("November");
        
        
        ll.addLast("December");        
        ll.addFirst("January");
        ll.add(1, "February");
        ll.add(2, "March");
        ll.add(8, "September");
        ll.add(9, "October");
        ll.add(3, "April");
        ll.remove(8);
//        ll.remove(3);
        
//        System.out.println(ll);          
        
        Iterator itr=ll.iterator();
        while(itr.hasNext()) { 
        System.out.println(itr.next());
        }
        
        int temp_val = 0;
        
        // using a for-each loop to
          // iterate through the list
        System.out.print("\nElements at even position are : ");
        for (String ss : ll) {
            if (temp_val % 2 != 0) {
                System.out.print(ss + " ");
            }
            temp_val += 1;
        }
        System.out.print("\nElements at odd position are : ");
      
        for (String sss : ll) {
            if (temp_val % 2 == 0) {
                System.out.print(sss + " ");
            }
            temp_val += 1;
        }
        
        System.out.println("\n");
        System.out.println("\nSize of the linked list: "+ll.size());
        System.out.println("\nIs LinkedList empty? "+ll.isEmpty());
        System.out.println("\nDoes LinkedList contains 'November'? "+ll.contains("September"));
        System.out.println("\nMy birth month removed: "+ll.get(3));
        ll.remove(3);
        System.out.println(ll);
        System.out.println("\nAfter fetching first and last month using peek: " + ll.peekFirst()+" "+ll.peekLast());
        ll.pollFirst();
        ll.pollLast();
        System.out.println("\nAfter removing first and last month using poll: ");
        System.out.println(ll);
    }
}
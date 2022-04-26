package Collection;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapDemo {
	
  public static void main(String[] args) {
        
	    Map<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>();
        
        linkedHashMap.put(1, new String("Banana"));
        linkedHashMap.put(2, new String("Orange"));
        linkedHashMap.put(3, new String("Cucumber"));
        linkedHashMap.put(4, new String("Mango"));
        linkedHashMap.put(5, new String("Carrot"));
        linkedHashMap.put(6, new String("Apple"));
        linkedHashMap.put(7, new String("Guave"));
        linkedHashMap.put(8, new String("Pineapple"));
        linkedHashMap.put(9, new String("Strawberry"));
        linkedHashMap.put(10, new String("Lichi"));
        int hash = linkedHashMap.hashCode();
//        print map
        System.out.println("Contents of LinkedHashMap : " + linkedHashMap);
        System.out.println("\nValues of map after iterating over it : ");
        
      
        System.out.println("The HashCode is: " + hash);
        //        all key-value pair
        for (Integer key : linkedHashMap.keySet()) {
            System.out.println(key + ":\t" + linkedHashMap.get(key));
        }
        System.out.println("\nRemove entry for value carrot : " + linkedHashMap.remove(5));
        System.out.println("Content of LinkedHashMap after removing key 5: " + linkedHashMap);
        System.out.println("\nThe size of the LinkedHashMap is : " + linkedHashMap.size());
        System.out.println("\nIs LinkedHashMap empty? : " + linkedHashMap.isEmpty());
        System.out.println("\nLinkedHashMap contains 2 as key? : " + linkedHashMap.containsKey(2));
        System.out.println("LinkedHashMap contains Orange as value? : " + linkedHashMap.containsValue("Banana"));
        System.out.println("LinkedHashMap contains Apple as value? : " + linkedHashMap.containsValue("Apple"));
        System.out.println("\nContent of LinkedHashMap after removing key 2: " + linkedHashMap);
        System.out.println("Removing first and last month using peek: ");
        System.out.println("The HashCode is: " + hash);
        linkedHashMap.clear();
        System.out.println("\nContent of LinkedHashMap after clearing: " + linkedHashMap);
    }
}
package Serching;

import java.util.Stack;  
public class StackOperation   
{  
public static void main(String[] args)   
{  
Stack<String> stk= new Stack<>();  
// pushing elements into Stack  
stk.push("India");  
stk.push("US");  
stk.push("Japan");  
stk.push("Taiwan");
stk.push("Asia");  
stk.push("Pakistan");  
stk.push("Bhutan");  
stk.push("China");  
stk.push("UK");  
stk.push("Nagaland");  

System.out.println("Stack: " + stk);  
// Access element from the top of the stack  
String country = stk.peek();  
//prints stack  
System.out.println("Removing three elements: ");
stk.pop();
stk.pop();
stk.pop();
System.out.println("Stack: " + stk);  
System.out.println("Adding three fruits");
stk.push("Apple");  
stk.push("Peer");  
stk.push("Orange");
System.out.println("Peeking the stack: " + stk);
System.out.println("4 time pop operation done !");
stk.pop();
stk.pop();
stk.pop();
stk.pop();
int location = stk.search("India");
int location1 = stk.search("Canada"); 
System.out.println("found india in pos: "+location);
System.out.println("found canada in pos: "+location1);
} 

}
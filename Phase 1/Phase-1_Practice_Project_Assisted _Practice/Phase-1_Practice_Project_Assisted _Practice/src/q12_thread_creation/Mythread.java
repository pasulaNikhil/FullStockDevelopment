package q12_thread_creation;

public class Mythread extends Thread
{
 	public void run()
 	{
  		System.out.println("concurrent thread started running..");
}
 	public static void main( String args[] )
 	{
  		Mythread mt = new  Mythread();
  		mt.start();
 	}
}

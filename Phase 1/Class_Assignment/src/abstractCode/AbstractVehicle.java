package abstractCode;
abstract class Vehicle{
	
	int speed = 3;
	long distance = 300;
	
	abstract void run();
	abstract void stop();
	public void fuel(int a) {}
	public void fuel(float b, String s) {}
	public void fuel(char ch, int c) {System.out.println("Hello");}
	Vehicle(){}
    Vehicle(int s, long d){}
    
    public void display(int a, long s) {
    	System.out.println(speed + distance);
    }
}  

    class W2 extends Vehicle{
    	int speed2, nos_of_tyre = 2;
    	long distance2;
    	W2(){}
    	@Override
    	void run() {
    		System.out.println("inside the run method W2");
    	}
    	@Override
    	void stop() {
    		System.out.println("inside the stop method W2");
    	}
    	
    	public void display(int speed2, long distance2) {
    		this.speed2 = speed2;
    		this.distance2 = distance2;
    		System.out.println(speed2+" m/s, no.of tyre: "+nos_of_tyre+", "+distance2+" km, "+super.speed+" m/s, "+super.distance+" km");
    	}	
    	
    }
    class W3 extends Vehicle{
    	int speed3, nos_of_tyre = 3;
    	long distance3;
    	W3(){}
    	@Override
    	void run() {
    		System.out.println("\ninside the run method W3");
    	}
    	@Override
    	void stop() {
    		System.out.println("inside the stop method W3");
    	}
        public void display(int speed3, long distance3) {
        	this.speed3 = speed3;
    		this.distance3 = distance3;
    		System.out.println(speed3+" m/s, no.of tyre: "+nos_of_tyre+", "+distance3+" km, "+super.speed+" m/s, "+super.distance+" km");
    	}    	
    }
    
    class W4 extends Vehicle{
    	int speed4 = 8, nos_of_tyre = 4;
    	long distance4 = 400;
    	W4(){
    	}
    	@Override
    	void run() {
    		System.out.println("\ninside the run method W4");
    	}
    	@Override
    	void stop() {
    		System.out.println("inside the stop method W4");
    	}
    	public void display(int speed4, long distance4) {
    		this.speed4 = speed4;
    		this.distance4 = distance4;
    		System.out.println(speed4+" m/s, no.of tyre: "+nos_of_tyre+", "+distance4+" km, "+super.speed+" m/s, "+super.distance+" km");
    	}
    }
    
    class W8 extends Vehicle{
    	int speed5, nos_of_tyre = 8;
    	long distance5;
    	W8(){
    	}
    	@Override
    	void run() {
    		System.out.println("\ninside the run method W8");
    	}
    	@Override
    	void stop() {
    		System.out.println("inside the stop method W8");
    	}
    	public void display(int speed5, long distance5) {
    		this.speed5 = speed5;
    		this.distance5 = distance5;
    		System.out.println(speed5+" m/s, no.of tyre: "+nos_of_tyre+", "+distance5+" km, "+super.speed+" m/s, "+super.distance+" km");
    	}
    }

public class AbstractVehicle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehicle w2 = new W2();
		w2.run();
		w2.stop();
	    w2.display(4, 300);
		Vehicle w3 = new W3();
		w3.run();
		w3.stop();
	    w3.display(5, 400);
		Vehicle w4 = new W4();
		w4.run();
		w4.stop();
	    w4.display(9, 789);
		Vehicle w8 = new W8();
		w8.run();
		w8.stop();
	    w8.display(5, 456);
	}
}

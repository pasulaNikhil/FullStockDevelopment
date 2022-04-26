package package2;

class X{
	private  int aa= 159;
	long bb = 254;
	protected float pf = 543.33f;
	public char d = 'X';
	public void methodPublic(){     // public method
		methodPrivate();
	}
	private void methodPrivate() {
		System.out.println("Class X: Value of private  int aa: "+ aa);
	}
}
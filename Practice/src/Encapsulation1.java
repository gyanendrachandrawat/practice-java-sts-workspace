
public class Encapsulation1 {
	public int aa1=10;
	private int b=20;
	protected int c=30;
	int d=40;
	private int e;
	public void setMethod(int setNum) {
		e=setNum;
	}
	public int getMethod() {
		return e;
	}	
	public static void main(String[] args) {
		Encapsulation1 obj1=new Encapsulation1();
		System.out.println("IN SAME CLASS Encapsulation1 public int a="+obj1.aa1);
		System.out.println("IN SAME CLASS Encapsulation1 private int b="+obj1.b);
		System.out.println("IN SAME CLASS Encapsulation1 protected int c="+obj1.c);
		System.out.println("IN SAME CLASS Encapsulation1 int d="+obj1.d);
	}
}
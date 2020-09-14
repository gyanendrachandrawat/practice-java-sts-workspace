package other;
public class Encapsulation2 extends Encapsulation1{
	public static void main(String[] args) {
		Encapsulation2 obj2=new Encapsulation2();
		obj2.setMethod(50);
		int x=obj2.getMethod();
		System.out.println("IN CHILD CLASS Encapsulation2 public int a="+obj2.aa1);
		//System.out.println("IN CHILD CLASS Encapsulation2 private int b="+obj2.b);
		System.out.println("IN CHILD CLASS Encapsulation2 protected int c="+obj2.c);
		System.out.println("IN CHILD CLASS Encapsulation2 int d="+obj2.d);
		System.out.println("(by getter/setter)IN CHILD CLASS Encapsulation2 private int e="+x);
	}
}
class Overloading1{
	void print(int a, double b) {
		System.out.println("2 parameters(int,double) x="+ a +" y="+ b);
	}
	Overloading1(){
		System.out.println("Overloading1() Constructor");
	}
	Overloading1(int c){
		System.out.println("Overloading1(int c) Constructor c="+c );
	}
}

class Overloading2 extends Overloading1{
	void print(int x) {
		System.out.println("1 parameter(int) x="+ x);
	}
	int print(double x) {
		System.out.println("1 parameter(double) x="+ x);
		return 0;
	}
}

public class OverloadingInheritance {
	public static void main(String[] args) {
		Overloading2 obj=new Overloading2();
		obj.print(5);
		obj.print(5.6);
		obj.print(6, 7.4);
		Overloading1 obj2=new Overloading1();
		Overloading1 obj3=new Overloading1(5);
	}
}
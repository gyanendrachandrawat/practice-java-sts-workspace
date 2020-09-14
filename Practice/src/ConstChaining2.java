
public class ConstChaining2 {
	ConstChaining2(){
		this(5);
		System.out.println("in ConstChaining2()");
	}
	ConstChaining2(int x){
		this(6,7);
		System.out.println("in ConstChaining2(int x)");
		System.out.println("x="+x);
	}
	ConstChaining2(int a, int b){
		System.out.println("in ConstChaining2(int a, int b)");
		System.out.println("a="+a +" b="+b);
	}
	public static void main(String[] args) {
		ConstChaining2 obj=new ConstChaining2();
	}

}

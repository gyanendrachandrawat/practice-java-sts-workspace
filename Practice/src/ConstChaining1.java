class Const1A{
	Const1A(){
		System.out.println("in Parent");
	}
}
class Const1B extends Const1A{
	Const1B(){
		System.out.println("in Child");
	}
}
public class ConstChaining1 {
	ConstChaining1(){
		System.out.println("ConstChaining1");
	}
	public static void main(String[] args) {
		ConstChaining1 obj=new ConstChaining1();
		Const1B obj1=new Const1B();
	}
}

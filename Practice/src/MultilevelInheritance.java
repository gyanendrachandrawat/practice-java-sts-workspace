class A1{
	String name="ClassA";
	void print(){
		System.out.println("Hello from class A");
	}
}
class B1 extends A1{
	int number(int x, int y){
		System.out.println("a+b="+(x+y));
		return 0;
	}
}
public class MultilevelInheritance extends B1{
	int a=3;
	int b=4;
	public static void main(String[] args) {
		MultilevelInheritance obj=new MultilevelInheritance();
		obj.print();
		obj.number(obj.a,obj.b);
		System.out.println("name of parent class="+obj.name);
	}
}

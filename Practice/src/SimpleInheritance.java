class A{
	String name="ClassA";
	void print(){
		System.out.println("Hello from class A");
	}
	int number(int x, int y){
		System.out.println("a+b="+(x+y));
		return 0;
	}
}
class SimpleInheritance extends A{
	int a=3;
	int b=4;
	public static void main(String args[]) {
		SimpleInheritance obj=new SimpleInheritance();
		obj.print();
		obj.number(obj.a, obj.b);
		System.out.println("name of parent class="+obj.name);
	}
}

class ConstChainingX{
	ConstChainingX(){
		System.out.println("ConstChainingX()");
	}
}
class ConstChainingY extends ConstChainingX{
	ConstChainingY(){
		super();
		System.out.println("ConstChainingY()");
	}
}
class ConstChainingZ extends ConstChainingY{
	ConstChainingZ(){
		super();
		System.out.print("ConstChainingZ()");
	}
}
public class ConstChaining3 {

	public static void main(String[] args) {
		ConstChainingZ obj=new ConstChainingZ();
	}

}


public class Flip {

	public static void main(String[] args) {
		int num1 = 0000;
		int num2 = 0;
		int div = 1000;
		int mlt = 1;
		for (int i = 0; i < 4; i++) {
		int temp = num1%div;
		if(temp==0) {
			temp = 1;
		}
		if(temp==1) {
			temp = 0;
		}
		
		num2 = 
		mlt = mlt*10;
		div = div/10;
		num1=num1/10;
		}
System.out.println(num2);
	}

}
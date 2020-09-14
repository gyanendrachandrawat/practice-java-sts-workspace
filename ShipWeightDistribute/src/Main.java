import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Solution s=new Solution();
		int n;
		System.out.println("Enter number of ships=");
		n=sc.nextInt();
		int[]w=new int[n];
		System.out.println("enter weights=");
		for(int i=0;i<n;i++){
			w[i]=sc.nextInt();
		}		
		s.solution(n, w);
	}
}
class Solution{
	int solution(int n, int[]w){
		float sum=0;
		int move=0;
		for(int k=0;k<n;k++){
			int y=w[k];
			sum=sum+y;
		}
		System.out.println("total weight="+sum);
		float eq_weight=sum/n;		
		if(eq_weight==(int)eq_weight){
			int eqWeight=(int)eq_weight;			
			for(int j=0;j<n;j++){
				int eq=w[j];				
				while(eq<eqWeight){
					int x=eqWeight-eq;
					move=move+x;
				}				
			}
			return move;
		}
		else{
			return -1;
		}
	}		
}
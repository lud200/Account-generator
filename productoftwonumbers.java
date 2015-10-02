package AccountGenerator;

public class productoftwonumbers {
	public static void main(String[] args){
		System.out.print("4*3=");
		System.out.print(multiply(4, 3));
	}
	
	public static int multiply(int a , int b){
		
		if(b>0){
			return a+multiply(a, b-1);
		}
		else{
			return 0;
		}
		
	}
}

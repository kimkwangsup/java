package day03;

/*
 	문제 4 ]
 		3자리 숫자를 랜덤하게 발생시켜서
 		백자리 미만은 버리는 백단위 숫자를 만들고
 		출력하세요.
 */
public class Ex04 {
	public static void main(String[] args) {
		/*
		 int no = (int)(Math.random() * (999 - 100 + 1) + 100);
		 
		
		int num = 100 * (no / 100);
		
		
		System.out.println("랜덤 3자리 숫자 : " + no);
		System.out.println("백자리 미만은 버리는 백단위 : " + num);
	*/
	
	int no = (int)(Math.random() * (999 - 100 + 1) + 100);
	
	int result = no - ( no % 100 );
	
	System.out.println(no + " 의 100 단위 숫자 : " + result);
	
	
	
	}

}

package day07;


public class Test03_localVariable {
	/*
	지역변수(local Variable)
	==> 변수 중 생성된 지역에서만 사용할 수 있는 변수
	
		함수 내에서 생성된변수는 Stack 에 만들어진다.
		이 영역은 크기가 작은 영역으로 배정받는다.
		따라서 데이터를 지속적으로 기억하기에는 힘들다.
		
		해결방법은 
			1. 변수를 만들어 달라고 요청하는 순간 변수를 만든다.
			2. 변수가 만들어진 영역({})을 벗어나면 자동 소멸시킨다.
			
	주의 ]
		for 명령의 카운터변수는 (for(int i = 0 ; i < 10 ; i++) {} 에서 변수 i)
		해당 for 명령에서만 사용할 수 있는 지역변수이다.
		따라서 해당 for 명령의 블럭({})이 끝나는 순간 사라지는 변수이다.
		
	-------------------------------------------------------------------------------	
	
	반복문도 조건문과 같이 중첩해서 사용할 수 있다.
	**
	이때 안쪽에 있는 반복문은 감싸고 있는 반복문이 반복진행하면
	처음부터 다시 실행되게 해주는 것이 일반적이다.
	
	for 명령의 경우는 자동초기화가 문법적으로 이루어진다.
	
		for(int i = 0 ; i < 10 ; i++){
			for(int j = 0 ; j < 10 ; j++){
				처리내용...
			}
		}
		
	-------------------------------------------------------------------------------
	
	flag 기법
		==> 우리가 프로그램을 실행하다 보면
			두가지 이상의 경우가 발생되는 순간이 있다.
			실행이 끝난 후 그 경우를 알아내는 기법.
			
			예 ]
				for(;;){
					if(조건){
						break;
					}
				}
				
				이때 for 반복문이 모두 제대로 실행되어서 종료되었는지
				아니면 중간에 특정조건을 만나서 종료되었는지 알아내는 방법.
				
			방법 ]
				위의 경우는 반복문이 시작되기 전에 변수를
				가상의 데이터로 입력해서 생성 & 초기화 해둔다.
				특정 조건에 만족하는 경우는 그 변수의 데이터를 변경한다.
				(break 직전에 다른 데이터로 교체해둔다.)
				
				예 ] 
					boolean flag = false;
					for(int i = 0 ; i < 10 ; i++){
						if(조건식){
							flag = true;
							break;
						}
					}
				
					위의 반복문이 종료된 후에는
					반복문이 모두 실행되었는지
					아니면 중간에 조건을 만나서 멈췄는지는
					변수 flag 의 내용을 보면 알수 있게 된다.
			
	*/
	
		// flag 기법
		
		/*
			정해진 문자열이 순수하게 숫자로 구성되었는지
			중간에 다른 문자가 포함되어있는지 알아보세요.
			
			힌트 ]
				charAt() : 문자열중 해당 위치의 문자를 추출해주는 함수.
 		 */

	public static void main(String[] args) {
		String str = "1O301";
			
		// 결과 변수
		boolean result = false;		
		for(int i = 0 ; i < str.length() ; i++) {
			char ch = str.charAt(i);
			if(ch < '0' || ch > '9') {
				// 이 경우는 숫자 형태가 아닌 문자가 포함되어 있는 경우
				result = true;	// 결과값 변수 변경
				break;	// 더이상 검사작업이 불필요하므로 검사를 종료한다.
			}
		}
		if(result == true) {
			// 중간에 숫자 형태가 아닌 문자가 포함된 경우
			System.out.printf("[%s] 문자열은 숫자가 아닌 문자가 포함되어 있습니다.", str);
		} else {
			// 숫자만으로 이루어진 경우
			System.out.printf("[%s] 문자열은 숫자형태의 문자들로 이루어 있습니다..", str);
		}
	}
}
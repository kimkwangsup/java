package day14;

import java.util.Arrays;

/*
 	인터페이스
	==> 클래스의 한 종류이긴 하지만
		약간은 그 형태나 의미가 지금까지의 클래스와는 다른
		특수한 클래스
		
		1. 최상위 클래스가 Object 클래스가 아니다.
			==> 인터페이스는 다릌 클래스를 상속받아서 만들어진 클래스가 아니다.
		2. 내부에 100% 추상함수가 존재한다.
			==> 원칙은 일반함수(기능이 구현된 함수)는 존재하면 안된다.
			
			참고 ]
				추상함수
				==> abstract 속성을 하지 않아도 인터페이스 내에서는
					자동적으로 몸체가 존재하지 않는 추상함수가 된다.
					
		3. 인터페이스는 다른 클래스에 상속할 수 있다.
		 	이때 다중 상속이 가능하다.
		
		4. 변수는 가질 수 있다.
			문제는 이 변수는 묵시적으로 public static final 변수가 된다.
 		
 		5. 인터페이스 소속 함수는 묵시적으로 public 함수가 된다.
 	
 		==> 2 + 5
 			인터페이스 소속 함수는 묵시적으로
 				public abstract 가 생략된 함수 형태로 작성될 수 있다.

		만드는 방법 ]
			
			[접근지정자] Interface 인터페이스 이름 {
				변수   ==> public static final 변수
				함수() ==> public abstract 추상함수
			}
			
		참고 ]
			
			final 속성
			==> 클래스, 함수, 변수에 붙여질 수 있는 속성
			
				클래스
				==> 더 이상 상속해 줄 수 없는 클래스
				
				함수
				==> 더 이상 오버라이딩 할 수 없는 함수
				
				변수
				==> 더 이상 데이터를 수정할 수 없는 변수
				
	왜 인터페이스 만들었을까?
	==> 가끔은 JVM에 의해서 자동 호출되어야 하는 함수가 필요하다.
		
		따라서 함수의 존재는 필요하다.
		
		하지만, 가끔은 해당 함수가 해야할 일은 개발자의 몫인 경우가 있다.
		
		따라서 기능은 개발자의 몫으로 남겨놓은 것이다.
		
		참고 ]
			자바에서 이벤트를 처리하는 순서
				1. 사용자가 버튼을 클릭하면 이벤트가 발생한다.
					이 이벤트는 운영체제가 인지하게 된다.
				2. 운영체제는 자신이 인지한 이벤트가 발생한
					프로그램을 구분하여 그 프로그램을 담당하는
					플랫폼(JVM)에게 알려준다.
				3. JVM은 통보받은 이벤트의 정보를 분석하여
					그 정보에 합당한 함수를 호출하여 이벤트 처리를 한다.
					==> 정보에 합당한 함수를 호출한다는 것에 큰 의미가 있다.
						결국 함수가 있어야 한다.
					==> 이벤트가 발생하면 무엇을 처리할지는 JVM이
						결정하게 된다.
						
	인터페이스 사용하기
	
		1. 인터페이스는 스스로 new 되지 못한다.
			이유는 추상클래스와 마찬가지고
			인터페이스 소속 함수는 기능이 없기 때문에 new 시킬 수 없다.
			따라서
			일반클래스에 상속해준다.
			
			상속 방법 ]
				class 클래스이름 implements 인터페이스 {
					추상함수 오버라이딩...
				}
				
				==> 클래스는 "상속" 이라고 표현하고
					인터페이스는 "구현" 이라고 표현한다.
						
	참고 ]
		클래스의 상속은 단일 상속만 가능한 반면
		인터페이스는 다중 상속이 가능하다.
		
		형식 ]
			class 클래스이름 implements 인터페이스1, 인터페이스2, ...{
				모든 추상함수 오버라이딩
			}
			
	참고 ]
		클래스의 상속과 함께 상속할 수 있다.
		
		형식 ]
			class 클래스이름 extends 상속할클래스 implements 인터페이스1, 인터페이스2,...{
				모든 추상함수 오버라이딩....
			
			}
	
		주의 ]
			반드시 클래스 상속(extends)이 먼저 와야하고
			인터페이스 구현(implements)이 나중에 와야 한다.

-----------------------------------------------------------------------------------------------------------------

	참고 ]
		인터페이스를 상속받아서 인터페이스를 만들 수 있다.

		형식 ]
			interface 인터페이스이름 extends 상속해줄인터페이스 {
				물려받은 추상함수
				+
				내가만든 추상함수
			}
			
	***		
	참고 ]
		인터페이스 내에도 일반 함수(몸체가 있는 함수)가 올 수 있다.
		이 경우는 반드시 함수의 속성에 default 라고 밝혀줘야 한다.
		
		형식 ]
			default 함수이름([매개변수리스트]){
				실행내용
			
		

*/
public class Test01_Interface {
	public Test01_Interface() {
		// Figure를 상속받은 클래스 Nemo, Semo 10개를 기억한 배열 fig를 만들어 랜덤하게 채워보자
		Figure[] fig = new Figure[10];
		for(int i = 0 ; i < 10 ; i++) {
			// 랜덤하게 형태를 결정하고
			int type = (int)(Math.random() * 4 + 1);
			// 가로 세로 랜덤하게 생성
			int width = (int)(Math.random() * 20 + 1);
			int height = (int)(Math.random() * 20 + 1);
			fig[i] = type == 3 ? new Semo(width, height) : new Nemo(width, height);
			// 아직 Nemo의 area가 셋팅이 안됐으므로 셋팅해준다.
			fig[i].setArea();
		}
		//출력
		
		for(Figure f : fig) {
			System.out.println(f);
		}
		
		
		
	}

	public static void main(String[] args) {
		new Test01_Interface();
	}

}
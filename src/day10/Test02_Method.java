package day10;

/*
	두 정수를 입력받아서 더한 값을 반환해주는 함수 sum을 제작해서
	랜덤하게 두 수를 입력해서 더한 결과를 출력하세요.
 */
public class Test02_Method {
	int hap;
/*
	함수를 제작하는 위치는 클래스 블럭 아래에서만 만들 수 있다.
	
	참고 ]
		함수를 만드는 이유
		: 프로그램을 만들다 보면 여러 행의 코드가 반복적으로 사용되어야 될 때가 생긴다.
		  반복되는 이 코드를 하나로 묶어서 실행할 수 있다면 편리해질 것이다.
		  이것이 함수다.
 */
	// 여기서 함수를 만들어도 되고
	public int sum(int no1, int no2) {
		hap = no1 + no2;
		return hap;
	}
	public int sum(int no1, int no2, int hap) {
		this.hap = no1 + no2;
		return hap;
	}
/*
 	기억해야 할 메모리 영역
 	8가지 중
 		stack
 		Heap
 		리터럴 풀
 		static
 		
--------------------------------------------------------------------------------------------

	static 속성
	==> static 영역에 생기는 함수나 변수를 의미한다.
	
		참고 ]
			클래스, 함수, 변수를 만들 때 속성을 지정할 수 있다.
				
				클래스 : [접근지정자] [속성] class 클래스이름 {}
				함수   : [접근지정자] [속성] 반환값타입 함수이름(매개변수리스트) {}
				변수   : [접근지정자] [속성] 데이터타입 변수이름[ = 데이터];
				
	Static 영역의 특징
		1. 프로그램이 실행되기 위해서 JVM이 로딩 되는 순간 확보되는 영역이다.
		   즉, 사용자가 특별히 만들어 달라고 요구하지 않아도 자동적으로 확보되는 영역이다.
		   
		2. 한번 생긴 변수나 함수는 두번 다시 생기지 않는다.
		
	Static 변수
		==> Static 영역에 생기는 변수
			
			형식 ]
				[접근지정자] static 데이터타입 변수이름 = 데이터;
				
			특징 ]
				1. 여러 객체(Object)가 공동으로 사용하는 변수가 된다.
				   ==> 객체를 100개 만들어도
				   	   static 변수는 오직 한개만 올려지기 때문에...
				   
				   따라서 한 오브젝트가 변수의 내용을 바꾸면
				   다른 오브젝트에서도 변경된 내용을 사용해야 한다.
				   ==> public static final 데이터타입 변수이름 = 데이터;
				   
				   그래서 결국 static 변수는 객체의 주소의 의미가 없다.
				   그리고 객체가 없어도 사용할 수 있다.
				   
				2. new 시키지 않아도 사용할 수 있는 변수이다.
				   ==> 이미 메모리에 올려져 있기 때문에...
				   
			사용방법 ]
				클래스이름.변수이름
				
	Static 함수
		==> 변수와 마찬가지로 미리 static 영역에 올려지는 함수
			따라서 객체로 만들어지지 않아도 사용할 수 있는 함수이다.
			
			사용방법 ]
				클래스이름.함수이름([데이터...]);
				
				
				
	*****
	Static 함수 내에서는 
	메모리에 올려져 있는 멤버들만 사용할 수 있다.
	
	*****
	static 함수 내에서는 this 를 사용할 수 없다.
	
--------------------------------------------------------------------------------------------

	this
	==> 현재 실행중인 개체의 주소를 기억하는 약속된 변수
	
		JVM이 클래스를 처리하기 위해서 JVM이 사용하는 변수
		개발자는 거의 사용하지 않는다.
		
		규칙 ]
			1. 모든 멤버는 사용할 때 앞에 주소가 있어야 한다.
			   멤버는 클래스 안에 만들어진 변수, 함수를 말한다.
			   
			   따라서 new를 시킨 후 그 주소를 기억시켜 놓았다가
			   그 주소를 이용해서 사용하게 된다.
			   
			2. 만약 주소가 없으면 JVM이 자동적으로 this를 붙여준다.
			
			3. 멤버 함수를 호출할 때는 무조건 주소값을 함수에게 알려주도록 약속했고
			   함수는 this 변수를 준비한 후 
			   함수를 호출할 때 알려준 주소를 기억하게 된다.
	
	참고 ]
		this 를 개발자가 사용해야 하는 경우
		==>	가끔은 지역변수와 전역변수가 이름이 동일한 경우
			함수는 지역변수를 우선 사용하게 된다.
			이렇게 하면 전역변수에는 데이터가 기억되지 않을 수 있다.
			
			이 때 
			이 변수가 멤버변수임을 
			꼭 밝혀야 하는 경우
			강제로 변수 앞에 소속을 밝혀준느 의미로
			"this." 을 붙여주면 된다.
 */
	
	public static void main(String[] args) {
		// 여기서는 함수 만들면 안된다.
//		 sum(10, 9);	
		
		// A 를 메모리에 올려서 사용 가능한 것으로 만든다
//		A a = new A();
//		System.out.println("A.CODE1 : " + a.CODE1);
		
//		System.out.println("A.CODE1 : " + A.CODE1);
		
		Test02_Method t1 = new Test02_Method();
		System.out.println(t1.sum(1, 879, 100));
		System.out.println(t1.hap);
		
		
	}
	
	// 여기서 함수 만들어도 된다.

}

class A{
	public static final int CODE1 = 1011;
	/*
		 변수 형식 ]
		 	[접근지정자] [속성] 데이터타입 변수이름;
		 	
		 	==> 
		 		public	: 접근지정자
		 		final	: 속성
		 		int		: 데이터타입
		 		CODE1	: 변수이름
	 */
}
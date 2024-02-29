package day09;

public class Circle {
	// 이 클래스는 원의 정보를 기억하는 클래스
	/*
	 	VO 클래스를 제작할 때 원칙은
	 	변수를 은닉화 하는것이 원칙이나
	 	당분간은 은닉화 하지 않고 사용하는 것으로 한다.
	 	
	 	참고 ]
	 		함수 : 프로그램의 최소 단위
	 			   특정 기능을 코드화 한 것
	 			   엄밀히 따지면 자바에서의 함수는 Method 라 불러야 하지만
	 			   자바에서는 클래스 밖에 Method 가 존재할 수 없으므로
	 			   함수라 칭한다.
	 			   
	 			   자바에서는 프로그램 제작의 기본 단위가 클래스이기 때문에...
	 			   
	 			형식 ]
	 			
	 				[접근지정자] [속성]  반환값타입  함수이름([ 매개변수리스트 ]) {
	 					실행 내용...
	 				}
	 				
	 				참고 ]
	 					당분간은 함수의 접근지정자는 public 으로 사용하기로 한다.
	 					
	 	-------------------------------------------------------------------------------------
	 		***
	 		생성자 함수
	 			:	클래스가 실행되기 위해서는
	 				클래스의 내용이 메모리에 올려져야 실행될 수 있다.
	 				이때 메모리에 클래스의 내용을 올려주는 명령이
	 				new 라는 명령이다.
	 				그런데 이때 new 라는 명령에 의해서 만들어진 것은
	 				Heap 영역에 기록되고
	 				이때 기록된 것의 주소를 모르면 사용할 수 없게 된다.
	 				이것을 사용하려면 만들어진 것(Instance)의 주소를 기억해야 하는데
	 				기억하는 것을 담당하는 것이 변수(Reference)이다.
	 				
	 				그런데 Heap 영역에 올려지는 것들은 
	 				자동 초기화가 된다.
	 				기본 데이터타입의 변수들은 모두 0, 0.0, false 로 초기화 되고
	 				참조형 타입의 경우는 null 로 초기화가 된다.
	 				
	 				그런데 지금 이 클래스처럼
	 				객체가 만들어지는 순간 특정한 작업이 이미 처리되어야 하는 경우도 있다.
	 				이 클래스의 예를 들자면 반지름 세팅과 같은 작업...
	 				
	 				이처럼 클래스가 객체가 되는 순간 해줘야 하는 작업들을 실행해준느 함수가
	 				생성자 함수이다.
	 				주로 하는 것들이 변수의 초기화, 목적에 따라서 기본적으로 준비해야 하는 작업들을
	 				해주는 역할을 담당한다.
	 				
	 			형식 ]
	 			
	 				public 클래스이름() {} ==> 기본 생성자
	 				==> 기본 생성자는 정의하지 않으면 JVM(자바가상머신)이 만들어서 호출해준다.
	 					그런데 생성자를 하나라도 만들게 되면 자바가상머신은 만드는 작업을 하지 않는다.
	 					따라서 습관적으로 기본생성자는 내용이 없더라도 작성하는 습관을 가진다.
	 					
	 					생성자는 반환값 타입을 적지 않는다.
	 					반환값이 없더라도 적지 않는 것이 원칙이다.
	 					
	 					생성자는 일반적인 함수처럼 호출할 수 없다.
	 					반드시 new 라는 명령과 함께 호출할 수 있다.
	 					
	 				public 클래스이름(매개변수리스트){
	 					실행내용...
	 				}
	 				
	 				참고 ]
	 					this : 현재 실행중인 객체 자기자신의 주소를 기억하고 있는 약속된 변수
	 */
	
	// 반지름 기억할 변수
	int rad;
	// 둘레 기억할 변수
	double arround;
	// 넓이 기억할 변수
	double area;
	
	public Circle() {}
	
	public Circle(int rad) {
		this.rad = rad;
		setArround();
		setArea();
	}
	
	// 기능들
	
	// 둘레 계산해서 세팅해주는 기능
	public void setArround() {
		// 계산에 필요한 반지름은 이미 세팅이 되어있으므로
		// 반지름을 입력받을 필요는 없다.
		arround = 2 * 3.14 * rad;
	}
	// 면적 계산해서 세팅해주는 기능
	public void setArea() {
		area = rad * rad * 3.14;
	}
}
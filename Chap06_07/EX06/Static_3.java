package chap06_07.Ex06;

//정적 초기화 블록 : 생성자와 같이 static 필드의 값을 호출시 초기화 하는 역할

//생성자와 static 블락 :
	// -생성자 : 인스턴스 필드를 초기화, 정적 필드의 값도 초기화
	// -static 블락 : static 필드의 값을 초기화, 인스턴스 필드의 값은 초기화 할수 없다.


class E {
	
	int a;
	static int b;		//객체 생성 없이도 호출
	
	static {	//정적(static) 초기화 블록 : 객체 생성 없이 클래스 명으로 호출할때 초기화
	//	a=3;	//오류가 발생, 인스턴스 필드는 초기화 할수 없다. (static만)
		b=5; 
		System.out.println("클래스 E가 로딩 되었습니다. 변수 b : " + b);
	}
	
	E() {			//생성자 : 객체화를 할때 필드의 값을 초기화 
		a = 3;		//인스턴스 필드  초기화
		b = 10;		//static 필드  초기화
	}
}

public class Static_3 {

	public static void main(String[] args) {
		
	System.out.println(E.b); 	//객체 생성없이 E.b 호출 될때 static 블락이 작동됨 : static의 값을 초기화 함.	
		

	}

}

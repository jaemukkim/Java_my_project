package chap06_07.Ex05;

class B {	//외부 클래스 : public 이 올수없다. default가 생략되어 있다.
			//다른 패키지에서는 접근이 불가, 같은 패키지 내에서 접근가능
	private int a = 1; 		//private : 같은 클래스에서만 사용
	int b = 2;				//default : 같은 패키지내의 다른 클래스에서 접근가능
	protected int c = 3;	//protected : default 포함 + 다른패키지에 접근가능 (상속된 경우만 가능)
	public int d = 4;		//public	: 다른 패키지에서 접근이 가능
	
		// private < default < protected < public
	
	private void print1() {	//같은 클래스에 존재하는 메소드
		a = 10;
		b = 20;
		c = 30;
		d = 40;
	}
	protected void print2() {	//같은 클래스에 존재하는 메소드
		a = 10;
		b = 20;
		c = 30;
		d = 40;
	}
	void print3() {	//같은 클래스에 존재하는 메소드
		a = 10;
		b = 20;
		c = 30;
		d = 40;
	}
	public void print4() {	//같은 클래스에 존재하는 메소드
		a = 10;
		b = 20;
		c = 30;
		d = 40;
	}
}


public class ExternalClass_1 {

	public static void main(String[] args) {
		
		B b = new B();	//default 접근 제어자가 class 이름에 할당/ 같은 클래스에 존재하므로 B class를 생성할 수 있다.
		
		Bb bb = new Bb(); //public 접근 제한자, 같은 패키지 내에서 접근
		
		//같은 패키지의 다른 클래스에서 접근
		
		//필드 접근
		// bb.a = 10;	// private : a는 Bb 클래스 내부에서만 사용. / 오류발생 : 접근 불가 
		bb.b = 20;		//default : 같은 패키지의 클래스에서 접근을 허용
		bb.c = 30;		//protected : default를 포함, + << 다른 패키지에서 접근이 가능하지만 상속관계일때만 >>
		bb.d = 40;		//public : protected를 포함 + 다른 패키지에서 접근 가능
		
		//메소드 접근
//		bb.print1();		//private : 오류발생, 클래스 내부에서만 호출
		bb.print2();		//protected
		bb.print3();		//default
		bb.print4();		//public
		
	}

}

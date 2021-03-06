package Chap18.Ex02;

//람다식 문법

//아래 4개의 인터페이스는 람다식으로 처리가 가능 : 함수형 인터페이스

@FunctionalInterface
interface A {			//입력X, 리턴X
	void method1();
}

@FunctionalInterface
interface B {			//입력O, 리턴X
	void method2(int a);
}

@FunctionalInterface
interface C {			//입력X, 리턴O
	int method3();
}

@FunctionalInterface
interface D {			//입력O, 리턴O
	double method4(int a, int b);
}

public class FunctionalToLambdaExpression {

	public static void main(String[] args) {
		
		//인터페이스의 구현되지 않은 함수를 구현 --> 람다식
		
		//1. 입력x, 리턴x
		//1-1. 익명 이너클래스로 처리
		A a1 = new A() {
			@Override
			public void method1() {
				System.out.println("메소드 1 - 1");
			}
		};		
		a1.method1();
		
		//1-2. 람다식으로 처리
				//람다식은 리턴 타입, 메소드 이름까지 제거
				//(인풋) -> {구현부};
		A a2 = () -> {System.out.println("메소드 1 - 2");};	//전체
		A a3 = () -> System.out.println("메소드 1 - 3");		//구현부에 한 라인만 존재할때 { }; 를 생략 가능
		
		a2.method1();
		a3.method1();
		
		
		//2. 입력O, 리턴X
		//2-1. 익명이너클래스로 처리
		B b1 = new B() {
			@Override
			public void method2(int a) {
				System.out.println("메소드 2 - 4 : " + a);
			}			
		};
		b1.method2(0);
		
		//2-2. 람다식 표현 (생략 가능한 것은 최대한 생략해서 표현.
		B b2 = (int a) -> {System.out.println("메소드 2 - 4 : " + a);};  //전체 구문
		B b3 = (a) -> {System.out.println("메소드 2 - 5 : " + a);}; // 입력 매개변수의 타입은 생략가능
		B b4 = (a) -> System.out.println("메소드 2 - 5 : " + a); 	  // 실행문이 한 라인일때, { }; 생략가능 
		B b5 =  a -> System.out.println("메소드 2 - 6 : " + a); 	  // 입력 매개변수가 하나일때 () 생략 가능
		
		b2.method2(1);
		b3.method2(2);
		b4.method2(3);
		b5.method2(4);
		
		//3. 입력X, 리턴O
		//3-1. 익명이너클래스
		C c1 = new C() {

			@Override
			public int method3() {
				return 4;
			}
		};
		System.out.println("돌려받은 값은 : " + c1.method3()); 	//리턴값은 sysout으로 출력
		
		//3-2. 람다식으로 표현
		
		C c2 = () -> {return 5;}; 		//전체 구문
		C c3 = () -> 6; 		//리턴이 한 라인으로 적용된 경우 : return을 생략가능, 반드시 중괄호와 함께 생략		
		
		System.out.println("돌려받은 값은 : " + c2.method3());
		System.out.println("돌려받은 값은 : " + c3.method3());
		
		//4. 입력O, 리턴O
		//4-1. 익명이너클래스
		
		D d1 = new D() {
			public double method4(int a, int b) {
				return a + b;
			};
		};
		System.out.println("두 수의 합은 : " + d1.method4(1, 2));
		
		//4-2. 람다식으로 표현
		
		D d2 = (int a, int b) -> {return a + b;};	//전체 표현
		D d3 = (a, b) -> {return a + b;};			//인풋 타입은 생략가능 / 입력 매개변수가 2개이므로 () 생략 불가능
		D d4 = (a, b) -> a + b;						//리턴이 하나일 때 생략가능, {}; 중괄호와 반드시 같이 생략 
		
		System.out.println("두 수의 합은 : " + d2.method4(3, 4));
		System.out.println("두 수의 합은 : " + d3.method4(3, 4));
		System.out.println("두 수의 합은 : " + d4.method4(3, 4));
		
		
		
		
		
		
	}

}

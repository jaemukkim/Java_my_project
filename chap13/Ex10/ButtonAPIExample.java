package chap13.Ex10;

class Button {
	// OnClickListener : 객체 타입,  ocl : 참조 변수
	OnClickListener ocl;	//ocl 기본 값으로  null
	
	
	//setter를 통해서 OnClickListener의 참조 변수 ocl에 객체 주소를 담는다.
	void setOnClickListener (OnClickListener ocl) {
		this.ocl = ocl;
	}
	
	//인터페이스만 존재하고 구현한 자식 클래스가 존재하지 않는다.
	//호출하는 곳에서 OnClick() 메소드를 재정의해서 호출
	interface OnClickListener {	//InnerInterface, static(생략됨), Button.OnClickListener : 
		void OnClick();		//메소드 선언만됨. 하위에서 오버라이딩 해서 재정의
	}
	void click() {		//실행했을때 ocl.OnClick()를 호출
		ocl.OnClick();	//ocl : 참조변수 : null ===> setOnClickListener (OnClickListener ocl)
		System.out.println(ocl);
	}
}

public class ButtonAPIExample {

	public static void main(String[] args) {
		//개발자 1 : 클릭시 음악 재생
		Button button1 = new Button();	// button1 객체 생성
		
		//A.B = new A.B(){이너인터페이스B의 메소드를 구현한 코드};
		
		//OnClickListener 객체타입으로 객체 생성 매개변수로 전달
		
		button1.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void OnClick() {
				System.out.println("개발자 1. 음악 재생");
			}});					
		button1.click();
		
		System.out.println("========================");
		
		//개발자 2 : 클릭시 네이버 접속
		Button button2 = new Button();
		//setOnClickListener 메소드에 매개변수로 OnClickListener의 하위 익명객체를 생성후 OnClickListener
		button2.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void OnClick() {
				System.out.println("개발자 2. 네이버 접속");
			}
		});
		button2.click();
		
	}

}

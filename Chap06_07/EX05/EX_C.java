package chap06_07.Ex05;

public class Ex_C {

	public static void main(String[] args) {		
		
		//같은 클래스에 존재함.
		C c = new C();	//같은 패키지에 존재하는 클래스
		
	//	필드에 값을 직접 할당
	//	c.company = "삼성자동차	"; //private : 외부 클래스에서 접근 불가	
		c.model = "소나타";	//default
		c.color = "흰색";		//protected
		c.maxspeed = 230;	//public
				
		
		c.print();
		
	}

}

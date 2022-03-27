package chap10.Ex07.Ex02;

class A {
	String name;
	A(String name){
		this.name = name;
	}
}
class B {
	String name ;
	B(String name){
		this.name = name;
	}
	
	@Override 			// b1.equals(b2) 
	public boolean equals(Object obj) {	//��ü�� �Ű������� ������ Object Ÿ������ �ڵ����� ��ĳ����
		if(this.name == ((B)obj).name) { //BŸ������ �ٿ�ĳ���� �� �� ��ü�� name �ʵ��� ���� ��.
			return true ;
		}else {
			return false ;
		}
		
	}
}

public class ObjectMethod_equals {

	public static void main(String[] args) {
		//1. ��ü ����
		A a1 = new A("�ȳ�");
		A a2 = new A("�ȳ�");
		
		/*  �� ��ü �� ( == , equals() )
			 == : �⺻ Ÿ���� ��� ���� ���ؼ� true, false ����
			    : ���� Ÿ���� ��� ��ü�� ������ �� 
		equals() : �⺻������ object Ŭ������ equals() ��ü�� ������ �� (==)
			��ü ������ Ư�� �ʵ��� ���� ���ϱ����� ������ �ؼ� ����Ѵ�.
		
		*/	
		System.out.println(a1);
		System.out.println(a2);
		
		System.out.println(a1 == a2);	   //false
		System.out.println(a1.equals(a2)); //false
		
		System.out.println("==========================");
		
		B b1 = new B("�ȳ�");
		B b2 = new B("�ȳ�");
		
		System.out.println(b1 == b2); //false
		System.out.println(b1.equals(b2)); //true  / equals() �� ������ �ϸ鼭 name �ʵ��� ���� ��.
		
		
		
		
		
		
	}

}
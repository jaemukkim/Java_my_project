package chap10.Ex07.Ex01;


//Object Ŭ������ toString �޼ҵ� : ��ü�� ����Ҷ� Object toStirng() ȣ��
	// toString() : ��Ű����.Ŭ������@�ؽ��ڵ�
	// �ؽ��ڵ� : ��ü�� ����Ű�� �ִ� ���޸��� ������ �ؽ��ڵ�� ��ȯ 
	// ������ �ؼ� ��� : ��ü�� ������ ���, (�ʵ尪, �޼ҵ� ȣ��)


class A {	 	//
	int m = 3;
	int n = 4;
}
class B {      //extends Object   ������ 
	int a = 3;
	int b = 4;
	
	@Override
	public String toString() {
		return " a : " + a + " , b : " + b; 
	}
	
}





public class ObjectMethod_toString {

	public static void main(String[] args) {
		A a = new A();
		System.out.println(a);  // ��Ű����.Ŭ������@�ؽ��ڵ� , chap10.Ex07.Ex01.A@32d2fa64(16����)
		System.out.println(a.toString());
		System.out.printf("%x\n", a.hashCode());  // %x�� 16����
		System.out.println(a.hashCode());
		
		
		
		B b = new B();
		System.out.println(b);  //toString() �������ؼ� ��ü�� �ʵ��� ������ ���.


	}

}
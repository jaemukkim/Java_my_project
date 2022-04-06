package Chap17.Ex07;

//LinkedHashSet : ���� ������ �� ���� ���� ��ġ ������ �� ���� ���� ��ġ ������ ������.
	//HashSet�� ������ : ��� �޼ҵ尡 �����ϴ�. �ߺ��� ���� �������� �ʴ´�. ���ȣ(index)���� ������ �ʴ´�.
						//�⺻ for������ ����� �� ����. iterator �� Enhanced for���� ���.

	//LinkedHashSet�� �ٸ��� : HashSet�� �Է´�� ��µ��� �ʴ´�. LinkedHashSet �� �Է´�� ��µȴ�.

import java.util.Arrays;

//Set<E> : �������̽��̸�, ���ȣ(index)�� ����. �ߺ��� ���� ���� �� ����.
	// - HashSet		: �ߺ��� ���� ���� �� ����.  ���� ������ ������� �������� �ʴ´�.
	// - LinkedHashSet  : �ߺ��� ���� ���� �� ����.  ��½� ������� ���.
	// - TreeSet		: ����ɶ� ���� ������ �Ǿ ����. ascending (�������� ����) : 0 -> 9,  a -> z,  �� -> ��
										  //���� : descending (�������� ����) : 9 -> 0 , z -> a , �� -> ��
	
//����Ű ���� : Ctrl + Shift + L
//ã�� / �ٲٱ� : Ctrl + F

import java.util.LinkedHashSet;
import java.util.Iterator;
import java.util.Set;



public class LinkedHashSetMethod {

	public static void main(String[] args) {
		
		Set<String> LinkedSet1 = new LinkedHashSet();	//Set�� Interface �̹Ƿ� Ÿ�����θ� ����
		//Set�� ���ʸ� Ÿ�Ժ����� wrapper Ŭ������ ����� ���, equals(), hashCode(), toString() �� �����ǵǾ� ����.
		
		
		//1. add(E element) : Set�� ���� �߰�, 
		LinkedSet1.add("��");
		LinkedSet1.add("��");
		LinkedSet1.add("��");  //"��" �� �ߺ� ���� �ȵ�.
		System.out.println(LinkedSet1);
		System.out.println(LinkedSet1.toString());	// toString �޼ҵ尡 ������ �Ǿ��ִ�.
		
		System.out.println("===========================");
		
		//2. addAll (�ٸ� set ��ü)	: �ڽ��� Set�� �ٸ� Set�� ����� ���� �߰� : �ߺ��� ���� ���ŵ�
		Set<String> LinkedSet2 = new LinkedHashSet<>();
		LinkedSet2.add("��");
		LinkedSet2.add("��");
		LinkedSet2.addAll(LinkedSet1);	
		System.out.println(LinkedSet2); //[��,��,��]	//�Է°� ����� �����ϴ�.
		
		//3. remove (Object o) : ������ ����, ( List�� ��� ���ȣ�� ����)
		LinkedSet2.remove("��");	//[��,��]
		System.out.println(LinkedSet2);
		
		//4. clear() : ��λ���
		LinkedSet2.clear();
		System.out.println(LinkedSet2);
		
		//5.isEmpty() : ��������� true, ������������� false
		System.out.println(LinkedSet2.isEmpty());
		
		//6. contains(Object o) : ���� Set�� �����ϸ� true, �׷��� ������ false
		Set<String> LinkedSet3 = new LinkedHashSet<>();
		LinkedSet3.add("��");
		LinkedSet3.add("��");
		LinkedSet3.add("��");
		System.out.println(LinkedSet3); 	// �Է°� ����� �����ϴ�.
		System.out.println(LinkedSet3.contains("��")); //true
		System.out.println(LinkedSet3.contains("��")); //false		
		
		//7. size() : Set�� ���Ե� ���� ����
		System.out.println(LinkedSet3.size());
		
		System.out.println("=========iterator()�� ����� ���.==============");
		
		//8. iterator() : set �� index�� ������ �ʴ´�. for���� ���ȣ�� ���� ����ؼ�,(set �� ���Ұ�) enhanced for���� ��밡��
						//��ȸ��, Set�� ������ ��ȸ�ϸ鼭 ���. 
						//hasNext() : Set�� ���� �����ϸ� true, �������� ������ false
						//next()  : ���� ���� ����ϰ� ���� ������ �̵�.
		Iterator<String> iterator = LinkedSet3.iterator();
			//Ŭ����<E> ������ü = Set��ü.iterator();
		while(iterator.hasNext()){
			System.out.print(iterator.next() + "  ");
		}
		System.out.println();
		
		System.out.println("=============Enhaced For�� ���=============");
		
		for(String k : LinkedSet3) {
			System.out.print(k + "  ");
		}
		System.out.println();
		
		//9. toArray() : set�� ������ �迭�� ������. Object Ÿ������ ����, �ٿ�ĳ���� �ʿ�.
		Object[] objArray = LinkedSet3.toArray();
		System.out.println(Arrays.toString(objArray));	//
		for(int i=0; i<objArray.length; i++) {
			System.out.print(objArray[i] + "  ");
		}
		System.out.println();
		System.out.println("=========================");
		for(Object k : objArray) {		//�ٿ� ĳ������ �ʿ��ϴ�.
			System.out.print(k + "  ");
		}
		System.out.println();
		
		//10. toArray(T[] t) : �ٷ� �ٿ� ĳ������ ���� ���
		String[] strArray1 = LinkedSet3.toArray(new String[0]); // 0 : ���� ũ�⸦ ����
														//���� ũ�Ⱑ ���� ������ ���� ��� �����Ϸ��� ���� ũ�⸸ŭ ����
		System.out.println(Arrays.toString(strArray1));
		
		//11. ���� Set�� ������ ���� ũ�⸦ ũ�� ���� ���� Null�� �� �� �ִ�.
		String[] strArray2 = LinkedSet3.toArray(new String[5]);
		System.out.println(Arrays.toString(strArray2));
		System.out.println("=============================");
		
		
		Set<Integer> intSet1 = new LinkedHashSet();
		
		intSet1.add(30); intSet1.add(50); intSet1.add(100); intSet1.add(10);
		
		//iterator ���, Enhanced for�� ���.
		Iterator<Integer> iterator1 = intSet1.iterator();
		while(iterator1.hasNext()) {
			System.out.print(iterator1.next() + "  ");
		}
		System.out.println();
		//Enhanced for�� ���.
		for(int k : intSet1) {
			System.out.print(k + "  ");
		}
		
	}

}
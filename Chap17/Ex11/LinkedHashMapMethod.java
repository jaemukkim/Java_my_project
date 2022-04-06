package Chap17.Ex11;

//Map<K,V> : Key�� �ߺ����� �ʴ´�. <== Set���� �����ȴ�.
//HashMap vs LinkedHashMap
	//HashMap<K,V>  :  �Է°� ����� �ٸ� �� �ִ�. ����� �����ϰ� ���
	//LinkedHashMap<K,V>  :  key�� ��ũ�Ǿ� �ִ�. ���� ���� ���� ���� ������ ������.
							//�Է� ������� ����� �ȴ�.

import java.util.Hashtable;
import java.util.LinkedHashMap;

/*	Map<K,V> : K : Key , V : Value �������� �����͸� ����.
 		Key�� �ߺ��� �� ����. ==>  Set���� ����.  	index�� �ƴϴ�. index�� 0���� �Ҵ�, JVM�� �Ҵ�.
 		Value�� �ߺ��� �� ����.
 
 		//HashMap : ����� �����ϰ� ���. ���� ������ ȯ�濡 ����. ��� �޼ҵ尡 ����ȭ �Ǿ������ʴ�.
 		//Hashtable : ��� �޼ҵ尡 ����ȭ�Ǿ� �ִ�. ��Ƽ ������ ȯ�濡 ����.
 		 			  ��� �޼ҵ�� HashtMap�� ����
 
 
 */

import java.util.Map;
import java.util.Set;

public class LinkedHashMapMethod {

	public static void main(String[] args) {
		
		Map<Integer, String> LhMap1 = new LinkedHashMap<>();
		
		//1. put(K key, V value) : ���� ������.
		LhMap1.put(2, "���ٶ�");
		LhMap1.put(1, "������");
		LhMap1.put(3, "�ٶ�");
//		LhMap1.put(3, "������");	//Ű�� �ߺ��ؼ� ����� �� ����. ���� ���� ��� ������ ���� ������ �ȴ�.
		System.out.println(LhMap1);
		
		//2. putAll(�ٸ��� ��ü) : �ٸ� ���� �����ؼ� ���.
		Map<Integer, String> LhMap2 = new LinkedHashMap();
		LhMap2.putAll(LhMap1);
		System.out.println(LhMap2);
		
		//3. replace(K V) : key�� ����� ���� value�� ����.
		LhMap2.replace(1, "������");
		LhMap2.replace(4, "����");	//key 4�� �������� �ʴ´�. �۵�X, ���ܹ߻���X
		System.out.println(LhMap2);
		
		//4. replace(K key, V oldValue, V newValue) : oldValue�� newValue�� ����
		LhMap2.replace(1, "������", "������");
		LhMap2.replace(2, "�ٴٴ�", "����");	//���۾ȵ�.. ���ܹ߻���X ===> Key�� Value�� ��Ȯ�� ��ġ�ؾ� ������. 
		System.out.println(LhMap2);
		
		//5. get(Object Key) : Map�� ���� �����ö�.		Key�� �־���� Key�� �Ҵ�� Value�� ���.
		System.out.println(LhMap2.get(1)); 	//���� 1�� index�� �ƴ϶� 1�� Key�� ��.
		System.out.println(LhMap2.get(2));	//2�� key�� ��
		System.out.println(LhMap2.get(3));
		
		//6. containsKey(Object key) : �ʿ� �ش�Ű�� �����ϴ��� Ȯ��, true, false
		System.out.println(LhMap2.containsKey(1)); // 1�� key�� �ִ��� / true
		System.out.println(LhMap2.containsKey(5)); // 5�� key�� �ִ��� / false
		
		//7. containsValue(Object value) : �ʿ� �ش� ���� �����ϴ��� Ȯ��
		System.out.println(LhMap2.containsValue("������")); //true 
		System.out.println(LhMap2.containsValue("�ٴٴ�"));  //false
		
		//8. Set<K> keySet() : Ű�� ����
		Set<Integer> keySet = LhMap2.keySet();	//LhMap2�� ����� keySet�� ���� / ����� key�� 
		System.out.println(keySet);
		
		//9. Set<Map.Entry<K,V>> entrySet() : Ű�� ���� ��(Set)�� ����
		Set<Map.Entry<Integer, String>> entrySet = LhMap2.entrySet();
		System.out.println(entrySet); // key�� value ��� ���
		
		//10. size() : �� ����
		System.out.println(LhMap2.size()); // 3
		
		//11. remove(Object Key) : Ű�� �־ key�� value�� ����.
		LhMap2.remove(1);	//1�� key ����
		LhMap2.remove(4);	//4�� ���� / ����X
		System.out.println(LhMap2);
		
		//12. remove (Object key, Object Value) : Key�� value�� ��Ȯ�ϰ� ��ġ�Ҷ� ����.
		LhMap2.remove(2, "���ٶ�");	
		LhMap2.remove(3, "�ٴٴ�");  //����X / key�� value�� ��Ȯ�ϰ� ��ġ�ؾ���.
		System.out.println(LhMap2);
		
		//13. clear() : ��� ����
		LhMap2.clear();
		System.out.println(LhMap2);
		
		
		
		
	}

}
package Chap17.Ex08;

import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

//TreeSet : 출력시 정렬되어서 출력. (오름차순 정렬(ascending) : 1  --> 9,  a --> z, 가 --> 하)
			//출력시 검색의 메소드가 지원.
			//임의의 값을 넣으면 Set에 정렬되어서 저장됨, 출력시에 오름차순으로 정렬되어서 출력.
			// Set <= SortedSet <= NavigableSet(검색 메소드 정의) <== TreeSet
			//TreeSet<String> treeSet = new TreeSet<String>(); 타입을 TreeSet으로 지정해야 정렬/검색 기능을 사용.
			//Set 인터페이스의 모든 메소드 사용. 추가적으로 정렬 메소드 / 검색 메소드를 사용가능

public class TreeSetMethod {

	public static void main(String[] args) {
		//TreeSet은 Set 의 모든 메소드 사용.
		
		//TreeSet에 값을 넣었을 경우 오름차순 정렬되어 값이 Set에 저장, 출력시 오름차순 정렬로 출력.
		TreeSet<Integer> treeSet = new TreeSet(); //Type을 TreeSet으로 지정해야 정렬(Sort)과 검색을 사용할 수 있다.
		
		for(int i=50; i>0; i-=2) {	// 50, 48, 46, 44, 42 .... 4, 2
			treeSet.add(i);  //내부적으로 임의의 값을 넣을때 오름차순으로 정렬되어 값이 저장.
		}
		System.out.println(treeSet);
		
		//TreeSet에서만 사용 가능한 메소드 (1. ~15)  / 중요하진않음
		System.out.println("============데이터 검색 (가져오기)============");
		//1. first()  :  제일 처음값을 리턴
		System.out.println(treeSet.first()); //2
		
		//2. last()   :  제일 마지막값 리턴
		System.out.println(treeSet.last()); //50
		
		//3. lower(E element) : element에 오는값 보다 한칸 작은 값을 출력
		System.out.println(treeSet.lower(26)); //24
		
		//4. higher(E element) : element에 오는값 보다 한칸 큰 값을 출력
		System.out.println(treeSet.higher(26));
		
		//5. floor(E element ) element를 포함해서 작은 값을 출력 
		System.out.println(treeSet.floor(25)); //24
		System.out.println(treeSet.floor(26)); //26
		
		//6. ceiling(E element) element를 포함해서 큰 값을 출력
		System.out.println(treeSet.ceiling(25)); //26
		System.out.println(treeSet.ceiling(26));
		System.out.println("=============데이터 꺼내기===============");
		
		//7. pollFirst() : 제일 처음 값을 꺼내기 / 안에 것을 빼냄
		int treeSetSize = treeSet.size(); //값의 개수
		System.out.println(treeSetSize); // 25개
		System.out.println();
		for(int i=0; i<treeSetSize; i++) {
			System.out.println(treeSet.pollFirst()); //25번 루프 돌면서 첫번째 값만 꺼내와서 출력. 
		}
		System.out.println();
		System.out.println(treeSet.size()); //0 / 다 꺼내옴	
		
		//8. pollLast() : 제일 마지막 값을 꺼내기
		for(int i=50; i>0; i-=2) {
			treeSet.add(i);
		}
		treeSetSize = treeSet.size();
		System.out.println(treeSetSize);
		System.out.println(treeSet);
		System.out.println();
		
		for(int i=0; i<treeSetSize; i++) {
			System.out.println(treeSet.pollLast()); //마지막값 부터 꺼냄
		}
		System.out.println();
		System.out.println(treeSet.size()); //0
		System.out.println("=============정렬================");
		
		//9. SortedSet<E> headSet(E element)  :  정렬을 사용하기 위해서 SortedSet<E> 타입으로 리턴
			//SortedSet<E> : 정렬된 데이터를 저장하는 Set.
			//headSet(E element) : element의 Head 쪽으로의 값을 저장. <element 값은 미포함>
		for(int i=50; i>0; i -=2) {
			treeSet.add(i);		//오름차순으로 정렬되어서 treeSet에 저장.
		}
		System.out.println(treeSet);
														
		SortedSet<Integer> sSet = treeSet.headSet(20); //headSet(20)은 SortedSet으로 리턴값을 돌려줌.
		//Set<Integer> sSet = treeSet.headSet(20);			//treeSet에 20 기준으로 head쪽 값
		System.out.println(sSet);	
		
		//10. NavigableSet<E> headSet(E element, boolean inclusive) : element를 포함(true), 미포함(false)해서 head쪽으로 출력
		NavigableSet<Integer> nSet = treeSet.headSet(20, true); // true / 20 포함해서
//		Set<Integer> nSet = treeSet.headSet(20, true);  / Set으로도 가능			
		System.out.println(nSet);
		
		//11. SortedSet<E> tailSet(E element)
		SortedSet<Integer> sSet2 = treeSet.tailSet(20); //시작값은 포함이 기본, 끝값을 미포함이 기본 <== 모든 언어에서 동일한 내용
//		Set<Integer> sSet2 = treeSet.tailSet(20); / Set도 가능 
		System.out.println(sSet2);
		
		//12. NavigableSet<E> tailSet<E elemnet, boolean inclusive) : element를 포함(true), 미포함(false)해서 tail쪽으로 출력
		NavigableSet nSet2 = treeSet.tailSet(20, false);
//		Set nSet2 = treeSet.tailSet(20, false); / Set 가능		
		System.out.println(nSet2);
		System.out.println("===========특정 범위의 값 가져오기 (subSet)=============");
		//13. SortedSet<E> subSet(E element, E element); 특정 범위의 값을 set으로 담을때.
		SortedSet sSet3 = treeSet.subSet(10, 20); // 10~20 범위
		System.out.println(sSet3);	//시작값은 포함, 끝값은 미포함.
		
		//14. NavigableSet<E> subSet(E element, boolean inclusive, E element, boolean inclusive)
		NavigableSet<Integer> nSet4 = treeSet.subSet(10, true, 20, true);// 포함할건지 미포함 할건지
		//Set<Integer> nSet4 = treeSet.subSet(10, true, 20, true); / Set으로도 가능
		System.out.println(nSet4);
		System.out.println("=============반대로 정렬하기 descendingSet===============");
		
		//15. NavigableSet<E> descendingSet()  :  현재 정렬을 기준으로 반대로 정렬한다. /  원래 descending 뜻은 ==> <내림차순 정렬>
		System.out.println(treeSet); //오름차순 정렬
		
		NavigableSet<Integer> descendingSet = treeSet.descendingSet();
		//Set<Integer> descendingSet = treeSet.descendingSet();  / Set으로 가능
		System.out.println(descendingSet);  // 반대로 정렬 ==> 내림차순
		
		NavigableSet<Integer> descendingSet2 = descendingSet.descendingSet();
		//Set<Integer> descendingSet2 = descendingSet.descendingSet();  / Set으로 가능
		System.out.println(descendingSet2); //반대로 정렬한 것을 다시 반대로 정렬 ==> 오름차순
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

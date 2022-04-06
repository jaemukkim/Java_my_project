package Chap17.Ex14;

import java.util.ArrayList;
import java.util.Scanner;

class Account {   //계좌 정보를 저장하는 객체. 중요한 필드, private(캡슐화), 
					//DTO, VO <== 각 계층으로 필드의 값을 저장하고 전달  
					//객체명 필드접근(x), 생성자, getter, setter를 통해
	private String ano;     //계좌번호
	private String owner;   //계좌 주, 이름
	private int balance;	//통장 금액
	
	Account(String ano, String owner, int balance){ //객체 생성시 필드의 값을 받아서 필드에 로드
		this.ano = ano;
		this.owner = owner;
		this.balance = balance;		
	}
	
	//getter, setter
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	
}

public class BankAccountUsingArrayList {
	//컬렉션(ArrayList<E>)을 사용해서 Account 객체 등록
	//배열은 방의 크기가 고정, 선언시 방의 크기를 지정, 방의 크기를 수정할 수 없다.
	//컬렉션은 방의 크기가 동적, 무한정 저장.
	private static ArrayList<Account> aList = new ArrayList();
	private static Scanner sc = new Scanner(System.in);
	
		//컬렉션의 방의 값을 넣을 경우 add() : 제일 마지막 방에 값을 추가할 경우,  size() 
		//각방의 값을 삭제할때 remove() : 삭제시 
	
	//메소드 정의
	private static void createAccount() {
		//1.계좌 생성  / 스캐너로 1.계좌번호 , 2.이름 , 3.초기통장 금액
		//배열 객체에 저장.
		System.out.println("----------");
		System.out.println("1. 계좌 생성");
		System.out.println("----------");
		System.out.println("계좌 번호를 입력 하세요 >>");
		String ano = sc.next();	 //계좌 번호를 인풋받아서 ano 변수에 할당. <메소드 내에서만 사용하는 지역변수>
		System.out.println("이름을 입력 하세요>>");
		String owner = sc.next();
		System.out.println("계좌 개설시 초기 금액을 입력하세요.");
		int balance = sc.nextInt();
		
		//각 필드의 정보를 사용자로부터 할당 받아서 객체를 생성후 객체에 필드의 값을 저장.
		Account newAccount = new Account(ano, owner, balance);	//생성자를 통해서 객체에 필드값 적용후 객체 생성.
		
				aList.add(newAccount);
				System.out.println("계좌가 성공적으로 생성되었습니다.");
			}					
	
	private static void accountList() {
		//2.계좌 목록 출력 : 배열에 저장된 객체를 가져와서 계좌번호, 이름, 금액을 출력
		//배열의 각 방을 순회하면서 null이 아닌 경우 배열에서 객체를 꺼내서 필드의 정보를 출력.
		System.out.println("-----------");
		System.out.println("2. 계좌목록출력");
		System.out.println("-----------");

		//배열의 각방의 null이 아닌경우 , 객체의 필드의 값을 출력
		for(int i=0; i<aList.size(); i++) {
			//각 방의 객체를 담는 변수를 선언
			Account account = aList.get(i);	//0~99 방의 객체를 account 참조변수에 담는다. 
			if(account != null) {	//각 방의 값이 null이 아닐 경우만 객체정보를 가져와서 출력.
				System.out.print(account.getAno()); //계좌정보.
				System.out.print("    ");
				System.out.print(account.getOwner()); //이름
				System.out.print("    ");
				System.out.print(account.getBalance()); //금액
				System.out.println(); //라인개행				
			}
		}		
	}
	private static void deposit() {
		//3.예금 : 계좌번호를 받아서 객체에서 해당 계좌를 찾아서, 입금금액 : 해당 계좌에 저장.		
		//1.사용자로부터 입금할 계좌를 받아야한다.
		//2.사용자로 받은 계좌번호를 배열에 저장된 객체내의 계좌 번호를 확인후 해당 계좌에 입금.
		
		System.out.println("---------");
		System.out.println("3.예금하기");
		System.out.println("---------");
		System.out.println("예금할 계좌번호를 입력하세요.");
		String ano =sc.next();
		System.out.println("예금할 금액을 입력하세요.");
		int money = sc.nextInt();
		
		//해당 계좌를 배열에서 찾아서 찾은 객체를 받아온다.
		Account account = findAccount(ano); 	//findAccount(계좌번호)
		
		if (account == null) {
			System.out.println("결과 : 해당 계좌가 존재하지 않습니다.");
			return;  //메소드 종료.
		}
		account.setBalance(account.getBalance() + money);	//setter를 사용해서 기존의 금액 + 추가 입금
		System.out.println("결과 : 예금이 성공적으로 입금 되었습니다.");
		System.out.println("남은 금액 : " + account.getBalance());
	}
	
	private static void withdraw() {
		//4.출금 : 계좌번호를 인풋받아 해당 계좌를 객체에서 찾아서 출금.
		System.out.println("----------");
		System.out.println("4.출금하기");
		System.out.println("----------");
		System.out.println("출금할 계좌번호를 입력하세요 >>");
		String ano =sc.next();
		System.out.println("출금할 금액을 입력하세요>>");
		int money = sc.nextInt();			
		
		//해당 계좌를 배열에서 찾아서 찾은 객체를 받아온다.
		Account account = findAccount(ano); 	//findAccount(계좌번호)
		
		if (account == null) {
			System.out.println("결과 : 해당 계좌가 존재하지 않습니다.");
			return;  //메소드 종료.
		}
		account.setBalance(account.getBalance() - money);	//setter를 사용해서 기존의 금액 + 추가 입금
		System.out.println("결과 : 예금이 성공적으로 출금 되었습니다.");
		System.out.println("남은 금액 : " + account.getBalance());
	}
	
	//배열에서 Account 객체내의 ano[계좌번호]와 동일한 계좌를 찾아서 찾은 객체를 리턴으로 돌려줌.
	//예금, 출금할때 공통코드, 여러 메소드에서 중복 사용될 때 별도의 메소드를 생성해서 중복코드를 간단하게 만들어 준다.
	private static Account findAccount(String ano) {
		Account account = null;
		//코드 작성
		for(int i=0; i<aList.size(); i++) {
			if(aList.get(i)!=null) {   //배열방의 값이 null이 아닐경우에 객체의 ano[계좌] 번호.
				//각 객체의 방의 ano를 담는 변수 선언
				String dbAno = aList.get(i).getAno(); // 배열의 각 방에 저장된 객체의 ano를 dbAno 변수에 할당.
				 if(dbAno.equals(ano)) {
					 account = aList.get(i);	//account 참조변수는 객체의 주소정보를 담는다.
					 break;
				 }
			}
		}
		return account;
	}
	
	public static void main(String[] args) {
		boolean run = true;
		
		while(run) {
			System.out.println("-----------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("-----------------------------------------");
			System.out.println("선택>>");
			int selectNo = sc.nextInt();
			
			if(selectNo == 1) {
				createAccount(); //메소드 호출, 객체 생성없이 메소드명으로 호출(static),
			}else if(selectNo == 2) {
				accountList();
			}else if(selectNo == 3) {
				deposit();
			}else if(selectNo == 4) {
				withdraw();
			}else if(selectNo == 5) {
				break;
			}
		}
		sc.close();
		System.out.println("프로그램을 종료합니다.");

	}

}

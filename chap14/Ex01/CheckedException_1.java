package chap14.Ex01;

import java.util.Scanner;

//Error : 프로그래머가 제어할 수 없는 부분, OS 발생하는 Error, H/W Error
//Exception (예외) : 프로그래머가 제어할 수 있는 부분,
			// 예외가 발생 되면 프로그램이 종료되어 버린다.
			// 예외가 발생 되더라고 프로그램이 종료도

//ArithmeticException : 어떤수를 0으로 나누면 발생하는 예외
		//컴퓨터는 어떤수를 0으로 나눌경우 계산 불가.


public class CheckedException_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수값 하나를 입력하세요");
		int a = sc.nextInt();
		int b = 10;
		
		try {	//try 블락에서 예외 (Exception)이 발생될 경우
			//try 블락
			System.out.println(b / a);
			
		}catch(ArithmeticException e) {
			//catch 블락 : try{} 블락에서 오류가 발생될 경우 catch{}블락이 작동
			System.out.println("오류가 발생했습니다. 0으로 나눌수 없습니다. 다른 수를 넣어주세요.");
		}finally {
			
		}
		System.out.println("프로그램을 종료합니다.");
	}

}

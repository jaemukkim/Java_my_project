package Chap19.Ex04;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileInputStream_1 {

	public static void main(String[] args) throws IOException {
		
		//현재 작업 디렉토리 위치 확인
		System.out.println(System.getProperty("user.dir"));
		
		//1. 입력 파일 생성
			//절대경로로 설정
		File inFile1 = new File("D:\\KJM\\JAVA\\src\\Chap19\\files\\FileInputStream1.txt");
		
			//상대경로로 설정 : 현재 작업 디렉토리를 기준으로 설정
		File inFile = new File("src\\Chap19\\files\\FileInputStream1.txt");
		
		//InputStream 객체를 생성해야 파일의 내용을 읽을 수 있다.
		InputStream is = new FileInputStream(inFile);	
			//InputStream 은 추상클래스, 직접 객체 생성을 할 수 없다. 타입 지정은 가능하다.
		
		//파일의 내용을 출력.
		
		
		
		//UTF-8 : 영어 : 1byte, 한글은 : 3byte
		//MS949 : 영어 : 1byte, 한글은 : 2byte
		//EUC-KR: 영어 : 1byte, 한글은 : 2byte
		//UTF-16: 영어, 한글 : 2byte, 첫번째 BOM 2byte  <= 식별자
		
		//JAVA에서 줄바꿈 처리
		//	- UNIX 	 : \n
		//	- Widows : \r\n 	==> \r 생략가능.  ==> 콘솔이나 메모장에서 enter : \r\n
		//	- MAC  	 : \r
		
		//한 바이트 데이터를 읽어서 char로 변환 후 출력.
		System.out.print(is.read());			//read() 한 바이트를 읽어들임
		System.out.print((char)is.read());		
		System.out.print((char)is.read());
		System.out.print((char)is.read());
		System.out.print((char)is.read());
		System.out.print((char)is.read());
		System.out.print((char)is.read());
		System.out.print((char)is.read());
		System.out.print((char)is.read());
		System.out.print((char)is.read());
		System.out.print((char)is.read());
		System.out.print((char)is.read());
		System.out.print((char)is.read());
		System.out.print((char)is.read());
		System.out.print((char)is.read());
		System.out.print((char)is.read());
		System.out.print((char)is.read());
		
		System.out.println();
		System.out.println();
		System.out.println("=============================");
		
		//스트림은 값을 읽으면 메모리에서 삭제된다. 새로 읽기 위해서는 새로운 스트림을 생성해야 한다.
		
		
		// int read() : 한 바이트를 읽어서 값이 존재할 경우 양수를 리턴, 읽은 데이터가 존재하지 않을 경우 -1 
		//while 문을 사용해서 한번에 출력
		
		
		InputStream is1 = new FileInputStream(inFile);
		
		int data;
		
		while((data = is1.read()) != -1 ) {  //마지막 값까지 계속 순환	 ( -1 : 값이 더이상 존재 하지 않으면 -1)
			System.out.print((char)data);			
		}
			//중요 : is1.read() : 1byte를 읽어들임.	반환 타입은 int 이다.
			//
			//FileInputStream은 반드시 index 0번부터 읽어들임.	 중간의 임의의 방에서 읽을 수 없다.
				//FileRandomAccess를 사용해서 임의의 index에서 읽어들임.
		
		System.out.println();
		System.out.println();
		System.out.println("=======================");
		
		// available() : 스트림의 남은 바이트수를 출력.
		
		InputStream is2 = new FileInputStream(inFile);
		
		while((data = is2.read()) != -1 ) {  //마지막 값까지 계속 순환  
			System.out.println("읽은 데이터 : " + (char)data + "  남은 바이트 수 : " + is2.available());			
		}
		is.close();
		is1.close();
		is2.close();
		
		System.out.println(System.lineSeparator());
		
		
		
	}

}

package Chap19.Ex08;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

//InputStreamReader : byte 데이터를 char 포멧으로 변환하는 객체.	==> 인코딩을 지정할 수 있다.
	//byte 포멧은 인코딩을 잘 지정해야 한다. 	  ==> encoding : MS949, UTF-8
	//char 포멧으로 바꾸면 인코딩 타입을 신경쓸 필요가 없다. 
	// 사용목적 1. FileReader : default Charset 만 사용 가능해서, 현재 Default Charset MS949 이지만 외부 파일이 UTF-8을 읽어올 경우
	// 		 2.  네트워크에서 전송되는 스트림이 UTF-8, MS949  byte ===> char로 변환 처리

public class InputStreamReader_1 {
	public static void main(String[] args) {
		
		//1.파일 객체 생성
		File isr = new File("src\\Chap19\\Ex08\\isr.txt");	//isr.txt는 UTF-8로 저장되어있다.
		
		try (Reader reader = new FileReader(isr);){		//FileReader는 인코딩 설정이 안됨. default Encoding만 사용가능
			int data;
			
			while((data = reader.read()) != -1){
				System.out.print((char)data);			
			}
			
		} catch (Exception e) {}
		System.out.println();
		System.out.println("=============================");
		
		//2. FileInputStream + InputStreamReader 를 이용한 파일 읽기
		// InputSTreamReader (is, "UTF-8");   byte ==> char로 변환
		
		try (InputStream is = new FileInputStream(isr);
				InputStreamReader isr1 = new InputStreamReader(is, "UTF-8");){ 	//isr : char 변환된 
																//  3byte => 2byte
			int data;
			while((data = isr1.read()) != -1) {
				System.out.print((char)data);
			}
			
			System.out.println();
			System.out.println(isr1.getEncoding());
			
		} catch (Exception e) {}
		
		
		
		
		
	}

}

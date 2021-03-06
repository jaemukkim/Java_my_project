package Chap19.Ex04;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/*
	1. is1 	==> InputStream 객체 	 (절대경로로 접근 : ms949.txt) 예외처리
	2. is2  ==> InputStream 객체	 (상대경로로 접근 : utf8.txt) 예외처리 (try ~ with resource로 예외처리
									close()메소드를 자동으로 처리
	파일인풋스트림으로 읽어서 출력.
	
*/
public class EX3_Exception1 {

	public static void main(String[] args) {
		
		//1. is1 : 절대경로로 접근 MS949 예외처리
		File inFile = new File("D:\\KJM\\JAVA\\src\\Chap19\\Ex04\\exception-ms949.txt");
		
		InputStream is1 = null;		//전역 변수로 선언. / finally 블락에서 is1.close()
		byte[] arr = new byte[100];
		
		try {
			is1 = new FileInputStream(inFile);		//객체 생성. FileInputStream은 FileNotFoundException
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다.");
		}		
		
		int data = 0;
		
		try {
			while((data = is1.read(arr)) != -1) {
				String str = new String(arr, 0, data, Charset.forName("MS949"));
				System.out.println(str);
			}
		} catch (IOException e) {
			System.out.println("파일을 읽지 못합니다.");
		}finally {
			if(is1 != null) {				
				try {
					is1.close();
			}catch(IOException e) {
				
			}
		}
		}
	
			System.out.println("=================");
			
			
	//	1-1 여러 Exception에 대해서 단일 try ~ catch 로 처리		
			InputStream is1_1 = null;		//전역 변수로 선언. / finally 블락에서 is1.close()
			byte[] arr1_1 = new byte[100];	//byte[] 배열 선언. / 한글처리
					// 한글처리 #1 : byte[] 배열 선언.

			
			int data1_1 = 0;
			
			try {
				is1_1 = new FileInputStream(inFile);			//FileNotFoundException
				while((data1_1 = is1_1.read(arr1_1)) != -1) {	//IOException
					//한글 처리 #2 : read(byte 배열)
					
					String str1_1 = new String(arr1_1, 0, data1_1, Charset.forName("MS949"));
						//한글 처리 #3 : String(byte배열, offset, length, "encoding"(Charset.forName) )
					
					System.out.println(str1_1);
				}
			} catch (IOException e) {
				System.out.println("파일을 읽지 못합니다.");
			}finally {
				
				if(is1_1 != null) {
					try {
						is1_1.close();
					} catch (IOException e) {
					}
				}
			}		
		
		
		System.out.println("============utf8==상대경로=========");
		
		//2. is2 : 상대경로 UTF-8 / 예외처리 (try ~ with resource로 예외처리)
		File inFile2 = new File("src\\Chap19\\Ex04\\exception-utf8.txt");		
		
		byte[] arr2 = new byte[100];
			//한글처리 #1 : 
		int data2 =0;
		
			try (InputStream is2 = new FileInputStream(inFile2)) {
				// try (with resource : 객체 생성, RAM를 사용) ==> close() 자동으로 처리된다. AutoClosable의 close() 구현한 클래스여야 한다
				
				while((data2 = is2.read(arr2)) != -1) {
						//한글처리 #2 : is.read (byte배열)
					
					String str2 = new String(arr2, 0, data2, Charset.forName("UTF-8"));
						//한글처리 #3 : new String(byte배열, offset, length, "encoding")
					System.out.println(str2);
				}
			} catch (IOException e) {
				System.out.println("예외가 발생했습니다.");
			}
	
			
			
	}
}

	



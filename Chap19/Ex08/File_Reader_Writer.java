package Chap19.Ex08;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/*
	Reader / Writer : char 단위 입출력. 문자만 처리하도록 특화된 추상클래스
		엔코딩의 신경을 덜 써도 된다.
		/byte : 1byte
		//char : 2byte, UTF-16 (유니코드)로 처리, 영문 2byte, 한글로 2byte 전세계 모든 언어를 처리
		  
		 FileReader : charset 지정 옵션이 없다. default charset 사용
		 FileWriter : charset 지정 옵션이 없다. default charset 사용
		


*/

public class File_Reader_Writer {

	public static void main(String[] args) {
		
		//1. 파일객체 생성
		File rwFile = new File ("src\\Chap19\\Ex08\\rwFile.txt");
		
		try (Writer writer = new FileWriter(rwFile);){	//Writer : 추상 클래스, FileWriter : Writer를 구현한 자식 클래스
			//OutputStream : byte 단위 출력, 추상클래스, FileOutputStream, 문자, 데이터, MP3, JPG, AVG ... 모든 처리
			//Writer 	   : char 단위 출력, 추상클래스, FileWriter, 문자 특화해서 처리
			
			
			writer.write("안녕하세요\n".toCharArray()); 	// String ==> Char 배열에 저장.
			writer.write("Hello \n"); //String
			writer.write('A');
			writer.write('\r');
			writer.write("반갑습니다", 2, 3);
			writer.flush();
			
		} catch (IOException e) {}
		
		//2. FileReader를 이용한 파일 읽기 (Default MS949) ===> Charactorset 지정 옵션이 없다.
		
		try (Reader reader = new FileReader(rwFile);){
			
			int data;
			while((data = reader.read()) != -1) {
				System.out.print((char) data);
			}
			
		} catch (Exception e) {
		}
	}

}

package Chap19.Ex08;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

//PrintWriter : 자동 flush() 기능이 있지만 활성화 해야한다.
	// flush()를 처리해야 한다.
	// close()가 호출될 때 flush()가 호출되고 나서 close()

public class PrintWriterExample {

	public static void main(String[] args) {
		
		//1. 파일 객체 생성
		File pw1 = new File("src\\Chap19\\Ex08\\pw1.txt");
		File pw2 = new File("src\\Chap19\\Ex08\\pw2.txt");
		File pw3 = new File("src\\Chap19\\Ex08\\pw3.txt");
		
		//2. PrintWriter (File file)
		
		try (PrintWriter pw = new PrintWriter(pw1);){
			pw.println("PrintWriter 예제 #1");
			pw.println(13);
			pw.println(5.8);
			pw.print("안녕하세요. ");
			pw.println("반갑습니다. ");
			pw.printf("%d, %S", 7, "안녕").printf("%S %f", "감사", 3.7);		
			
		} catch (FileNotFoundException e) {}
		
		//3. PrintWriter(OutputStream os)
		
		try (PrintWriter pw = new PrintWriter(new FileOutputStream(pw2)); ){
			
			pw.println("PrintWriter 예제 #1");
			pw.println(13);
			pw.println(5.8);
			pw.print("안녕하세요. ");
			pw.println("반갑습니다. ");
			pw.printf("%d, %S", 7, "안녕").printf("%S %f", "감사", 3.7);
			
			
		} catch (FileNotFoundException e) {}
		
		//4. PrintWriter (System.out)
		
		PrintWriter pw = new PrintWriter(System.out, true); //
						//   PrintWriter(System.out, true);   true ==> Auto flush() 활성화
		
		
		pw.println("PrintWriter 예제 #1");
		pw.println(13);
		pw.println(5.8);
		pw.print("안녕하세요. ");
		pw.println("반갑습니다. ");
		pw.printf("%d, %S", 7, "안녕").printf("%S %f", "감사", 3.7);
		
//		pw.flush();
//		pw.close();
		

	}

}

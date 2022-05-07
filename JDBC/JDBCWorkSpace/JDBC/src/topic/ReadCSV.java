package topic;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadCSV {

	public void read(String path) {
		try ( FileInputStream fis = new FileInputStream(path);   
				InputStreamReader isr = new InputStreamReader(fis,"UTF8");
				BufferedReader br = new BufferedReader(isr);
				){
		
			String line;
			//line = br.readLine();
			while (  (line = br.readLine() ) != null) {
				System.out.println(line);
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println("請重新操作系統");
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("請重新操作系統");
		}
		
	}

}
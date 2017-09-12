package IOStreams;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class BufferdIpStream {
	public BufferdIpStream(FileInputStream fis) {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		File file;
		FileInputStream fis;
		BufferedInputStream bis;
		FileOutputStream fos;
		BufferedOutputStream bos;
		InputStreamReader isr;
		try {
			file = new File(System.getProperty("user.dir")+"/Data/text");
			fis = new FileInputStream(file);
			//bis = new BufferedInputStream(fis, "UTF-16");
			isr = new InputStreamReader(fis, "UTF-16");
			//if(bis.toString().length() == 0) {
			//System.out.println("bis.toString()=="+bis.toString());	
			System.out.println("In the if");
				String str = "I am Prem";
				fos = new FileOutputStream(file);
				bos = new BufferedOutputStream(fos);
				bos.write( str.getBytes("UTF-16"));
			//}
				bos.flush();
				bos.close();
				fos.close();
				int i = 0;
				System.out.println("Reading start");
				StringBuilder sb = new StringBuilder();
				
				while((i = isr.read()) != -1) {
					
					sb.append((char)i);
				}
				
				//String s = new String(sb.toString(),"UTF-16");
				System.out.println(sb);

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {

		}

	}

}

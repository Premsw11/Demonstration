import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadAndWriteXL {
	public static void main(String[] args) throws Exception {
	File file =    new File("F:\\IT\\EclipseWorkSpace\\Demo121\\LargeIndex_UserContainer Info.xlsx");
    FileInputStream inputStream = new FileInputStream(file);
    Workbook workbook = new XSSFWorkbook(inputStream);
    org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet("Done");
    StringBuffer mdf = new StringBuffer();
    
    int start = 1;
    int last = 1;
    int current = 1;
    int whilecount = 0;
    while(whilecount<50) {
    	Row row = sheet.getRow(current);
    	String user1 = row.getCell(1).getStringCellValue();
    	
       	mdf.append(row.getCell(3).getStringCellValue());
    	
       	current++;
    	
       	row = sheet.getRow(current);
    	String user2 = row.getCell(1).getStringCellValue();
    	
    	if(user1==user2) {
    		mdf.append(row.getCell(3).getStringCellValue());
    		last++;
    	}
    	else {
    		row = sheet.getRow(start);
    		
    		String[] mdfArr = mdf.toString().split(",");
    	    List<String> list = new ArrayList<String>();
    	    for(String str:mdfArr) {
    	    	list.add(str);
    	    }
    	    Set<String> uniqueSet = new HashSet<>(list);
    		
    	    row.createCell(4).setCellValue(uniqueSet.toString());
    		
    	    start = last+1;
    		last++;
    		
    		mdf.delete(0, mdf.length());
    	}
    	whilecount++;
    }
    inputStream.close();
    FileOutputStream outputStream = new FileOutputStream(file);
    workbook.write(outputStream);
    workbook.close();
 	}
}

/**
 * 
 */
package Reader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

 
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import net.sourceforge.htmlunit.corejs.javascript.tools.debugger.Main;

/**
 * @author almgwary
 * Dec 11, 2015  3:09:53 PM  
 * TesstingAssigment2  Reader  
 * Exel.java
 */
public class Exel {
	
	 public ArrayList<LoginItem> read() throws BiffException, IOException{
		ArrayList<LoginItem> loginItems = new ArrayList<LoginItem>();
		
		File file = new File("C:\\f\\f.xls");
		Workbook workbook = Workbook.getWorkbook(file);
		Sheet sheet = workbook.getSheet(0);
		int row = sheet.getRows(), column  = sheet.getColumns();
		//System.out.println(row+ "-"+column);
		
		for(int j=0;j<row;++j ){
			loginItems.add(new LoginItem(sheet.getCell(0,j).getContents(), sheet.getCell(1,j).getContents()));	 
		}
		return loginItems;
		
		
	} 
}

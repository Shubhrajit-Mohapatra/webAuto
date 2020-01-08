package Nanoprecise.WebAuto;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ExcelLib {

		public static String folderpath = "X:\\Automation\\EBanking\\Test Data\\";
		public static Workbook book;
		public static Sheet sh;
		public static WritableWorkbook wbook;
		public static WritableSheet wsh;

		// create excel connetion to read the data
		public static void createExcelConnection(String fileName, String sheetName) {
			try {
				FileInputStream fis = new FileInputStream(folderpath + fileName);
				book = Workbook.getWorkbook(fis);
				sh = book.getSheet(sheetName);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// read the data from a particular cell
		public static String readData(int cnum, int rnum) {
			return sh.getCell(cnum, rnum).getContents();
		}

		// get no of rows
		public static int rowCount() {
			return sh.getRows();
		}

		// get no of columns
		public static int columnCount() {
			return sh.getColumns();
		}

		// create output excel connection
		public static void createOutputExcelConnection(String iFileName, String oFileName, String sheetName){
			try {
				FileInputStream fis = new FileInputStream(folderpath+iFileName);
				book =  Workbook.getWorkbook(fis);
				FileOutputStream fos = new FileOutputStream(folderpath+oFileName);
				wbook = Workbook.createWorkbook(fos,book);
				wsh = wbook.getSheet(sheetName);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		//write data into particular cell
		public static void writeData(int cnum, int rnum, String data){
			try {
				wsh.addCell(new Label(cnum, rnum, data));
				//wsh.addCell(new Number(cnum, rnum, val));
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		//save workbook
		public static void saveWorkbook(){
			try {
				wbook.write();
				wbook.close();
				book.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
}

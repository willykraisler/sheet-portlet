package co.com.bnpparibas.cardif.reader;


import co.com.bnpparibas.cardif.model.BogotaRow;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReaderFile {

	public final static int ID_CERT = 0;
	public final static int PROD_ID = 1;
	public final static int NAMES = 2;
	public final static int INITDATE = 3;
	public final static int FINALDATE = 4;
	public final static int PERID = 5;

	public static List<BogotaRow> readXLSXFile(List<BogotaRow> bogotaRows) throws IOException {

		InputStream ExcelFileToRead = new FileInputStream("/tmp/uploaded/Test.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
		XSSFWorkbook test = new XSSFWorkbook();
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row;
		XSSFCell cell;
		BogotaRow br = null;
		Iterator rows = sheet.rowIterator();
		rows.next();
		while (rows.hasNext()) {
			br = new BogotaRow();
			row = (XSSFRow) rows.next();
			Iterator cells = row.cellIterator();

			while (cells.hasNext()) {
				cell = (XSSFCell) cells.next();

				switch (cell.getColumnIndex()) {

				case ID_CERT:
					br.setCertNumber(cell.getNumericCellValue());
					break;

				case PROD_ID:
					br.setProdId(String.valueOf(cell.getNumericCellValue()));
					break;

				case NAMES:
					br.setName(cell.getStringCellValue());
					break;

				case INITDATE:
					br.setInitDate(String.valueOf(cell.getDateCellValue()));
					break;

				case FINALDATE:
					br.setFinalDate(String.valueOf(cell.getDateCellValue()));
					break;
					
				case PERID:
					br.setId(String.valueOf(cell.getNumericCellValue()));
					break;

				default:
					break;
				}

			}
			bogotaRows.add(br);			
		}
		return bogotaRows;

	}



}
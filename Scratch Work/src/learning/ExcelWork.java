package learning;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@SuppressWarnings("unused")
public class ExcelWork {
	public static void main(String[] args) {
		String FILE_NAME = ("C:/Users/Ali/Dropbox/Payroll/Name_Period_#.xlsx");
		FileInputStream excelFile;
		Workbook workbook = null;
		try {
			excelFile = new FileInputStream(new File(FILE_NAME));
			workbook = new XSSFWorkbook(excelFile);
			workbook.getSheetAt(0).getRow(0).getCell(0).setCellValue("5/13");
			workbook.setForceFormulaRecalculation(true);
			
			String EMPLOYEE_FILE_NAME = "C:/Users/Ali/Dropbox/Payroll/Ali_Period_#.xlsx";

			File file = new File(EMPLOYEE_FILE_NAME);
			if (!file.exists()) {
				file.createNewFile();

				// Write the output to a file
				FileOutputStream fileOut = new FileOutputStream(EMPLOYEE_FILE_NAME);
				workbook.write(fileOut);
				fileOut.close();
			}
			
			// Close IOs.
			workbook.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//		String FILE_NAME = "C:/Users/Smash!BSD/Dropbox/Payroll/Awaiting Approval/Submitted/Ali_Period_";
		//		FILE_NAME += 1 + ".xlsx";
		//		// String FILE_NAME =
		//		// ("C:/Users/Ali/Dropbox/Payroll/Example_Period_00.xlsx");
		//		try {
		//
		//			FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
		//			Workbook workbook = new XSSFWorkbook(excelFile);
		//			Sheet datatypeSheet = workbook.getSheetAt(1);
		//			Iterator<Row> iterator = datatypeSheet.iterator();
		//			// int countRow = 0;
		//			// while (iterator.hasNext()) {
		//			//
		//			// Row currentRow = iterator.next();
		//			// countRow++;
		//			// Iterator<Cell> cellIterator = currentRow.iterator();
		//			//
		//			// int countCell = 0;
		//			// while (cellIterator.hasNext()) {
		//			// Cell cell = cellIterator.next();
		//			// countCell++;
		//			// if (cell.getCellType() == CellType.FORMULA) {
		//			// switch (cell.getCachedFormulaResultType()) {
		//			// case NUMERIC:
		//			//// System.out.println(
		//			//// "Last evaluated as: " + cell.getNumericCellValue() + "| Row,Cell: " +
		//			// countRow + "," + countCell);
		//			// break;
		//			// }
		//			// }
		//			// }
		//			//// System.out.println();
		//			//
		//			// }
		//			for (int i = 0; i < 9; i++) {
		//				iterator.next();
		//			}
		//			Row totals = iterator.next();
		//			Iterator<Cell> cellItr = totals.iterator();
		//			double hours, rackets;
		//			Cell cell = cellItr.next();
		//			hours = (cell.getNumericCellValue());
		//			cell = cellItr.next();
		//			cell = cellItr.next();
		//			rackets = cell.getNumericCellValue();
		//			System.out.println("Hours, Rackets: " + hours + ", " + rackets);
		//		} catch (FileNotFoundException e) {
		//			e.printStackTrace();
		//		} catch (IOException e) {
		//			e.printStackTrace();
		//		}
	}

}

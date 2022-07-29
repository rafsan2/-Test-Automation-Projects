package ExcelUtils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static String projectPath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public ExcelUtils(String excelPath, String sheetName) {

		try {

			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	public static void main(String[] args) {

		getRowCount();
		getCellDataString(0, 0);
		getCellDataNumber(0, 1);

	}

	public static void getRowCount() {

		try {

			int rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("Number of rows : " + rowCount);

		} catch (Exception exp) {

			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();

		}

	}

	public static void getCellDataString(int rowNum, int colNum) {

		try {

			projectPath = System.getProperty("user.dir");
			workbook = new XSSFWorkbook(projectPath + "/Excel/Data.xlsx");
			sheet = workbook.getSheet("Sheet1");
			String urlCellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
//			String userName = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
//			String passWord = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			System.out.println(urlCellData);
			//System.out.println(userName);
//			System.out.println(passWord);

		} catch (Exception exp) {

			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();

		}

	}

	public static void getCellDataNumber(int rowNum, int colNum) {

		try {

			projectPath = System.getProperty("user.dir");
			workbook = new XSSFWorkbook(projectPath + "/Excel/Data.xlsx");
			sheet = workbook.getSheet("Sheet1");
			double urlCellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			System.out.println(urlCellData);

		} catch (Exception exp) {

			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();

		}

	}

}

package ExcelUtils;

public class ExcelUtilsDemo {

	public static void main(String[] args) {
		
		String projectPath = System.getProperty("user.dir");
		ExcelUtils excel = new ExcelUtils(projectPath + "/Excel/Data.xlsx", "sheet1");
		
		excel.getRowCount();
		excel.getCellDataString(0, 0);
		excel.getCellDataString(0, 1);
		excel.getCellDataString(0, 2);
		excel.getCellDataString(1, 0);
		excel.getCellDataString(1, 1);
		excel.getCellDataString(1, 2);
		excel.getCellDataNumber(2, 2);
	}
	
}

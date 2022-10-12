package basePackage;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelDataSupplier {

	
	@DataProvider
	public String [] [] getData() throws Exception {
	File excelFile=new File("./excel/exceldataPro.xlsx");
	System.out.println(excelFile.exists());
	
	FileInputStream fis=new FileInputStream(excelFile);
	
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	XSSFSheet sheet=workbook.getSheet("DataSheet");
	System.out.println(sheet.getPhysicalNumberOfRows());
	System.out.println(sheet.getLastRowNum()	);
	int noofRows=sheet.getPhysicalNumberOfRows();
	
	int noOfCoumns=sheet.getRow(0).getLastCellNum();
	
	String [] [] data=new String[noofRows-1][noOfCoumns];
	
	for(int i=0; i<noofRows-1;i++) {
		for (int j=0; j<noOfCoumns;j++) {
			DataFormatter df=new DataFormatter();
			//System.out.println(df.formatCellValue(sheet.getRow(i).getCell(j)));
          //System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
			data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
		}
		 System.out.println();
	}
	
	/**for(String [] dataArr:data) {
		System.out.println(Arrays.toString(dataArr));
	}**/
	 
	workbook.close();
	fis.close();
	return data;
}

}

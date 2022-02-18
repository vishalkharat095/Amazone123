package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {

	public static String getDataFromExcelSheet(String sheet,int row,int col) throws EncryptedDocumentException, IOException {
		String path="C:\\Users\\ASUS\\OneDrive\\Desktop\\Book2.xlsx";
		FileInputStream file=new FileInputStream(path);
	    String value=WorkbookFactory.create(file).getSheet("Sheet1")
	    		.getRow(row).getCell(col).getStringCellValue();
		String Data=value;
		return Data;
	}
	public static void getScreenshot(WebDriver driver,int testID) throws IOException {
	//	Date d=new Date(0);
	//	File fs=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//	SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy HH mm ss");
	//	String timestamp=sdf.format(d);
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd MM yyyy HH mm ss");
		LocalDateTime now=LocalDateTime.now();
		String DT=dtf.format(now);
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\ASUS\\OneDrive\\Pictures\\Screenshots\\"+"Test-"+testID+" "+DT+" .jpg");
		FileHandler.copy(src, dest);
		
	}
}

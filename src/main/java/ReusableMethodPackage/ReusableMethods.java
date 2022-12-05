package ReusableMethodPackage;








import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Com.ZomatoTest.Basetest1;







public class ReusableMethods  extends Basetest1 {

	
	
	JavascriptExecutor js;
	
	
	public void Frames(String id,WebDriver driver){
		driver.switchTo().frame(id);
		System.out.println("switched to frame");
		
	}
	
	public void  Webdriverwait(WebDriver driver,int time,WebElement element) {
		
		WebDriverWait wait=new WebDriverWait(driver,time);
	wait.until(ExpectedConditions.visibilityOf(element));

	}
	
	
	public void javaScript(WebDriver driver) {
		js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,80)");
	}
	
	public void ScreenShot(WebDriver driver, String TestcaseName) throws IOException {
		
		TakesScreenshot ts= (TakesScreenshot)driver;
	File src=	ts.getScreenshotAs(OutputType.FILE);
	File dest=new File(System.getProperty("user.dir")+"\\ScreenShots\\"+TestcaseName+".png");
	System.out.println(dest);
	FileUtils.copyFile(src,dest);
		
	}
	
public void 	ScreenShotElement(WebElement element,String WebElementName) throws IOException{
	
	File src=element.getScreenshotAs(OutputType.FILE);
	File dest=new File(System.getProperty("user.dir")+"\\ScreenShots\\"+WebElementName+".png");
	System.out.println(dest);
	FileUtils.copyFile(src,dest);
}

public ExtentReports CustomizeReport() {
	File f=new File(System.getProperty("user.dir")+"\\test-output\\index.html");
	ExtentSparkReporter reporter =new ExtentSparkReporter(f); 
	reporter.config().setDocumentTitle("Selenium Automation Report For UI Base Application");
	reporter.config().setReportName("TestCase Execution progress Report");
	
	ExtentReports report=new ExtentReports();
	report.attachReporter(reporter);
	return report;

}

public String ScreenShotPath(WebDriver driver, String TestcaseName) throws IOException {
	
	TakesScreenshot ts= (TakesScreenshot)driver;
File src=	ts.getScreenshotAs(OutputType.FILE);
File dest=new File(System.getProperty("user.dir")+"\\ScreenShots\\"+TestcaseName+".png");
System.out.println(dest);
FileUtils.copyFile(src,dest);
	return System.getProperty("user.dir")+"\\ScreenShots\\"+TestcaseName+".png";
}




public List<HashMap<String,String>>  JasonData() throws IOException {
	File f=new File(System.getProperty("user.dir")+"\\src\\main\\java\\Com\\utilityPackage\\DataReader.jason");
	String JasonContent=FileUtils.readFileToString(f, StandardCharsets.UTF_8);
	ObjectMapper mapper=new ObjectMapper();
	List<HashMap<String,String>> l=mapper.readValue(JasonContent, new TypeReference<List<HashMap<String,String>>>(){});
	
	return l;
}


public void ReadFileFromExcel() {
	XSSFSheet sheet = null;
XSSFWorkbook xsf=new XSSFWorkbook();	
for(int i=0;i<xsf.getNumberOfSheets();i++) {
	
	if(xsf.getSheetName(i).equalsIgnoreCase("Data")) {
	 sheet=	xsf.getSheetAt(i);
	}
	
}

Iterator it=sheet.iterator();
while(it.hasNext()) {
	Row row= (Row) it.next();
	
	Iterator it1=row.cellIterator();
	while(it1.hasNext()) {
		Cell cell=(Cell) it1.next();
		cell.setCellType(Cell.CELL_TYPE_STRING);
		System.out.println(cell.getStringCellValue());
		
	}}}
	
	
	
	
	
	public void ChromeOptionsMethod() {
		ChromeOptions options=new ChromeOptions();
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
	}
	








	
}

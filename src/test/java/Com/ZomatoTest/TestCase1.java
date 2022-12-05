package Com.ZomatoTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;


import org.apache.logging.log4j.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Com.WebPages.HomeWebPage;
import Com.WebPages.LandingWebPage;
import Com.WebPages.LoginwebPage;
import Com.WebPages.SearchresultPage;
import Com.WebPages.SelectedFoodWebPage;
import Listeners.Rerun;

import ReusableMethodPackage.ReusableMethods;




public class TestCase1 extends ReusableMethods{

	
	private static Logger l=LogManager.getLogger(TestCase1.class.getName());
	WebDriver driver;
	
	LandingWebPage landingWebPage;
	LoginwebPage  loginwebPage;
	HomeWebPage homeWebPage;
	SearchresultPage searchresultPage;
	
	
	
	
	
	
	
	SelectedFoodWebPage selectedFoodWebPage;
	@BeforeMethod
	public void OpenBroweser() throws IOException{
	driver=	invokeBrowser();	
	l.info("Invoke Browser Successfully");
		
		
	}
	
	
	

	@Test(groups="SmokeTest",retryAnalyzer=Rerun.class)
	@Parameters("Food")
	public void searchProduct(String Food) throws InterruptedException {
		
		landingWebPage=new LandingWebPage(driver);
		
		landingWebPage.setLocation();
		l.info("Location Selected Succesfully");
		searchresultPage=landingWebPage.SearchFood(Food);
		searchresultPage.searchresults();
		l.info("Search Results appears");
	}
	
	
	
	
	@Test(enabled=false)
	@Parameters("Food")
	public void selectVegOption(String Food) throws InterruptedException, IOException {
		
		landingWebPage=new LandingWebPage(driver);
	
		landingWebPage.setLocation();
		
		searchresultPage=landingWebPage.SearchFood(Food);
		selectedFoodWebPage=searchresultPage.searchresults();
		selectedFoodWebPage.VegOnlyOption();
		selectedFoodWebPage.ContainsEggs();
		
	
	}
	
	
	

		
	
	
}

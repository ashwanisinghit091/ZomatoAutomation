package Com.ZomatoTest;







import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
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

public class TestCase2 extends ReusableMethods {

	
	

	LoginwebPage  loginwebPage;
	HomeWebPage homeWebPage;
	SearchresultPage searchresultPage;
WebDriver driver;
SelectedFoodWebPage selectedFoodWebPage;
	LandingWebPage landingWebPage;
	
	
	@BeforeMethod
	public void OpenBroweser() throws IOException{
	driver=	invokeBrowser();	
		
		
	}
	
	
	@Test(enabled=false)
	public void Login() throws InterruptedException {
		
		landingWebPage=new LandingWebPage(driver);
		
		
		
	}
	
	
	@Test(dataProvider="getJasonData")
	
	public void selectVegOption(HashMap<String,String> h ) throws InterruptedException, IOException {
		
		landingWebPage=new LandingWebPage(driver);
	
		landingWebPage.setLocation();
		
		searchresultPage=landingWebPage.SearchFood(h.get("Food"));
		selectedFoodWebPage=searchresultPage.SelectSpecific_restro_from_searchresults(h.get("Restro_Name"));
		selectedFoodWebPage.VegOnlyOption();
		selectedFoodWebPage.ContainsEggs();
		
		
	}
	@DataProvider()
	public Object[][] getJasonData() throws IOException{
		
		List<HashMap<String,String>>  l=JasonData();
		Object [][] o= {{l.get(0)},{l.get(1)}};
		return o;
	}
}

package StepDefinition;

import org.testng.Assert;

import com.cucumber.listener.Reporter;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import Pages.HomePage;
import Pages.LoginPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class SeleniumStep {

	WebDriver driver;
	LoginPage lo;
	HomePage home;
@Before
	public static void setup(){
		Reporter.assignAuthor("susmitha");
	}
	
@Given("^open browser and enter url$")
public void open_browser_and_enter_url() {
	System.setProperty("webdriver.chrome.driver", "G://Eclipse Workspace//Resources//Drivers//chromedriver.exe");
	driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 driver.get("file:///C:/Users/acer/Downloads/original_1588252119_Testing_Casestudy_HotelBooking/Casestudy_HotelBooking/login.html");
	 }

@Given("^title of login is Hotel Booking Application$")
public void title_of_login_is_Hotel_Booking_Application()  {
    lo= new LoginPage(driver);
 String title=  lo.getLoginTitle();
 
 Assert.assertEquals("Hotel Booking Application", title);
   
  // assert.assertEquals(title, "Hotel Booking Application");
}

@When("^user enter \"([^\"]*)\" and \"([^\"]*)\"$")
public void user_enter_and(String arg1, String arg2) throws InterruptedException  {
   
	lo=new LoginPage(driver);
	lo.clickOnloginbtn();
	Thread.sleep(2000);
	lo.enterName(arg1);
	lo.clickOnloginbtn();
	lo.enterPassword(arg2);
	lo.clickOnloginbtn();
	
}

@When("^user is on HotelBooking homepage$")
public void user_is_on_HotelBooking_homepage()  {
    
	home =new HomePage(driver);
	String hometitle = home.getHomeTitle();
	Assert.assertEquals("Hotel Booking Form", hometitle);
	   
}

@Then("^User enter all the required Details$")
public void user_enter_all_the_required_Details()  {
  
	home =new HomePage(driver);

	home.clickOnconfirmbutton();
	Alert alert = driver.switchTo().alert();
	alert.accept();
	home.enterfirstname("sai susmitha");
	home.clickOnconfirmbutton();
	alert.accept();
	home.enterLastName("Gajjarapu");
	home.clickOnconfirmbutton();
	alert.accept();
	home.enter_Email("sai.gajjarapu@");
	home.clickOnconfirmbutton();
	alert.accept();
	home.enter_Email("sai.gajjarapu@gmail.com");
	home.enter_Phone("012345678");
	home.clickOnconfirmbutton();
	alert.accept();
	home.enter_Phone("9989408943");
	home.enterAddress("kondapur flat no 222");
	home.clickOnconfirmbutton();
	alert.accept();
	home.select_city();
	home.clickOnconfirmbutton();
	alert.accept();
	home.select_state();
	home.clickOnconfirmbutton();
	alert.accept();
	home.select_persons();
	home.clickOnconfirmbutton();
	alert.accept();
	home.enterHolderName("Kaveti");
	home.clickOnconfirmbutton();
	alert.accept();
	home.enterCardNumber("987642229933300333");
	home.clickOnconfirmbutton();
	alert.accept();
	home.enterCvv("893");
	home.clickOnconfirmbutton();
	alert.accept();
	home.enterMonth("December");
	home.clickOnconfirmbutton();
	alert.accept();
	home.enterYear("2023");
	home.clickOnconfirmbutton();
}

@Then("^Close the browser$")
public void close_the_browser() throws InterruptedException  {
	
	home =new HomePage(driver);
    String Success=	home.getSuccessTitle();
	Assert.assertEquals("Booking Completed!", Success);
	Thread.sleep(2000);
    driver.quit();	
}

@After
public void afterSenerio(Scenario senerio) throws IOException{
	
	Reporter.addScenarioLog("In Case of failure takes screenshot");
	if(senerio.isFailed()){
		String screenshotname = senerio.getName().replaceAll(" ","_");
		
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"//target//html//"+screenshotname+".png");
		FileHandler.copy(src,dest);
		
		Reporter.addScreenCaptureFromPath(dest.toString());
		
		
	}
}
}

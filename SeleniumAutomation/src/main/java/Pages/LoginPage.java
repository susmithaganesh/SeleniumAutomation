package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver) {
	     PageFactory.initElements(driver, this);
	 }
	
	@FindBy(xpath="//h1[text()=' Hotel Booking Application ']")
	WebElement pagetitle;
	
	@FindBy(name = "userName")
	WebElement username;
	
	@FindBy(name= "userPwd")
	WebElement pwd;
	
	@FindBy(xpath ="//input[@class='btn']")
	WebElement loginbtn;
	
	
	public String getLoginTitle(){

	     return    pagetitle.getText();

	    }
	
	public void enterName(String name) {
		username.sendKeys(name);
		 }
		 
		 public void enterPassword(String password) {
			 pwd.sendKeys(password);
		 }
		 public void clickOnloginbtn() {
			 loginbtn.click();
			 }
}

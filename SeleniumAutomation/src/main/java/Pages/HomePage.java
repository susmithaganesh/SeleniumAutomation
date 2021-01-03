package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	
	public HomePage(WebDriver driver) {
	     PageFactory.initElements(driver, this);
	 }
	
	@FindBy(xpath="//h2[text()='Hotel Booking Form']")
	
	WebElement hometitle;

	@FindBy(id="txtFirstName")
	WebElement FirstName;
	
	@FindBy(id="txtLastName")
	WebElement LastName;
	
	@FindBy(id="txtEmail")
	WebElement Email;
	
	@FindBy(id="txtPhone")
	WebElement phoneNumber;
	
	@FindBy(xpath ="/html/body/div/div/form/table/tbody/tr[6]/td[2]/textarea")
	WebElement Address;
	
	@FindBy(xpath ="//select[@name='city']")
	WebElement City;
	
	@FindBy(xpath="//select[@name='state']")
	WebElement state;
	
	@FindBy(xpath="//select[@name='persons']")
	WebElement persons;
	
	@FindBy(id="txtCardholderName")
	WebElement Holdername;
	
	@FindBy(id="txtDebit")
	WebElement cardnumber;
	
	@FindBy(id="txtCvv")
	WebElement CVV;
	
	@FindBy(id="txtMonth")
	WebElement month;
	
	@FindBy(id="txtYear")
	WebElement year;
	
	@FindBy(id="btnPayment")
	WebElement confirmbtn;
	

	@FindBy(xpath="//h1[text()='Booking Completed!']")
	
	WebElement successtitle;
	
	public String getHomeTitle(){
     return    hometitle.getText();

	    }

	 public void enterfirstname(String name) {
		 FirstName.sendKeys(name);
	 }
	 
	 public void enterLastName(String lastName) {
		 LastName.sendKeys(lastName);
	 }
	 
	 public void enter_Email(String email) {
		 Email.clear();
		 Email.sendKeys(email);
	 }
	 
	 public void enter_Phone(String phone) {
		 phoneNumber.clear();
		 phoneNumber.sendKeys(phone);
		 }
		 public void enterAddress(String address) {
			 Address.sendKeys(address);
			 
	 }
		 public void select_city() {
			 Select selectcity =new Select(City);
			 selectcity.selectByVisibleText("Pune");
		 }
		 
		 public void select_state() {
			 Select selectstate =new Select(state);
			 selectstate.selectByVisibleText("Maharashtra");
		 }			 
		 public void select_persons() {
			 Select selectprn =new Select(persons);
			 selectprn.selectByValue("3");
		 }	
		 public void enterHolderName(String Hname) {
			 Holdername.sendKeys(Hname);
		 } 
		 
		 public void enterCardNumber(String crdnum) {
			 cardnumber.sendKeys(crdnum);
		 }
		 
		 public void enterCvv(String cvv) {
			 CVV.sendKeys(cvv);
		 }
		
		 public void enterMonth(String expmonth) {
			 month.sendKeys(expmonth);
		 } 
		 
		 public void enterYear(String expyear) {
			 year.sendKeys(expyear);
		 }
		 
			 public void clickOnconfirmbutton() {
				 confirmbtn.click();
				 }
			 
			 public String getSuccessTitle(){
			     return    successtitle.getText();

				    }
		 
}

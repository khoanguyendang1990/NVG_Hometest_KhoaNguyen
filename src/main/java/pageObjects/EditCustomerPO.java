package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.ReuseFunctions;

public class EditCustomerPO extends ReuseFunctions {

	WebDriver driver;
	public EditCustomerPO(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
}

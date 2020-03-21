package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.ReuseFunctions;

public class DeleteCustomerPO extends ReuseFunctions {

	WebDriver driver;
	public DeleteCustomerPO(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
}

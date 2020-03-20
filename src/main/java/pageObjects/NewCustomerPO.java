package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.ReuseFunctions;

public class NewCustomerPO extends ReuseFunctions {

	WebDriver driver;

	public NewCustomerPO(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}

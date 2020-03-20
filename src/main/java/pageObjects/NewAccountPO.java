package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.ReuseFunctions;

public class NewAccountPO extends ReuseFunctions {

	WebDriver driver;

	public NewAccountPO(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}

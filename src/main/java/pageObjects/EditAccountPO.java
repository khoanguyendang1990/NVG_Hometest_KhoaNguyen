package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.ReuseFunctions;

public class EditAccountPO extends ReuseFunctions {

	WebDriver driver;

	public EditAccountPO(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}

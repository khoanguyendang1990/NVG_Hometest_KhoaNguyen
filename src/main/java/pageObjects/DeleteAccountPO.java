package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.ReuseFunctions;

public class DeleteAccountPO extends ReuseFunctions {

	WebDriver driver;

	public DeleteAccountPO(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}

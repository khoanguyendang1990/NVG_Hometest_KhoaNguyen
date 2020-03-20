package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.ReuseFunctions;

public class DepositPO extends ReuseFunctions {

	WebDriver driver;

	public DepositPO(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}

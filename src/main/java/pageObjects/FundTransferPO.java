package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.ReuseFunctions;

public class FundTransferPO extends ReuseFunctions {

	WebDriver driver;

	public FundTransferPO(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}

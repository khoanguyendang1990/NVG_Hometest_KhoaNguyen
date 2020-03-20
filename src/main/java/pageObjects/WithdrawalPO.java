package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.ReuseFunctions;

public class WithdrawalPO extends ReuseFunctions {

	WebDriver driver;

	public WithdrawalPO(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}

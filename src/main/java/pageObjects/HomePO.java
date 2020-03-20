package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.ReuseFunctions;

public class HomePO extends ReuseFunctions {

	WebDriver driver;
	public HomePO(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
}

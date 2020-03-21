package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.ReuseFunctions;
import pageUIs.HomePageUI;

public class HomePO extends ReuseFunctions {

	WebDriver driver;
	DeleteCustomerPO deleteCustomerPO;
	public HomePO(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public DeleteCustomerPO openDeleteCustomerPage() {
		waitForElementVisible(HomePageUI.DELETE_CUSTOMER_MENU);
		clickToElement(HomePageUI.DELETE_CUSTOMER_MENU);
		return deleteCustomerPO;
	}
}

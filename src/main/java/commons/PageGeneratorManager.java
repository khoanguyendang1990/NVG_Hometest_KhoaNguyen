package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.DepositPO;
import pageObjects.EditAccountPO;
import pageObjects.EditCustomerPO;
import pageObjects.HomePO;
import pageObjects.LoginPO;
import pageObjects.NewAccountPO;
import pageObjects.NewCustomerPO;
import pageObjects.WithdrawalPO;

public class PageGeneratorManager {

	public static HomePO getHomePage(WebDriver driver) {
		return new HomePO(driver);
	}
	
	public static LoginPO getLoginPage(WebDriver driver) {
		return new LoginPO(driver);
	}

	public static NewCustomerPO getNewCustomerPage(WebDriver driver) {
		return new NewCustomerPO(driver);
	}
	
	public static EditCustomerPO getEditCustomerPage(WebDriver driver) {
		return new EditCustomerPO(driver);
	}
	
	public static NewAccountPO getNewAccountPage(WebDriver driver) {
		return new NewAccountPO(driver);
	}
	
	public static EditAccountPO getEditAccountPage(WebDriver driver) {
		return new EditAccountPO(driver);
	}
	
	public static DepositPO getDepositPage(WebDriver driver) {
		return new DepositPO(driver);
	}
	
	public static WithdrawalPO getWithdrawalPage(WebDriver driver) {
		return new WithdrawalPO(driver);
	}
}

package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.ReuseFunctions;
import commons.PageGeneratorManager;
import pageUIs.LoginPageUI;

public class LoginPO extends ReuseFunctions {

	WebDriver driver;

	public LoginPO(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void inputTextToUserName(String userID) {
		
		waitForElementVisible(LoginPageUI.USERID_TEXTBOX);
		sendKeyToElement(LoginPageUI.USERID_TEXTBOX, userID);
	}

	public void inpurtTextToPassword(String password) {
		waitForElementVisible(LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public void clickOnNextButton() {	
		waitForElementClickable(LoginPageUI.RESET_BUTTON);
		clickToElement(LoginPageUI.RESET_BUTTON);
	}
	
	public HomePO clickOnLogin() {	
		waitForElementClickable(LoginPageUI.LOGIN_BUTTON);
		clickToElement(LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}

	public HomePO loginSuccessfully(String userID, String password) {
		inputTextToUserName(userID);
		inpurtTextToPassword(password);
		clickOnLogin();
		return PageGeneratorManager.getHomePage(driver);
	}
}

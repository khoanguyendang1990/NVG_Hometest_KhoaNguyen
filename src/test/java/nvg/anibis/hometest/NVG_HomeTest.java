package nvg.anibis.hometest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.AbstractTest;
import commons.Constants;
import commons.PageGeneratorManager;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageUIs.LoginPageUI;

public class NVG_HomeTest extends AbstractTest {

	private WebDriver driver;
	private HomePageObject homePage;
	private LoginPageObject loginPage;

	@BeforeClass
	@Parameters("browserName")
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		homePage.openUrl(Constants.URL);
	}

//	@Test
//	public void TC_01_NavigateToLoginPage() {
//		loginPage= homePage.openLoginPage();
//	}
//	
//	@Test(enabled=false)
//	public void TC_02_Verify_Cursor_at_Login_page() {
//		//Cursor starts at Username when navigated to page.
//		verifyTrue(loginPage.isElementActived(LoginPageUI.EMAIL_TEXTBOX));
//		loginPage.inputTextToEmail("1234");
//		loginPage.clickToElement(LoginPageUI.NEXT_BUTTON);
//		
//		String backgroudColor = loginPage.getCSSvalue(LoginPageUI.EMAIL_TEXTBOX, "background");
//		System.out.println(backgroudColor);
//		String backgroudColor_hex = Color.fromString(backgroudColor).asHex();
//		System.out.println(backgroudColor_hex);
//		backgroudColor_hex.equalsIgnoreCase("#FFECEC");
//		
//		String borderColor = loginPage.getCSSvalue(LoginPageUI.EMAIL_TEXTBOX, "border-color");
//		System.out.println(borderColor);
//		String borderColor_hex = Color.fromString(borderColor).asHex();
//		System.out.println(borderColor_hex);
//		borderColor_hex.equalsIgnoreCase("#D01D00");
//		
//		verifyEquals(loginPage.getAttributeValue(LoginPageUI.EMAIL_TEXTBOX, "aria-invalid"), "true");
//		
//		verifyEquals(loginPage.getTextElement(LoginPageUI.EMAIL_ERROR_MSG), "Indiquez votre adresse e-mail");
//		
//	}
//	
//	@Test
//	public void TC_03_Verify_Login_Successfully() {
//		loginPage.inputTextToEmail(Constants.EMAIL_USERNAME);
//		loginPage.clickOnNextButton();
//		loginPage.inpurtTextToPassword(Constants.PASSWORD);
//		homePage = loginPage.clickOnLogin();
//		assertTrue(homePage.isMyAnibisDisplay("Mein Anibis"));
//	}
	
	@Test
	public void TC_04_Perform_Search() {
//		homePage.clickToHomeLink();
		System.out.println("click to Home link");
		homePage.clickToCatelogyLink();
		System.out.println("Select catelogy Immobilien");
		homePage.sendKeyToLocation("Zurich");
		homePage.selectLocationDropdown("10 km");
		homePage.sendKeyFromPrice("1000");
		homePage.sendKeyToPrice("1500");
	}
	
//	@Test
//	public void TC_05_Verify_Result_Dispaly_20_item_1st_page() {
//	}
//	
//	@Test
//	public void TC_06_Verify_Sort_List_By_Date() {
//	}


	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
}

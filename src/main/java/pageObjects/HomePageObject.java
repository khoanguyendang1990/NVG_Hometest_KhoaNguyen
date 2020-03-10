package pageObjects;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;

import commons.AbstractPageObject;
import pageUIs.HomePageUI;

public class HomePageObject extends AbstractPageObject {

	WebDriver driver;
	public HomePageObject(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public boolean isMyAnibisDisplay(String headerName) {
		waitForElementVisible(HomePageUI.HEADER_MY_ANIBIS);
		String header=getTextElement(HomePageUI.HEADER_MY_ANIBIS);
		return header.contains(headerName);
	}
	
	public void clickToAllCatelogies() {
		waitForElementVisible(HomePageUI.ALL_CATELOGIES_BUTTON);
		clickToElement(HomePageUI.ALL_CATELOGIES_BUTTON);
	}
	
	public void selectItemFromCatelogies(String itemName) throws InterruptedException {
		waitForElementVisible(HomePageUI.ALL_CATELOGIES_PARENT);
		selectItemInCustomDropdownJS(HomePageUI.ALL_CATELOGIES_PARENT, HomePageUI.ALL_CATELOGIES_CHILD, itemName);		
	}

	public void clickToCategoryApply() {
		waitForElementVisible(HomePageUI.CATELOGY_APPLY_BUTTON);
		clickToElement(HomePageUI.CATELOGY_APPLY_BUTTON);
	}

	public void clickToHomeLink() {
		waitForElementVisible(HomePageUI.HEADER_ANIBIS_LOGO);
		clickToElement(HomePageUI.HEADER_ANIBIS_LOGO);
	}

	public void sendKeyToLocation(String location) {
		scrollToElement(HomePageUI.LOCATION_TEXTBOX);
		waitForElementVisible(HomePageUI.LOCATION_TEXTBOX);
		
		sendKeyToElement(HomePageUI.LOCATION_TEXTBOX, location);
	}

	public void selectLocationDropdown(String valueItem) {
		waitForElementVisible(HomePageUI.LOCATION_DROPDOWN);
		scrollToElement(HomePageUI.LOCATION_DROPDOWN);
		selectItemInDropdown(HomePageUI.LOCATION_DROPDOWN, valueItem);
	}

	public void sendKeyFromPrice(String fromPrice) {
		scrollToElement(HomePageUI.FROM_PRICE_TEXTBOX);
		waitForElementVisible(HomePageUI.FROM_PRICE_TEXTBOX);
		sendKeyToElement(HomePageUI.FROM_PRICE_TEXTBOX, fromPrice);
	}

	public void sendKeyToPrice(String toPrice) {
		waitForElementVisible(HomePageUI.TO_PRICE_TEXTBOX);
		scrollToElement(HomePageUI.TO_PRICE_TEXTBOX);
		sendKeyToElement(HomePageUI.TO_PRICE_TEXTBOX, toPrice);
	}

	public void clickToCatelogyLink() {
		waitForElementVisible(HomePageUI.CATELOGY_IMMOBILIEN_lINK);
		scrollToElement(HomePageUI.CATELOGY_IMMOBILIEN_lINK);
		clickToElement(HomePageUI.CATELOGY_IMMOBILIEN_lINK);	
	}



}

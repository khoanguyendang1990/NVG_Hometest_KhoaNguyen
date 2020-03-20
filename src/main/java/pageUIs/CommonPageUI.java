package pageUIs;

public class CommonPageUI {

	//Header
	
	// Dynamic Element Component
	public static final String DYNAMIC_LINK="//a[contains(text(),'%s')]";
	public static final String DYNAMIC_TEXTBOX="//input[@name='%s']";
	public static final String DYNAMIC_TEXTAREA="//textarea[@name='%s']";
	public static final String DYNAMIC_BUTTON="//input[@name='%s']";
	public static final String DYNAMIC_RADIO_BUTTON="//input[@type='radio' and @value='%s']";
	public static final String DYNAMIC_PAGE_HEADING="//p[@class='heading3' and text()='%s']";
	public static final String DYNAMIC_TABLE_ROWNAME="//td[contains(text(),'%s')]/following-sibling::td";
	public static final String DYNAMIC_DROPDOWN_LIST="//select[@name='%s']";
	

}

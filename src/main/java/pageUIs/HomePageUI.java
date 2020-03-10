package pageUIs;

public class HomePageUI {
	//Header
	public static final String HEADER_ANIBIS_LOGO="//a[@id='ctl00_Header1_ctlHeaderMetaBar_hypLogo']";
	public static final String HEADER_MY_ANIBIS="//a[@id='ctl00_Header1_ctlHeaderMetaBar_ucMainLinks_hypMyAnibis']";
	
	//Category
	public static final String ALL_CATELOGIES_BUTTON="//a[@class='category-link modal-opener']";
	public static final String CATELOGY_APPLY_BUTTON="//a[@id='ctl00_phlContent_ModalDialogCategoryBrowser_lnkBrowserCategoryApply']";
	public static final String ALL_CATELOGIES_PARENT="//li[@class='category-item has-subcategories is-active']//ul[@class='categories-list']";
	public static final String ALL_CATELOGIES_CHILD="//li[@class='category-item has-subcategories is-active']//ul[@class='categories-list']/li";
	public static final String ALL_CATELOGIES_NAME="//span@id='ctl00_phlContent_ModalDialogCategoryBrowser_rptCategories_ctl16_lblCategoryName']";
	
	//Left Menu
	public static final String LOCATION_TEXTBOX="//input[@class='dyh2vd-0 jsDOZP']";
	public static final String LOCATION_DROPDOWN="//div[@class='sc-19dcm61-0 gFBkyB']//select[@class='sc-171glo2-0 bVVsvh']";
	public static final String FROM_PRICE_TEXTBOX="//div[@class='hxca5-0 kpwZbM']//div[@class='f5iff9-0 iKEMNZ'][1]//input[@class='sbfswc-0 gICDFB sc-6pjau7-0 exjtqj']";
	public static final String TO_PRICE_TEXTBOX="//div[@class='hxca5-0 kpwZbM']//div[@class='f5iff9-0 iKEMNZ'][2]//input[@class='sbfswc-0 gICDFB sc-6pjau7-0 exjtqj']";
	
	//Footer
	public static final String CATELOGY_IMMOBILIEN_lINK="//h2[@data-scroll-to-target='all-categories']//parent::div//a[contains(@data-tracking,'Immobilien')]";
}

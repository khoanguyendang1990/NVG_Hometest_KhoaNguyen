package com.bankguru.payment;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.impl.conn.Wire;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import commons.BaseTest;
import commons.Constants;
import commons.PageGeneratorManager;
import driverFactory.DriverManager;
import driverFactory.DriverManagerFactory;
import pageObjects.DepositPO;
import pageObjects.EditCustomerPO;
import pageObjects.HomePO;
import pageObjects.LoginPO;
import pageObjects.NewAccountPO;
import pageObjects.NewCustomerPO;
import pageObjects.WithdrawalPO;
import reportConfig.ExtentTestManager;

public class FC_01_Create_Edit_new_customer_account extends BaseTest {

	private WebDriver driver;
	private DriverManager driverManager;
	private LoginPO loginPageObject;
	private HomePO homePageObject;
	private NewCustomerPO newCustomerPageObject;
	private EditCustomerPO editCustomerPageObject;
	private NewAccountPO newAccountPageObject;
	private DepositPO depositPageObject;
	private WithdrawalPO withdrawalPageObject;

	private static int currentBalance;
	// TC01
	private String customerName = "Automation";
	private String gender = "m";
	private String dateOfBirth = "05/28/1990";

	private String address = "54 Tran Quang Co";
	private String city = "HoChiMinh";
	private String state = "VN";
	private String pin = "123456";
	private String mobileNumber = "0938992805";
	private String email = "khoa" + randomNumber() + "@hotmail.com";
	private String password = "1234aaAA";
	private static String customerID;
	// TC02
	private String updated_address = "54 Tran Quang Co updated";
	private String updated_city = "HoChiMinh updated";
	private String updated_state = "VN updated";
	private String updated_pin = "654321";
	private String updated_mobileNumber = "0338808365";
	private String updated_email = "vy" + randomNumber() + "@hotmail.com";

	// TC03
	private int initialDeposit = 50000;
	private String accountID;

	// TC05
	private int transferAmount = 5000;

	// TC06
	private int withdrawalAmount = 15000;
	private Log log = LogFactory.getLog(getClass());

	@Test
	public void TC_01_Create_new_customer_account_and_check_created_successfully() throws ParseException {
		ExtentTestManager.startTest("TC_01_Create_new_customer_account_and_check_created_successfully", "Create new customer account and check created successfully");

		log.info("========Start TC_01_Create_new_customer_account_and_check_created_successfully========");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 3: Open New Customer Page");
		log.info("Step 3: Open New Customer Page");
		homePageObject.openMultiplePages("New Customer");
		newCustomerPageObject = PageGeneratorManager.getNewCustomerPage(driver);
		verifyEquals(newCustomerPageObject.getTextDynamicPageHeading("heading3"), "Add New Customer");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 4: Fill in Customer Name, Gender, Date of Birth, Address, City, State, PIN, Mobile Number, E-mail, Password fields");
		log.info("Step 4: Fill in Customer Name, Gender, Date of Birth, Address, City, State, PIN, Mobile Number, E-mail, Password fields");

		log.info("Input Customer Name");
		newCustomerPageObject.inputToDynamicTextbox("name", customerName);

		log.info("Click on Gender Male radion button");
		newCustomerPageObject.clickToDynamicRadioButton(gender);

		log.info("Input Date of Birth");
		newCustomerPageObject.inputToDynamicTextbox("dob", dateOfBirth);

		log.info("Input Address");
		newCustomerPageObject.inputToDynamicTextarea("addr", address);

		log.info("Input City");
		newCustomerPageObject.inputToDynamicTextbox("city", city);

		log.info("Input State");
		newCustomerPageObject.inputToDynamicTextbox("state", state);

		log.info("Input Pin");
		newCustomerPageObject.inputToDynamicTextbox("pinno", pin);

		log.info("Input Mobile Number");
		newCustomerPageObject.inputToDynamicTextbox("telephoneno", mobileNumber);

		log.info("Input Email");
		newCustomerPageObject.inputToDynamicTextbox("emailid", email);

		log.info("Input Password");
		newCustomerPageObject.inputToDynamicTextbox("password", password);

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 5: Click Submit Button");
		log.info("Step 5: Click Submit Button");
		newCustomerPageObject.clickToDynamicButton("sub");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Verify Create New Customer Successfully");
		log.info("Verify Create New Customer Successfully");
		verifyEquals(newCustomerPageObject.getTextDynamicPageHeading("heading3"), "Customer Registered Successfully!!!");

		customerID = newCustomerPageObject.getTextDynamicTableRow("Customer ID");
		log.info("Get Customer ID after create. Customer ID: " + customerID);

		log.info("Verify Customer Name");
		verifyEquals(newCustomerPageObject.getTextDynamicTableRow("Customer Name"), customerName);

		log.info("Verify Date of Birth");
		String dob = convertFormatDateTime(dateOfBirth, "MM/dd/yyyy", "yyyy-MM-dd");
		verifyEquals(newCustomerPageObject.getTextDynamicTableRow("Birthdate"), dob);

		log.info("Verify Address");
		verifyEquals(newCustomerPageObject.getTextDynamicTableRow("Address"), address);

		log.info("Verify City");
		verifyEquals(newCustomerPageObject.getTextDynamicTableRow("City"), city);

		log.info("Verify State");
		verifyEquals(newCustomerPageObject.getTextDynamicTableRow("State"), state);

		log.info("Verify Pin");
		verifyEquals(newCustomerPageObject.getTextDynamicTableRow("Pin"), pin);

		log.info("Verify Mobile No.");
		verifyEquals(newCustomerPageObject.getTextDynamicTableRow("Mobile No."), mobileNumber);

		log.info("Verify Email");
		verifyEquals(newCustomerPageObject.getTextDynamicTableRow("Email"), email);
		log.info("========End TC_01_Create_new_customer_account_and_check_created_successfully========");
		ExtentTestManager.endTest();
	}

	@Test(dependsOnMethods = "TC_01_Create_new_customer_account_and_check_created_successfully")
	public void TC_02_Edit_customer_account_and_check_edited_successfully() {
		ExtentTestManager.startTest("TC_02_Edit_customer_account_and_check_edited_successfully", "Edit customer account and check edited successfully");
		log.info("========Start TC_02_Edit_customer_account_and_check_edited_successfully========");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 3: Open Edit Customer Page");
		log.info("Step 3: Open Edit Customer Page");
		homePageObject.openMultiplePages("Edit Customer");
		editCustomerPageObject = PageGeneratorManager.getEditCustomerPage(driver);
		verifyEquals(editCustomerPageObject.getTextDynamicPageHeading("heading3"), "Edit Customer Form");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 4: Enter Customer ID ");
		log.info("Step 4: Enter Customer ID");
		editCustomerPageObject.inputToDynamicTextbox("cusid", customerID);

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 5: Click Submit button");
		log.info("Step 5: Click Submit button");
		editCustomerPageObject.clickToDynamicButton("AccSubmit");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 6: Fill in Address, City, State, PIN, Mobile Number, E-mail fields");
		log.info("Step 6: Fill in Address, City, State, PIN, Mobile Number, E-mail fields");
		log.info("Input Address");
		editCustomerPageObject.inputToDynamicTextarea("addr", updated_address);

		log.info("Input City");
		editCustomerPageObject.inputToDynamicTextbox("city", updated_city);

		log.info("Input State");
		editCustomerPageObject.inputToDynamicTextbox("state", updated_state);

		log.info("Input Pin");
		editCustomerPageObject.inputToDynamicTextbox("pinno", updated_pin);

		log.info("Input Mobile Number");
		editCustomerPageObject.inputToDynamicTextbox("telephoneno", updated_mobileNumber);

		log.info("Input Email");
		editCustomerPageObject.inputToDynamicTextbox("emailid", updated_email);

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 7: Click Submit button");
		log.info("Step 7: Click Submit button");
		editCustomerPageObject.clickToDynamicButton("sub");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 8: Verify Edit Customer Successfully");
		log.info("Step 8: Verify Edit Customer Successfully");
		verifyEquals(editCustomerPageObject.getTextDynamicPageHeading("heading3"), "Customer details updated Successfully!!!");

		log.info("Verify Customer ID");
		verifyEquals(editCustomerPageObject.getTextDynamicTableRow("Customer ID"), customerID);

		log.info("Verify Customer Name");
		verifyEquals(editCustomerPageObject.getTextDynamicTableRow("Customer Name"), customerName);

		log.info("Verify Updated Address");
		verifyEquals(editCustomerPageObject.getTextDynamicTableRow("Address"), updated_address);

		log.info("Verify Updated City");
		verifyEquals(editCustomerPageObject.getTextDynamicTableRow("City"), updated_city);

		log.info("Verify Updated State");
		verifyEquals(editCustomerPageObject.getTextDynamicTableRow("State"), updated_state);

		log.info("Verify Updated Pin");
		verifyEquals(editCustomerPageObject.getTextDynamicTableRow("Pin"), updated_pin);

		log.info("Verify Updated Mobile No.");
		verifyEquals(editCustomerPageObject.getTextDynamicTableRow("Mobile No."), updated_mobileNumber);

		log.info("Verify Updated Email");
		verifyEquals(editCustomerPageObject.getTextDynamicTableRow("Email"), updated_email);
		log.info("========End TC_02_Edit_customer_account_and_check_edited_successfully========");
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_03_Create_new_account_and_check_created_successfully() {
		ExtentTestManager.startTest("TC_03_Create_new_account_and_check_created_successfully",
				"Add new account and check created successfully, then verify 'Current Amount' and 'Initial Deposit' are equal");
		log.info("========Start TC_03_Create_new_account_and_check_created_successfully========");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 3: Open New Account Page");
		log.info("Step 3: Open New Account Page");
		homePageObject.openMultiplePages("New Account");
		newAccountPageObject = PageGeneratorManager.getNewAccountPage(driver);
		verifyEquals(newAccountPageObject.getTextDynamicPageHeading("heading3"), "Add new account form");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 4: Fill in CustomerID, Account Type, Initial deposit fields");
		log.info("Step 4: Fill in CustomerID, Account Type, Initial deposit fields");
		newAccountPageObject.inputToDynamicTextbox("cusid", "16275");

		log.info("Select Account Type");
		newAccountPageObject.selectDynamicDropDownList("selaccount", "Savings");

		log.info("Input Initial Deposit");
		newAccountPageObject.inputToDynamicTextbox("inideposit", String.valueOf(initialDeposit));

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 5: Click Submit button");
		log.info("Step 5: Click Submit button");
		newAccountPageObject.clickToDynamicButton("button2");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 6: Verify New Account Created Successfully");
		log.info("Step 6: Verify New Account Created Successfully");
		verifyEquals(newAccountPageObject.getTextDynamicPageHeading("heading3"), "Account Generated Successfully!!!");

		accountID = newAccountPageObject.getTextDynamicTableRow("Account ID");
		log.info("Get Account ID after create. Account ID: " + accountID);

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 7: Verify Current Account = Initial Deposit = " + String.valueOf(initialDeposit));
		log.info("Step 7: Verify Current Account = Initial Deposit = " + String.valueOf(initialDeposit));
		verifyEquals(newAccountPageObject.getTextDynamicTableRow("Current Amount"), String.valueOf(initialDeposit));

		currentBalance = initialDeposit;
		log.info("Get Current Balance after initial. Current Balance: " + currentBalance);
		log.info("========End TC_03_Create_new_account_and_check_created_successfully========");
		ExtentTestManager.endTest();
	}

	@Test(dependsOnMethods = "TC_03_Create_new_account_and_check_created_successfully")
	public void TC_04_Edit_account_anh_check_type_of_Account_is_Current() {

		ExtentTestManager.startTest("TC_04_Edit_account_anh_check_type_of_Account_is_Current", "Edit account anh check type of Account is 'Current'");
		log.info("========Start TC_04_Edit_account_anh_check_type_of_Account_is_Current========");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 3: Open Edit Account Page");
		log.info("Step 3: Open Edit Account Page");
		homePageObject.openMultiplePages("Edit Account");
		editCustomerPageObject = PageGeneratorManager.getEditCustomerPage(driver);
		verifyEquals(editCustomerPageObject.getTextDynamicPageHeading("heading3"), "Edit Account Form");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 4: Enter Account ID ");
		log.info("Step 4: Enter Account ID");
		editCustomerPageObject.inputToDynamicTextbox("accountno", accountID);

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 5: Click Submit button");
		log.info("Step 5: Click Submit button");
		editCustomerPageObject.clickToDynamicButton("AccSubmit");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 6: Change Type Account to Current");
		log.info("Step 6: Change Type Account to Current");
		editCustomerPageObject.selectDynamicDropDownList("a_type", "Current");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 7: Click Submit button");
		log.info("Step 7: Click Submit button");
		editCustomerPageObject.clickToDynamicButton("AccSubmit");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 8: Verify Account details updated Successfully!!!");
		log.info("Step 8: Verify Account details updated Successfully!!!");
		verifyEquals(editCustomerPageObject.getTextDynamicPageHeading("heading3"), "Account details updated Successfully!!!");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 9: Verify Account Type = Current");
		log.info("Step 9: Verify Account Type = Current");
		verifyEquals(editCustomerPageObject.getTextDynamicTableRow("Account Type"), "Current");

		log.info("========End TC_04_Edit_account_anh_check_type_of_Account_is_Current========");
		ExtentTestManager.endTest();
	}

	@Test(dependsOnMethods = "TC_04_Edit_account_anh_check_type_of_Account_is_Current")
	public void TC_05_Transfer_Money_Into_Current_Account() {
//		accountID="76401";
		ExtentTestManager.startTest("TC_05_Transfer_Money_Into_Current_Account", "Transfer money into a current account and check account balance equal 55,000");
		log.info("========Start TC_05_Transfer_Money_Into_Current_Account========");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 3: Open Deposit Page");
		log.info("Step 3: Open Deposit Page");
		homePageObject.openMultiplePagesJS("Deposit");
		depositPageObject = PageGeneratorManager.getDepositPage(driver);
		verifyEquals(depositPageObject.getTextDynamicPageHeading("heading3"), "Amount Deposit Form");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 4: Fill in Account No, Amount, Description fields");
		log.info("Step 4: Fill in Account No, Amount, Description fields");

		log.info("Input Account ID");
		depositPageObject.inputToDynamicTextbox("accountno", accountID);

		log.info("Input Amount");
		depositPageObject.inputToDynamicTextbox("ammount", String.valueOf(transferAmount));

		log.info("Input Description");
		depositPageObject.inputToDynamicTextbox("desc", "Deposit");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 5: Click Submit Button");
		log.info("Step 5: Click Submit Button");
		depositPageObject.clickToDynamicButton("AccSubmit");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Verify message displays with content Transaction details of Deposit for Account Number " + accountID);
		log.info("Verify message displays with content Transaction details of Deposit for Account Number " + accountID);
		verifyEquals(depositPageObject.getTextDynamicPageHeading("heading3"), "Transaction details of Deposit for Account " + accountID);

		ExtentTestManager.getTest().log(LogStatus.INFO, "Verify Current Balance: " + String.valueOf(currentBalance + transferAmount));
		System.out.println(String.valueOf(currentBalance + transferAmount));
		log.info("Verify Current Balance: " + String.valueOf(currentBalance + transferAmount));
		verifyEquals(depositPageObject.getTextDynamicTableRow("Current Balance"), String.valueOf(currentBalance + transferAmount));
		currentBalance = currentBalance + transferAmount;
		log.info("Get Current Balance after Transfer Amount. Current Balance: " + currentBalance);
		
		log.info("========End TC_05_Transfer_Money_Into_Current_Account========");
		ExtentTestManager.endTest();
	}

	@Test(dependsOnMethods = "TC_05_Transfer_Money_Into_Current_Account")
	public void TC_06_Withdraw_Money_From_Current_Account() {
		ExtentTestManager.startTest("TC_06_Withdraw_Money_From_Current_Account", "Withdraw money from current account and check account balance equal 40,000");
		log.info("========Start TC_06_Withdraw_Money_From_Current_Account========");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 3: Open Withdraw Page");
		log.info("Step 3: Open Withdrawal Page");
		homePageObject.openMultiplePagesJS("Withdrawal");
		withdrawalPageObject = PageGeneratorManager.getWithdrawalPage(driver);
		verifyEquals(withdrawalPageObject.getTextDynamicPageHeading("heading3"), "Amount Withdrawal Form");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 4: Fill in Account No, Amount, Description fields");
		log.info("Step 4: Fill in Account No, Amount, Description fields");

		log.info("Input Account ID");
		withdrawalPageObject.inputToDynamicTextbox("accountno", accountID);

		log.info("Input Amount");
		withdrawalPageObject.inputToDynamicTextbox("ammount", String.valueOf(withdrawalAmount));

		log.info("Input Description");
		withdrawalPageObject.inputToDynamicTextbox("desc", "Withdrawal");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 5: Click Submit Button");
		log.info("Step 5: Click Submit Button");
		withdrawalPageObject.clickToDynamicButton("AccSubmit");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Verify message displays with content Transaction details of Withdrawal for Account " + accountID);
		log.info("Verify message displays with content Transaction details of Withdrawal for Account " + accountID);
		verifyEquals(withdrawalPageObject.getTextDynamicPageHeading("heading3"), "Transaction details of Withdrawal for Account " + accountID);

		ExtentTestManager.getTest().log(LogStatus.INFO, "Verify Current Balance: " + String.valueOf(currentBalance - withdrawalAmount));
		log.info("Verify Current Balance: " + String.valueOf(currentBalance - withdrawalAmount));
		verifyEquals(withdrawalPageObject.getTextDynamicTableRow("Current Balance"), String.valueOf(currentBalance - withdrawalAmount));

		currentBalance = currentBalance - withdrawalAmount;
		log.info("Get Current Balance after Transfer Amount. Current Balance: " + currentBalance);
		
		log.info("========End TC_06_Withdraw_Money_From_Current_Account========");
		ExtentTestManager.endTest();
	}

	@BeforeClass
	@Parameters("browserName")
	public void beforeClass(String browserName) {
//		driverManager = DriverManagerFactory.getBrowserDriver(browserName);
//		driver = driverManager.getDriver();
		driver = getBrowserDriver(browserName);
		loginPageObject = PageGeneratorManager.getLoginPage(driver);
		loginPageObject.openUrl(Constants.URL);
		homePageObject = loginPageObject.loginSuccessfully(Constants.USERID, Constants.PASSWORD);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}

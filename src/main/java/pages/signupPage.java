package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {

	public SignupPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[normalize-space()='Create Account']")
	public WebElement createAccount_button;

	@FindBy(xpath = "//*[@id='id_gender1' and @value='Mr']")
	public WebElement mrRadioBtn;

	@FindBy(xpath = "//*[@id='id_gender2' and @value='Mrs']")
	public WebElement mrsRadioBtn;

	@FindBy(xpath = "//input[@id='password']")
	public WebElement passwordTxtbox;

	@FindBy(xpath = "//select[@name='days']")
	public WebElement day_dropdown;

	@FindBy(xpath = "//select[@name='months']")
	public WebElement month_dropdown;

	@FindBy(xpath = "//select[@id='years']")
	public WebElement year_dropdown;

	@FindBy(xpath = "//input[@name='newsletter']")
	public WebElement signUpForNewsLetter_Checkbox;

	@FindBy(xpath = "//input[@name='optin']")
	public WebElement Receivespecialoffer_checkbox;

	@FindBy(xpath = "//input[@id='first_name']")
	public WebElement firstName_txtbox;

	@FindBy(xpath = "//input[@id='last_name']")
	public WebElement lastName_txtbox;

	@FindBy(xpath = "//input[@id='company']")
	public WebElement company_txtbox;

	@FindBy(xpath = "//input[@id='address1']")
	public WebElement address1_txtbox;

	@FindBy(xpath = "//input[@id='address2']")
	public WebElement address2_txtbox;

	@FindBy(xpath = "//select[@id='country']")
	public WebElement countryDropdown;

	@FindBy(xpath = "//input[@id='state']")
	public WebElement state_txtbox;

	@FindBy(xpath = "//input[@id='city']")
	public WebElement city_txtbox;

	@FindBy(xpath = "//input[@id='zipcode']")
	public WebElement zipcode_txtbox;

	@FindBy(xpath = "//input[@id='mobile_number']")
	public WebElement mobile_number_txtbox;

	@FindBy(xpath = "//h2[@class='title text-center']//b")
	public WebElement accountCreated_txt;

	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div/p[1]")
	public WebElement congratulation_txt;

	@FindBy(xpath = "//a[@data-qa='continue-button']")
	public WebElement continueBtn;

	@FindBy(xpath = "//a[@href='/logout']")
	public WebElement logoutBtn;

	@FindBy(xpath = "//a[@href='/delete_account']")
	public WebElement deleteaccount_Btn;

	@FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a/b")
	public WebElement userName;

}

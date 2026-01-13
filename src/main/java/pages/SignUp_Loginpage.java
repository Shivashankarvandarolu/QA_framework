package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SignUp_Loginpage {

	public WebDriver driver;

	public SignUp_Loginpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//h2[normalize-space()='Login to your account']")
	public WebElement loginToYourAccount_txt;

	@FindBy(xpath = "//h2[normalize-space()='New User Signup!']")
	public WebElement newUserSignup_txt;

	@FindBy(xpath = "//h2[normalize-space()='Login to your account']//following::input[@type='email' and @name='email' and @data-qa='login-email']")
	public WebElement login_email;

	@FindBy(xpath = "//h2[normalize-space()='Login to your account']//following::input[@data-qa='login-password']")
	public WebElement login_password;

	@FindBy(xpath = "//input[@data-qa='signup-name']")
	public WebElement signUp_name_txtbox;

	@FindBy(xpath = "//input[@data-qa='signup-email']")
	public WebElement signup_email;

	@FindBy(xpath = "//button[@data-qa='login-button']")
	public WebElement loginBtn;

	@FindBy(xpath = "//button[@data-qa='signup-button']")
	public WebElement signUpBtn;

}

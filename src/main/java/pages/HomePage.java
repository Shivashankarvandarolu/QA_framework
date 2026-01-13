package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.DriverFactory;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver; // ✅ USE PASSED DRIVER
		PageFactory.initElements(driver, this); // ✅ SAME DRIVER
	}

	@FindBy(xpath = "//img[@alt='Website for automation practice']")
	public WebElement logo;

	@FindBy(xpath = "//a[normalize-space()='Home']")
	public WebElement HomeButton;

	@FindBy(xpath = "//a[@href='/products']")
	public WebElement productsBtn;

	@FindBy(xpath = "//a[normalize-space()= 'Cart']")
	public WebElement cartBtn;

	@FindBy(xpath = "//a[normalize-space()='Signup / Login']")
	public WebElement signUp_login_btn;

	@FindBy(xpath = "//a[normalize-space()='Test Cases']")
	public WebElement testcases_Btn;

	@FindBy(xpath = "//a[normalize-space()='API Testing']")
	public WebElement apitesting_btn;

	@FindBy(xpath = "//a[normalize-space()='Video Tutorials']")
	public WebElement videoTutorials_btn;

	@FindBy(xpath = "//a[normalize-space()='Contact us']")
	public WebElement contact_btn;

}

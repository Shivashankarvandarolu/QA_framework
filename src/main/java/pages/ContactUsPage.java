package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {

	public WebDriver driver;

	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//h2[@class='title text-center' and text()='Get In Touch']")
	public WebElement getInTouch_txt;

	@FindBy(xpath = "//*[@name='name']")
	public WebElement name_txtbox;

	@FindBy(xpath = "//*[@name='email']")
	public WebElement email_txtbox;

	@FindBy(xpath = "//*[@name='subject']")
	public WebElement subject_txtbox;

	@FindBy(xpath = "//*[@id='message']")
	public WebElement message_txtbox;

	@FindBy(xpath = "//input[@name='upload_file']")
	public WebElement upload_fileBtn;

	@FindBy(xpath = "//*[@name='submit']")
	public WebElement submitBtn;
	
	@FindBy(xpath="//*[@class='status alert alert-success']")
	public WebElement alertSuccessmessage;
	
	@FindBy(xpath="//a[@class='btn btn-success']")
	public WebElement homeBtn;

}

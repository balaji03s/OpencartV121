package Day47;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage1 {
	
	WebDriver driver;
	
	//constructor
	
	loginPage1(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//Locators
	/*
	By txt_username=By.xpath("//input[@placeholder='Username']");
	By txt_password=By.xpath("//input[@placeholder='Password']");
	By btn_login=By.xpath("//button[normalize-space()='Login']");*/
	
	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement txt_username;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement txt_password;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement btn_login;
	
	//Action methods
	
	public void setUserName(String user)
	{
		txt_username.sendKeys(user);
	}
	
	public void setPassword(String pwd)
	{
		txt_password.sendKeys(pwd);
	}
	
	public void Clickloginn()
	{
		btn_login.click();
	}

	
	
	
}

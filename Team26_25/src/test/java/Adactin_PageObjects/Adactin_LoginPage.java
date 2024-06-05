package Adactin_PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Adactin_LoginPage {
	
	//3 parts(constructor, identify the elements and corresponding actions)
	
	WebDriver driver;
	public Adactin_LoginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	WebElement txtUsername;
	
	@FindBy(id="password")
	WebElement txtPassword;
	
	@FindBy(id="login")
	WebElement btnLogin;
	
	
	//create the corresponding actions
	
	public void setIUsername(String uname) {
		txtUsername.sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void ClickLoginBtn() {
		btnLogin.click();
	}

}

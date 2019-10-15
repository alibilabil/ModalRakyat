package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	By emailField = By.name("email");
	
	By selanjunyaButton = By.xpath("//form[@id='login-step-one-form']/button");
	
	By passwordField = By.xpath("//input[@id='password']");
	
	By loginButton = By.xpath("//button[@id='login-submit']");
	
	By verifByWA = By.xpath("//div[@id='cotp__method--wa']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	//fill the email field
	public void setEmail(String email) {
		driver.findElement(emailField).sendKeys(email);
	}
	//click the next button
	public void clickNext() {
		driver.findElement(selanjunyaButton).click();
	}
	//fill the password field
	public void setPassword(String password)
	{
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(passwordField)).click();
		driver.findElement(passwordField).sendKeys(password);
	}
	
	public void clickLogin()
	{
		driver.findElement(loginButton).click();
	}
	public void clickVerifMethod() {
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(verifByWA)).click();
	}
	}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PulsaPage {
	WebDriver driver;
	
	By phoneNumberField = By.name("client_number");
	//nominal Rp.100.0000
	By nominal = By.xpath("//div[contains(@role,'button')]//*[text()='100.000']");
	
	By beliButton = By.xpath("//button[@data-test='beli-btn']");
	
	public PulsaPage(WebDriver driver) {
		this.driver = driver;
	}
	//set phone number
	public void fillNumberPhone(String phoneNumber) {
		driver.findElement(phoneNumberField).sendKeys(phoneNumber);
	}
	//choose the amount of pulsa
	public void chooseAmount() {
		driver.findElement(nominal).click();
	}
	
	public void clickBeliButton() {
		driver.findElement(beliButton).click();
	}
	}

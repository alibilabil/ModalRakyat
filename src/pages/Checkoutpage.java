package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checkoutpage {
	WebDriver driver;
	By payButton = By.xpath("//a[@id='pay-btn']");
	
	By othersMethodPayment = By.xpath("//div[contains(@class,'unf-btn unf-btn--animate unf-btn--secondaryGreen unf-btn--block unf-btn--large')]");
	
	By BCAPayment = By.xpath("//body/div[@class='popup popup__payment']/div[@class='list_payment_method popup__payment-method method-list popup__container mt-40']/div[@class='method__wrapper']/div[@class='method__content']/div[@id='VirtualAccount']/div[2]");
	
	By bayarButton =By.xpath("//body/div[@class='btn-floating']/a[1]");
	
	By bankNumber = By.xpath("//*[@id=\"content\"]/div[2]/div[6]/div[1]/div[1]/div/div[2]/div[2]");
	
	By bayarSekarangPopUpButton = By.xpath("//span[contains(text(),'Yuk, Bayar Sekarang!')]");
	
	public Checkoutpage(WebDriver driver) {
		this.driver= driver;
	}
	
	public void clickPayButton() throws InterruptedException{
		driver.findElement(payButton).click();
	}
	
	public void bayarSekarangPopUpButton() throws InterruptedException {
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(bayarSekarangPopUpButton));
		driver.findElement(bayarSekarangPopUpButton).click();
	}
	public void clickOthersMethod() throws InterruptedException{
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(othersMethodPayment));
		driver.findElement(othersMethodPayment).click();
	}
	
	public void clickPaymentMethod() throws InterruptedException{
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(BCAPayment));
		driver.findElement(BCAPayment).click();
	}
	public void clickBayarButton() throws InterruptedException{
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(bayarButton));
		driver.findElement(bayarButton).click();
	}
	
	public String getBankNummber() throws InterruptedException{
		return driver.findElement(bankNumber).getText();
	}

}

package test;

import org.testng.annotations.Test;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import pages.Checkoutpage;
import pages.LoginPage;
import pages.PulsaPage;

public class MainTest {
	WebDriver driver;
	LoginPage loginPage;
	PulsaPage pulsaPage;
	Checkoutpage checkOutPage;
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + File.separator+"driver"+File.separator + "geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.tokopedia.com/pulsa");
	}
	@Test(priority=0)
	public void buyingPulsa() {
		String numberPhone = "082277338443";
		pulsaPage= new PulsaPage(driver);
		pulsaPage.fillNumberPhone(numberPhone);
		pulsaPage.chooseAmount();
		pulsaPage.clickBeliButton();
	}
	@Test(priority=1)
	public void login() throws InterruptedException {
		String email = "namaemail@gmail.com";
		String password = "Passwordpassword";
		loginPage = new LoginPage(driver);
		loginPage.setEmail(email);
		loginPage.clickNext();
		System.out.println("Click next");
		loginPage.setPassword(password);
		System.out.println("sampe sini");
		loginPage.clickLogin();
		loginPage.clickVerifMethod();
		System.out.println("wait 20 detik");
		Thread.sleep(20000);
		
	}
	@Test(priority=2)
	public void checkOutPage() throws InterruptedException {
		checkOutPage = new Checkoutpage(driver);
		checkOutPage.clickPayButton();
		checkOutPage.bayarSekarangPopUpButton();
		checkOutPage.clickOthersMethod();
		checkOutPage.clickPaymentMethod();
		checkOutPage.clickBayarButton();
		Assert.assertTrue(checkOutPage.getBankNummber().toLowerCase().contains("80777082277338443"));
	}
}

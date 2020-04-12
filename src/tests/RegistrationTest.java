package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objects.SignIn;
import objects.Excell;
import objects.Registration;

public class RegistrationTest {
	
	public static final String REGISTRATION_URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	public static final String SIGN_IN_EMAIL = "//input[@id='email']";
	public static final String SIGN_IN_PASS = "//input[@id='passwd']";
	public static final String SIGN_IN = "//p[@class='submit']//span[1]";
	
	public static final String SIGN_IN_BUTTON = "//a[@class='login']";
	 WebDriver driver;
	 Registration register;
	 
	@BeforeClass 
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Projekti Java\\ProjectFinal\\src\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	@Test(priority = 1)
	public void navigateToRegistrationPage() {
		driver.navigate().to(REGISTRATION_URL);
		Assert.assertEquals(driver.getCurrentUrl(),REGISTRATION_URL);
	}

	@Test(priority = 2)
	
	public void createOneAccount() throws InterruptedException {
		driver.navigate().to(REGISTRATION_URL);
		Thread.sleep(3000);
		Registration.inputEmail(driver, "hristina.s@gmail.com");
		Registration.createAccount(driver);
		Registration.inputFirstName(driver, "Hristina");  
		Registration.inputLastName(driver, "Stankovic");
		Registration.inputPassword(driver, "12345"); //kucala sam br zahtevanih karaktera (5), da sam kucala 4 karaktera,test bi trebao da padne
        // First name i Last name za adresu su automatski popunjeni
		Registration.inputAddress(driver, "Dzordza Vasingtona 17");
		Registration.inputCity(driver, "Wildwood");
		Registration.chooseState(driver, "New Jersey");
		Registration.inputZip(driver, "07101");
		Registration.chooseCountry(driver, "United States");
		Registration.inputMobilePhone(driver, "06477777");
		Registration.assignAddress(driver, "Hridza");
		Registration.clickOnRegButton(driver);
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(Registration.signOut(driver).getText().contains("Sign out"));
		
		SignIn.clickSignOut(driver);

	}

	
	@Test(priority = 3)
	public void randomUserRegistrationTest() {
		SoftAssert sa = new SoftAssert();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Excell.setExcel();
		Excell.setWorkSheet(0);
		Excell.setCellData(0, 13, "registration");

		for (int i = 1; i <= 30; i++) {
			if (driver.getCurrentUrl() != REGISTRATION_URL)
				driver.navigate().to(REGISTRATION_URL);
			Registration.inputEmail(driver, Excell.getCellData(i, 1));
			Registration.createAccount(driver);
			Registration.inputFirstName(driver, Excell.getCellData(i, 2));
			Registration.inputLastName(driver, Excell.getCellData(i, 3));
			Registration.inputPassword(driver, Excell.getCellData(i, 4));
			Registration.inputAddress(driver, Excell.getCellData(i, 5));
			Registration.inputCity(driver, Excell.getCellData(i, 6));
			Registration.chooseState(driver, Excell.getCellData(i, 7));
			Registration.inputZip(driver, Excell.getCellData(i, 8));
			Registration.chooseCountry(driver, Excell.getCellData(i, 9));
			Registration.inputMobilePhone(driver, Excell.getCellData(i, 10));
			Registration.assignAddress(driver, Excell.getCellData(i, 11));
			Registration.clickOnRegButton(driver);

			sa.assertTrue(Registration.signOut(driver).getText().contains("Sign out"));
			
			if (Registration.signOut(driver).getText().contains("Sign out")) {
				SignIn.clickSignOut(driver);
				Excell.setCellData(i, 12, "PASS");
			} else {
				System.out.println("Error");
				Excell.setCellData(i, 12, "FAIL");
			}

		}
		sa.assertAll();
	}

}
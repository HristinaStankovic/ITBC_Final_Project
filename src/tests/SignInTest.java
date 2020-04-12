package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objects.Registration;
import objects.SignIn;
import objects.Excell;

public class SignInTest {
	WebDriver driver; 
	@BeforeClass 
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Projekti Java\\ProjectFinal\\src\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);}
	@Test(priority = 1)
	public void navigateToRegPage() {
		driver.get(RegistrationTest.REGISTRATION_URL);
		Assert.assertEquals(driver.getCurrentUrl(), RegistrationTest.REGISTRATION_URL);
	}


	@Test(priority = 2)
	public void signUsersTest() {
		SoftAssert sa = new SoftAssert();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Excell.setExcel();
		Excell.setWorkSheet(0);
		Excell.setCellData(0, 14, "sign_in");
		for (int i = 2; i <= 30; i++) {
			if (driver.getCurrentUrl() != RegistrationTest.REGISTRATION_URL)
				driver.navigate().to(RegistrationTest.REGISTRATION_URL);
			SignIn.inputSignInEmail(driver, Excell.getCellData(i, 1));
			SignIn.inputSignInPass(driver, Excell.getCellData(i, 4));
			SignIn.clickSignIn(driver);
			sa.assertTrue(Registration.signOut(driver).getText().contains("Sign out"));

			if (Registration.signOut(driver).getText().contains("Sign out")) {
				SignIn.clickSignOut(driver);
				Excell.setCellData(i, 13, "PASS");
			} else {
				System.out.println("Log In Unsuccessful");
				Excell.setCellData(i, 13, "FAIL");
			}
		}
		sa.assertAll();
	}

}
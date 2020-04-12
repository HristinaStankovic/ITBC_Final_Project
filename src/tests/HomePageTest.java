package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objects.HomePage;

public class HomePageTest {
	public static final String HP_URL="http://automationpractice.com/index.php";
	 WebDriver driver;
	 WebDriverWait wait; 
	 HomePage hp;

	 @BeforeClass 
		public void createDriver() {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Projekti Java\\ProjectFinal\\src\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
  @Test(priority = 1)
	public void testWomen_Summer_Dresses() {
		driver.get(HP_URL);
		hp = new HomePage();
		hp.clickOnWomenSubmenu(driver);
		
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "http://automationpractice.com/index.php?id_category=11&controller=category";
	
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	@Test(priority = 2)
	public void testDressesSubmenu() {
		hp.clickOnDressesSubmenu(driver);
		
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "http://automationpractice.com/index.php?id_category=11&controller=category";
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	@Test(priority = 3)
	public void testFinalUrl() {
		driver.navigate().to(HP_URL);
		String WomenSummerDressesUrl = hp.clickOnWomenSubmenu(driver);

		String DressesSummerDressesUrl = hp.clickOnDressesSubmenu(driver);
		
		Assert.assertEquals(WomenSummerDressesUrl, DressesSummerDressesUrl);
	}
	
	
}

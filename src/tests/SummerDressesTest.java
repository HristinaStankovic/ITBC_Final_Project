package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objects.SummerDresses;

public class SummerDressesTest {
	public static final String WOMEN_SUMMER_DRESSES_URL = "http://automationpractice.com/index.php?id_category=11&controller=category";
	public static final String FIRST_SUMMER_DRESS_URL = "http://automationpractice.com/index.php?id_product=5&controller=product";
	public static final String DRESS_NAME = "//td[@class='cart_description']//a[contains(text(),'Printed Summer Dress')]";
	public static final String COLOR_SIZE_CART = "layer_cart_product_attributes";
	public static final String QTY = "layer_cart_product_quantity";
	
	WebDriver driver;
	 WebDriverWait wait;
	 SummerDresses dress;

	 @BeforeClass
		public void createDriver() {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Projekti Java\\ProjectFinal\\src\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
	 @Test (priority = 1) 
		public void testNavigationToFirstDress() {
			driver.navigate().to(WOMEN_SUMMER_DRESSES_URL);
			dress=new  SummerDresses();
			dress.chooseFirstSummerDresses(driver);
			
			
			String actualUrl = driver.getCurrentUrl();
			String expectedUrl =FIRST_SUMMER_DRESS_URL;
		
			Assert.assertEquals(actualUrl, expectedUrl);
		
		}
	@Test(priority = 2)
		public void testAddToCart() throws InterruptedException {

			driver.navigate().to(FIRST_SUMMER_DRESS_URL);
			
			SummerDresses.addtoCard(driver);

			Thread.sleep(3000);
	
			SoftAssert sa = new SoftAssert();
sa.assertTrue(SummerDresses.getDressName(driver).getText().contains("Printed Summer Dress"));
sa.assertTrue(SummerDresses.getColorSize(driver).getText().contains("Color : Blue, Size : M"));
sa.assertEquals(SummerDresses.getQuantity(driver).getAttribute("value"), "2");

			sa.assertAll(); 
		}
		
		@Test(priority = 3)
		public void testProceedToCheckoutButton() {
			SummerDresses.proceedToCheckoutButton(driver);
			
			String actualUrl = driver.getCurrentUrl();
			String expectedUrl ="http://automationpractice.com/index.php?controller=authentication&multi-shipping=0&display_guest_checkout=0&back=http%3A%2F%2Fautomationpractice.com%2Findex.php%3Fcontroller%3Dorder%26step%3D1%26multi-shipping%3D0";
			
			Assert.assertEquals(actualUrl, expectedUrl);
		}


}


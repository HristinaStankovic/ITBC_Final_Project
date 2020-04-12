package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SummerDresses {
	
	public static final String FIRST_SUMMER_DRESS_XPATH ="//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 first-in-line last-line first-item-of-tablet-line first-item-of-mobile-line last-mobile-line']//a[@class='product-name'][contains(text(),'Printed Summer Dress')]";
	public static final String QUANTITY_XPATH = "//input[@id='quantity_wanted']";
	public static final String SIZE_PATH = "//select[@id='group_1']";
	public static final String SIZEM_PATH = "//option[contains(text(),'M')]";
	public static final String COLOUR_XPATH = "//a[@id='color_14']";
	public static final String ADD_TO_CART_XPATH = "//span[contains(text(),'Add to cart')]";
	public static final String POP_UP_CART = "//span[@class='cross']";
	public static final String CART = "//body[@id='product']/div[@id='page']/div[@class='header-container']/header[@id='header']/div/div[@class='container']/div[@class='row']/div[@class='col-sm-4 clearfix']/div[@class='shopping_cart']/a[1]";
	public static final String DRESS_NAME = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/p[1]/a[1]";
	public static final String COLOR_SIZE_CART = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/small[2]/a[1]";
	public static final String Q = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[5]/input[2]";
	
	public static final String CHECKOUT = "//span[text()='Proceed to checkout']";
	
	
	

	public String chooseFirstSummerDresses(WebDriver driver) {
		WebElement firstDress = driver.findElement(By.xpath(FIRST_SUMMER_DRESS_XPATH));
		firstDress.click();
		return driver.getCurrentUrl();
	}

	public static void addtoCard(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath(QUANTITY_XPATH));
		element.clear();
		element.sendKeys("2");

		driver.findElement(By.xpath(SIZE_PATH)).click();
	
		driver.findElement(By.xpath(SIZEM_PATH)).click();
	
		driver.findElement(By.xpath(COLOUR_XPATH)).click();
	

		driver.findElement(By.xpath(ADD_TO_CART_XPATH)).click();
		driver.findElement(By.xpath(POP_UP_CART)).click();
		driver.findElement(By.xpath(CART)).click();
	}
	
	public static WebElement getDressName(WebDriver driver) {
		return driver.findElement(By.xpath(DRESS_NAME));

	}

	public static WebElement getColorSize(WebDriver driver) { 
		return driver.findElement(By.xpath(COLOR_SIZE_CART));
	}

	public static WebElement getQuantity(WebDriver driver) {
		return driver.findElement(By.xpath(Q));
	}

	
	


	public static void proceedToCheckoutButton(WebDriver driver) {
		driver.findElement(By.xpath(CHECKOUT)).click();
	}

}



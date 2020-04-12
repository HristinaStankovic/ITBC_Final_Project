package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Registration {
	
	public static final String EMAIL = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/input[1]";
	public static final String CREATE_AN_ACCOUNT = "//form[@id='create-account_form']//span[1]";
	public static final String FIRST_NAME = "//input[@id='customer_firstname']";
	public static final String LAST_NAME = "//input[@id='customer_lastname']";
	public static final String PASSWORD = "//input[@id='passwd']";
	public static final String ADDRESS_FIRST_NAME = "//input[@id='firstname']";
	public static final String ADDRESS_LASTNAME = "//input[@id='lastname']";
	public static final String ADDRESS = "//input[@id='address1']";
	public static final String CITY = "//input[@id='city']";
	public static final String STATE = "//select[@id='id_state']";
	public static final String STATE_CHOOSE = "//option[contains(text(),String data)]";
	public static final String ZIP = "//input[@id='postcode']";
	public static final String COUNTRY = "//select[@id='id_country']";
	public static final String MOBILE = "//input[@id='phone_mobile']";
	public static final String ASSIGN_ADDRESS = "//input[@id='alias']";
	public static final String REG_BUTTON = "//span[contains(text(),'Register')]";
	public static final String SIGN_OUT = "//a[@class='logout']";
	
	public static void inputEmail(WebDriver driver, String data) {
		driver.findElement(By.xpath(EMAIL)).sendKeys(data);
	}

	public static void createAccount(WebDriver driver) {
		driver.findElement(By.xpath(CREATE_AN_ACCOUNT)).click();
	}

	public static void inputFirstName(WebDriver driver, String podatak) {
		driver.findElement(By.xpath(FIRST_NAME)).sendKeys(podatak);
	}

	public static void inputLastName(WebDriver driver, String podatak) {
		driver.findElement(By.xpath(LAST_NAME)).sendKeys(podatak);
	}

	public static void inputPassword(WebDriver driver, String podatak) {
		driver.findElement(By.xpath(PASSWORD)).sendKeys(podatak);
	}

	public static void inputAddressFirstName(WebDriver driver, String podatak) {
		driver.findElement(By.xpath(ADDRESS_FIRST_NAME)).sendKeys(podatak);
	}

	public static void inputAddressLastName(WebDriver driver, String podatak) {
		driver.findElement(By.xpath(ADDRESS_LASTNAME)).sendKeys(podatak);
	}

	public static void inputAddress(WebDriver driver, String podatak) { 
		driver.findElement(By.xpath(ADDRESS)).sendKeys(podatak);
	}

	public static void inputCity(WebDriver driver, String podatak) {
		driver.findElement(By.xpath(CITY)).sendKeys(podatak);
	}

	public static Select state(WebDriver driver) {
		return new Select(driver.findElement(By.xpath(STATE)));
	}

	public static void chooseState(WebDriver driver, String podatak) {
		state(driver).selectByVisibleText(podatak);

	}

	public static void inputZip(WebDriver driver, String podatak) {
		driver.findElement(By.xpath(ZIP)).sendKeys(podatak);

	}

	public static Select country(WebDriver driver) {
		return new Select(driver.findElement(By.xpath(COUNTRY)));
	}

	public static void chooseCountry(WebDriver driver, String podatak) {
		country(driver).selectByVisibleText(podatak);

	}

	public static void inputMobilePhone(WebDriver driver, String podatak) {
		driver.findElement(By.xpath(MOBILE)).sendKeys(podatak);
	}

	public static void assignAddress(WebDriver driver, String podatak) {
		driver.findElement(By.xpath(ASSIGN_ADDRESS)).sendKeys(podatak);
	}

	public static void clickOnRegButton(WebDriver driver) {
		driver.findElement(By.xpath(REG_BUTTON)).click();
	}
	public static WebElement signOut(WebDriver driver) {
		return driver.findElement(By.xpath(SIGN_OUT));
	}
}


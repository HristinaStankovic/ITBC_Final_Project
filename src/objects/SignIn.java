package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignIn {
	public static final String SIGN_IN_EMAIL = "//input[@id='email']";
	public static final String SIGN_IN_PASS = "//input[@id='passwd']";
	public static final String SIGN_IN = "//p[@class='submit']//span[1]";
	public static final String SIGN_OUT = "//a[@class='logout']"; 
	public static final String SIGN_IN_BUTTON = "//a[@class='login']";
	
	public static void inputSignInEmail(WebDriver driver, String data) {
		driver.findElement(By.xpath(SIGN_IN_EMAIL)).sendKeys(data);
	}

	public static void inputSignInPass(WebDriver driver, String data) {
		driver.findElement(By.xpath(SIGN_IN_PASS)).sendKeys(data);
	}

	public static void clickSignIn(WebDriver driver) {
		driver.findElement(By.xpath(SIGN_IN)).click();

	}

	public static void clickSignOut(WebDriver driver) {
		driver.findElement(By.xpath(SIGN_OUT)).click();
	}
	
	public static void clickSignInButton(WebDriver driver) {
		driver.findElement(By.xpath(SIGN_IN_BUTTON));
	}

}


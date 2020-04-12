package objects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage { 
	
	public static final String WOMEN_XPATH = "//a[@class='sf-with-ul'][contains(text(),'Women')]";
	public static final String WOMEN_SUMMER_DRESS_XPATH = "//ul[@class='submenu-container clearfix first-in-line-xs']//li//ul//a[contains(text(),'Summer Dresses')]";
	public static final String DRESSES_XPATH = "//body[@id='category']/div[@id='page']/div[@class='header-container']/header[@id='header']/div/div[@class='container']/div[@class='row']/div[@id='block_top_menu']/ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[2]/a[1]";
	public static final String DRESSES_SUMMER_DRESSES_XPATH = "//body[@id='category']/div[@id='page']/div[@class='header-container']/header[@id='header']/div/div[@class='container']/div[@class='row']/div[@id='block_top_menu']/ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/ul[@class='submenu-container clearfix first-in-line-xs']/li[@class='sfHoverForce']/a[1]";


	
	public String clickOnWomenSubmenu(WebDriver driver) {
		Actions actions = new Actions(driver);
		WebElement women= driver.findElement(By.xpath(WOMEN_XPATH));
		actions.moveToElement(women).perform();
		
		WebElement Women_dresses = driver.findElement(By.xpath(WOMEN_SUMMER_DRESS_XPATH));
		Women_dresses.click();
		return driver.getCurrentUrl();
	}
	
	public String clickOnDressesSubmenu(WebDriver driver) {
		Actions actions = new Actions(driver);
		
		WebElement dresses = driver.findElement(By.xpath(DRESSES_XPATH));
		actions.moveToElement(dresses).perform();
		
		WebElement Dresses_summer_dresses = driver.findElement(By.xpath(DRESSES_SUMMER_DRESSES_XPATH));
		Dresses_summer_dresses.click();
		return driver.getCurrentUrl();
	}
	
	public void waitWomenLink(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(WOMEN_XPATH))); 
	}
}



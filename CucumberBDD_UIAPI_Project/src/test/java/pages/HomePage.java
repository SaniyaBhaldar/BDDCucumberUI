package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	By toolsQAImgIcon = By.xpath("//*[@id=\"app\"]/header/a/img");
	By alertsFrameWindowsMenu = By.cssSelector(".element-group:nth-child(3)");
	By elementsMenu = By.cssSelector(".element-group:nth-child(1)");
	By widgetsMenu = By.cssSelector(".element-group:nth-child(4)");
	By bookStoreAppMenu = By.cssSelector(".element-group:nth-child(6)");


	public Boolean displayToolsQAIcon() {
		return driver.findElement(toolsQAImgIcon).isDisplayed();
	}

	public void clickAlertsFrameWindowsMenu() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// driver.findElement(alertsFrameWindowsMenu).click();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(alertsFrameWindowsMenu);
		jse.executeScript("arguments[0].scrollIntoView();", Element);
		new Actions(driver).click(driver.findElement(alertsFrameWindowsMenu)).perform();
	}

	public void clickElementsMenu() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		new Actions(driver).click(driver.findElement(elementsMenu)).perform();
	}
	
	public void clickWidgetsMenu() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(widgetsMenu);
		jse.executeScript("arguments[0].scrollIntoView();", Element);
		//new Actions(driver).click(driver.findElement(widgetsMenu)).perform();
		driver.findElement(widgetsMenu).click();
	}
	
	public void clickBookStoreAppMenu() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(widgetsMenu);
		jse.executeScript("arguments[0].scrollIntoView();", Element);
		new Actions(driver).click(driver.findElement(bookStoreAppMenu)).perform();
		//driver.findElement(bookStoreAppMenu).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

}

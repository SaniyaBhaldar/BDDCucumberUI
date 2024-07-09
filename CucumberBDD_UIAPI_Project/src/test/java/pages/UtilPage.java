package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

public class UtilPage {

	WebDriver driver;

	public UtilPage(WebDriver driver) {
		this.driver = driver;
	}

	By headerText = By.cssSelector(".text-center");
	
	public String getTextOfHeader() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return driver.findElement(headerText).getText();
	}

	public void scrollDown() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)");
	}
	

	public String mainTab() {
		String currentTab = driver.getWindowHandle();
		return currentTab;
	}

	public void switchToNewTab() {
		String currentTab = mainTab();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		for (String tab : driver.getWindowHandles()) {
			if (!tab.equals(currentTab)) {
				driver.switchTo().window(tab);
			}
		}
	}

	public void closeNewTab() {
		String currentTab = mainTab();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		for (String tab : driver.getWindowHandles()) {
			if (!tab.equals(currentTab)) {
				driver.close();
				driver.switchTo().window(tab);
			}
		}
	}
	
	public void clickAlertOkBtn() {
		Alert alert = driver.switchTo().alert();
        alert.accept();
	}
	
	public void clickAlertCancelBtn() {
		Alert alert = driver.switchTo().alert();
        alert.dismiss();
	}
	
	public String getTextOfAlert() {
		return driver.switchTo().alert().getText();
	}
	
	public void enterValueInAlert() {
		driver.switchTo().alert().sendKeys("Saniya");
	}
}

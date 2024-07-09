package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.datatable.DataTable;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By loginOption = By.cssSelector(".element-group:nth-child(6) li:nth-child(1)");
	By newUserBtn = By.cssSelector("#newUser");
	By usernameTB = By.cssSelector("#userName");
	By passwordTB = By.cssSelector("#password");
	By loginBtn = By.cssSelector("#login");
	By userNameProfileLabel = By.cssSelector(".text-right #userName-label");
	By userNameProfileValue = By.cssSelector(".text-right #userName-value");

	public void clickLoginOption() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(loginOption);
		jse.executeScript("arguments[0].scrollIntoView();", Element);
		new Actions(driver).click(driver.findElement(loginOption)).perform();
		// driver.findElement(loginOption).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	public void clickNewUserBtn() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(newUserBtn);
		jse.executeScript("arguments[0].scrollIntoView();", Element);
		driver.findElement(newUserBtn).click();
	}

	public void enterInfoForLogin(DataTable dbTable) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(usernameTB);
		jse.executeScript("arguments[0].scrollIntoView();", Element);
		List<List<String>> data = dbTable.cells();
		driver.findElement(usernameTB).sendKeys(data.get(1).get(1));
		driver.findElement(passwordTB).sendKeys(data.get(2).get(1));
	}

	public void clickLoginBtn() {
		driver.findElement(loginBtn).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getTextOfUserNameProfileLabel() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(userNameProfileLabel);
		jse.executeScript("arguments[0].scrollIntoView();", Element);
		return driver.findElement(userNameProfileLabel).getText();

	}

	public String getTextOfUserNameProfileValue() {
		return driver.findElement(userNameProfileValue).getText();

	}

}

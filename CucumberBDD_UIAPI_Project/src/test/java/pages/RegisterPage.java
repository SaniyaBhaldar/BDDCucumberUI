package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;

public class RegisterPage {
	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}

	By registerTitleText = By.cssSelector("#userForm h4");
	By backToLoginBtn = By.cssSelector("#gotologin");
	By firstNameTB = By.cssSelector("#firstname");
	By lastNameTB = By.cssSelector("#lastname");
	By usernameTB = By.cssSelector("#userName");
	By passwordTB = By.cssSelector("#password");
	By checkRecaptcha = By.cssSelector(".recaptcha-checkbox-border");
	By recaptchaFrame=By.xpath("//iframe[@title='reCAPTCHA']");
	By registerBtn = By.cssSelector("#register");

	public String getTextOfRegisterTitle() {
		return driver.findElement(registerTitleText).getText();

	}

	public void enterInfoForRegistration(DataTable dataTable) {
		List<List<String>> data = dataTable.cells();
		driver.findElement(firstNameTB).sendKeys(data.get(1).get(1));
		driver.findElement(lastNameTB).sendKeys(data.get(2).get(1));
		driver.findElement(usernameTB).sendKeys(data.get(3).get(1));
		driver.findElement(passwordTB).sendKeys(data.get(4).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	public void clickBackToLoginBtn() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(backToLoginBtn);
		jse.executeScript("arguments[0].scrollIntoView();", Element);
		driver.findElement(backToLoginBtn).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void checkRecaptcha() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(recaptchaFrame);
		jse.executeScript("arguments[0].scrollIntoView();", Element);
		driver.switchTo().frame(driver.findElement(recaptchaFrame));
		Thread.sleep(5000);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement Element1 = driver.findElement(checkRecaptcha);
		je.executeScript("arguments[0].scrollIntoView();", Element1);
		new Actions(driver).click(driver.findElement(checkRecaptcha)).perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(5000);
		driver.switchTo().defaultContent();

	}

	public void clickRegisterBtn() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(registerBtn).click();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}

package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class FormsPage {

	private WebDriver driver;

	public FormsPage(WebDriver driver) {
		this.driver = driver;

	}

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	private By formsTab = By.cssSelector(".element-group:nth-child(2)");

	private By practiceForm = By.cssSelector(".element-group:nth-child(2) li");

	private By firstName = By.xpath("//input[@placeholder='First Name']");

	private By lastName = By.id("lastName");

	private By userEmail = By.id("userEmail");

	private By genderBtn = By.cssSelector("#gender-radio-2");

	private By mobileNumber = By.id("userNumber");

	private By submitBtn = By.id("submit");

	By successMsg = By.cssSelector(".modal-title");

	public void clickOnFormsTab() {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			WebElement Element = driver.findElement(formsTab);
			jse.executeScript("arguments[0].scrollIntoView();", Element);
			new Actions(driver).click(driver.findElement(formsTab)).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnPracticeForm() {
		driver.findElement(practiceForm).click();
	}

	public void enterFirstName(String firstNameInput) {
		driver.findElement(firstName).sendKeys("Aishwarya");

	}

	public void enterLastName(String lastNameInput) {
		driver.findElement(lastName).sendKeys("Ganweer");
	}

	public void enterEmailId(String emailIdInput) {
		driver.findElement(userEmail).sendKeys("aishwaryag@gmail.com");
	}

	public void clickOnGenderButton() {
		new Actions(driver).click(driver.findElement(genderBtn)).build().perform();
		// driver.findElement(genderBtn).click();
	}

	public void enterMobileNumber(String mobileNumberInput) {
		driver.findElement(mobileNumber).sendKeys("0123456789");
	}

	public void clickOnSubmitButton() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(submitBtn);
		jse.executeScript("arguments[0].scrollIntoView();", Element);
		driver.findElement(submitBtn).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getSuccessMessage() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		return driver.findElement(successMsg).getText();
	}

}

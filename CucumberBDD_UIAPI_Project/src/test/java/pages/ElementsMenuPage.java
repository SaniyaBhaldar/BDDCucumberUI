package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.datatable.DataTable;

public class ElementsMenuPage {
	WebDriver driver;

	public ElementsMenuPage(WebDriver driver) {
		this.driver = driver;
	}

	By userNameTB = By.id("userName");
	By userEmailTB = By.id("userEmail");
	By currentAddressTB = By.id("currentAddress");
	By permanentAddressTB = By.id("permanentAddress");
	By submitBtn = By.id("submit");
	By enteredInfoTextArea = By.cssSelector(".border:nth-child(1)");
	By radioButtonMOption = By.cssSelector(".element-group:nth-child(1) li:nth-child(3)");
	By radioBtnQueText = By.cssSelector(".mb-3");
	By selectedRBTextArea = By.cssSelector(".mt-3 span");
	By yesRadioBtn = By.id("yesRadio");
	By checkboxOption = By.xpath("//span[text()='Check Box']");
	By selectedCBOption = By.cssSelector(".rct-title");
	By resultCB=By.id("result");

	public void enterInfoInTextBox(DataTable dbTable) {
		List<List<String>> data = dbTable.cells();

		System.out.println(data.get(1).get(1));
		driver.findElement(userNameTB).sendKeys(data.get(1).get(1));
		driver.findElement(userEmailTB).sendKeys(data.get(2).get(1));
		driver.findElement(currentAddressTB).sendKeys(data.get(3).get(1));
		driver.findElement(permanentAddressTB).sendKeys(data.get(4).get(1));
	}

	public void clickSubmitButton() {
		driver.findElement(submitBtn).click();
	}

	public Boolean checkEnteredInfoTextAreaDisplay() {
		return driver.findElement(enteredInfoTextArea).isDisplayed();

	}

	public Boolean checkEnteredInfoTextAreaSize() {
		return driver.findElements(enteredInfoTextArea).size() > 0;

	}

	public void clickRadioButtonMOption() {
		driver.findElement(radioButtonMOption).click();
	}

	public String getTextOfRadtioBtnQue() {
		return driver.findElement(radioBtnQueText).getText();

	}

	public void clickYesRadioBtnOption() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		new Actions(driver).click(driver.findElement(yesRadioBtn)).perform();

	}

	public Boolean checkSelectedRBInfoTextAreaDisplay() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return driver.findElement(selectedRBTextArea).isDisplayed();
	}

	public String getTextOfRBTextArea() {
		return driver.findElement(selectedRBTextArea).getText();

	}
	
	public void clickCheckBoxOption() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(checkboxOption).click();

	}

	public void selectCBOption() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(selectedCBOption);
		jse.executeScript("arguments[0].scrollIntoView();", Element);
		new Actions(driver).click(driver.findElement(selectedCBOption)).build().perform();
		
	}

	public String getResultCB() {
		return driver.findElement(resultCB).getText();
	}
}

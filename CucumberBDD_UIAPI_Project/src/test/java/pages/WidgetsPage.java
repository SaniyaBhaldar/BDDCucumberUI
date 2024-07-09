package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WidgetsPage {
	WebDriver driver;

	public WidgetsPage(WebDriver driver) {
		this.driver = driver;
	}

	By selectMenuOption = By.cssSelector(".element-group:nth-child(4) li:nth-child(9)");
	By headerOfSelectValue = By.cssSelector(".row:nth-child(2)");
	By selectValueFirstOption = By.cssSelector(".row:nth-child(3) .css-yk16xz-control");
	By resultOfSelectValue = By.cssSelector(".css-1uccc91-singleValue");
	By resultOfSelectOne = By.cssSelector(".mt-2:nth-child(5) .css-1uccc91-singleValue");
	By selectValueSecondOption = By.cssSelector(".row:nth-child(5) .css-yk16xz-control");
	By selectValueFromFirst = By.cssSelector("#react-select-2-option-1-0");
	By selectValueFromSecond = By.cssSelector("#react-select-3-option-0-1");
	By selectValueThirdOption = By.cssSelector("#oldSelectMenu");
	By headerOfSelectOne = By.cssSelector(".row:nth-child(4)");
	By headerOfOldStyleSelectMenu = By.cssSelector(".row:nth-child(6)");
	By headerOfMultiselectDropdown = By.cssSelector(".row:nth-child(8) b");
	By headerOfStandardMultiselect = By.cssSelector(".row:nth-child(9) b");
	By resultOfOldStyleSelectMenu = By.cssSelector(".mt-2:nth-child(7)");
	By resultOfMultiselectDropdown = By.cssSelector(".row:nth-child(8) .css-1hwfws3");
	By selectValueForthOption = By.cssSelector(".row:nth-child(8) .css-2b097c-container");
	By selectValueForthOptionOne = By.cssSelector("#react-select-4-option-1");
	By selectValueForthOptionTwo = By.cssSelector("#react-select-4-option-2");
	By selectValueFifthOption = By.cssSelector("#cars");

	public void clickSelectMenuOption() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(selectMenuOption);
		jse.executeScript("arguments[0].click();", Element);
		// new Actions(driver).click(driver.findElement(selectMenuOption)).perform();
		// driver.findElement(selectMenuOption).click();
	}

	public String getHeaderOfSelectValue() {
		return driver.findElement(headerOfSelectValue).getText();
	}

	public void selValFromSelectValueDropdown() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(selectValueFirstOption);
		jse.executeScript("arguments[0].scrollIntoView();", Element);
		driver.findElement(selectValueFirstOption).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//new Actions(driver).click(driver.findElement(selectValueFromFirst)).perform();
		driver.findElement(selectValueFromFirst).click();
	}

	public String getResultOfSelectValue() {
		return driver.findElement(resultOfSelectValue).getText();
	}

	public String getResultOfSelectOne() {
		return driver.findElement(resultOfSelectOne).getText();
	}

	public void selValFromSelectOneDropdown() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(selectValueSecondOption);
		jse.executeScript("arguments[0].scrollIntoView();", Element);
		driver.findElement(selectValueSecondOption).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(selectValueFromSecond).click();
	}

	public void selValFromOldStyleSelectMenu() {
		Select selOldStyleSelectMenu = new Select(driver.findElement(selectValueThirdOption));
		selOldStyleSelectMenu.selectByValue("2");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	public String getResultOfOldStyleSelectMenu() {
		Select selOldStyleSelectMenu = new Select(driver.findElement(selectValueThirdOption));
		WebElement option = selOldStyleSelectMenu.getFirstSelectedOption();
		String resultOfOldStyleSelectMenu = option.getText();
		return resultOfOldStyleSelectMenu;
	}

	public String getHeaderOfSelectOne() {
		return driver.findElement(headerOfSelectOne).getText();
	}

	public String getHeaderOfOldStyleSelectMenu() {
		return driver.findElement(headerOfOldStyleSelectMenu).getText();
	}

	public String getHeaderOfMultiselectDropdown() {
		return driver.findElement(headerOfMultiselectDropdown).getText();
	}

	public String getHeaderOfStandardMultiselect() {
		return driver.findElement(headerOfStandardMultiselect).getText();
	}

	public void selValFromMultiselectDropdown() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(selectValueForthOption);
		jse.executeScript("arguments[0].scrollIntoView();", Element);
		driver.findElement(selectValueForthOption).click();
		driver.findElement(selectValueForthOptionOne).click();
		driver.findElement(selectValueForthOptionTwo).click();
	}

	public String getResultOfMultiselectDropdown() {
		return driver.findElement(resultOfMultiselectDropdown).getText();

	}

	public void selValFromStandardMultiselect() {
		driver.findElement(selectValueForthOption).click();
		Select selValFromStandardMultiselect = new Select(driver.findElement(selectValueFifthOption));
		selValFromStandardMultiselect.selectByValue("saab");
		selValFromStandardMultiselect.selectByValue("opel");

	}

	public List<String> getResultOfStandardMultiselect() {
		Select selValFromStandardMultiselect = new Select(driver.findElement(selectValueFifthOption));
		List<WebElement> option = selValFromStandardMultiselect.getAllSelectedOptions();
		List<String> resultOfStandardMultiselect = new ArrayList<>();
		for (WebElement e : option) {
			resultOfStandardMultiselect.add(e.getText());
		}
		return resultOfStandardMultiselect;
	}

}

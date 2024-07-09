package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AlertsFramesWindowsPage {
	WebDriver driver;

	public AlertsFramesWindowsPage(WebDriver driver) {
		this.driver = driver;
	}

	By browserWindowsOption = By.cssSelector(".element-group:nth-child(3) li:nth-child(1)");
	By newTabBtn = By.id("tabButton");
	By newWindowBtn = By.id("windowButton");
	By newWindowMsgBtn = By.id("messageWindowButton");
	By tabWindowMsg = By.id("sampleHeading");
	By windowDetailMsg = By.xpath("/html/body");
	/**
	 * 2nd sceanrio elements
	 */
	By alertsOption = By.cssSelector(".element-group:nth-child(3) li:nth-child(2)");
	By firstClickMeBtn = By.id("alertButton");
	By secondClickMeBtn = By.id("timerAlertButton");
	By thirdClickMeBtn = By.id("confirmButton");
	By fourthClickMeBtn = By.id("promtButton");
	By firstClickMeBtnHeader = By.cssSelector(".row:nth-child(2) .mr-3");
	By secondClickMeBtnHeader = By.cssSelector(".mt-4 .row:nth-child(3) .mr-3");
	By thirdClickMeBtnHeader = By.cssSelector(".mt-4 .row:nth-child(4) .mr-3");
	By fourthClickMeBtnHeader = By.cssSelector(".mt-4 .row:nth-child(5) .mr-3");
	By textOfSelectedValue = By.cssSelector("#confirmResult");
	By textOfEnteredValue = By.cssSelector("#promptResult");
	/**
	 * 3rd scenario elements
	 */
	By modalDialogsOption = By.cssSelector(".element-group:nth-child(3) li:nth-child(5)");
	By textOfActionHeader = By.cssSelector("#modalWrapper div:nth-child(1)");
	By smallModalBtn = By.id("showSmallModal");
	By largeModalBtn = By.id("showLargeModal");
	By smallModalTitle = By.cssSelector("#example-modal-sizes-title-sm");
	By smallLargeModalMsg = By.cssSelector(".modal-body");
	By smallModalCloseBtn = By.id("closeSmallModal");
	By largeModalTitle = By.cssSelector("#example-modal-sizes-title-lg");
	By crossCloseBtn = By.cssSelector(".modal-header .close");
	/**
	 * 4th scenario elements
	 */

	By clickOnAFWMenu = By.xpath("//li[@id='Frame']");
	By clickNestedFrameSubTab = By.cssSelector(".element-group:nth-child(3) li:nth-child(4)");
	By textBody = By.xpath("/html/body");
	By title = By.xpath("//h1[text()='Nested Frames']");


	public void clickBrowserWindowsOption() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(browserWindowsOption).click();

	}

	public void clickNewTabBtn() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(newTabBtn);
		jse.executeScript("arguments[0].scrollIntoView();", Element);
		driver.findElement(newTabBtn).click();
	}

	public void clickNewWindowBtn() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(newWindowBtn).click();
	}

	public void clickNewWindowMsgBtn() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(newWindowMsgBtn).click();
	}

	public String getTextOfTabWindowMsg() {
		return driver.findElement(tabWindowMsg).getText();
	}

	public String getTextOfWindowDetailMsg() {
		return driver.findElement(windowDetailMsg).getText();
	}

	public boolean displayNewWindow() {
		return driver.findElement(windowDetailMsg).isDisplayed();
	}

	/**
	 * 2nd scenario methods
	 */

	public void clickAlertsOption() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(alertsOption);
		jse.executeScript("arguments[0].scrollIntoView();", Element);
		driver.findElement(alertsOption).click();
	}

	public void clickFirstClickMeOption() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(firstClickMeBtn);
		jse.executeScript("arguments[0].scrollIntoView();", Element);
		driver.findElement(firstClickMeBtn).click();
	}

	public void clickSecondClickMeOption() {
		driver.findElement(secondClickMeBtn).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickThirdClickMeOption() {
		driver.findElement(thirdClickMeBtn).click();
	}

	public void clickFourthClickMeOption() {
		driver.findElement(fourthClickMeBtn).click();
	}

	public String getTextOfFirstClickMeBtnHeader() {
		return driver.findElement(firstClickMeBtnHeader).getText();
	}

	public String getTextOfSecondClickMeBtnHeader() {
		return driver.findElement(secondClickMeBtnHeader).getText();
	}

	public String getTextOfThirdClickMeBtnHeader() {
		return driver.findElement(thirdClickMeBtnHeader).getText();
	}

	public String getTextOfFourthClickMeBtnHeader() {
		return driver.findElement(fourthClickMeBtnHeader).getText();
	}

	public String getTextOfSelectedValue() {
		return driver.findElement(textOfSelectedValue).getText();
	}

	public String getTextOfEnteredValue() {
		return driver.findElement(textOfEnteredValue).getText();
	}

	/**
	 * 3rd scenario methods
	 */

	public void clickModalDialogsOption() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(modalDialogsOption);
		jse.executeScript("arguments[0].scrollIntoView();", Element);
		driver.findElement(modalDialogsOption).click();
	}

	public String getTextOfActionHeader() {
		return driver.findElement(textOfActionHeader).getText();
	}

	public void clickSmallModalButton() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(smallModalBtn);
		jse.executeScript("arguments[0].scrollIntoView();", Element);
		driver.findElement(smallModalBtn).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	public void clickLargeModalButton() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(largeModalBtn);
		jse.executeScript("arguments[0].scrollIntoView();", Element);
		driver.findElement(largeModalBtn).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	public String getTextOfSmallModalTitle() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return driver.findElement(smallModalTitle).getText();
	}

	public String getTextOfSmallLargeModalMsg() {
		return driver.findElement(smallLargeModalMsg).getText();
	}

	public void clickCloseButton() {
		driver.findElement(smallModalCloseBtn).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	public void clickCrossBtn() {
		driver.findElement(crossCloseBtn).click();
	}

	public String getTextOfLargeModalTitle() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return driver.findElement(largeModalTitle).getText();
	}

	/**
	 * 4th scenario methods
	 */

	public void clickOnAFWMenu() {
		driver.findElement(clickOnAFWMenu).click();
	}

	public void clickNestedFrameSubMenu() {
		driver.findElement(clickNestedFrameSubTab).click();
	}

	public void switchToFrame1() {
		driver.switchTo().frame("frame1");
	}

	public void switchToFrame2() {
		driver.switchTo().frame("frame2");
	}

	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	public String getTextOfTextBody() {
		return driver.findElement(textBody).getText();
	}
	
	public String getTextOfTitle() {
		return driver.findElement(title).getText();
	}

}

package utils;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UtilDriver {

	public WebDriver driver;
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();

	public WebDriver init(String browserNm) {

		if (browserNm.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			tldriver.set(driver);
		} else if (browserNm.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			tldriver.set(driver);
		} else if (browserNm.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			tldriver.set(driver);
		} else {
			System.out.println("Please enter correct browser name");
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		getDriver().manage().window().maximize();
		getDriver().get("https://demoqa.com/text-box");
		return getDriver();

	}

	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}

	public void close() {
		getDriver().close();
		getDriver().quit();
	}

	public void takeTestScreenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenShotNm = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenShotNm);
		}
	}

}

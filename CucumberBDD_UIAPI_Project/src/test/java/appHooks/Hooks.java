package appHooks;

import java.util.Properties;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;
import utils.UtilDriver;

public class Hooks {

	private UtilDriver utilDriver;
	private ConfigReader configReader;
	Properties prop;

	@Before(order = 0)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_Prop();
	}

	@Before(order = 1)
	public void setup() {
		String browserNm = prop.getProperty("browser");
		utilDriver = new UtilDriver();
		utilDriver.init(browserNm);
	}

	@After(order = 0)
	public void tearDown() {
		utilDriver.close();
	}

	@After(order = 1)
	public void failTestResult(Scenario scenario) {
		utilDriver.takeTestScreenshot(scenario);
	}
}

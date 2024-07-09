package stepDefinitions;

import static org.testng.Assert.assertEquals;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.HomePage;
import pages.UtilPage;
import utils.UtilDriver;

public class homeStep {

	HomePage homePage = new HomePage(UtilDriver.getDriver());
	UtilPage utilPage = new UtilPage(UtilDriver.getDriver());

	@Given("user go to DemoToolsQA web application")
	public void user_go_to_demo_tools_qa_web_application() {
		System.out.println("User navigates to demoQA application");
	}

	@And("user see the title of the page")
	public void user_see_the_title_of_the_page() {
		assertEquals(true, homePage.displayToolsQAIcon());
		utilPage.scrollDown();
		assertEquals("Text Box", utilPage.getTextOfHeader());
	}

	@Then("close browser")
	public void close_browser() {
		System.out.println("User returns from demoQA application");

	}

}

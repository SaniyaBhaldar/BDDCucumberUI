package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ElementsMenuPage;
import pages.FormsPage;
import pages.UtilPage;
import utils.UtilDriver;

public class FormsStep {

	public WebDriver driver;

	protected SoftAssert softAssert;

	private FormsPage formsPage = new FormsPage(UtilDriver.getDriver());
	private UtilPage utilPage = new UtilPage(UtilDriver.getDriver());
	private ElementsMenuPage elementsMenuPage = new ElementsMenuPage(UtilDriver.getDriver());

	@Given("the user is on DemoQA element page click on Forms tab")
	public void the_user_is_on_demo_qa_element_page_click_on_forms_tab() {

		formsPage.clickOnFormsTab();
		formsPage.clickOnPracticeForm();

	}

	@When("the user enters {string} in the First Name field")
	public void the_user_enters_in_the_first_name_field(String firstName) {
		formsPage.enterFirstName(firstName);
	}

	@When("the user enters {string} in the Last Name field")
	public void the_user_enters_in_the_last_name_field(String lastName) {
		formsPage.enterLastName(lastName);
	}

	@When("the user enters {string} in the Email field")
	public void the_user_enters_in_the_email_field(String userEmail) {
		formsPage.enterEmailId(userEmail);
	}

	@When("the user selects Female from the radio button")
	public void the_user_selects_Female_from_the_radio_button() {
		formsPage.clickOnGenderButton();
	}

	@When("the user enters {string} in the Mobile Number field")
	public void the_user_enters_in_the_mobile_number_field(String mobileNumber) {
		formsPage.enterMobileNumber(mobileNumber);
	}

	@When("the user clicks the Submit button")
	public void the_user_clicks_the_submit_button() {
		formsPage.clickOnSubmitButton();
	}
	
	@Then("the user should see a success message")
	public void the_user_should_see_a_success_message() {
		softAssert = new SoftAssert();
		softAssert.assertEquals(formsPage.getSuccessMessage(), "Thanks for submitting the form");
		softAssert.assertAll();
	}

}

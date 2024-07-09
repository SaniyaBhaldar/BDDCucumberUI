package stepDefinitions;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ElementsMenuPage;
import pages.UtilPage;
import utils.UtilDriver;

public class ElementsStep {

	UtilPage utilPage = new UtilPage(UtilDriver.getDriver());
	ElementsMenuPage elementsMenuPage = new ElementsMenuPage(UtilDriver.getDriver());

	@Given("user on the homepage")
	public void user_on_the_homepage() {
		System.out.println("User navigates to demoQA application");
	}

	@When("user enters the following details")
	public void user_enters_the_following_details(DataTable dbTable) {
		elementsMenuPage.enterInfoInTextBox(dbTable);
	}

	@And("user clicks submit button")
	public void user_clicks() {
		utilPage.scrollDown();
		elementsMenuPage.clickSubmitButton();
	}

	@Then("entered user information displayed below in a text area")
	public void entered_user_information_displayed_below_in_a_text_area() {
		Assert.assertTrue(elementsMenuPage.checkEnteredInfoTextAreaDisplay());
		Assert.assertTrue(elementsMenuPage.checkEnteredInfoTextAreaSize(), "Text area has entered user information");

	}

	/**
	 * Added on 27/06/2024 2nd scenario started
	 * 
	 * @throws InterruptedException
	 */

	@When("clicks on radio button option")
	public void clicks_on_radio_button_option() {
		elementsMenuPage.clickRadioButtonMOption();
		assertEquals("Radio Button", utilPage.getTextOfHeader());
	}

	@And("user can see question with selection of radio buttons")
	public void user_can_see_question_with_selection_of_radio_buttons() {
		assertEquals("Do you like the site?", elementsMenuPage.getTextOfRadtioBtnQue());
	}

	@When("user clicks on yes radio button")
	public void user_clicks_on_yes_radio_button() {
		utilPage.scrollDown();
		elementsMenuPage.clickYesRadioBtnOption();
	}

	@Then("selected radio button information displayed below in a text area")
	public void selected_radio_button_information_displayed_below_in_a_text_area() {
		Assert.assertTrue(elementsMenuPage.checkSelectedRBInfoTextAreaDisplay());
		assertEquals("Yes", elementsMenuPage.getTextOfRBTextArea());
	}

	// Added on 1/07/2024 3rd scenario started

	@When("user click on check box option")
	public void user_click_on_check_box_option() {
		elementsMenuPage.clickCheckBoxOption();
	}

	@Then("click on check box button")
	public void click_on_check_box_button() {
		elementsMenuPage.selectCBOption();
		assertEquals(true,elementsMenuPage.getResultCB().contains("home"));
	}

}

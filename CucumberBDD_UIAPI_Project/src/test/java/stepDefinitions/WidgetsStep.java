package stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.UtilPage;
import pages.WidgetsPage;
import utils.UtilDriver;

public class WidgetsStep {

	HomePage homePage = new HomePage(UtilDriver.getDriver());
	UtilPage utilPage = new UtilPage(UtilDriver.getDriver());
	WidgetsPage widgetsPage = new WidgetsPage(UtilDriver.getDriver());

	@Given("user on the homepage and clicks on widgets Menu option")
	public void user_on_the_homepage_and_clicks_on_widgets_menu_option() {
		assertEquals(true, homePage.displayToolsQAIcon());
		homePage.clickWidgetsMenu();
	}

	@When("user clicks on select menu option")
	public void user_clicks_on_select_menu_option() {
		// utilPage.scrollDown();
		widgetsPage.clickSelectMenuOption();
	}

	@Then("user see header text and title for first selection option")
	public void user_see_header_text_and_title_for_first_selection_option() {
		assertEquals("Select Menu", utilPage.getTextOfHeader());
		assertEquals("Select Value", widgetsPage.getHeaderOfSelectValue());
	}

	@When("user select any value from select value dropdown")
	public void user_select_any_value_from_select_value_dropdown() {
		widgetsPage.selValFromSelectValueDropdown();
	}

	@Then("validate selected value for first")
	public void validate_selected_value_for_first() {
		assertEquals("Group 2, option 1", widgetsPage.getResultOfSelectValue());
	}

	@When("user select any value from select one dropdown")
	public void user_select_any_value_from_select_one_dropdown() {
		assertEquals("Select One", widgetsPage.getHeaderOfSelectOne());
		widgetsPage.selValFromSelectOneDropdown();
	}

	@Then("validate selected value for second")
	public void validate_selected_value_for_second() {
		assertEquals("Mr.", widgetsPage.getResultOfSelectOne());
	}

	@When("user select any value from old style select menu dropdown")
	public void user_select_any_value_from_old_style_select_menu_dropdown() {
		assertEquals("Old Style Select Menu", widgetsPage.getHeaderOfOldStyleSelectMenu());
		widgetsPage.selValFromOldStyleSelectMenu();
	}

	@Then("validate selected value for third")
	public void validate_selected_value_for_third() {
		assertEquals("Green", widgetsPage.getResultOfOldStyleSelectMenu());
	}

	@When("user select two values from multiselect dropdown")
	public void user_select_two_values_from_multiselect_dropdown() {
		assertEquals("Multiselect drop down", widgetsPage.getHeaderOfMultiselectDropdown());
		widgetsPage.selValFromMultiselectDropdown();
	}

	@Then("validate selected values for fourth")
	public void validate_selected_values_for_fourth() {
		assertTrue(widgetsPage.getResultOfMultiselectDropdown().contains("Blue"));
		assertTrue(widgetsPage.getResultOfMultiselectDropdown().contains("Black"));
	}

	@When("user select two values from standard multiselect dropdown")
	public void user_select_two_values_from_standard_multiselect_dropdown() {
		assertEquals("Standard multi select", widgetsPage.getHeaderOfStandardMultiselect());
		widgetsPage.selValFromStandardMultiselect();
	}

	@Then("validate selected values for fifth")
	public void validate_selected_values_for_fifth() {
		assertTrue(widgetsPage.getResultOfStandardMultiselect().contains("Saab"));
		assertTrue(widgetsPage.getResultOfStandardMultiselect().contains("Opel"));
	}

}

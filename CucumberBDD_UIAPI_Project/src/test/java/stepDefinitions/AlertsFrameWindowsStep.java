package stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AlertsFramesWindowsPage;
import pages.HomePage;
import pages.UtilPage;
import utils.UtilDriver;

public class AlertsFrameWindowsStep {

	HomePage homePage = new HomePage(UtilDriver.getDriver());
	UtilPage utilPage = new UtilPage(UtilDriver.getDriver());
	AlertsFramesWindowsPage alertsFramesWindowsPage = new AlertsFramesWindowsPage(UtilDriver.getDriver());

	@Given("user on the homepage and clicks on Alerts, Frame and Windows Menu option")
	public void user_homepage_clicks_Alerts_Frame_Windows_Menu_option() {
		assertEquals(true, homePage.displayToolsQAIcon());
		homePage.clickAlertsFrameWindowsMenu();
	}

	@Given("user clicks on browser windows option")
	public void user_clicks_on_browser_windows_option() {
		alertsFramesWindowsPage.clickBrowserWindowsOption();
		assertEquals("Browser Windows", utilPage.getTextOfHeader());
	}

	@When("user clicks on new tab option")
	public void user_clicks_on_new_tab_option() {
		alertsFramesWindowsPage.clickNewTabBtn();

	}

	@Then("user can see new opened tab and message")
	public void user_can_see_new_opened_tab_and_message() {
		utilPage.switchToNewTab();
		assertEquals("This is a sample page", alertsFramesWindowsPage.getTextOfTabWindowMsg());
		utilPage.closeNewTab();
	}

	@When("user clicks on new window option")
	public void user_clicks_on_new_window_option() {
		alertsFramesWindowsPage.clickNewWindowBtn();
	}

	@Then("user can see new opened window and message")
	public void user_can_see_new_opened_window_and_message() {
		utilPage.switchToNewTab();
		assertEquals("This is a sample page", alertsFramesWindowsPage.getTextOfTabWindowMsg());
		utilPage.closeNewTab();
	}

	@When("user clicks on new window message option")
	public void user_clicks_on_new_window_message_option() {
		alertsFramesWindowsPage.clickNewWindowMsgBtn();
	}

	@Then("user can see new opened window and detailed message")
	public void user_can_see_new_opened_window_and_detailed_message() {
		// utilPage.switchToNewWindow();
		/*
		 * assertEquals(
		 * "Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization."
		 * , alertsFramesWindowsPage.getTextOfWindowDetailMsg());
		 */
		assertTrue(alertsFramesWindowsPage.displayNewWindow());
		utilPage.closeNewTab();

	}

	/**
	 * 2nd scenario of validation of alerts started
	 */

	@Given("user clicks on alerts option")
	public void user_clicks_on_alerts_option() {
		alertsFramesWindowsPage.clickAlertsOption();
		assertEquals("Alerts", utilPage.getTextOfHeader());
	}

	@When("user clicks on first click me button")
	public void user_clicks_on_first_click_me_button() {
		assertEquals("Click Button to see alert", alertsFramesWindowsPage.getTextOfFirstClickMeBtnHeader());
		alertsFramesWindowsPage.clickFirstClickMeOption();
	}

	@Then("user can see simple alert window and clicks ok")
	public void user_can_see_simple_alert_window_and_clicks_ok() {
		assertEquals("You clicked a button", utilPage.getTextOfAlert());
		utilPage.clickAlertOkBtn();
	}

	@When("user clicks on second click me button")
	public void user_clicks_on_second_click_me_button() {
		assertEquals("On button click, alert will appear after 5 seconds",
				alertsFramesWindowsPage.getTextOfSecondClickMeBtnHeader());
		alertsFramesWindowsPage.clickSecondClickMeOption();
	}

	@Then("user can see alert window after five seconds")
	public void user_can_see_alert_window_after_five_seconds() {
		assertEquals("This alert appeared after 5 seconds", utilPage.getTextOfAlert());
		utilPage.clickAlertOkBtn();
	}

	@When("user clicks on third click me button")
	public void user_clicks_on_third_click_me_button() {
		assertEquals("On button click, confirm box will appear",
				alertsFramesWindowsPage.getTextOfThirdClickMeBtnHeader());
		alertsFramesWindowsPage.clickThirdClickMeOption();
	}

	@Then("user can see confirm box and clicks cancel")
	public void user_can_see_confirm_box_and_clicks_cancel() {
		assertEquals("Do you confirm action?", utilPage.getTextOfAlert());
		utilPage.clickAlertCancelBtn();
	}

	@Then("user can see selected option value")
	public void user_can_see_selected_option_value() {
		assertEquals("You selected Cancel", alertsFramesWindowsPage.getTextOfSelectedValue());
	}

	@When("user clicks on fourth click me button")
	public void user_clicks_on_fourth_click_me_button() {
		assertEquals("On button click, prompt box will appear",
				alertsFramesWindowsPage.getTextOfFourthClickMeBtnHeader());
		alertsFramesWindowsPage.clickFourthClickMeOption();
	}

	@Then("user can see pop-up box and enters name")
	public void user_can_see_pop_up_box_and_enters_name() {
		assertEquals("Please enter your name", utilPage.getTextOfAlert());
		utilPage.enterValueInAlert();
		utilPage.clickAlertOkBtn();
	}

	@Then("user can see entered value")
	public void user_can_see_entered_value() {
		assertEquals("You entered Saniya", alertsFramesWindowsPage.getTextOfEnteredValue());
	}

	/**
	 * 3rd scenario started
	 */

	@Given("user clicks on modal dialogs option")
	public void user_clicks_on_modal_dialogs_option() {
		alertsFramesWindowsPage.clickModalDialogsOption();
	}

	@Then("user can see header text and the text to do action")
	public void user_can_see_header_text_and_the_text_to_do_action() {
		assertEquals("Modal Dialogs", utilPage.getTextOfHeader());
		assertEquals("Click on button to see modal", alertsFramesWindowsPage.getTextOfActionHeader());
	}

	@When("user clicks on small modal button")
	public void user_clicks_on_small_modal_button() {
		alertsFramesWindowsPage.clickSmallModalButton();
	}

	@Then("user can see opened small modal and message")
	public void user_can_see_opened_small_modal_and_message() {
		assertEquals("Small Modal", alertsFramesWindowsPage.getTextOfSmallModalTitle());
		assertEquals("This is a small modal. It has very less content",
				alertsFramesWindowsPage.getTextOfSmallLargeModalMsg());
	}

	@Then("user clicks on close button")
	public void user_clicks_on_close_button() {
		alertsFramesWindowsPage.clickCloseButton();
	}

	@When("user clicks on large modal button")
	public void user_clicks_on_large_modal_button() {
		alertsFramesWindowsPage.clickLargeModalButton();
	}

	@Then("user can see opened large modal and message")
	public void user_can_see_opened_large_modal_and_message() {
		assertEquals("Large Modal", alertsFramesWindowsPage.getTextOfLargeModalTitle());
		assertEquals(
				"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
				alertsFramesWindowsPage.getTextOfSmallLargeModalMsg());
	}

	@Then("user clicks on cross button option and see header text")
	public void user_clicks_on_cross_button_option_and_see_header_text() {
		alertsFramesWindowsPage.clickCrossBtn();
	}

	/**
	 * 4th scenario started
	 */

	@When("Click on the Nested Frames sub menu")
	public void click_on_the_nested_frames_sub_menu() {
		alertsFramesWindowsPage.clickNestedFrameSubMenu();
	}

	@When("user switch to frame1")
	public void user_switch_to_frame1() {
		alertsFramesWindowsPage.switchToFrame1();
	}

	@When("user switch to frame2")
	public void user_switch_to_frame2() {
		alertsFramesWindowsPage.switchToFrame2();

	}

	@Then("the text {string} is display")
	public void the_text_is_display(String string) {
		Assert.assertEquals(alertsFramesWindowsPage.getTextOfTextBody(), "Nested frame body");

	}

	@When("Switch back to the default content")
	public void switch_back_to_the_default_content() {
		alertsFramesWindowsPage.switchToDefaultContent();
	}

	@Then("Verify the text {string} is displayed")
	public void verify_the_text_is_displayed(String string) {
		Assert.assertEquals(alertsFramesWindowsPage.getTextOfTitle(), "Nested frames");
	}
}

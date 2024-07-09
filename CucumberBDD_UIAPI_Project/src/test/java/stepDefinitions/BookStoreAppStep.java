package stepDefinitions;

import static org.testng.Assert.assertEquals;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;
import pages.UtilPage;
import utils.UtilDriver;

public class BookStoreAppStep {

	HomePage homePage = new HomePage(UtilDriver.getDriver());
	UtilPage utilPage = new UtilPage(UtilDriver.getDriver());
	RegisterPage registerPage = new RegisterPage(UtilDriver.getDriver());
	LoginPage loginPage = new LoginPage(UtilDriver.getDriver());

	@Given("user on the homepage and clicks on Book store menu option")
	public void user_on_the_homepage_and_clicks_on_book_store_menu_option() {
		assertEquals(true, homePage.displayToolsQAIcon());
		homePage.clickBookStoreAppMenu();
	}

	@Given("user clicks login menu and clicks new user button")
	public void user_clicks_login_menu_and_clicks_new_user_button() {
		loginPage.clickLoginOption();
		assertEquals("Login", utilPage.getTextOfHeader());
		loginPage.clickNewUserBtn();
		assertEquals("Register", utilPage.getTextOfHeader());
		assertEquals("Register to Book Store", registerPage.getTextOfRegisterTitle());
	}

	@When("user enters the following details for registration")
	public void user_enters_the_following_details_for_registration(DataTable dataTable) {
		registerPage.enterInfoForRegistration(dataTable);
	}

	@When("user check recaptcha option and clicks register button")
	public void user_check_recaptcha_option_and_clicks_register_button() throws InterruptedException {
		registerPage.checkRecaptcha();
		registerPage.clickRegisterBtn();
	}

	@Then("user registered alert displayed and clicks ok")
	public void user_registered_alert_displayed_and_clicks_ok() {
		assertEquals("User Register Successfully.", utilPage.getTextOfAlert());
		utilPage.clickAlertOkBtn();
	}

	/**
	 * 2nd scenario of login validation started
	 */

	@Given("user clicks login option")
	public void user_clicks_login_option() {
		loginPage.clickLoginOption();
		assertEquals("Login", utilPage.getTextOfHeader());
	}

	@When("user enters the following details for login")
	public void user_enters_the_following_details_for_login(DataTable dataTable) {
		loginPage.enterInfoForLogin(dataTable);
	}

	@When("user clicks login button")
	public void user_clicks_login_button() {
		loginPage.clickLoginBtn();
	}

	@Then("user redirected to profile page and validate logged in username")
	public void user_redirected_to_profile_page_and_validate_logged_in_username() {
		assertEquals("User Name :", loginPage.getTextOfUserNameProfileLabel());
		assertEquals("saniya", loginPage.getTextOfUserNameProfileValue());
	}
}

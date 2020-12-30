package stepDefinition.registration;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import question.registration.UserRegistrationQuestion;
import question.registration.UserRegistrationWelcome;
import task.registration.UserLocationTask;
import task.registration.UserPasswordTask;
import task.registration.UserPersonalInformationTask;
import task.registration.UsersDevicesInformationTask;

public class UserRegistrationStep {

    @Managed
    WebDriver driver;

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^I opened the utest page$")
    public void i_opened_the_utest_page() {
        OnStage.theActorCalled("the freelance tester").can(BrowseTheWeb.with(driver));
        OnStage.theActorInTheSpotlight().attemptsTo(Open.url("https://utest.com"));
    }

    @When("^I register my personal information \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" " +
            "\"([^\"]*)\"$")
    public void i_register_my_personal_information(
            String name, String lastName, String email, String birthMonth, String birthDay, String birthYear) {

        OnStage.theActorInTheSpotlight().attemptsTo(UserPersonalInformationTask.register(
                name, lastName, email, birthMonth, birthDay, birthYear
        ));
    }

    @When("^I register my location$")
    public void i_register_my_location() {
        OnStage.theActorInTheSpotlight().attemptsTo(UserLocationTask.register());
    }

    @When("^I register my devices information for software testing$")
    public void i_register_my_devices_information_for_software_testing() {
        OnStage.theActorInTheSpotlight().attemptsTo(UsersDevicesInformationTask.register());
    }

    @When("^I create my account password \"([^\"]*)\"$")
    public void i_create_my_account_password(String password) {
        OnStage.theActorInTheSpotlight().attemptsTo(UserPasswordTask.create(password));
    }

    @Then("^I should be redirected to welcome page \"([^\"]*)\" and copy \"([^\"]*)\" is displayed$")
    public void i_should_be_redirected_to_welcome_page(String url, String copy) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(UserRegistrationWelcome.copy().answeredBy(OnStage.theActorInTheSpotlight()))
                    .isEqualTo(copy),
                Ensure.that(UserRegistrationQuestion.successfulRedirect().answeredBy(
                        OnStage.theActorInTheSpotlight())).isEqualTo(url)
        );
    }

    @After
    public void tearDown() {
        driver.close();
    }
}

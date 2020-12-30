package runners.registration;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/registration/user_registration.feature",
        tags = {"@SuccessfulUserRegistration"},
        glue = "stepDefinition"
)

public class UserRegistrationRunner {
}

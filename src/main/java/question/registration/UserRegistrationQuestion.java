package question.registration;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.WebDriver;

@Subject("verifying that redirect after user registration is correct")
public class UserRegistrationQuestion implements Question<String> {

    WebDriver driver = ThucydidesWebDriverSupport.getProxiedDriver();

    @Override
    public String answeredBy(Actor actor) {
        return driver.getCurrentUrl();
    }

    public static Question<String> successfulRedirect() {
        return new UserRegistrationQuestion();
    }
}

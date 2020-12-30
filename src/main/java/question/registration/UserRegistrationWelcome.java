package question.registration;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.registration.successful.WelcomePage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

@Subject("verifying that welcome copy is displayed correctly")
public class UserRegistrationWelcome implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(WelcomePage.WELCOME_COPY, isVisible())
                    .forNoMoreThan(300).seconds()
        );
        return WelcomePage.WELCOME_COPY.resolveFor(actor).getTextContent();
    }

    public static Question<String> copy() {
        return new UserRegistrationWelcome();
    }

}

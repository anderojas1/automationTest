package task.registration;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.registration.forms.PasswordCreationPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class UserPasswordTask implements Task {

    private final String password;

    public UserPasswordTask(String password) {
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(PasswordCreationPage.PASSWORD_INPUT, isVisible())
                    .forNoMoreThan(20).seconds(),
                Enter.theValue(password).into(PasswordCreationPage.PASSWORD_INPUT),
                Enter.theValue(password).into(PasswordCreationPage.CONFIRM_PASSWORD_INPUT),
                Click.on(PasswordCreationPage.TERMS_OF_USE_CHECK),
                Click.on(PasswordCreationPage.POLICIES_CHECK),
                Click.on(PasswordCreationPage.COMPLETE_SETUP_BUTTON)
        );
    }

    public static Performable create(String password) {
        return instrumented(UserPasswordTask.class, password);
    }
}

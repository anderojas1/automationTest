package task.registration;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import ui.registration.LandingPage;
import ui.registration.forms.PersonalInformationPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class UserPersonalInformationTask implements Task {

    private final String name;
    private final String lastName;
    private final String email;
    private final String birthMonth;
    private final String birthDay;
    private final String birthYear;

    public UserPersonalInformationTask(
            String name, String lastName, String email, String birthMonth, String birthDay, String birthYear) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
        this.birthYear = birthYear;
    }

    @Override
    @Step("{0} register his/her personal information")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LandingPage.JOIN_TODAY_BUTTON),
                WaitUntil.the(PersonalInformationPage.NAME_INPUT, isVisible())
                    .forNoMoreThan(20).seconds(),
                Enter.theValue(name).into(PersonalInformationPage.NAME_INPUT),
                Enter.theValue(lastName).into(PersonalInformationPage.LAST_NAME_INPUT),
                Enter.theValue(email).into(PersonalInformationPage.EMAIL_INPUT),
                SelectFromOptions.byVisibleText(birthMonth).from(PersonalInformationPage.BIRTH_MONTH_SELECT),
                SelectFromOptions.byVisibleText(birthDay).from(PersonalInformationPage.BIRTH_DAY_SELECT),
                SelectFromOptions.byVisibleText(birthYear).from(PersonalInformationPage.BIRTH_YEAR_SELECT),
                Click.on(PersonalInformationPage.NEXT_TO_LOCATION_BUTTON)
        );
    }

    public static Performable register(
            String name, String lastName, String email, String birthMonth, String birthDay, String birthYear) {

        return instrumented(
                UserPersonalInformationTask.class, name, lastName, email, birthMonth, birthDay, birthYear);

    }
}

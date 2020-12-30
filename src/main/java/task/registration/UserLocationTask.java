package task.registration;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;
import ui.registration.forms.LocationPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class UserLocationTask implements Task {

    @Override
    @Step("{0} registers his/her location")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(LocationPage.NEXT_TO_DEVICES_BUTTON)
                    .andAlignToBottom(),
                Click.on(LocationPage.NEXT_TO_DEVICES_BUTTON)
        );
    }

    public static Performable register() {
        return instrumented(UserLocationTask.class);
    }
}

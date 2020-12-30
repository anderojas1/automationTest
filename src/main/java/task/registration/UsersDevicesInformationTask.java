package task.registration;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;
import ui.registration.forms.DevicesInformationPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class UsersDevicesInformationTask implements Task {

    @Override
    @Step("{0} registers the devices information available for software testing")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(DevicesInformationPage.NEXT_TO_LAST_STEP_BUTTON)
                    .andAlignToBottom(),
                Click.on(DevicesInformationPage.NEXT_TO_LAST_STEP_BUTTON)
        );
    }

    public static Performable register() {
        return instrumented(UsersDevicesInformationTask.class);
    }
}

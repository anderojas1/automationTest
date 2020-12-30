package ui.registration.forms;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class DevicesInformationPage extends PageObject {

    public static final Target NEXT_TO_LAST_STEP_BUTTON =
            Target.the("next to password creation button")
            .located(By.xpath("//i[text()='chevron_right']/ancestor::a"));
}

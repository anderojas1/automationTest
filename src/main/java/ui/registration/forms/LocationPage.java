package ui.registration.forms;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class LocationPage extends PageObject {

    public static final Target NEXT_TO_DEVICES_BUTTON = Target.the("next to devices section button")
            .located(By.xpath("//i[text()='chevron_right']/ancestor::a"));

}

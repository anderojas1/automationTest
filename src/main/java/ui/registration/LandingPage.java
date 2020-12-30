package ui.registration;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class LandingPage extends PageObject {

    public static final Target JOIN_TODAY_BUTTON = Target.the("join today button")
        .located(By.xpath("//a[@ui-sref='signup.personal']"));

}

package ui.registration.forms;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class PasswordCreationPage extends PageObject {

    public static final Target PASSWORD_INPUT = Target.the("password input")
            .located(By.id("password"));

    public static final Target CONFIRM_PASSWORD_INPUT = Target.the("confirm password input")
            .located(By.id("confirmPassword"));

    public static final Target TERMS_OF_USE_CHECK = Target.the("terms of use checkbox")
            .located(By.id("termOfUse"));

    public static final Target POLICIES_CHECK = Target.the("policies checkbox")
            .located(By.id("privacySetting"));

    public static final Target COMPLETE_SETUP_BUTTON = Target.the("complete setup button")
            .located(By.id("laddaBtn"));

}

package ui.registration.successful;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class WelcomePage extends PageObject {

    public static final Target WELCOME_COPY = Target.the("welcome title").located(
            By.xpath("//div[@class='image-box-header']/h1")
    );
}

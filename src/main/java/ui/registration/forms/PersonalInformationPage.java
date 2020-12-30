package ui.registration.forms;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class PersonalInformationPage extends PageObject {

    public static final Target NAME_INPUT = Target.the("name input").located(By.id("firstName"));

    public static final Target LAST_NAME_INPUT = Target.the("last name input").located(
            By.id("lastName"));

    public static final Target EMAIL_INPUT = Target.the("email input").located(By.id("email"));

    public static final Target BIRTH_MONTH_SELECT = Target.the("birth month select")
            .located(By.id("birthMonth"));

    public static final Target BIRTH_DAY_SELECT = Target.the("birth day select")
            .located(By.id("birthDay"));

    public static final Target BIRTH_YEAR_SELECT = Target.the("birth year select")
            .located(By.id("birthYear"));

    public static final Target NEXT_TO_LOCATION_BUTTON = Target.the("next to location button")
            .located(By.xpath("//i[text()='chevron_right']/ancestor::a"));

}

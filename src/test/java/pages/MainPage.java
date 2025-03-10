package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    // https://demoqa.com/
    private final SelenideElement formButton = $x("//h5[text()='Forms']");
    private final WebElement practiceFormButton = $x("//span[text()='Practice Form']");

    @Step("Открыть форму практики")
    public void openPracticeFormPage() {
        open("");
        formButton.click();
        practiceFormButton.click();
    }
}

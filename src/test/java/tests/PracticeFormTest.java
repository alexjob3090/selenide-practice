package tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.java.demoqa.pages.MainPage;
import ru.java.demoqa.pages.PracticeFormPage;

@Feature("Форма регистрации")
@Story("Заполнение формы регистрации")
@DisplayName("Тест Заполнение формы")
public class PracticeFormTest extends BaseTest {

    private MainPage mainPage = new MainPage();
    private PracticeFormPage practiceFormPage = new PracticeFormPage();


    @Test
    @DisplayName("Тестирование заполнения формы")
    @Owner("Alex")
    public void testFillForm() {
      mainPage.openPracticeFormPage();
      practiceFormPage.checkTitle();
      practiceFormPage.setFirstNameInput("Alex")
              .setLastNameInput("Petrov")
              .setEmailInput("alex.petrov@gmail.com")
              .selectGenderButton()
              .setPhoneNumberInput("+799999999")
              .setBirthDateInput("1", "January", "1990");


    }
}

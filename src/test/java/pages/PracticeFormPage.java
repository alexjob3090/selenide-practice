package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {
    private final SelenideElement practiceFormTitle = $x("//h1[text()='Practice Form']");
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement emailInput = $("#userEmail");
    private final SelenideElement genderMaleRadioButton = $("label[for='gender-radio-1']");
    private final SelenideElement phoneNumberInput = $("#userNumber");
    private final SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private final SelenideElement yearOfBirthSelect = $(".react-datepicker__year-select");
    private final SelenideElement monthOfBirthSelect = $(".react-datepicker__month-select");
    private final ElementsCollection dayOfBirthSelect = $$(".react-datepicker__day");
    private final SelenideElement subjectsInput = $("#subjectsContainer");
    private final SelenideElement hobbiesSportsCheckbox = $("#hobbies-checkbox-1");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement stateSelect = $("#state");
    private final SelenideElement citySelect = $("#city");
    private final SelenideElement submitButton = $("#submit");

    @Step("Проверить заголовок страницы")
    public boolean checkTitle() {
        return practiceFormTitle.isDisplayed();
    }

    @Step("Ввести Имя")
    public PracticeFormPage setFirstNameInput(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    @Step("Ввести Фамилию")
    public PracticeFormPage setLastNameInput(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    @Step("Ввести email")
    public PracticeFormPage setEmailInput(String email) {
        emailInput.setValue(email);
        return this;
    }

    @Step("Выбрать пол")
    public PracticeFormPage selectGenderButton() {
        genderMaleRadioButton.click();
        return this;
    }

    @Step("Ввести номер телефона")
    public PracticeFormPage setPhoneNumberInput(String phoneNumber) {
        phoneNumberInput.setValue(phoneNumber);
        return this;
    }

    @Step("Ввести день рождения")
    public PracticeFormPage setBirthDateInput(String day, String month, String year) {
        dateOfBirthInput.click();
        yearOfBirthSelect.selectOption(year);
        monthOfBirthSelect.selectOption(month);
        dayOfBirthSelect.filter(Condition.exactText(day)).first().click();
        return this;

    }

}

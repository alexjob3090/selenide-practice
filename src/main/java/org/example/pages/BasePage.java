package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BasePage {

    protected SelenideElement get(By locator) {
        return $(locator);
    }

    protected void type(By locator, String text) {
        get(locator).val(text);
    }

    protected void click(By locator) {
        get(locator).click();
    }
}

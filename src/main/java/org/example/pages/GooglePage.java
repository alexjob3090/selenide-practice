package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class GooglePage extends BasePage {
    private final By googleSearch = By.id("searchbox_input");

    public void search(String text) {
        type(googleSearch, text);
        get(googleSearch).pressEnter();
    }

}

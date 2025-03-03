package com.example.google;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.example.pages.GooglePage;
import org.example.pages.GoogleResultsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class GoogleTest {

    private GooglePage googlePage;
    private GoogleResultsPage googleResultsPage;

    @BeforeEach
    public void setUp() {
        if (WebDriverRunner.hasWebDriverStarted()) {
            closeWebDriver();
        }
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        googlePage = new GooglePage();
        googleResultsPage = new GoogleResultsPage();
        open("https://duckduckgo.com");
    }

    @Test
    public void testGoogleSearch() {
        googlePage.search("Selenium");

        googleResultsPage.checkCollectionSize(1);
        googleResultsPage.checkElementHasText("Selenium", 1);

    }
}

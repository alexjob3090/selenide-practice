package com.example.google;

import com.codeborne.selenide.Config;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.example.pages.GooglePage;
import org.example.pages.GoogleResultsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class GoogleTest {

    private GooglePage googlePage;
    private GoogleResultsPage googleResultsPage;

    @BeforeEach
    public void setUp() throws MalformedURLException {
//        if (WebDriverRunner.hasWebDriverStarted()) {
//            closeWebDriver();
//        }

        Configuration.baseUrl = "https://duckduckgo.com";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";


        Configuration.browser = "chrome";
        Configuration.browserVersion = "100.0"; // Optional, specify Chrome version
        Configuration.browserSize = "1920x1080"; // Set resolution
        Configuration.timeout = 10000; // Set timeout in milliseconds

        // Enable Selenoid-specific capabilities
        ChromeOptions options = new ChromeOptions();
        options.setCapability("selenoid:options", Map.of(
                "name", "google search",           // Set test name (badge)
//                "sessionTimeout", "15m",           // Set session timeout
                "env", List.of("TZ=UTC"),          // Set timezone to UTC
//                "labels", Map.of("manual", "true"),// Enable manual session cleanup
                "enableVideo", true                // Enable video recording
        ));
        Configuration.browserCapabilities = options;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        googlePage = new GooglePage();
        googleResultsPage = new GoogleResultsPage();

    }

    @Step("Test google search")
    @Test
    public void testGoogleSearch() {

        step("Открываем главную страницу duckduckgo", () -> {
            open("");
        });

        googlePage.search("Selenium");

        googleResultsPage.checkCollectionSize(1);
        googleResultsPage.checkElementHasText("Selenium", 1);

    }
}

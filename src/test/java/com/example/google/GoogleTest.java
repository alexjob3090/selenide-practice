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

//        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserVersion", "100.0");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            /* How to add test badge */
            put("name", "Test badge...");

            /* How to set session timeout */
            put("sessionTimeout", "15m");

            /* How to set timezone */
            put("env", new ArrayList<String>() {{
                add("TZ=UTC");
            }});

            /* How to add "trash" button */
            put("labels", new HashMap<String, Object>() {{
                put("manual", "true");
            }});

            /* How to enable video recording */
            put("enableVideo", true);
        }});
        RemoteWebDriver driver = new RemoteWebDriver(new URL("https://user1:1234@selenoid.autotests.cloud/wd/hub"), options);

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

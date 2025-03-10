package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.DriverConfig;
import config.InitConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import utils.Attach;

public class BaseTest {

    private static final InitConfig initConfig = new InitConfig();

    @BeforeAll
    public static void setUp() {
        initConfig.initConfig();

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    public void addAttachments() {
        Attach.screenshotAs("Last");
        Attach.pageSource();
//        Attach.browserConsoleLog();
        Selenide.closeWebDriver();
    }
}

package config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class InitConfig {

    private final DriverConfig config = ConfigFactory.create(DriverConfig.class, System.getProperties());

    public InitConfig() {
        initConfig();
    }

    public void initConfig() {

        Configuration.browser = config.browserName();
        Configuration.browserSize = config.browserSize();
        Configuration.browserVersion = config.browserVersion();
        Configuration.baseUrl = config.baseUrl();
        Configuration.pageLoadStrategy = "eager";

        if (config.isRemote()) {
            String remoteUrl = config.selenoidUser() + ":" + config.selenoidPassword() + "@selenoid.autotests.cloud/wd/hub";
            Configuration.remote = remoteUrl;

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true));

            Configuration.browserCapabilities = capabilities;
        }
    }
}

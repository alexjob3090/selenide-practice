package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:config/settings.properties",
        "classpath:config/remote.properties"})
public interface DriverConfig extends Config {

    @Key("browserName")
    @DefaultValue("chrome")
    String browserName();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("browserVersion")
//    @DefaultValue("113")
    String browserVersion();

    @Key("baseUrl")
    @DefaultValue("https://demoqa.com")
    String baseUrl();

    @Key("isRemote")
    boolean isRemote();

    @Key("selenoidUser")
    String selenoidUser();

    @Key("selenoidPassword")
    String selenoidPassword();

    @Key("selenoidHost")
    String selenoidHost();

    @Key("remoteUrl")
    String getRemoteUrl();

}

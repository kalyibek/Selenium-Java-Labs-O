package com.automation.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class WebDriverFactory {
    private static final File CROMEDRIVER_EXE = new File("src/test/resources/chromedriver.exe");
    private static final File FIREFOXDRIVER_EXE = new File("src/test/resources/geckodriver.exe");
    public static WebDriver createWebDriver(String browserName) {
        WebDriver driver;

        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", CROMEDRIVER_EXE.getAbsolutePath());
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", FIREFOXDRIVER_EXE.getAbsolutePath());
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Неподдерживаемый браузер: " + browserName);
        }

        return driver;
    }
}

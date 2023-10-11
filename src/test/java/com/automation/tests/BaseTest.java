package com.automation.tests;

import com.automation.Utils.WebDriverFactory;
import com.automation.pages.CreateTutorialPage;
import com.automation.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import static com.automation.data.ExpectedData.*;

public abstract class BaseTest {
    private static WebDriver driver;
    private static Integer uniqueId;
    private static final By uniqueIdLocator = By.tagName("th");
    private static final By confirmBtn = By.id("yesBtn");
    private static final By deleteBtn = By.cssSelector("a[id='btnDelete']");

    public static WebDriver getDriver () {
        return driver;
    }

    @BeforeClass
    public void setUp() {
        String BASE_URL = "http://194.152.37.7:4446/tutorials";
        driver = WebDriverFactory.createWebDriver("firefox");
        driver.get(BASE_URL);
        HomePage homePage = new HomePage();
        CreateTutorialPage createPage = new CreateTutorialPage();
        homePage.clickAddTutorialLink();
        createPage.fillFormAndSubmit();
        setUniqueId();
    }

    @AfterClass
    public void tearDown() {
        deleteTutorial();
        HomePage homePage = new HomePage();
        homePage.assertThatTutorialDeleted();
        driver.quit();
    }

    public static Integer getUniqueId() {
        return uniqueId;
    }

    public static void setUniqueId() {
        By tutorialRowTitle = By.xpath("//tr[td[contains(text(), '" + TITLE + "')]]");
        WebElement tutorialRowElement = driver.findElement(tutorialRowTitle);
        WebElement uniqueIdElement = tutorialRowElement.findElement(uniqueIdLocator);
        uniqueId = Integer.parseInt(uniqueIdElement.getText());
    }

    public static void deleteTutorial() {
        By tutorialRowId = By.xpath("//tr[th[contains(text(), '" + uniqueId + "')]]");
        WebElement tutorialRowElement = driver.findElement(tutorialRowId);

        WebElement deleteBtnElement = tutorialRowElement.findElement(deleteBtn);
        deleteBtnElement.click();

        WebElement confirmBtnElement = driver.findElement(confirmBtn);
        confirmBtnElement.click();
    }
}

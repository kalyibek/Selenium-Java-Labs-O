package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.automation.data.ExpectedData.*;

public class RetrieveUpdateTutorialPage extends BasePage {
    private final By inputTitle = By.id("title");
    private final By inputDescription = By.id("description");
    private final By inputLevel = By.id("level");
    private final By radioPublished = By.id("published1");
    private final By btnSubmit = By.cssSelector("input[value='Save']");

    public RetrieveUpdateTutorialPage() {
        super();
    }

    public void submit() {
        WebElement btnSubmitElement = driver.findElement(btnSubmit);
        btnSubmitElement.click();
    }

    public void fillFormAndSubmit() {
        WebElement inputTitleElement = driver.findElement(inputTitle);
        inputTitleElement.clear();
        inputTitleElement.sendKeys(NEW_TITLE);

        WebElement inputDescriptionElement = driver.findElement(inputDescription);
        inputDescriptionElement.clear();
        inputDescriptionElement.sendKeys(NEW_DESCRIPTION);

        WebElement inputLevelElement = driver.findElement(inputLevel);
        inputLevelElement.clear();
        inputLevelElement.sendKeys(NEW_LEVEL.toString());

        WebElement radioPublishedElement = driver.findElement(radioPublished);
        radioPublishedElement.click();

        submit();
    }

    public boolean isActualDataEqualsExpected() {
        WebElement inputTitleElement = driver.findElement(inputTitle);
        WebElement inputDescriptionElement = driver.findElement(inputDescription);
        WebElement inputLevelElement = driver.findElement(inputLevel);

        return inputTitleElement.getAttribute("value").equals(TITLE) &&
                inputDescriptionElement.getAttribute("value").equals(DESCRIPTION) &&
                inputLevelElement.getAttribute("value").equals(LEVEL.toString());
    }
}

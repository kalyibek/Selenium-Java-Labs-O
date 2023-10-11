package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.automation.data.ExpectedData.*;

public class CreateTutorialPage extends BasePage {
    private final By inputTitle = By.id("title");
    private final By inputDescription = By.id("description");
    private final By inputLevel = By.id("level");
    private final By radioPublished = By.id("published1");
    private final By btnSubmit = By.cssSelector("input[value='Save']");

    public CreateTutorialPage() {
        super();
    }

    public void fillFormAndSubmit() {
        WebElement inputTitleElement = driver.findElement(inputTitle);
        inputTitleElement.sendKeys(TITLE);

        WebElement inputDescriptionElement = driver.findElement(inputDescription);
        inputDescriptionElement.sendKeys(DESCRIPTION);

        WebElement inputLevelElement = driver.findElement(inputLevel);
        inputLevelElement.clear();
        inputLevelElement.sendKeys(LEVEL.toString());

        WebElement radioPublishedElement = driver.findElement(radioPublished);
        radioPublishedElement.click();

        WebElement btnSubmitElement = driver.findElement(btnSubmit);
        btnSubmitElement.click();
    }
}


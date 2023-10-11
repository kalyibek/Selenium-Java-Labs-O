package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.List;

import static com.automation.data.ExpectedData.*;
import static com.automation.tests.BaseTest.getUniqueId;
import static org.testng.Assert.*;

public class HomePage extends BasePage {
    private final By tutorialRowId;
    private final By addLink = By.cssSelector("a[href='/tutorials/new']");
    private final By editLink = By.cssSelector("a[title='Edit this tutorial']");

    public HomePage() {
        super();
        Integer uniqueId = getUniqueId();
        tutorialRowId = By.xpath("//tr[th[contains(text(), '" + uniqueId + "')]]");
    }

    public void clickAddTutorialLink() {
        WebElement addLinkElement = driver.findElement(addLink);
        addLinkElement.click();
    }

    public void clickTutorialEditLink() {
        WebElement tutorialRowElement = driver.findElement(tutorialRowId);
        WebElement editBtnElement = tutorialRowElement.findElement(editLink);
        editBtnElement.click();
    }

    public boolean isTutorialVisible() {
        WebElement tutorialRowElement = driver.findElement(tutorialRowId);
        return tutorialRowElement.isDisplayed();
    }

    public void assertThatTutorialDeleted() {
        List<WebElement> tutorialRowElements = driver.findElements(tutorialRowId);
        assertTrue(tutorialRowElements.isEmpty());
    }

    public void assertThatCreatedActualDataEqualsExpected() {
        WebElement tutorialRowElement = driver.findElement(tutorialRowId);
        List<WebElement> tutorialCellsElement = tutorialRowElement.findElements(By.tagName("td"));
        assertTrue(isActualDataEqualsExpected(tutorialCellsElement, TITLE, DESCRIPTION, LEVEL.toString()));
    }

    public void assertThatUpdatedActualDataEqualsExpected() {
        WebElement tutorialRowElement = driver.findElement(tutorialRowId);
        List<WebElement> tutorialCellsElement = tutorialRowElement.findElements(By.tagName("td"));

        assertTrue(isActualDataEqualsExpected(
                tutorialCellsElement, NEW_TITLE, NEW_DESCRIPTION, NEW_LEVEL.toString())
        );
    }

    private boolean isActualDataEqualsExpected(List<WebElement> elements,
                                            String title, String description, String level) {

        return elements.get(0).getText().equals(title) &&
                elements.get(1).getText().equals(description) &&
                elements.get(2).getText().equals(level);
    }
}


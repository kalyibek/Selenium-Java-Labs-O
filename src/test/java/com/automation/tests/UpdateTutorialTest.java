package com.automation.tests;

import com.automation.pages.HomePage;
import com.automation.pages.RetrieveUpdateTutorialPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class UpdateTutorialTest extends BaseTest {
    @Test
    public void testUpdateTutorial() {
        HomePage homePage = new HomePage();
        RetrieveUpdateTutorialPage updateTutorialPage = new RetrieveUpdateTutorialPage();
        homePage.clickTutorialEditLink();
        updateTutorialPage.fillFormAndSubmit();
        assertTrue(homePage.isTutorialVisible());
        homePage.assertThatUpdatedActualDataEqualsExpected();
    }
}

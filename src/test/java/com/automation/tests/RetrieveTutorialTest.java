package com.automation.tests;

import com.automation.pages.HomePage;
import com.automation.pages.RetrieveUpdateTutorialPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class RetrieveTutorialTest extends BaseTest {
    @Test
    public void testRetrieveTutorial() {
        HomePage homePage = new HomePage();
        RetrieveUpdateTutorialPage retrieveTutorialPage = new RetrieveUpdateTutorialPage();
        homePage.clickTutorialEditLink();
        boolean positive = retrieveTutorialPage.isActualDataEqualsExpected();
        retrieveTutorialPage.submit();
        assertTrue(positive);
    }
}

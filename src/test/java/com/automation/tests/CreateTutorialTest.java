package com.automation.tests;

import com.automation.pages.HomePage;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CreateTutorialTest extends BaseTest {
    @Test
    public void testCreateTutorial() {
        HomePage homePage = new HomePage();
        assertTrue(homePage.isTutorialVisible());
        homePage.assertThatCreatedActualDataEqualsExpected();
    }
}

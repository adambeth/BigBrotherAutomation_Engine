package UI.tests.controlRefresh.flows;

import UI.pages.controlPage;
import UI.pages.loginPage;
import baseTestUtils.baseTest.testConfig;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class openExistingFlowTest extends testConfig {
    /**
     *  .Control Redesign :: Flow :: High-lightening selected flow
     *  https://jira.clickatell.com/browse/PPEN-2355
     *  Author: Adam Bethlehem
     * @throws InterruptedException
     */

    //Todo split this up into one test to check if up can open and one test to check if it is highlighted
    @Test
    public void openExistingFlowCheckForHighLitesTest() throws InterruptedException {

        loginPage loginPage = new loginPage();
        controlPage controlPage = loginPage.successfulLogin("adminuser","admin");
        controlPage.openExistingFLow();
        Assert.assertEquals(WebDriverRunner.url(),"http://control.refresh.dev.za01.payd.co/control/flow/dev/CLIENT/42/25,1");
        Assert.assertTrue(controlPage.selectedAttributes().contains("rgba(41, 194, 236,"));

    }


}

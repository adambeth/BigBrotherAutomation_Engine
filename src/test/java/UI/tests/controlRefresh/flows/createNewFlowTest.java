package UI.tests.controlRefresh.flows;
import UI.pages.controlPage;
import UI.pages.loginPage;
import baseTestUtils.baseTest.testConfig;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;

public class createNewFlowTest extends testConfig {
    /**
     *  .Control redesign:: Flows :: Open existing flow
     *  https://jira.clickatell.com/browse/PPEN-2353
     *  Author: Adam Bethlehem
     *  Test to check
     */


    @Test
    public void simpleCreateFlowTest(){
        loginPage loginPage = new loginPage();
        controlPage controlPage = loginPage.successfulLogin("adminuser","admin");
        controlPage.createNewFlow();
        controlPage.createNewFlowSave("a");


    }

}
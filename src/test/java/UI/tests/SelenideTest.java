package UI.tests;

import UI.pages.controlPage;
import UI.pages.loginPage;
import org.testng.annotations.Test;

public class SelenideTest extends loginPage {

    @Test
    public void test1(){

    loginPage loginPage = new loginPage();
    controlPage controlPage = loginPage.successfulLogin("adminuser","admin");
    controlPage.topBar();
    controlPage.clickEntityDropDown();

    }
}

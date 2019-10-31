package UI.tests.controlRefresh;

import UI.pages.controlPage;
import UI.pages.loginPage;
import org.testng.annotations.Test;

public class loginTest extends controlPage {

    @Test
    public void successfulLogInTest(){

        loginPage loginPage = new loginPage();
        controlPage controlPage = loginPage.successfulLogin("adminuser","admin");
        controlPage.clickConfigurationsDropDown();
        controlPage.topBar();



    }
}

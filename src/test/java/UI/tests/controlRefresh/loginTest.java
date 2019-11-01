package UI.tests.controlRefresh;


import UI.pages.controlPage;
import UI.pages.loginPage;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;

;import java.util.zip.CheckedOutputStream;

public class loginTest extends controlPage {

    @Test
    public void successfulLogInTest(){

        loginPage loginPage = new loginPage();
        controlPage controlPage = loginPage.successfulLogin("adminuser","admin");
        controlPage.clickConfigurationsDropDown();
        controlPage.topBar();



    }
}

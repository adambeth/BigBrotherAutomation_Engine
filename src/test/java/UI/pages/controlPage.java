package UI.pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class controlPage extends loginPage {

    public controlPage() {
    }

    public void topBar() {


        $(By.className("topBar_logo")).shouldBe(Condition.visible);

    }

    public void clickEntityDropDown(){

        $(By.id("mat-select-2")).click();
    }

    public void clickConfigurationsDropDown(){

        $(By.id("mat-expansion-panel-header-0")).click();
    }

    public void clickKeywords(){

        $(By.xpath("//a[@title='keywords']")).click();
    }

    public void clickRouting(){
        $(By.id("routes")).click();
    }
    public void clickAPIIntegration(){

        $(By.id("endpoints")).click();
    }
}

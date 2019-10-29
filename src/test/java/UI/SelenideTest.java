package UI;
import baseTestUtils.baseTest.testConfig;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class SelenideTest extends testConfig
{

    @Test
    public void test1(){


        open("http://www.google.com");
        close();
    }
}

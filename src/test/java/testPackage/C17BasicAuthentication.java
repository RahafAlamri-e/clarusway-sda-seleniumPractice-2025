package testPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

public class C17BasicAuthentication extends TestBase {
//    Go to URL: https://the-internet.herokuapp.com/basic_auth
//    Username: admin
//    Password: admin

//    Syntax:  driver.get("https://url"/);

//    Authenticate using the above method and test data.
//    https://the-internet.herokuapp.com/basic_auth
//    Verify the congratulations message.


    @Test
    void authenticationTest() throws InterruptedException {

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        Thread.sleep(2000);
        Assertions.assertTrue(driver.findElement(By.xpath("//h3[.='Basic Auth']")).isDisplayed());

    }
}

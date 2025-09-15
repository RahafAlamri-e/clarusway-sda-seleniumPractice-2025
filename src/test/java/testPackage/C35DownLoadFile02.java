package testPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class C35DownLoadFile02 extends TestBase {

    String url = "https://opensource-demo.orangehrmlive.com/";
    String name = "Admin";
    String password = "admin123";
    String fileName = "importData.csv";

    By usernameByXpath = By.xpath("//*[@name='username']");
    By passwordByXpath = By.xpath("//*[@name='password']");
    By loginButtonByXpath = By.xpath("//*[@type='submit']");
    By PIMButtonByXpath = By.xpath("(//a[@class='oxd-main-menu-item'])[2]");
    By configurationByClassName = By.className("oxd-topbar-body-nav-tab-item");
    By dataImportByXpath = By.xpath("//a[.='Data Import']");
    By downloadByClassName = By.className("download-link");

    @Test
    void name() throws InterruptedException, IOException {

        //Go to URL: https://opensource-demo.orangehrmlive.com/
        driver.get(url);

        //Login page valid credentials.
        driver.findElement(usernameByXpath).sendKeys(name);
        driver.findElement(passwordByXpath).sendKeys(password);
        driver.findElement(loginButtonByXpath).click();

        //Click PIM on the left sidebar
        driver.findElement(PIMButtonByXpath).click();

        //Click Configuration and select Data Import
        driver.findElement(configurationByClassName).click();
        driver.findElement(dataImportByXpath).click();

        //Download sample CSV file.
        driver.findElement(downloadByClassName).click();

        //Verify if the file downloaded successfully.
        Thread.sleep(3000);
        Path filePath = Path.of(System.getProperty("user.home"),"Downloads",fileName);
        Assertions.assertTrue(Files.exists(filePath));
        Files.deleteIfExists(filePath);


    }
}

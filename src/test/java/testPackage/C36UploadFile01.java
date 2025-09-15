package testPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Path;

public class C36UploadFile01 extends TestBase {

    String url = "https://the-internet.herokuapp.com/upload";
    By uploadButtonById = By.id("file-upload");
    By submitButtonById = By.id("file-submit");
    By uploadMessageByTagName = By.tagName("h3");

    @Test
    void name() throws InterruptedException {
        //Go to URL: https://the-internet.herokuapp.com/upload
        driver.get(url);

        //Find the path of the file that you want to upload.
        Path filePath = Path.of(System.getProperty("user.home"), "Downloads", "Screenshot (1).png");

        //Click on Upload button.
        driver.findElement(uploadButtonById).sendKeys(filePath.toString());
        driver.findElement(submitButtonById).click();

        Thread.sleep(2000);

        //Verify the upload message.
        Assertions.assertTrue(driver.findElement(uploadMessageByTagName).getText().contains("File Uploaded!"));
    }
}

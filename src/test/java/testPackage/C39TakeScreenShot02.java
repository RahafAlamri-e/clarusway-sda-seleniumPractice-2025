package testPackage;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C39TakeScreenShot02 extends TestBase {
    /*
    Go to Linkedin
    Take homepage's screenshot
    Take logo's screenshot
*/

    @Test
    public void screenShotWithTestBaseTest() throws InterruptedException {

        driver.get("https://www.linkedin.com");
        Thread.sleep(1000);

        TakesScreenshot ss = (TakesScreenshot) driver;

        File scrwwnFile = ss.getScreenshotAs(OutputType.FILE);
        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd:HH-mm-ss"));
        String screenShotName = "ScreenShot" + timeStamp + ".png";
        Path screenShotPath = Path.of(System.getProperty("user.dir"), "target", "test-output", "screenshot", screenShotName);

        try {
            FileUtils.copyFile(scrwwnFile, screenShotPath.toFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}

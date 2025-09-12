package testPackage;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C25DragAndDropBy extends TestBase {
    /*
    Go to URL: https://rangeslider.js.org/
    Shift 100 units to the right and 100 units to the left on the horizontal axis.

     */


    By sliderBy = By.xpath("//section[@id=\"top\"]//input[@type='range']");
    By sliderHandleByXpath = By.xpath("//div[@id='js-rangeslider-0']//div[@class='rangeslider__handle']");
    String url = "https://rangeslider.js.org/";

    @Test
    public void dragAndDropByTest() throws InterruptedException {
        // Go to URL
        driver.get(url);

        // Locate slider handle
        WebElement sliderHandle = driver.findElement(sliderHandleByXpath);
        WebElement sliderInput = driver.findElement(sliderBy);

        // Print initial value
        System.out.println("Initial value: " + sliderInput.getAttribute("value"));

        Actions actions = new Actions(driver);

        // Move right 100 px
        actions.dragAndDropBy(sliderHandle, 100, 0).perform();
        Thread.sleep(1000);
        System.out.println("After moving right: " + sliderInput.getAttribute("value"));

        // Back to initial location
        actions.dragAndDropBy(sliderHandle, -100, 0).perform();
        Thread.sleep(1000);
        System.out.println("After Back to initial location: " + sliderInput.getAttribute("value"));

        // Move left 100 px
        actions.dragAndDropBy(sliderHandle, -100, 0).perform();
        Thread.sleep(1000);
        System.out.println("After moving left: " + sliderInput.getAttribute("value"));
    }

}

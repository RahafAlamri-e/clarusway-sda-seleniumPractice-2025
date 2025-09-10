package testPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C18Frames01 extends TestBase {
    /*
    TestBase Class:
    We create this class to avoid repeating the same setup and teardown code
    in every test class. It uses Java’s OOP (Object-Oriented Programming) concept
    of inheritance.

    Key points:

    1-Reusability:
        Any class that extends TestBase automatically gets access to the driver,
        setup(), and teardown() methods.
        Child classes don’t need to write these methods again.

    2-Access Modifier:
        TestBase is usually placed in a separate package.
        To allow child classes to use the driver, it must be declared
        as public or protected.
        We choose "protected" since only child classes need it, not external classes.

    3-Abstract Class:
        We don’t want anyone to create objects of TestBase directly.
        To prevent this, we declare TestBase as abstract.
        Abstract classes can’t be instantiated; they can only be inherited.

    4-Usage:
        We will extend TestBase in our test classes.
        The driver variable and common methods are inherited,
        which keeps our code shorter, cleaner, and easier to maintain.
*/

    @Test
    void name() {
        String url="https://the-internet.herokuapp.com/iframe";
        String expectesText = "Editor";

        By headerByTagName = By.tagName("h3");
        By closeButtonByXpath = By.xpath("//div[@aria-label='Close']");
        By textBoxByXpath = By.xpath("//p[.='Your content goes here.']");
        By elementalTextByXpath = By.xpath("//a[.='Elemental Selenium']");

        //Go to URL: https://the-internet.herokuapp.com/iframe
        driver.get(url);
        driver.findElement(closeButtonByXpath).click();

        //Verify the Bolded text contains “Editor”
        Assertions.assertTrue(driver.findElement(headerByTagName).getText().contains(expectesText));

        //Locate the text box
        //driver.switchTo().frame(0);
        driver.switchTo().frame("mce_0_ifr");
        //driver.switchTo().frame(driver.findElement(By.cssSelector("#mce_0_ifr")));

        WebElement element = driver.findElement(textBoxByXpath);

        //Print the text in the text box
        System.out.println("element.getText() = " + element.getText());

        //Verify the text Elemental Selenium text is displayed on the page.
        driver.switchTo().defaultContent();
        WebElement textElement = driver.findElement(elementalTextByXpath);
        Assertions.assertTrue(textElement.isDisplayed());

    }

}

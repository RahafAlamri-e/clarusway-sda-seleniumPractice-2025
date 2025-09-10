package testPackage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class C09CheckBoxes {

    /*
    Go to https://the-internet.herokuapp.com/checkboxes
    Locate the elements of checkboxes.
    Then click on checkbox 1 if box is not selected.
    Then click on checkbox 2 if box is not selected.
    Then verify that checkbox 1 is checked.
     */

    WebDriver driver;


    @Test
    void checkBoxTest01() {
        String url = "https://the-internet.herokuapp.com/checkboxes";
        driver.get(url);
        By checkBox1XPath = By.xpath("(//input[@type='checkbox'])[1]");
        By checkBox2XPath = By.xpath("(//input[@type='checkbox'])[2]");
        By allCheckBoxes = By.xpath("//input[@type='checkbox']");

        WebElement checkBox1 = driver.findElement(checkBox1XPath);
        WebElement checkBox2 = driver.findElement(checkBox2XPath);


        if (!checkBox1.isSelected()) {
            checkBox1.click();
        }
        if (!checkBox2.isSelected()) {
            checkBox2.click();
        }

        Assertions.assertTrue(checkBox1.isSelected());
        Assertions.assertTrue(checkBox2.isSelected());

        //check if all check boxes are selected
        List<WebElement> checkBoxesList = driver.findElements(allCheckBoxes);
        for (WebElement checkbox : checkBoxesList) {
            if (!checkbox.isSelected()) {
                Assertions.assertTrue(checkbox.isSelected());
            }
            checkBoxesList.forEach(t-> System.out.println(t.isSelected()));

        }
        Assertions.assertTrue(checkBox1.isSelected() && checkBox2.isSelected());

    }




    @Test
    void checkBoxTest02() {

    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();


    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}

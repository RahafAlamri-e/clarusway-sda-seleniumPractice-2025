package testPackage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_CSSSelector {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


    @Test
    void cssSelectorTest() {
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
        driver.findElement(By.cssSelector("#email")).sendKeys("johndoeSDA@yahoo.com");
        driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("John.123");
        List<WebElement> welcomeMessages = driver.findElements(By.cssSelector(".welcome-message"));
        welcomeMessages.forEach(t-> System.out.println(t.getText()));
    }

  /*
    http://the-internet.herokuapp.com/add_remove_elements/
    Click on the "Add Element" button 100 times.
    Write a function that takes a number, and clicks the "Delete" button.
    Given number of times, and then validates that given number of buttons was deleted.
    1. Method: createButtons(100)
    2. Method: DeleteButtonsAndValidate()
     */

    @Test
    void addElementTest(){
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        createButtons(50);
        deleteButtonsAndValidate(40);

    }

    void createButtons(int num){;
        for (int i = 0; i < num; i++) {
            driver.findElement(By.cssSelector("button[onclick='addElement()']")).click();
        }

    }

    void deleteButtonsAndValidate(int num){
        List<WebElement> deletes = driver.findElements(By.cssSelector(".added-manually"));
        int sizeBeforeDelete = deletes.size();
        for (int i = 0; i < num; i++) {
            deletes.get(i).click();
    }

        deletes = driver.findElements(By.cssSelector(".added-manually"));
        int sizeAfterDelete = deletes.size();
        Assertions.assertEquals(sizeBeforeDelete - sizeAfterDelete, num);


    }

}

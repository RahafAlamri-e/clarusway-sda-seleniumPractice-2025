package testPackage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C11Dropdown {

    WebDriver driver;
    String url = "https://demoqa.com/select-menu";
    By oldSelectMenu = By.id("oldSelectMenu");
    By multiSelectDropDown = By.id("cars");


    @Test
    void oldDropDownMenuTest() {
        WebElement dropdownElement = driver.findElement(oldSelectMenu);

        Select select = new Select(dropdownElement);



        // Select 2nd option from dropdown:
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

        // Select option which has value of "red":
        select.selectByValue("red");
        System.out.println(select.getFirstSelectedOption().getText());

        // Select according to visible text:
        select.selectByVisibleText("Purple");
        System.out.println(select.getFirstSelectedOption().getText());

        // Check if the dropdown is multi-select
        System.out.println("select.isMultiple() = " + select.isMultiple());

    }

    @Test
    void multiSelectTest() {
        WebElement multiSelectElement = driver.findElement(multiSelectDropDown);
        Select select = new Select(multiSelectElement);

        // Select 2nd option from dropdown:
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        select.deselectAll();

        // Select option which has value of "volvo"
        select.selectByValue("volvo");
        System.out.println(select.getFirstSelectedOption().getText());


        // Select according to visible text:
        select.selectByVisibleText("Audi");
        List<WebElement> selectedCars = select.getAllSelectedOptions();
        selectedCars.forEach(t-> System.out.println(t.getText()));
        System.out.println(selectedCars.get(0).getText());


        // verify that Opel is one of the selected options
        List<WebElement>options = select.getOptions();
        boolean isOpelThere = false;
        for (WebElement option : options) {
            if (option.getText().equals("Opel")){
                isOpelThere = true;
                break;
            }
        }
        Assertions.assertTrue(isOpelThere);
        Assertions.assertEquals(4,options.size());

    }

    @BeforeEach
    void setUp() {
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

}

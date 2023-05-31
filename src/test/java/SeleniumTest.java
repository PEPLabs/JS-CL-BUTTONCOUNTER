import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set up ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

        // Create a new ChromeDriver instance
        driver = new ChromeDriver();
        File file = new File("ButtonCounter.html");
        // Open the HTML file
        driver.get(file.getAbsolutePath());
    }
    @Test
    public void testIncrementButton() {

        // Find the increment button and click it
        WebElement incrementButton = driver.findElement(By.id("button"));
        incrementButton.click();

        // Find the display element and verify the incremented value
        WebElement displayElement = driver.findElement(By.id("count"));
        assertEquals("1", displayElement.getText());
    }
    @Test
    public void testIncrementButtonMultipleTimes() {

        // Find the increment button and click it
        WebElement incrementButton = driver.findElement(By.id("button"));
        incrementButton.click();
        incrementButton.click();
        incrementButton.click();
        incrementButton.click();
        incrementButton.click();
        incrementButton.click();
        

        // Find the display element and verify the incremented value
        WebElement displayElement = driver.findElement(By.id("count"));
        assertEquals("6", displayElement.getText());

    }



    @After
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
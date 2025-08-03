import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class CheckboxTest {
    @Test
    public void test2() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox = driver.findElement(By.cssSelector("[type=checkbox]"));
        boolean startState = checkbox.isSelected();
        checkbox.click();
        boolean endState = checkbox.isSelected();
        Assert.assertNotEquals(startState, endState);
        driver.quit();

    }
}

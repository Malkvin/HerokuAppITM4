import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

public class InputsTest {
    @Test
    public void test4() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://the-internet.herokuapp.com/inputs");
        driver.findElement(By.tagName("input")).sendKeys("abcd");
        String inputValue = driver.findElement(By.tagName("input")).getAttribute("value");
        Assert.assertEquals(inputValue, "");
        driver.findElement(By.tagName("input")).sendKeys("абвг");
        String inputValue1 = driver.findElement(By.tagName("input")).getAttribute("value");
        Assert.assertEquals(inputValue1, "");
        driver.findElement(By.tagName("input")).sendKeys("10");
        String inputValue2 = driver.findElement(By.tagName("input")).getAttribute("value");
        Assert.assertEquals(inputValue2, "10");
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_UP);
        String inputValue3 = driver.findElement(By.tagName("input")).getAttribute("value");
        Assert.assertEquals(inputValue3, "11");
        driver.findElement(By.tagName("input")).clear();
        driver.findElement(By.tagName("input")).sendKeys("10");
        String inputValue4 = driver.findElement(By.tagName("input")).getAttribute("value");
        Assert.assertEquals(inputValue4, "10");
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_DOWN);
        String inputValue5 = driver.findElement(By.tagName("input")).getAttribute("value");
        Assert.assertEquals(inputValue5, "9");
        driver.quit();
    }
}

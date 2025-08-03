import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import java.time.Duration;

public class FramesTest {
    @Test
    public void checkFrames(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://the-internet.herokuapp.com/frames");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("example")));
        driver.findElement(By.linkText("iFrame")).click();
        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mce_0_ifr")));
        driver.switchTo().frame(iframe);
        WebElement paragraph = driver.findElement(By.xpath("//body[@id='tinymce']/p"));
        String expectedText = "Your content goes here.";
        assertEquals(expectedText, paragraph.getText().trim(),
                "Текст внутри iframe не соответствует ожидаемому");
                driver.switchTo().defaultContent();
        driver.quit();
    }
}

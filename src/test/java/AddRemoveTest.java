import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

public class AddRemoveTest {

    @Test
    public void test1() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        int numberOfDeleteButtons = driver.findElements(By.xpath("//button[text()='Delete']")).size();
        softAssert.assertEquals(numberOfDeleteButtons, 2);
        driver.findElement(By.xpath("//button[text()='Delete']")).click();
        int numberOfDeleteButtons2 = driver.findElements(By.xpath("//button[text()='Delete']")).size();
        softAssert.assertEquals(numberOfDeleteButtons2, 1);
        driver.quit();
        softAssert.assertAll();
    }
}

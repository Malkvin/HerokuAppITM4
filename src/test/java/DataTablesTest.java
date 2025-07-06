import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;
import java.time.Duration;


public class DataTablesTest {

    @Test
    public void test6() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://the-internet.herokuapp.com/tables");
        String firstSell = driver.findElement(By.xpath("//*[@id='table1']/tbody/tr[3]/td[2]")).getText();
        softAssert.assertEquals(firstSell, "Jason");
        String secondSell = driver.findElement(By.xpath("//*[@id='table1']/tbody/tr[4]/td[3]")).getText();
        softAssert.assertEquals(secondSell, "tconway@earthlink.net");
        String thirdSell = driver.findElement(By.xpath("//*[@id='table2']/tbody/tr[2]/td[4]")).getText();
        softAssert.assertEquals(thirdSell, "$51.00");
        driver.quit();
    }
}

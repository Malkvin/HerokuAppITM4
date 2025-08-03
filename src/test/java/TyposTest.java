import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import java.time.Duration;


public class TyposTest {
    @Test
    public void test5() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://the-internet.herokuapp.com/typos");
        String paragraphText = driver.findElement(By.tagName("p")).getText();
        if (paragraphText.equals("Sometimes you'll see a typo, other times you won't.")) {
            System.out.println("Предложение верно");
        } else {
            System.out.println("Предложение содержит ошибку!");
        }
        driver.navigate().refresh();
        String paragraphText2 = driver.findElement(By.tagName("p")).getText();
        if (paragraphText2.equals("Sometimes you'll see a typo, other times you won't.")) {
            System.out.println("Предложение верно");
        } else {
            System.out.println("Предложение содержит ошибку!");
        }
        driver.quit();
    }
}

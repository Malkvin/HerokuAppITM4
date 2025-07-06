import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import java.time.Duration;

public class NotificationTest {
    @Test
    public void test7() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://the-internet.herokuapp.com/notification_message_rendered");
        driver.findElement(By.xpath("//a[@href='/notification_message']")).click();
        String notificationMessage = driver.findElement(By.xpath("//div[@id='flash']")).getText().replace("×", "").replaceAll("[\\n\\r]", "").trim();
        if (notificationMessage.equals("Action successful")) {
            System.out.println("Успешное уведомление");
        } else if (notificationMessage.equals("Action unsuccessful, please try again"))  {
            System.out.println("Уведомление об ошибке!");
        } else {
            System.out.println("Некорректное уведомление");
        }
        driver.quit();
    }

}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import java.io.File;
import java.time.Duration;
import static org.testng.Assert.assertEquals;

public class FileUploadTest {
    @Test
    public void checkFileUpload(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://the-internet.herokuapp.com/upload");
        File file = new File("src/test/resources/testFile.text");
        driver.findElement(By.id("file-upload")).sendKeys(file.getAbsolutePath());
        driver.findElement(By.id("file-submit")).submit();
        assertEquals(driver.findElement(By.id("uploaded-files")).getText(), "testFile.text");
        driver.quit();
}
}

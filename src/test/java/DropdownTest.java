import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DropdownTest {

    @Test
    public void Test3() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select dropdown = new Select(dropdownElement);
        List<WebElement> options = dropdown.getOptions();
        Assert.assertTrue(options.size() > 0, "Опции есть");
        dropdown.selectByIndex(1);
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), options.get(1).getText());
        dropdown.selectByIndex(2);
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), options.get(2).getText());
        driver.quit();
    }
}

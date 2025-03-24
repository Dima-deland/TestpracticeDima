import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;
public class Test001 {

    @Test
    public void goodBadUgly() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.imdb.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(300));

        WebElement textBox = driver.findElement(By.id("suggestion-search"));

        textBox.sendKeys("Clint Eastwood");
        textBox.sendKeys(Keys.RETURN);

        WebElement listItemClint = driver.findElement(By.linkText("Clint Eastwood"));
        listItemClint.click();

        WebElement declinebutton = driver.findElement(By.cssSelector("[data-testid='reject-button']"));
        declinebutton.click();

        new Actions(driver)
                .scrollByAmount(0, 1000).perform();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(300));

        WebElement expandbutton = driver.findElement(By.cssSelector("[data-testid='nm-flmg-all-accordion-expander']"));
        expandbutton.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement movielink = driver.findElement(By.linkText("The Good, the Bad and the Ugly"));
        movielink.click();

        driver.quit();


    }

}

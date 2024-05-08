import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class AutomationProject4 {
    @Test
    public void testCase() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.airbnb.com/");

        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[@data-testid='cypress-headernav-profile']")).click();

        driver.findElement(By.linkText("Log in")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@data-testid='social-auth-button-email']")).click();

        driver.findElement(By.xpath("//input[@data-testid='email-login-email']")).sendKeys("coissennudapre-4310@yopmail.com", Keys.ENTER);

        driver.findElement(By.xpath("//input[@data-testid='email-signup-password']")).sendKeys("Duotech123", Keys.TAB,Keys.TAB, Keys.ENTER);

        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[@aria-label='Secure your account - Airbnb']")).sendKeys(Keys.TAB, Keys.ENTER);


        Thread.sleep(1000);

        String expectedAccount = "1";
        String actualAccount = driver.findElement(By.xpath("//button[@data-testid='cypress-headernav-profile']")).getText();
        Assert.assertEquals(actualAccount, expectedAccount);
//
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//input[@testid='structured-search-input-field-guests-button']")).sendKeys(Keys.ENTER);

        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@placeholder='Search destinations']")).sendKeys("Ibiza, Spain", Keys.ENTER);

        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[@class='_xg3ld4c notranslate']//div[@testid='calendar-day-04/14/2024']")).click();


        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@testid='calendar-day-04/20/2024']")).click();


    }
}

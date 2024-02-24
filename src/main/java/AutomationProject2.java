
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AutomationProject2 {
    @Test
    public void testCase() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://open.spotify.com/");

        driver.findElement(By.xpath("//button[@data-testid='login-button']")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@data-testid='login-username']")).sendKeys(
                "bahudomon.sehujicel@rungel.net", Keys.TAB,
                "duotech123", Keys.TAB, Keys.TAB, Keys.TAB);

        driver.findElement(By.xpath("//button[@data-testid='login-button']")).click();

        String expectedAccount= "A";
        String actualAccount = driver.findElement(By.xpath("//span[@data-testid='username-first-letter']")).getText();
        Assert.assertEquals(actualAccount, expectedAccount);


        driver.findElement(By.xpath("//a[@href='/search']")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//input[@data-testid='search-input']")).sendKeys("Adele Hello", Keys.ENTER);

        driver.findElement(By.xpath("//a[@href='/track/3AuzZHPlohKLpildLyORSM']")).click();

        driver.findElement(By.xpath("//button[@data-testid='control-button-playpause']")).click();

        Thread.sleep(5000);

        String expectedSong = "Hello";
        String expectedName = "Adele";
        String actualSong = driver.findElement(By.xpath("//div[@data-testid='context-item-info-title']")).getText();
        String actualName = driver.findElement(By.xpath("//div[@data-testid='context-item-info-subtitles']")).getText();

        Assert.assertEquals(actualSong, expectedSong);
        Assert.assertTrue(actualSong.contains(expectedSong));
        Assert.assertEquals(actualName, expectedName);
        Assert.assertTrue(actualName.contains(expectedName));


        driver.findElement(By.xpath("//button[@data-testid='control-button-playpause']")).click();


        driver.findElement(By.xpath("//span[@data-testid='username-first-letter']")).click();

        driver.findElement(By.xpath("//span[.='Log out']")).click();

        String expectedLogIn = "Log in";
        String actualLogIn = driver.findElement(By.xpath("//span[.='Log in']")).getText();
        Assert.assertEquals(actualLogIn, expectedLogIn);
        Assert.assertTrue(actualLogIn.contains(expectedLogIn));

        driver.quit();


    }
}


import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AutomationProject1 {
    @Test
    public void testCase() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("http://duotify.us-east-2.elasticbeanstalk.com/register.php");

        Assert.assertTrue(driver.getTitle().contains("Welcome to Duotify!"));

        driver.findElement(By.id("hideLogin")).click();


        Faker faker = new Faker();
        String user = faker.address().firstName();
        String first = faker.address().firstName();
        String last = faker.address().lastName();
        String email = faker.internet().emailAddress();
        String pass = faker.internet().password();
        driver.findElement(By.name("username")).sendKeys(
                user, Keys.TAB,
                first, Keys.TAB,
                last, Keys.TAB,
                email, Keys.TAB,
                email, Keys.TAB,
                pass, Keys.TAB, pass, Keys.ENTER);

        Thread.sleep(1000);

        Assert.assertEquals(driver.getCurrentUrl(), "http://duotify.us-east-2.elasticbeanstalk.com/browse.php?");

        String firstAndLastName = driver.findElement(By.xpath("//span[@id='nameFirstAndLast']"))
                .getText();
        Assert.assertEquals(firstAndLastName, first + " " + last);

        driver.findElement(By.xpath("//span[@id='nameFirstAndLast']"))
                .click();

        driver.findElement(By.xpath("//div[@class='userInfo']"))
                .getText();

        Assert.assertEquals(firstAndLastName, first + " " + last);

        driver.findElement(By.xpath("//button[@id='rafael']"))
                .click();

        Thread.sleep(1000);

        Assert.assertEquals(driver.getCurrentUrl(), "http://duotify.us-east-2.elasticbeanstalk.com/register.php");

        driver.findElement(By.name("loginUsername")).sendKeys(
                user, Keys.TAB,
                pass, Keys.TAB, Keys.ENTER);

        driver.findElement(By.xpath("//h1[@class='pageHeadingBig']"))
                .getText();

        Assert.assertTrue(driver.getPageSource().contains("You Might Also Like"));

        driver.findElement(By.xpath("//span[@id='nameFirstAndLast']"))
                .click();

        driver.findElement(By.xpath("//button[@id='rafael']"))
                .click();

        Thread.sleep(1000);

        Assert.assertEquals(driver.getCurrentUrl(), "http://duotify.us-east-2.elasticbeanstalk.com/register.php");

    }

}

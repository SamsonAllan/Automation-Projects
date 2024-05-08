
import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AutomationProject3 {
    @Test
    public void testCase() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.edmunds.com/");

        driver.findElement(By.linkText("Shop Used")).click();

        Thread.sleep(1000);

        new Actions(driver).doubleClick(driver.findElement(By.xpath("//input[@data-test='zip-input']"))).sendKeys("22031").perform();



        Thread.sleep(1000);

        WebElement checkbox = driver.findElement(By.xpath("//span[@title='Only show local listings']"));
        if(!checkbox.isSelected()){
            checkbox.click();
        }

        Thread.sleep(1000);

        Select makeDropdown = new Select(driver.findElement(By.cssSelector("select[name='make']")));

        Assert.assertEquals(makeDropdown.getFirstSelectedOption().getText(),"Add Make");

        makeDropdown.selectByVisibleText("Tesla");

        Thread.sleep(1000);

        Select makeDropdown2 = new Select(driver.findElement(By.cssSelector("select[name='model']")));

        Assert.assertEquals(makeDropdown2.getFirstSelectedOption().getText(),"Add Model");

        makeDropdown2.selectByVisibleText("Model 3");

        Thread.sleep(1000);


        new Actions(driver).doubleClick(driver.findElement(By.xpath("//input[@id='min-value-input-Year']"))).sendKeys(" 2020").perform();

        new Actions(driver).doubleClick(driver.findElement(By.xpath("//input[@id='max-value-input-Year']"))).sendKeys(" 2023").perform();

        Select makeDropdown3 = new Select(driver.findElement(By.cssSelector("select[name='sort-by']")));

        makeDropdown3.selectByVisibleText("Price: Low to High");

        makeDropdown3.selectByVisibleText("Price: High to Low");

        makeDropdown3.selectByVisibleText("Mileage: Low to High");

        driver.quit();


    }
}

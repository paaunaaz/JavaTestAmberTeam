import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Exercise1 {

    private WebDriver webDriver;

    @BeforeMethod
    public void before(){
        System.setProperty("webdriver.chrome.driver", "/Users/paulinanaze/Desktop/chromedriver");
        webDriver = new ChromeDriver();
        webDriver.navigate().to("https://antycaptcha.amberteam.pl/exercises/exercise1?seed=889afa9a-f2d3-4116-89dd-4628c0c696b0");
    }

    @AfterMethod
    public void after(){
        webDriver.close();
        webDriver.quit();
    }


    @Test
    public void testExercise() throws InterruptedException {
        WebElement element1 = webDriver.findElement(By.cssSelector("body > div > table > tbody > tr:nth-child(2) > td:nth-child(2) > code"));
        Assert.assertEquals(webDriver.findElement(By.cssSelector("body > div > table > tbody > tr:nth-child(2) > td:nth-child(2) > code")).getText(), "B1");
        WebElement buttonB1 = webDriver.findElement(By.id("btnButton1"));
        buttonB1.click();
        Thread.sleep(500);

        WebElement element2 = webDriver.findElement(By.cssSelector("body > div > table > tbody > tr:nth-child(3) > td:nth-child(2) > code"));
        Assert.assertEquals(webDriver.findElement(By.cssSelector("body > div > table > tbody > tr:nth-child(3) > td:nth-child(2) > code")).getText(), "B2");
        webDriver.findElement(By.id("btnButton2")).click();
        Thread.sleep(500);

        WebElement element3 = webDriver.findElement(By.cssSelector("body > div > table > tbody > tr:nth-child(4) > td:nth-child(2) > code"));
        Assert.assertEquals(webDriver.findElement(By.cssSelector("body > div > table > tbody > tr:nth-child(4) > td:nth-child(2) > code")).getText(), "B2");
        webDriver.findElement(By.id("btnButton2")).click();
        Thread.sleep(500);
        Assert.assertEquals(webDriver.findElement(By.className("wrap")).getText(), "b1b2b2");
        Thread.sleep(500);



        webDriver.findElement(By.id("solution")).click();
        Thread.sleep(500);
        Assert.assertEquals(webDriver.findElement(By.className("wrap")).getText(), "OK. Good answer");

        Thread.sleep(1000);


    }

}

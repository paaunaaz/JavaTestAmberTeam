import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class Exercise3 {
    private WebDriver webDriver;

    @BeforeMethod
    public void before(){
        System.setProperty("webdriver.chrome.driver", "/Users/paulinanaze/Desktop/chromedriver");
        webDriver = new ChromeDriver();
        webDriver.navigate().to("https://antycaptcha.amberteam.pl/exercises/exercise3?seed=65e130fd-d3b4-4bf9-848f-48ba17720d08");
    }

    @AfterMethod
    public void after(){
        webDriver.close();
        webDriver.quit();
    }

    @Test
    public void testExercise3() throws InterruptedException {
        WebElement element1 = webDriver.findElement(By.cssSelector("body > div > table > tbody > tr:nth-child(2) > td:nth-child(2) > code"));
        Assert.assertEquals(webDriver.findElement(By.cssSelector("body > div > table > tbody > tr:nth-child(2) > td:nth-child(2) > code")).getText(), "Mango Orange");
        Select drpColor = new Select(webDriver.findElement(By.id("s13")));
        drpColor.selectByVisibleText("Mango Orange");
        Thread.sleep(500);

        Assert.assertEquals(webDriver.findElement(By.className("wrap")).getText(), "s13:v1");
        WebElement solutionChoose = webDriver.findElement(By.id("solution"));
        solutionChoose.click();
        Thread.sleep(500);

        Assert.assertEquals(webDriver.findElement(By.className("wrap")).getText(), "OK. Good answer");
        Thread.sleep(1000);
    }


}

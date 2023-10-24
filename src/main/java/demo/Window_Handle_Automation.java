package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.*;
import java.util.logging.FileHandler;

public class Window_Handle_Automation {
    ChromeDriver driver;

    public Window_Handle_Automation(){
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();
    }

    public void  testCase01() throws InterruptedException {
//        Navigate to URL https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
//        Click on Try it button Using Locator "XPath" //button[text() = 'Try it'] | click()
        String MainWindow = driver.getWindowHandle();
        driver.findElement(By.xpath("//button[text() = 'Try it']")).click();
//        sleep  2 sec
//        Get the URL  getCurrentUrl()
        Thread.sleep(2000);
        System.out.println("Current URL is " + driver.getCurrentUrl());
//        Get the Title, and take the screenshot  getTitle() and TakeScreenshot()
        System.out.println("The Title is " + driver.getTitle());
        ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        Close the current window  driver. close()
        driver.close();
//        Switch to Original Window  driver.switchTo().window()
        driver.switchTo().window(MainWindow);
    }
}
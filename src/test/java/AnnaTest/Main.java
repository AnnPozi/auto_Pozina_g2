package AnnaTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.File;
import java.util.concurrent.TimeUnit;

public class Main {

        public WebDriver webDriver;

        @Test
        public void googleTest() {
            File fileChrome = new File("/Users/apozina/IdeaProjects/auto_Pozina_g2/driver/chromedriver");
            System.setProperty("webdriver.chrome.driver", fileChrome.getAbsolutePath());

            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();

            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            webDriver.get("https://www.pinterest.co.uk/");
            String title = webDriver.getTitle();
            System.out.println(title);
            Assert.assertEquals("Pinterest", title);
           // webDriver.findElement(By.xpath("//*[@id='logo']")).isDisplayed();
           //webDriver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Selenium" + Keys.ENTER);
            //webDriver.findElement(By.linkText("Home")).click();
            webDriver.quit();
        }
    }






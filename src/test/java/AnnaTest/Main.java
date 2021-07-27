package AnnaTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main  {

        public WebDriver webDriver;

        @Test
        public void googleTest() throws IOException {
            File fileChrome = new File("/Users/apozina/IdeaProjects/auto_Pozina_g2/driver/chromedriver");
            System.setProperty("webdriver.chrome.driver", fileChrome.getAbsolutePath());

            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();

            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            webDriver.get("https://www.pinterest.co.uk/");
            String title = webDriver.getTitle();
            System.out.println(title);
            File scrFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("./image.png"));
            Assert.assertEquals("Pinterest", title);

            String a= webDriver.findElement(By.xpath("//*[@id=\"__PWS_ROOT__\"]")).getText();
            System.out.println(a);
            String b= webDriver.findElement(By.xpath("//*[@id=\"__PWS_ROOT__\"]/div[1]/div/div/div/div[1]/div[1]/div[2]/div[1]/div[3]/div/a")).getText();
            String c= webDriver.findElement(By.xpath("//*[@id=\"__PWS_ROOT__\"]")).getTagName();
            System.out.println(" ");
            System.out.println("b=" + b);
            System.out.println("c=" + c);

            webDriver.findElement(By.xpath("//*[@id=\"__PWS_ROOT__\"]/div[1]/div/div/div/div[1]/div[1]/div[2]/div[2]/button")).click();
            webDriver.findElement(By.xpath("//*[@id=\"__PWS_ROOT__\"]/div[1]/div/div/div/div[1]/div[2]/div[2]/div/div/div/div/div/div/div/div[4]/form/div[5]/button")).click();
          String error =  webDriver.findElement(By.xpath("//*[@id=\"email-error\"]")).getText();
          Assert.assertEquals("You missed a bit! Don't forget to add your email address.", error);

          webDriver.quit();
        }
    }






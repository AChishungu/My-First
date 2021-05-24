package co.framawork;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ClickTest {
    @Test
    void repoLinkGoesToCorrectRapo() {
        //arrange is for setting up

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        // this is tell selemium where to get the deiver
        ChromeOptions options = new ChromeOptions().addArguments("start-fullscreen");
        //we set the option of the size of the screen


        WebDriver driver = new ChromeDriver(options);
        //this is how you create a webdrive the you pass in object (options)
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // this is how much time you assign to selenuim to


        String user ="AChishungu";
        driver.get("https://github.com/" + user);


        // action/Act mimick the User's movement

        String repo = "explore-california";
        WebElement repoLink = driver.findElement(By.linkText(repo));

        repoLink.click();

        driver.getCurrentUrl();


        String actaulURL = driver.getCurrentUrl();


        //assert

        Assertions.assertEquals("https://github.com/AChishungu/explore-california" + repo, actaulURL);

        driver.close();

    }

}

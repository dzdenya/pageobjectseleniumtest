import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SignUpTest {
    private WebDriver driver;
    private SignUpPage signUpPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Projects\\testUdemy\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        try {
            driver.manage().window().maximize();
        } catch (Exception e) {
            System.out.println("-------");
        }
        driver.get("http://github.com/join");
        signUpPage = new SignUpPage(driver);
    }

    @Test
    public void signUpWithShortPassTest(){
        SignUpPage sp = signUpPage.typePasswordName("asd");
        String error = sp.getPasswordErroeText();
        Assert.assertEquals("Password is too short (minimum is 7 characters) and needs at least one number", error);
    }

    @Test
    public void signUpWithReservedNameTest(){
        SignUpPage sp = signUpPage.typeUserName("asd");
        String error = sp.getUsernameErrorText();
        Assert.assertEquals("Username is already taken", error);
    }


    @After
    public void tearDown(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}

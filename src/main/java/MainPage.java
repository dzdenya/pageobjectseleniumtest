import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By signInButton = By.xpath("//a[text()='Sign in']");
    private By signUpButton= By.xpath ("//a[text()='Sign up']");
    private By userNameField= By.xpath("//*[@id='user[login]']");
    private By userEmailField= By.xpath("//*[@id='user[email]']");
    private By passwordField= By.xpath("//*[@id='user[password]']");
    private By signUpFormButton= By.xpath("//button[text()='Sign up for GitHub']");

    public LoginPage clickSignIn(){
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }

    public SignUpPage clickSignUpButton(){
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }

    public SignUpPage clickSignUpFormButton(){
        driver.findElement(signUpFormButton).click();
        return new SignUpPage(driver);
    }

    public MainPage typeUserName(String username){
        driver.findElement(userNameField).sendKeys(username);
        return this;
    }

    public MainPage typePasswordName(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public MainPage typeEmailName(String email){
        driver.findElement(userEmailField).sendKeys(email);
        return this;
    }

    public SignUpPage register(String username, String email, String password){
        this.typeUserName(username);
        this.typeEmailName(email);
        this.typePasswordName(password);
        this.clickSignUpFormButton();
        return new SignUpPage(driver);
    }
}

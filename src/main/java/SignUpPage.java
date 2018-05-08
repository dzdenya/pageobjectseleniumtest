import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By heading = By.xpath("//h1[text()='Join GitHub']");
    private By userNameField = By.xpath("//*[@id='user_login']");
    private By userEmailField = By.xpath("//*[@id='user_email']");
    private By passwordField = By.xpath("//input[@id='user_password']");
    private By signUpButton = By.xpath("//*[@id='signup_button']");
    private By mainError = By.xpath("//div[contains(text(), 'There were problems creating your account')]");
    private By userNameError = By.xpath("//input[@id='user_login']/ancestor::dd/following-sibling::dd");
    private By userEmailError = By.xpath("//input[@id='user_email']/ancestor::dd/following-sibling::dd");
    private By passwordError = By.xpath("//input[@id='user_password']/ancestor::dd/following-sibling::dd");

    public SignUpPage typeUserName(String username){
        driver.findElement(userNameField).sendKeys(username);
        return this;
    }

    public SignUpPage typePasswordName(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public SignUpPage typeEmailName(String email){
        driver.findElement(userEmailField).sendKeys(email);
        return this;
    }

    public SignUpPage registerWihtInavalidCreds(String username, String email, String password){
        this.typeUserName(username);
        this.typeEmailName(email);
        this.typePasswordName(password);
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }

    public String getHeadingText() {
        return driver.findElement(heading).getText();
    }

    public String getMainErrorText() {
        return driver.findElement(mainError).getText();
    }

    public String getUsernameErrorText() {
        return driver.findElement(userNameError).getText();
    }

    public String getEmailErrorText() {
        return driver.findElement(userEmailError).getText();
    }

    public String getPasswordErroeText() {
        return driver.findElement(passwordError).getText();
    }



}

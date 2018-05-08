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
    private By passwordField = By.xpath("//*[@id='password']");
    private By signUpButton = By.xpath("//*[@id='signup_button']");
    private By mainError = By.xpath("//div[contains(text(), 'There were problems creating your account')]");
    private By userNameError = By.xpath("//dd[contains(text(), \"Login can't be blank\")]");
    private By userEmailError = By.xpath("//dd[contains(text(), \"Email can't be blank\")]");
    private By passwordError = By.xpath("//dd[text()=\"Password can't be blank and is too short (minimum is 7 characters)\"]");

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

    public String getMainErroeText() {
        return driver.findElement(mainError).getText();
    }

    public String getUsernameErroeText() {
        return driver.findElement(userNameError).getText();
    }

    public String getEmailErroeText() {
        return driver.findElement(userEmailError).getText();
    }

    public String getPasswordErroeText() {
        return driver.findElement(passwordError).getText();
    }



}

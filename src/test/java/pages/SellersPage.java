package pages;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class SellersPage {
    WebDriver driver = Driver.getDriver();
    Faker faker = new Faker();

    public SellersPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='Add seller']")
    public WebElement addSellerButton;

    @FindBy(id = "company_name_input_text")
    public WebElement titleInput;

    @FindBy(id = "seller_name_input_text")
    public WebElement sellerFullNameInput;

    @FindBy(id = "email_input_text")
    public WebElement sellerEmailInput;

    @FindBy(id = "phone_number_input_text")
    public WebElement sellerPhoneInput;

    @FindBy(id = "address_input_text")
    public WebElement sellerAddressInput;

    @FindBy(xpath = "//button[text()='Save']")
    public WebElement sellerSaveButton;


    public void addSeller() {
        addSellerButton.click();

        titleInput.sendKeys(faker.name().title());
        sellerFullNameInput.sendKeys(faker.name().fullName());
        sellerEmailInput.sendKeys(faker.internet().emailAddress());
        sellerPhoneInput.sendKeys(faker.phoneNumber().phoneNumber());
        sellerAddressInput.sendKeys(faker.address().streetAddress());

        sellerSaveButton.click();

    }
}

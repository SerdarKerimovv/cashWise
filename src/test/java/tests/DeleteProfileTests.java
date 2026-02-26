package tests;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.DeleteProfilePage;
import pages.LoginPage;
import utils.BaseUI;
import utils.ConfigurationReader;
import utils.Driver;

public class DeleteProfileTests extends BaseUI {
    WebDriver driver = Driver.getDriver();
    LoginPage loginPage = new LoginPage();
    DeleteProfilePage deleteProfilePage = new DeleteProfilePage();

    @Test
    public void deleteProfile() {
        loginPage.login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));

        deleteProfilePage.deleteProfile();

        waitForUrlContains("main");
        Assertions.assertTrue(driver.getCurrentUrl().contains("main"));

    }
}

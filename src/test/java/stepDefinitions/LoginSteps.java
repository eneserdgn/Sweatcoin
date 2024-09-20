package stepDefinitions;

import io.cucumber.java.en.Then;
import pages.LoginPage;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @Then("should see Login Page")
    public void shouldSeeLoginPage() {
        loginPage.signInWithGoogleButton();
    }
}

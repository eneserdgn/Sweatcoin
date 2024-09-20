package stepDefinitions;

import io.cucumber.java.en.*;
import pages.WelcomePage;

public class WelcomeSteps {

    WelcomePage welcomePage = new WelcomePage();

    @Then("should see Logo on Welcome Page")
    public void shouldSeeLogoOnWelcomePage() {
        welcomePage.checkLogo();
    }

    @Then("should see Description {string} on Welcome Page")
    public void shouldSeeDescriptionOnWelcomePage(String desc) {
        welcomePage.checkTextDescription(desc);
    }

    @Then("should see Sign Up with Google Button {string} on Welcome Page")
    public void shouldSeeGoogleButtonOnWelcomePage(String button) {
        welcomePage.checkTextGoogleButton(button);
    }

    @Then("should see Already Have Account {string} on Welcome Page")
    public void shouldSeeAlreadyHaveAccountOnWelcomePage(String haveAccount) {
        welcomePage.checkTextAlreadyHaveAccount(haveAccount);
    }

    @Then("should see Terms of Use and Privacy Policy {string} on Welcome Page")
    public void shouldSeeTermsOfUseAndPrivacyPolicyOnWelcomePage(String termsPrivacy) {
        welcomePage.checkTextTermsAndPrivacy(termsPrivacy);
    }

    @When("click Sign Up with Google Button on Welcome Page")
    public void clickSignUpWithGoogleButtonOnWelcomePage() {
        welcomePage.clickGoogleButton();
    }

    @When("click Login Button on Welcome Page")
    public void clickLoginButtonOnWelcomePage() {
        welcomePage.clickAlreadyHaveAccount();
    }


}

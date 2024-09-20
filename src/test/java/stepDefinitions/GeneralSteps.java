package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.GeneralPage;

public class GeneralSteps {
    GeneralPage generalPage = new GeneralPage();

    @Given("User open app with {string} language and {string} locale")
    public void userOpenAppWithLanguage(String lang,String locale) {
        generalPage.startAppWithLang(lang,locale);
    }

    @Then("should see Google Account Popup")
    public void shouldSeeGoogleAccountPopup() {
        generalPage.checkGoogleAccountPopup();
    }
}

package pages;

import models.WelcomeModel;
import utils.ElementHelper;

public class WelcomePage extends ElementHelper {

    public void checkLogo() {
        check(WelcomeModel.logo);
    }

    public void checkTextDescription(String desc) {
        checkText(WelcomeModel.description, desc);
    }

    public void checkTextGoogleButton(String button) {
        checkAttribute(WelcomeModel.googleButton, "content-desc", button);
    }


    public void clickGoogleButton() {
        click(WelcomeModel.googleButton);
    }

    public void checkTextAlreadyHaveAccount(String haveAccount) {
        checkText(WelcomeModel.alreadyHaveAccount, haveAccount);
    }

    public void clickAlreadyHaveAccount() {
        clickElementRightSide(WelcomeModel.alreadyHaveAccount);
    }

    public void checkTextTermsAndPrivacy(String termsPrivacy) {
        checkTextWithoutWaitText(WelcomeModel.termsAndPrivacy, termsPrivacy);
    }


}

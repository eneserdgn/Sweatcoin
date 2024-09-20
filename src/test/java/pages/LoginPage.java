package pages;

import models.LoginModel;
import utils.ElementHelper;

public class LoginPage extends ElementHelper {

    public void signInWithGoogleButton() {
        check(LoginModel.signInWithGoogleButton);
    }
}

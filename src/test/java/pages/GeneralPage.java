package pages;

import models.GeneralModel;
import utils.DriverFactory;
import utils.ElementHelper;

public class GeneralPage extends ElementHelper {

    public void startAppWithLang(String lang, String locale) {
        DriverFactory.setDriver(lang, locale);
    }

    public void checkGoogleAccountPopup() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        check(GeneralModel.googleAccountPopup);
    }
}

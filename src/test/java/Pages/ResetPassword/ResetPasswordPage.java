package Pages.ResetPassword;

import Utils.WebExe;
import Utils.database;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ResetPasswordPage extends WebExe implements database {
    //================================================= Button & Icon ==================================================
    @FindBy(css="div.navbar-container img.navbar-brand__image") WebElement flipBrandIcon;
    public void klikFlipBrandIconButton(){
        waitingForPresenceOfElement(flipBrandIcon,6000,100);
        click(flipBrandIcon,4);
    }

    @FindBy(css="div.content div.content__title-container h1") WebElement titleHeader;
    public void klikOnTitlePageLupaPassword(){
        waitingForPresenceOfElement(titleHeader,5000,100);
        click(titleHeader,5);
    }

    //=============================================== Lupa Password Form ===============================================
    @FindBy(css="input[name='email']") WebElement emailInputField;
    public void klikOnInputFieldEmail(){
        waitingForPresenceOfElement(emailInputField,5000,100);
        click(emailInputField,4);
    }

    public void mengisiInputEmailField(String mail){
        waitingForPresenceOfElement(emailInputField,5000,100);
        sendKeys(emailInputField,mail,5);
    }

    @FindBy(css="div.container div.card-body button") WebElement buttonResetPassword;
    public void klikButtonResetPassword(){
        waitingForPresenceOfElement(buttonResetPassword,5000,100);
        click(buttonResetPassword,5);
    }
    //=============================================== ASSERTION FUNCTION ===============================================
    @FindBy(css="div.content div.content__title-container") WebElement titleContainer;
    @FindBy(css="div.content div.content__title-container h4") WebElement subTitleHeader;
    @FindBy(css="div.content div.card") WebElement lupaPasswordForm;
    @FindBy(css="div.content div.card p") WebElement helperText;
    @FindBy(css="div.card-body div.c-form__group>label>b") WebElement labelEmailField;
    @FindBy(css="footer.footer--center") WebElement footerPage;
    @FindBy(css="footer a[href='https://flip.id/site/tutorial']") WebElement hyperlinkTutorial;
    @FindBy(css="footer a[href='/start']") WebElement hyperlinkCaraKerja;
    @FindBy(css="footer a[href='http://flipid.zendesk.com/']") WebElement hyperlinkFAQ;
    public void assertionAllElementsDisplayedFollowingPODescription(){
        waitingForPresenceOfElement(lupaPasswordForm, 6000,100);
        waitingForPresenceOfElement(helperText, 6000,100);
        waitingForPresenceOfElement(labelEmailField, 6000,100);
        waitingForPresenceOfElement(emailInputField, 6000,100);
        waitingForPresenceOfElement(footerPage, 6000,100);

        Assert.assertTrue(titleContainer.isDisplayed());
        Assert.assertTrue(titleHeader.isDisplayed());
        Assert.assertTrue(subTitleHeader.isDisplayed());
        Assert.assertTrue(flipBrandIcon.isDisplayed());
        Assert.assertTrue(lupaPasswordForm.isDisplayed());
        Assert.assertTrue(helperText.isDisplayed());
        Assert.assertTrue(emailInputField.isDisplayed());
        Assert.assertTrue(buttonResetPassword.isDisplayed());
        Assert.assertTrue(footerPage.isDisplayed());
        Assert.assertTrue(hyperlinkTutorial.isDisplayed());
        Assert.assertTrue(hyperlinkCaraKerja.isDisplayed());
        Assert.assertTrue(hyperlinkFAQ.isDisplayed());

        Assert.assertTrue(getText(titleHeader,5).equals("Lupa Password?"));
        Assert.assertTrue(getText(subTitleHeader,5).equals("Silakan reset password di sini"));
        Assert.assertTrue(getText(helperText,5).equals("Silakan isi email yang didaftarkan. Link untuk mereset password akan dikirim ke email tersebut."));
        Assert.assertTrue(getText(labelEmailField,5).equals("EMAIL"));
        Assert.assertTrue(getText(buttonResetPassword,5).equals("RESET PASSWORD"));
    }

    public void userMendapatkanInvalidEmailFieldNotification(String notif){
        waitingForPresenceOfElement(feedbackInvalidMail,4000,100);
        Assert.assertTrue(feedbackInvalidMail.isDisplayed());
        Assert.assertTrue(getText(feedbackInvalidMail,5).equals(notif));
    }

    @FindBy(css="div.card-body div.c-form__group div") WebElement feedbackInvalidMail;
    public void usermendapatkanBorderColorPadaInputFieldEmailBerwarnaMerah(){
        Assert.assertTrue(((String) ((JavascriptExecutor) getDriver())
                        .executeScript("return getComputedStyle(arguments[0]).borderColor",emailInputField))
                        .equals("rgb(220, 53, 69)")
        );
    }

    @FindBy(css="div.container div.card-body button[disabled]") WebElement buttonResetPasswordDisable;
    public void assertionButtonDaftarMenjadiDisabled(){
        waitingForPresenceOfElement(buttonResetPasswordDisable,5000,100);
        Assert.assertTrue(buttonResetPasswordDisable.isDisplayed());
    }

    public void assertionUserTetapBeradaDiHalamanURL(String url){
        int i = 0;
        while (i<10 && !getDriver().getCurrentUrl().equals(url)){
            try{Thread.sleep(600);} catch (InterruptedException e){}
            i++;
        }

        Assert.assertTrue(getDriver().getCurrentUrl().equals(url));
    }
}

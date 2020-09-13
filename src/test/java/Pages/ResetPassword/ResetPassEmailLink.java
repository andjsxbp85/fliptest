package Pages.ResetPassword;

import Utils.WebExe;
import Utils.database;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class ResetPassEmailLink extends WebExe implements database {
    //Link on email for reset password
    @FindBy(css="div.content-container") WebElement formBigResPass;
    @FindBy(css="div.content-container h1") WebElement titlePageResetPass;
    @FindBy(css="div.content-container div.card-body") WebElement formResPass;
    @FindBy(css="div.content-container div.card-body>p") WebElement helperText;
    @FindBy(css="div.content-container div.card-body>div:nth-of-type(1) label>b") WebElement labelPassField;
    @FindBy(css="div.content-container div.card-body input[name='password']") WebElement fieldInputPass;
    @FindBy(css="div.content-container div.card-body>div:nth-of-type(2) label>b") WebElement labelKonfirmasiPassField;
    @FindBy(css="div.content-container div.card-body input[name='password_confirmation']") WebElement fieldInputPassComfirmatiom;
    @FindBy(css="div.content-container div.card-body button") WebElement buttonSimpan;
    public void assertionLamanRedirectResetPassWothTokenShowAllElementFollowingPODesc(){
        waitingForPresenceOfElement(formBigResPass,6000,100);
        waitingForPresenceOfElement(titlePageResetPass,6000,100);
        waitingForPresenceOfElement(formResPass,6000,100);
        waitingForPresenceOfElement(helperText,6000,100);
        waitingForPresenceOfElement(labelPassField,6000,100);
        waitingForPresenceOfElement(fieldInputPass,6000,100);
        waitingForPresenceOfElement(labelKonfirmasiPassField,6000,100);
        waitingForPresenceOfElement(fieldInputPassComfirmatiom,6000,100);
        waitingForPresenceOfElement(buttonSimpan,6000,100);

        Assert.assertTrue(formBigResPass.isDisplayed());
        Assert.assertTrue(titlePageResetPass.isDisplayed());
        Assert.assertTrue(formResPass.isDisplayed());
        Assert.assertTrue(helperText.isDisplayed());
        Assert.assertTrue(labelPassField.isDisplayed());
        Assert.assertTrue(fieldInputPass.isDisplayed());
        Assert.assertTrue(labelKonfirmasiPassField.isDisplayed());
        Assert.assertTrue(fieldInputPassComfirmatiom.isDisplayed());
        Assert.assertTrue(buttonSimpan.isDisplayed());

        Assert.assertTrue(getText(titlePageResetPass,5).equals("Reset Password"));
        Assert.assertTrue(getText(helperText,5).equals("Silakan masukkan password baru:"));
        Assert.assertTrue(getText(labelPassField,5).equals("PASSWORD"));
        Assert.assertTrue(getText(labelKonfirmasiPassField,5).equals("KONFIRMASI PASSWORD"));
        Assert.assertTrue(getText(buttonSimpan,5).equals("SIMPAN"));
    }
}

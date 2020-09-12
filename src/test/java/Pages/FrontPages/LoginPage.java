package Pages.FrontPages;

import Utils.WebExe;
import Utils.database;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class LoginPage extends WebExe implements database {
    //================================================= Button & Icon ==================================================
    @FindBy(css="div.navbar-container img.navbar-brand__image") WebElement flipBrandIcon;
    public void klikFlipBrandIconButton(){
        waitingForPresenceOfElement(flipBrandIcon,6000,100);
        click(flipBrandIcon,4);
    }

    @FindBy(css="div.navbar-container div.navbar-nav a[href='/signup']") WebElement buttonDaftar;
    public void klikButtonDaftarDiPojokKananAtasHalaman(){
        waitingForPresenceOfElement(buttonDaftar,6000,100);
        click(buttonDaftar,4);
    }

    @FindBy(css="iframe#fc_widget") WebElement hotlineChatIcon;

    //=================================================== Login Form ===================================================
    @FindBy(css="input[name='email']") WebElement inputFieldEmail;
    public void mengisiInputFieldEmail(String mail){
        waitingForPresenceOfElement(inputFieldEmail,3000,100);
        clear(inputFieldEmail, 5);
        sendKeys(inputFieldEmail, mail, 5);
    }

    @FindBy(css="input[name='password']") WebElement inputFieldPassword;
    public void mengisiInputFieldPassword(String pass){
        waitingForPresenceOfElement(inputFieldPassword,3000,100);
        clear(inputFieldPassword, 5);
        sendKeys(inputFieldPassword, pass, 5);
    }

    @FindBy(css="button.btn-primary") WebElement buttonMasuk;
    public void mengklikButtonMasuk(){
        waitingForPresenceOfElement(inputFieldEmail,3000,100);
        click(buttonMasuk, 5);
    }

    //==================================================== HyperLink ===================================================
    @FindBy(css="a[href='/lupa-password']") WebElement hyperlinkLupaPassword;
    public void klikHyperLinkLupaPassword(){
        waitingForPresenceOfElement(hyperlinkLupaPassword,4000,100);
        click(hyperlinkLupaPassword,5);
    }

    @FindBy(css="div.login-content a[href='/signup']") WebElement hyperlinkDiSiniSignUp;
    public void klikHyperLinkdisiniSignUp(){
        waitingForPresenceOfElement(hyperlinkDiSiniSignUp,4000,100);
        click(hyperlinkDiSiniSignUp,5);
    }

    @FindBy(css="a[href='https://flip.id/site/tutorial']") WebElement hyperlinkTutorial;
    public void klikHyperLinkTutorialFooter(){
        waitingForPresenceOfElement(hyperlinkTutorial,4000,100);
        click(hyperlinkTutorial,5);
    }

    @FindBy(css="a[href='/start']") WebElement hyperlinkCaraKerja;
    public void klikHyperLinkCaraKerjaFooter(){
        waitingForPresenceOfElement(hyperlinkCaraKerja,4000,100);
        click(hyperlinkCaraKerja,5);
    }

    @FindBy(css="a[href='http://flipid.zendesk.com/']") WebElement hyperlinkFAQ;
    public void klikHyperLinkFAQFooter(){
        waitingForPresenceOfElement(hyperlinkFAQ,4000,100);
        click(hyperlinkFAQ,5);
    }

    //=============================================== ASSERTION FUNCTION ===============================================
    public void assertionUserBeradaDiHalamanURL(String url){
        int i = 0;
        while (i<10 && !getDriver().getCurrentUrl().equals(url)){
            try{Thread.sleep(600);} catch (InterruptedException e){}
            i++;
        }

        Assert.assertTrue(getDriver().getCurrentUrl().equals(url));
    }

    @FindBy(css="div.content div.content__title-container") WebElement titleContainer;
    @FindBy(css="div.content div.content__title-container h1") WebElement titleHeader;
    @FindBy(css="div.content div.content__title-container h4") WebElement subTitleHeader;
    @FindBy(css="div.content-container div.login.container") WebElement loginForm;
    @FindBy(css="span#email i.fa-envelope") WebElement iconMail;
    @FindBy(css="span#password i.fa-lock") WebElement iconPass;
    @FindBy(css="div.login-content  p.text-center") WebElement textBelowButtonMasuk;
    @FindBy(css="footer.footer--center") WebElement footerPage;
    public void seluruhElemenPadaHalamanLoginPagesDitampilkan(){
        //Waiting until all element ready, so when assertion funct executed, it run as well as we decided
        waitingForPresenceOfElement(flipBrandIcon,5000,100);
        waitingForPresenceOfElement(buttonDaftar,4000,100);
        waitingForPresenceOfElement(titleContainer,3000,100);
        waitingForPresenceOfElement(loginForm,500,100);
        waitingForPresenceOfElement(footerPage,500,100);
        waitingForPresenceOfElement(hotlineChatIcon,5000,100); //Sering telat muncul

        //Assertion All Element Shown
        Assert.assertTrue(flipBrandIcon.isDisplayed());
        Assert.assertTrue(buttonDaftar.isDisplayed());
        Assert.assertTrue(titleContainer.isDisplayed());
        Assert.assertTrue(titleHeader.isDisplayed());
        Assert.assertTrue(subTitleHeader.isDisplayed());
        Assert.assertTrue(loginForm.isDisplayed());
        Assert.assertTrue(iconMail.isDisplayed());
        Assert.assertTrue(inputFieldEmail.isDisplayed());
        Assert.assertTrue(iconPass.isDisplayed());
        Assert.assertTrue(inputFieldPassword.isDisplayed());
        Assert.assertTrue(buttonMasuk.isDisplayed());
        Assert.assertTrue(textBelowButtonMasuk.isDisplayed());
        Assert.assertTrue(hyperlinkLupaPassword.isDisplayed());
        Assert.assertTrue(hyperlinkDiSiniSignUp.isDisplayed());
        Assert.assertTrue(hyperlinkTutorial.isDisplayed());
        Assert.assertTrue(hyperlinkCaraKerja.isDisplayed());
        Assert.assertTrue(hyperlinkFAQ.isDisplayed());
        Assert.assertTrue(hotlineChatIcon.isDisplayed());

        //Assertion Displayed Text
        Assert.assertTrue(getText(buttonDaftar,5).equals("Daftar"));
        Assert.assertTrue(getText(titleHeader,5).equals("Hai!"));
        Assert.assertTrue(getText(subTitleHeader,5).equals("Silakan masuk dengan email dan password akun Flip atau Big Flip yang biasa digunakan"));
        Assert.assertTrue(getText(hyperlinkLupaPassword,5).equals("Lupa password?"));
        Assert.assertTrue(getText(hyperlinkDiSiniSignUp,5).equals("di sini"));
        Assert.assertTrue(getText(textBelowButtonMasuk,5).equals("Lupa password? atau\nBelum memiliki akun Flip? Daftar di sini."));
        Assert.assertTrue(getText(hyperlinkTutorial,5).equals("Tutorial"));
        Assert.assertTrue(getText(hyperlinkCaraKerja,5).equals("Cara Kerja"));
        Assert.assertTrue(getText(hyperlinkFAQ,5).equals("FAQ"));
    }

    @FindBy(css="input[name='email'].form-control.is-invalid") WebElement ivalidFieldEmail;
    @FindBy(css="//input[@name='email'][@class='form-control is-invalid']/parent::*/div[contains(@class,'invalid-feedback')]") WebElement notifInvalidMail;
    public void assertionEmailInputFieldBorderBerwarnaMerahDenganNotifikasi(String notif){
        waitingForPresenceOfElement(ivalidFieldEmail,600,100);
        Assert.assertTrue(ivalidFieldEmail.isDisplayed());
        String rgbBorderColor = (String) ((JavascriptExecutor) getDriver()).executeScript("return getComputedStyle(arguments[0]).borderColor",ivalidFieldEmail);
        Assert.assertTrue(rgbBorderColor.equals("rgb(220, 53, 69)"));
        Assert.assertTrue(notifInvalidMail.isDisplayed());
        Assert.assertTrue(getText(notifInvalidMail,5).equals(notif));
    }

    @FindBy(css="input[name='password'].is-invalid") WebElement invalidFieldPassword;
    @FindBy(css="//input[@name='password'][@class='form-control is-invalid']/parent::*/div[contains(@class,'invalid-feedback')]") WebElement notifInvalidPass;
    public void assertionPasswordInputFieldBorderBerwarnaMerahDenganNotifikasi(String notif){
        waitingForPresenceOfElement(invalidFieldPassword,600,100);
        Assert.assertTrue(invalidFieldPassword.isDisplayed());
        String rgbBorderColor = (String) ((JavascriptExecutor) getDriver()).executeScript("return getComputedStyle(arguments[0]).borderColor",invalidFieldPassword);
        Assert.assertTrue(rgbBorderColor.equals("rgb(220, 53, 69)"));
        Assert.assertTrue(notifInvalidPass.isDisplayed());
        Assert.assertTrue(getText(notifInvalidPass,5).equals(notif));
    }

    @FindBy(css="div.alert.alert-danger") WebElement warnMsg;
    public void assertionWarnMessageGagalLoginDitampilkan(String msg){
        waitingForPresenceOfElement(warnMsg,4000,100);
        Assert.assertTrue(warnMsg.isDisplayed());
        System.out.println("msg ="+msg);
        System.out.println("getText(warnMsg,5) ="+getText(warnMsg,5));
        Assert.assertTrue(getText(warnMsg,5).equals(msg));
    }

    public void assertionWarnMessageGagalLoginDitampilkanRegex(String regex){
        waitingForPresenceOfElement(warnMsg,4000,100);
        Assert.assertTrue(warnMsg.isDisplayed());
        System.out.println("msg ="+regex);
        System.out.println("getText(warnMsg,5) ="+getText(warnMsg,5));
        String regout = getText(warnMsg,5).replaceAll(regex,"");
        System.out.println("hasil regex ="+regout);
        Assert.assertTrue(regout.equals(""));
    }
}

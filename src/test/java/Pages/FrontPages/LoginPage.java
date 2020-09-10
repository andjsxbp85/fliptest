package Pages.FrontPages;

import Utils.WebExe;
import Utils.database;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class LoginPage extends WebExe implements database {
    @FindBy(css="div.navbar-container img.navbar-brand__image") WebElement flipBrandIcon;
    public void klikFlipBranIconButton(){
        waitingForPresenceOfElement(flipBrandIcon,6000,100);
        click(flipBrandIcon,4);
    }

    @FindBy(css="div.navbar-container div.navbar-nav a[href='/signup']") WebElement buttonDaftar;
    public void klikButtonDaftarDiPojokKananAtasHalaman(){
        waitingForPresenceOfElement(buttonDaftar,6000,100);
        click(buttonDaftar,4);
    }

    //=============================================== ASSERTION FUNCTION ===============================================
    public void assertionUserBeradaDiHalamanLoginFlipID(){
        int i = 0;
        while (i<10 && !getDriver().getCurrentUrl().equals(_loginURL)){
            try{Thread.sleep(600);} catch (InterruptedException e){}
            i++;
        }

        Assert.assertTrue(getDriver().getCurrentUrl().equals(_loginURL));
    }

    @FindBy(css="div.content div.content__title-container") WebElement titleContainer;
    @FindBy(css="div.content div.content__title-container h1") WebElement titleHeader;
    @FindBy(css="div.content div.content__title-container h4") WebElement subTitleHeader;
    @FindBy(css="div.content-container div.login.container") WebElement loginForm;
    @FindBy(css="span#email i.fa-envelope") WebElement iconMail;
    @FindBy(css="input[name='email']") WebElement inputFieldEmail;
    @FindBy(css="span#password i.fa-lock") WebElement iconPass;
    @FindBy(css="input[name='password']") WebElement inputFieldPassword;
    @FindBy(css="button.btn-primary") WebElement buttonMasuk;
    @FindBy(css="div.login-content  p.text-center") WebElement textBelowButtonMasuk;
    @FindBy(css="a[href='/lupa-password']") WebElement hyperlinkLupaPassword;
    @FindBy(css="div.login-content a[href='/signup']") WebElement hyperlinkDiSiniSignUp;
    @FindBy(css="footer.footer--center") WebElement footerPage;
    @FindBy(css="a[href='https://flip.id/site/tutorial']") WebElement hyperlinkTutorial;
    @FindBy(css="a[href='/start']") WebElement hyperlinkCaraKerja;
    @FindBy(css="a[href='http://flipid.zendesk.com/']") WebElement hyperlinkFAQ;
    @FindBy(css="iframe#fc_widget") WebElement hotlineChatIcon;
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
}

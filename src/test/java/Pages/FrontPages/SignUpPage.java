package Pages.FrontPages;

import Utils.WebExe;
import Utils.database;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SignUpPage extends WebExe implements database {
    //================================================= Button & Icon ==================================================
    @FindBy(css="div.content div.content__title-container h1") WebElement titleHeader;
    public void klikJudulSelamatDatang(){
        waitingForPresenceOfElement(titleHeader,2000,100);
        click(titleHeader,4);
    }

    @FindBy(css="div.navbar-container img.navbar-brand__image") WebElement flipBrandIcon;
    public void klikFlipBrandIconButton(){
        waitingForPresenceOfElement(flipBrandIcon,6000,100);
        click(flipBrandIcon,4);
    }

    @FindBy(css="div.navbar-nav a[href='/login']") WebElement buttonMasuk;
    public void klikButtonMasukDiPojokKananAtasHalaman(){
        waitingForPresenceOfElement(buttonMasuk,6000,100);
        click(buttonMasuk,4);
    }

    @FindBy(css="iframe#fc_widget") WebElement hotlineChatIcon;
    public void klikFloatingButtonChatBox(){
        waitingForPresenceOfElement(hotlineChatIcon,6000,100);
        click(hotlineChatIcon,4);
    }

    //=================================================== Register Form ===================================================
    @FindBy(css="input[name='nama']") WebElement inputFieldNama;
    public void mengisiInputFieldNama(String nama){
        waitingForPresenceOfElement(inputFieldNama,3000,100);
        clear(inputFieldNama, 5);
        sendKeys(inputFieldNama, nama, 5);
    }

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

    @FindBy(css="span#password-visibility") WebElement buttonLihat;
    public void menekanButtonLihat(){
        waitingForPresenceOfElement(buttonLihat,3000,100);
        click(buttonLihat, 5);
        int i=0;
        while (i<5 && getText(buttonLihat,5).equals("SEMBUNYIKAN")){
            try{Thread.sleep(300);} catch (InterruptedException e){} i++;
        }
        Assert.assertTrue(getText(buttonLihat,5).equals("SEMBUNYIKAN"));
    }

    public void menekanButtonSembunyikan(){
        waitingForPresenceOfElement(buttonLihat,3000,100);
        click(buttonLihat, 5);
        int i=0;
        while (i<5 && getText(buttonLihat,5).equals("LIHAT")){
            try{Thread.sleep(300);} catch (InterruptedException e){} i++;
        }
        Assert.assertTrue(getText(buttonLihat,5).equals("LIHAT"));
    }

    @FindBy(css="div.form-group span#password") WebElement flagNoHp;
    @FindBy(css="div.fade.popup-info.modal.show") WebElement countryCodeShown;
    @FindBy(css="input[name='country']") WebElement searchCountryInputField;
    @FindBy(css="div.modal-body div.list-group") WebElement searchListGroupResult;
    String cssListCountrySearchResult = "div.modal-body div.list-group>button";
    public void memilihKodeNoHPNegaraAsal(String country){
        String xpathCountry = "//div[@class='modal-body']//div[@class='list-group']/button[contains(text(),'"+country+"')]";
        waitingForPresenceOfElement(flagNoHp,3000,100);
        click(flagNoHp,5);
        waitingForPresenceOfElement(countryCodeShown,3000,100);
        sendKeys(searchCountryInputField,country,5);
        WebElement expectedCountry = getDriver().findElement(By.xpath(xpathCountry));
        waitingForPresenceOfElement(expectedCountry,600,100);
        List<WebElement> countries = getDriver().findElements(By.cssSelector(cssListCountrySearchResult));
        for(WebElement cntry:countries){
            if(getText(cntry,5).contains(country)){
                click(cntry,5); break;
            }
        }
    }

    @FindBy(css="input[name='no_hp']") WebElement inputFieldNoHp;
    public void mengisiInputFieldNoHP(String phoneNumber){
        waitingForPresenceOfElement(inputFieldNoHp,3000,100);
        sendKeys(inputFieldNoHp,phoneNumber,5);
    }

    @FindBy(css="button.btn-primary") WebElement buttonDAFTAR;
    @FindBy(css="button.btn-primary>i.fa-spinner") WebElement loadingSpinner;
    public void mengklikButtonDAFTAR(){
        waitingForPresenceOfElement(buttonDAFTAR,3000,100);
        click(buttonDAFTAR, 5);
    }

    //==================================================== HyperLink ===================================================
    @FindBy(css="div.signup-content p a[href='/kebijakan-privasi']") WebElement hyperlinkKebijakan;
    public void klikHyperLinkSyaratDanKetentuanSertaKebijakanPrivasi(){
        waitingForPresenceOfElement(hyperlinkKebijakan,4000,100);
        click(hyperlinkKebijakan,5);
    }

    @FindBy(css="footer a[href='https://flip.id/site/tutorial']") WebElement hyperlinkTutorial;
    public void klikHyperLinkTutorialFooter(){
        waitingForPresenceOfElement(hyperlinkTutorial,4000,100);
        click(hyperlinkTutorial,5);
    }

    @FindBy(css="footer a[href='/start']") WebElement hyperlinkCaraKerja;
    public void klikHyperLinkCaraKerjaFooter(){
        waitingForPresenceOfElement(hyperlinkCaraKerja,4000,100);
        click(hyperlinkCaraKerja,5);
    }

    @FindBy(css="footer a[href='http://flipid.zendesk.com/']") WebElement hyperlinkFAQ;
    public void klikHyperLinkFAQFooter(){
        waitingForPresenceOfElement(hyperlinkFAQ,4000,100);
        click(hyperlinkFAQ,5);
    }

    //=============================================== ASSERTION FUNCTION ===============================================
    public void assertionUserBeradaDiHalamanSignUpFlipID(){
        int i = 0;
        while (i<10 && !getDriver().getCurrentUrl().equals(_registerURL)){
            try{Thread.sleep(600);} catch (InterruptedException e){}
            i++;
        }

        Assert.assertTrue(getDriver().getCurrentUrl().equals(_registerURL));
    }

    @FindBy(css="nav.fixed-top") WebElement topNavBarBox;
    @FindBy(css="div.content div.content__title-container") WebElement titleContainer;
    @FindBy(css="div.content div.content__title-container h4") WebElement subTitleHeader;
    @FindBy(css="div.signup-content>form.signup-form") WebElement signupForm;
    @FindBy(css="div.form-group div.handphone-subtitle>b") WebElement noHpSubTitle;
    @FindBy(css="div.signup-content p") WebElement setujuKebijakan;
    @FindBy(css="footer.footer--center") WebElement footerPage;
    public void seluruhElemenPadaHalamanSignUpDitampilkan(){
        //Waiting until all element ready, so when assertion funct executed, it run as well as we decided
        waitingForPresenceOfElement(flipBrandIcon,5000,100);
        waitingForPresenceOfElement(buttonDAFTAR,4000,100);
        waitingForPresenceOfElement(titleContainer,3000,100);
        waitingForPresenceOfElement(signupForm,500,100);
        waitingForPresenceOfElement(footerPage,500,100);
        waitingForPresenceOfElement(hotlineChatIcon,5000,100); //Sering telat muncul

        //Assertion All Element Shown
        Assert.assertTrue(topNavBarBox.isDisplayed());
        Assert.assertTrue(flipBrandIcon.isDisplayed());
        Assert.assertTrue(buttonMasuk.isDisplayed());
        Assert.assertTrue(titleContainer.isDisplayed());
        Assert.assertTrue(titleHeader.isDisplayed());
        Assert.assertTrue(subTitleHeader.isDisplayed());
        Assert.assertTrue(signupForm.isDisplayed());
        Assert.assertTrue(inputFieldNama.isDisplayed());
        Assert.assertTrue(inputFieldEmail.isDisplayed());
        Assert.assertTrue(inputFieldPassword.isDisplayed());
        Assert.assertTrue(noHpSubTitle.isDisplayed());
        Assert.assertTrue(flagNoHp.isDisplayed());
        Assert.assertTrue(inputFieldNoHp.isDisplayed());
        Assert.assertTrue(buttonDAFTAR.isDisplayed());
        Assert.assertTrue(setujuKebijakan.isDisplayed());
        Assert.assertTrue(hyperlinkKebijakan.isDisplayed());
        Assert.assertTrue(footerPage.isDisplayed());
        Assert.assertTrue(hyperlinkTutorial.isDisplayed());
        Assert.assertTrue(hyperlinkCaraKerja.isDisplayed());
        Assert.assertTrue(hyperlinkFAQ.isDisplayed());
        Assert.assertTrue(hotlineChatIcon.isDisplayed());

        //Assertion Displayed Text
        Assert.assertTrue(getText(buttonMasuk,5).equals("Masuk"));
        Assert.assertTrue(getText(buttonDAFTAR,5).equals("DAFTAR"));
        Assert.assertTrue(getText(titleHeader,5).equals("Selamat Datang!"));
        Assert.assertTrue(getText(subTitleHeader,5).equals("Lengkapi data berikut dan akun flipmu akan terbuat"));
        Assert.assertTrue(getText(hyperlinkKebijakan,5).equals("Syarat & Ketentuan serta Kebijakan Privasi"));
        Assert.assertTrue(getText(hyperlinkTutorial,5).equals("Tutorial"));
        Assert.assertTrue(getText(hyperlinkCaraKerja,5).equals("Cara Kerja"));
        Assert.assertTrue(getText(hyperlinkFAQ,5).equals("FAQ"));

        //Assertion Placeholder of Field
        Assert.assertTrue(getAttribute(inputFieldNama,"placeholder", 5).equals("Nama"));
        Assert.assertTrue(getAttribute(inputFieldEmail,"placeholder", 5).equals("Email"));
        Assert.assertTrue(getAttribute(inputFieldPassword,"placeholder", 5).equals("Password (Minimal 8 karakter)"));
        Assert.assertTrue(getAttribute(inputFieldNoHp,"placeholder", 5).equals("Contoh: 085692481828"));
    }

    String cssRedWarnMessage = "div.invalid-feedback";
    public void assertionSemuaBorderColorPadaRequiredFieldAkanBerwarnaMerah(){
        //Text Warn Message Validation for Each Field Sorted By Html Structure
        List<WebElement> warnMsg = getDriver().findElements(By.cssSelector(cssRedWarnMessage)); int i = 0;
        if(i<5 && warnMsg.size()==0){
            try{Thread.sleep(400);} catch (InterruptedException e){}
            warnMsg = getDriver().findElements(By.cssSelector(cssRedWarnMessage)); i++;
        }

        WebElement args = inputFieldNama;
        for(WebElement warn : warnMsg){
            switch (i){
                case 0: Assert.assertTrue(getText(warn, 5).equals("Nama harus diisi")); args = inputFieldNama; break;
                case 1: Assert.assertTrue(getText(warn, 5).equals("Email harus diisi")); args = inputFieldEmail; break;
                case 2: Assert.assertTrue(getText(warn, 5).equals("Password harus diisi")); args = inputFieldPassword; break;
                case 3: Assert.assertTrue(getText(warn, 5).equals("Nomor handphone harus diisi")); args = inputFieldNoHp; break;
            }

            Assert.assertTrue(
                    ((String) ((JavascriptExecutor) getDriver())
                            .executeScript("return getComputedStyle(arguments[0]).borderColor",args))
                            .equals("rgb(220, 53, 69)")
            );

            i++;
        }
    }

    public void assertionBorderColorBerwarnaMerahDanInputFieldDitampilkanWarnNotificationUntukField(List<Integer> fieldKosong){
        //Getting all red warn notif that appear and collect it
        List<WebElement> warnMsg = getDriver().findElements(By.cssSelector(cssRedWarnMessage)); int i = 0;
        if(i<5 && warnMsg.size()==0){
            try{Thread.sleep(400);} catch (InterruptedException e){}
            warnMsg = getDriver().findElements(By.cssSelector(cssRedWarnMessage)); i++;
        }

        String msg = "";
        for(WebElement warn : warnMsg){
            msg = msg+getText(warn,5)+" ";
        }

        //Apabila desired random field ter
        if(fieldKosong.contains(1)){
            Assert.assertTrue(
                    ((String) ((JavascriptExecutor) getDriver())
                            .executeScript("return getComputedStyle(arguments[0]).borderColor",inputFieldNama))
                            .equals("rgb(220, 53, 69)")
            );
            Assert.assertTrue(msg.contains("Nama harus diisi"));
        }
        if(!fieldKosong.contains(1)){
            Assert.assertTrue(
                    ((String) ((JavascriptExecutor) getDriver())
                            .executeScript("return getComputedStyle(arguments[0]).borderColor",inputFieldNama))
                            .equals("rgb(206, 212, 218)")
            );
            Assert.assertTrue(!msg.contains("Nama harus diisi"));
        }
        if(fieldKosong.contains(2)){
            Assert.assertTrue(
                    ((String) ((JavascriptExecutor) getDriver())
                            .executeScript("return getComputedStyle(arguments[0]).borderColor",inputFieldEmail))
                            .equals("rgb(220, 53, 69)")
            );
            Assert.assertTrue(msg.contains("Email harus diisi"));
        }
        if(!fieldKosong.contains(2)){
            Assert.assertTrue(
                    ((String) ((JavascriptExecutor) getDriver())
                            .executeScript("return getComputedStyle(arguments[0]).borderColor",inputFieldEmail))
                            .equals("rgb(206, 212, 218)")
            );
            Assert.assertTrue(!msg.contains("Email harus diisi"));
        }
        if(fieldKosong.contains(3)){
            Assert.assertTrue(
                    ((String) ((JavascriptExecutor) getDriver())
                            .executeScript("return getComputedStyle(arguments[0]).borderColor",inputFieldPassword))
                            .equals("rgb(220, 53, 69)")
            );
            Assert.assertTrue(msg.contains("Password harus diisi"));
        }
        if(!fieldKosong.contains(3)){
            Assert.assertTrue(
                    ((String) ((JavascriptExecutor) getDriver())
                            .executeScript("return getComputedStyle(arguments[0]).borderColor",inputFieldPassword))
                            .equals("rgb(206, 212, 218)")
            );
            Assert.assertTrue(!msg.contains("Password harus diisi"));
        }
        if(fieldKosong.contains(4)){
            Assert.assertTrue(
                    ((String) ((JavascriptExecutor) getDriver())
                            .executeScript("return getComputedStyle(arguments[0]).borderColor",inputFieldNoHp))
                            .equals("rgb(220, 53, 69)")
            );
            Assert.assertTrue(msg.contains("Nomor handphone harus diisi"));
        }
        if(!fieldKosong.contains(4)){
            Assert.assertTrue(
                    ((String) ((JavascriptExecutor) getDriver())
                            .executeScript("return getComputedStyle(arguments[0]).borderColor",inputFieldNoHp))
                            .equals("rgb(206, 212, 218)")
            );
            Assert.assertTrue(!msg.contains("Nomor handphone harus diisi"));
        }
    }

    String cssAllSignUpInput = "form.signup-form input.form-control";
    public void teradapatWarnNotificationDanBorderColoerRedPadaInvalidFields(int fieldKeYangInvalid, String desiredMsg){
        List<WebElement> warnMsg = getDriver().findElements(By.cssSelector(cssRedWarnMessage)); int i = 0;
        if(i<5 && warnMsg.size()==0){
            try{Thread.sleep(400);} catch (InterruptedException e){}
            warnMsg = getDriver().findElements(By.cssSelector(cssRedWarnMessage)); i++;
        }

        String msg = "";
        for(WebElement warn : warnMsg){
            msg = msg+getText(warn,5)+" ";
        }

        Assert.assertTrue(msg.contains(desiredMsg));


        List<WebElement> fields = getDriver().findElements(By.cssSelector(cssAllSignUpInput));
        Assert.assertTrue(
                ((String) ((JavascriptExecutor) getDriver())
                        .executeScript("return getComputedStyle(arguments[0]).borderColor",fields.get(fieldKeYangInvalid-1))) //karena index mulai dari 0,tapi field mulai dari 1
                        .equals("rgb(220, 53, 69)")
        );
    }

    @FindBy(css="div.alert.alert-danger") WebElement alertDanger;
    public void assertionBoxErroMassageKesalahanPenulisanFieldNamaDitampilkan(String desiredMsg){
        waitingForPresenceOfElement(alertDanger,5000,100);
        Assert.assertTrue(alertDanger.isDisplayed());
        getText(alertDanger,5).equals(desiredMsg);
    }

    public String gettingCurrentNamaInputFieldValue(){
        return element(inputFieldNama).getValue();
    }

    public String gettingCurrentEmailInputFieldValue(){
        System.out.println("element(inputFieldEmail).getValue() ="+element(inputFieldEmail).getValue());
        return element(inputFieldEmail).getValue();
    }

    public void assertionTypeInputFieldPasswordAdalah(String type){
        int i = 0;
        while (i<5 && !getAttribute(inputFieldPassword, "type", 5).equals(type)){
            try {Thread.sleep(200);} catch (InterruptedException e){}
        }
        Assert.assertTrue(getAttribute(inputFieldPassword, "type", 5).equals(type));
    }

    public String gettingPasswordValue(){
        return getAttribute(inputFieldPassword,"value",5);
    }
}

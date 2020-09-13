package Pages.Dashboard;

import Utils.WebExe;
import Utils.database;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class BerandaPages extends WebExe implements database {
    //============================================== Button, Icon, Input ===============================================
    @FindBy(css="div.card-body img[alt='send-money']") WebElement buttonSendMoneyDomestic;
    public void klikButtonSendMoneyDomestic(){
        waitingForPresenceOfElement(buttonSendMoneyDomestic,6000,100);
        click(buttonSendMoneyDomestic,5);
    }

    @FindBy(css="div.modal-content button[class*='button-close']") WebElement buttonTutupModal;
    public void menekanButtonTutupPadaModalDialogSendMoney(){
        waitingForPresenceOfElement(buttonTutupModal,2000,100);
        click(buttonTutupModal,5);
    }

    @FindBy(css="div.modal-content div.send-money-row>div:nth-child(1)>div.send-money-button") WebElement buttonSendMoneyModal;
    public void klikButtonKirimUangTanpaVerifikasiDiMdoalDialogSendMoneyDomestic(){
        waitingForPresenceOfElement(buttonSendMoneyModal,5000,100);
        click(buttonSendMoneyModal,4);
    }

    //=============================================== ASSERTION FUNCTION ===============================================
    @FindBy(css="div.navbar-container img.navbar-brand__image[alt='flip - transfer antar bank gratis']") WebElement iconBrandFlip;
    @FindBy(css="div.navbar-container div.navbar-nav>div:nth-child(3) a.dropdown-toggle") WebElement dropDownNamaUser;
    public void assertionUserBeradaDiHalamanBerandaDenganNamaUser(String nama){
        int i = 0;
        while (i<10 && !getDriver().getCurrentUrl().equals(_berandaURL)){
            try{Thread.sleep(500);} catch (InterruptedException e){}
        }
        waitingForPresenceOfElement(iconBrandFlip,4000,100);
        waitingForPresenceOfElement(dropDownNamaUser,2000,100);

        Assert.assertTrue(getDriver().getCurrentUrl().equals(_berandaURL));
        Assert.assertTrue(iconBrandFlip.isDisplayed());
        Assert.assertTrue(dropDownNamaUser.isDisplayed());
        Assert.assertTrue(getText(dropDownNamaUser,5).equals(nama));
    }

    @FindBy(css="div.modal-content div.send-money-container") WebElement buttonSendMoneyContainer;
    public void assertionDitampilkanModalContentSendMoney(){
        waitingForPresenceOfElement(buttonSendMoneyContainer,5000,100);
        Assert.assertTrue(buttonSendMoneyContainer.isDisplayed());
    }

    @FindBy(css="div.modal-content div.send-money-row>div:nth-child(1)>div.send-money-button") WebElement buttonVerifikasiModal;
    public void assertionTerdapatButtonKirimUangDanVerifikasiAkun(){
        waitingForPresenceOfElement(buttonSendMoneyModal,4000,100);
        waitingForPresenceOfElement(buttonVerifikasiModal,3000,100);

        Assert.assertTrue(buttonSendMoneyModal.isDisplayed());
        Assert.assertTrue(buttonVerifikasiModal.isDisplayed());
    }

    public void terdapatButtonTutupPadaModalDialogContainer(){
        waitingForPresenceOfElement(buttonTutupModal,2000,100);
        Assert.assertTrue(buttonTutupModal.isDisplayed());
    }

    public void AssertionModalDialogSendMoneyTidakDitampilkanLagi(){
        try{Thread.sleep(1000);} catch (InterruptedException e){}
        Assert.assertTrue(!waitingForPresenceOfElement(buttonSendMoneyContainer,200,100));
    }
}

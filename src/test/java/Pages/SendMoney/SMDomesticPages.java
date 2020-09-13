package Pages.SendMoney;

import Utils.WebExe;
import Utils.database;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SMDomesticPages extends WebExe implements database {
    //============================================== Button, Icon, Input ===============================================
    @FindBy(css="select[name='sender_bank']") WebElement selektorBankPengirim;
    @FindBy(css="select[name='beneficiary_bank']") WebElement selektorBankPenerima;
    @FindBy(css="input[name='account_number']") WebElement inputNoRekTujuan;
    @FindBy(css="input[name='amount']") WebElement inputNominalUang;
    public void mengisiSeluruhInputField(String bankPengirim, String bankPenerima, String noRekTujuan, String nominal){
        waitingForPresenceOfElement(selektorBankPengirim,5000,100);
        waitingForPresenceOfElement(selektorBankPenerima,2000,100);
        waitingForPresenceOfElement(inputNoRekTujuan,1000,100);
        waitingForPresenceOfElement(inputNominalUang,500,100);

        Select srcBank = new Select(selektorBankPengirim);
        srcBank.selectByValue(bankPengirim);

        Select destBank = new Select(selektorBankPenerima);
        destBank.selectByValue(bankPenerima);

        sendKeys(inputNoRekTujuan, noRekTujuan, 5);

        sendKeys(inputNominalUang, nominal, 5);
    }

    @FindBy(css="form>button.btn-primary:nth-last-of-type(1)") WebElement butotnOkDataSudahBenar;
    public void klikButtonOkDataSudahBenar(){
        waitingForPresenceOfElement(butotnOkDataSudahBenar,1500,100);
        click(butotnOkDataSudahBenar,4);
    }

    //=============================================== ASSERTION FUNCTION ===============================================
    public void assertionUserBeradaDiHalamanURL(String url){
        int i = 0;
        while (i<10 && !getDriver().getCurrentUrl().equals(url)){
            try{Thread.sleep(500);} catch (InterruptedException e){}
            i++;
        }

        Assert.assertTrue(getDriver().getCurrentUrl().equals(url));
    }

    @FindBy(css="div.modal-body div.content-container") WebElement containerPeringatan;
    @FindBy(css="div.modal-body div.content-container div[class*='button-confirm']") WebElement blokDuaBuahButtonYaTidak;
    @FindBy(css="div.modal-body div.content-container div[class*='button-confirm']>a") WebElement buttonBatal;
    @FindBy(css="div.modal-body div.content-container div[class*='button-confirm']>button") WebElement buttonYakin;
    public void kalauMunculPeringatanYakinMelanjutkanTransaksiDiluarJamOperationalKlikButton(boolean batal0yakin1){
        if( waitingForPresenceOfElement(containerPeringatan,2500,100) && waitingForPresenceOfElement(blokDuaBuahButtonYaTidak,1500,100)) {
            waitingForPresenceOfElement(buttonBatal,1000,100);
            waitingForPresenceOfElement(buttonYakin,1000,100);
            if(batal0yakin1) click(buttonYakin,4);
            else click(buttonBatal,4);
        }
    }

    @FindBy(css="div.content__title-container h1") WebElement judulHalaman;
    @FindBy(css="div.transaction__step") WebElement trxStep;
    public void assertionSeluruhElementDitampilkanBerdasarkanDeskripsiPO(){
        waitingForPresenceOfElement(judulHalaman,1000,100);
        waitingForPresenceOfElement(trxStep,1000,100);
        waitingForPresenceOfElement(selektorBankPengirim,1000,100);
        waitingForPresenceOfElement(selektorBankPenerima,1000,100);
        waitingForPresenceOfElement(inputNoRekTujuan,1000,100);
        waitingForPresenceOfElement(inputNominalUang,1000,100);
        waitingForPresenceOfElement(butotnOkDataSudahBenar,1000,100);

        Assert.assertTrue(judulHalaman.isDisplayed());
        Assert.assertTrue(trxStep.isDisplayed());
        Assert.assertTrue(selektorBankPengirim.isDisplayed());
        Assert.assertTrue(selektorBankPenerima.isDisplayed());
        Assert.assertTrue(inputNoRekTujuan.isDisplayed());
        Assert.assertTrue(inputNominalUang.isDisplayed());
        Assert.assertTrue(butotnOkDataSudahBenar.isDisplayed());
    }

    @FindBy(css="div.modal-body img[alt='limit-image']") WebElement limitTrxLogo;
    @FindBy(css="div.modal-body div.text-center") WebElement textLimitMsg;
    public void assertionUserMendapakanNotifikasiLimitTransaksi(){
        waitingForPresenceOfElement(limitTrxLogo,5000,100);
        waitingForPresenceOfElement(textLimitMsg,3000,100);

        Assert.assertTrue(limitTrxLogo.isDisplayed());
        Assert.assertTrue(textLimitMsg.isDisplayed());

        Assert.assertTrue(getText(textLimitMsg,5).contains("LIMIT TRANSAKSI SUDAH HABIS"));
        Assert.assertTrue(getText(textLimitMsg,5).contains("Untuk melakukan transfer lebih dari Rp500.000 maka kamu perlu melakukan verifikasi akun."));
    }
}

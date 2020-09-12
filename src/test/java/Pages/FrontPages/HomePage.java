package Pages.FrontPages;

import Utils.WebExe;
import Utils.database;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class HomePage extends WebExe implements database {
    @FindBy(css="div.company-logo img[src='/aset_gambar/logo.png']") WebElement iconFlip;
    @FindBy(css="div.navbar-header a[href='https://flipid.zendesk.com']") WebElement buttonBantuan;
    @FindBy(css="div.navbar-header a[href='https://flip.id/karir']") WebElement buttonKarir;
    @FindBy(css="div.navbar-header a[href='/site/biaya']") WebElement buttonBiaya;
    @FindBy(css="a.btn-register-daftar[href*='site/login']") WebElement buttonMasuk;
    public void menekanButtonMasuk(){
        waitingForPresenceOfElement(buttonMasuk,5000,100);
        click(buttonMasuk,5);
    }

    //=============================================== ASSERTION FUNCTION ===============================================
    public void assertionUserOnHomePageFlipID(){
        int i = 0;
        while (i<10 && !getDriver().getCurrentUrl().equals(_mainURL)){
            try{Thread.sleep(600);} catch (InterruptedException e){}
            i++;
        }

        Assert.assertTrue(getDriver().getCurrentUrl().equals(_mainURL));
    }
}

package Pages.Dashboard;

import Utils.WebExe;
import Utils.database;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class BerandaPages extends WebExe implements database {
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
}

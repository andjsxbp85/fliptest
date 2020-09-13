package Pages.Gmail;

import Utils.WebExe;
import Utils.database;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class GmailMainPage extends WebExe implements database {
    public void gotoGmailMainPage(){
        getDriver().get(_gmailURL1);
        int i = 0;
        while (i<10 && !(getDriver().getCurrentUrl().equals(_gmailURL1) || getDriver().getCurrentUrl().contains(_gmailURL2))){
            try {Thread.sleep(400);} catch (InterruptedException e){}
            if(i==9) getDriver().get(_gmailURL1); //last try
            i++;
        }
        Assert.assertTrue(getDriver().getCurrentUrl().equals(_gmailURL1) || getDriver().getCurrentUrl().contains(_gmailURL2));
    }

    @FindBy(css="div.header--desktop div[class$='header__cta']>ul:nth-child(1) a[ga-event-action='sign in']") WebElement buttonLogin;
    public void klikButtonLoginDiTopNavBarPojokKananAtas(){
        waitingForPresenceOfElement(buttonLogin,5000,100);
        if(getAttribute(buttonLogin, "target",5).contains("_blank")){
            click(buttonLogin,5);
            switchToWindowTabBrowser(1);
        }else {System.out.println("NO new tab"); click(buttonLogin,5);}
    }
}

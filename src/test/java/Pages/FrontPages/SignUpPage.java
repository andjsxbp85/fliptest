package Pages.FrontPages;

import Utils.WebExe;
import Utils.database;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class SignUpPage extends WebExe implements database {
    //=============================================== ASSERTION FUNCTION ===============================================
    public void assertionUserBeradaDiHalamanSignUpFlipID(){
        int i = 0;
        while (i<10 && !getDriver().getCurrentUrl().equals(_registerURL)){
            try{Thread.sleep(600);} catch (InterruptedException e){}
            i++;
        }

        Assert.assertTrue(getDriver().getCurrentUrl().equals(_registerURL));
    }
}

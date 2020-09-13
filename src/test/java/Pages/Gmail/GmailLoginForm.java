package Pages.Gmail;

import Utils.WebExe;
import Utils.database;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;

public class GmailLoginForm extends WebExe implements database {
    @FindBy(css="input#identifierId") WebElement inputFieldMail;
    public void mengisiInputFieldEmail(String mail){
        waitingForPresenceOfElement(inputFieldMail,6000,100);
        sendKeys(inputFieldMail,mail,5);
    }

    @FindBy(css="div#identifierNext button") WebElement buttonBerikutnyaEmail;
    public void mengklikButtonBerikutnyaEmail(){
        waitingForPresenceOfElement(buttonBerikutnyaEmail,2000,100);
        click(buttonBerikutnyaEmail,5);
    }

    @FindBy(css="div#password input") WebElement inputFieldPassword;
    public void mengisiInputFieldPassword(String pass){
        waitingForPresenceOfElement(inputFieldPassword,6000,100);
        sendKeys(inputFieldPassword,pass,5);
    }

    @FindBy(css="div#passwordNext button") WebElement buttonBerikutnyaPassword;
    public void mengklikButtonBerikutnyaPassword(){
        waitingForPresenceOfElement(buttonBerikutnyaPassword,2000,100);
        click(buttonBerikutnyaPassword,5);
    }
}

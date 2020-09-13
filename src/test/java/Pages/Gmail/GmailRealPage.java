package Pages.Gmail;

import Utils.WebExe;
import Utils.database;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GmailRealPage extends WebExe implements database {
    @FindBy(css="form[id*='search_form'] input[name='q']") WebElement inputFieldSearch;
    @FindBy(css="div[role='main'] div[jsaction]>div:nth-child(2) table>tbody") WebElement tableListOfResultSearchEmail;
    public void mencariEmailDenganSearchFilter(String filter){
        waitingForPresenceOfElement(inputFieldSearch,8000,100);
        sendKeys(inputFieldSearch, filter+"\n",5);
    }

    //List >> index0 = Nama Pengirim || index1 = subjek email
    //ke dimulai dari 1
    String csslistOfMailSearchResult = "div[role='main'] div[jsaction]>div:nth-child(2) table>tbody>tr";
    String cssNamaPengirim = "div[role='main'] div[jsaction]>div:nth-child(2) table>tbody>tr>td>div:last-child span[email]";
    String cssSubjekEmail = "div[role='main'] div[jsaction]>div:nth-child(2) table>tbody>tr>td>div:last-child span[data-thread-id]";
    public List<String> klikHasilPencarianPadaTableEmailListSearchResultKe(int ke){
        waitingForPresenceOfElement(tableListOfResultSearchEmail,4000,100);

        List<String> dataEmail = new ArrayList<>();
        List<WebElement> names = getDriver().findElements(By.cssSelector(cssNamaPengirim));
        List<WebElement> subjects = getDriver().findElements(By.cssSelector(cssSubjekEmail));
        dataEmail.add(getText(names.get(ke),5));
        dataEmail.add(getText(subjects.get(ke),5));

        List<WebElement> emails = getDriver().findElements(By.cssSelector(csslistOfMailSearchResult));
        click(emails.get(ke-1),5);

        return dataEmail;
    }

    @FindBy(css="div[role='main'] table[role='presentation'] div[role='list']>div:last-child div[data-message-id] p>a")
    WebElement hyperlinkRedirectResetPassWithToken;
    public void klikHyperlinkUntukRedirectKeURLResetPasswordDenganToken(){
        waitingForPresenceOfElement(NamaPengirim,5000,100);
        waitingForPresenceOfElement(emailPengirim,5000,100);
        waitingForPresenceOfElement(buttonExpandedForAllCondition,3000,100);

        if(waitingForPresenceOfElement(buttonExpandContentMailIfHidden, 1000,100)) click(buttonExpandContentMailIfHidden,3);
        waitingForPresenceOfElement(hyperlinkRedirectResetPassWithToken,3000,100);
        click(hyperlinkRedirectResetPassWithToken,4);
    }

    public void menggantiFokusTabBrowserMenujuTabKe(int ke){
        switchToWindowTabBrowser(ke);
    }

    //=============================================== ASSERTION FUNCTION ===============================================
    @FindBy(css="a[title='Gmail'][href='#inbox'] img") WebElement iconBrandGmail;
    @FindBy(css="div[jsaction] div[role='tabpanel']>div:nth-child(3) table>tbody") WebElement tableListOfMainEmail;
    @FindBy(css="header#gb div[data-ogsr-up] img[srcset]") WebElement profileIconPojokKananAtas;
    public void assertionUserAtGmailRealPage(){
        waitingForPresenceOfElement(iconBrandGmail,8000,100);
        waitingForPresenceOfElement(inputFieldSearch,8000,100);
        waitingForPresenceOfElement(tableListOfMainEmail,8000,100);
        waitingForPresenceOfElement(profileIconPojokKananAtas,8000,100);

        Assert.assertTrue(iconBrandGmail.isDisplayed());
        Assert.assertTrue(inputFieldSearch.isDisplayed());
        Assert.assertTrue(tableListOfMainEmail.isDisplayed());
        Assert.assertTrue(profileIconPojokKananAtas.isDisplayed());
    }

    @FindBy(css="div[role='main'] table[role='presentation'] div[role='list']>div:last-child div[data-message-id] h3>span>span:nth-of-type(1)")
    WebElement NamaPengirim;
    @FindBy(css="div[role='main'] table[role='presentation'] div[role='list']>div:last-child div[data-message-id] h3>span>span:nth-of-type(2)")
    WebElement emailPengirim;
    @FindBy(css="div[role='main'] table[role='presentation'] div[role='list']>div:last-child div[data-message-id] div[data-tooltip='Show trimmed content'] img")
    WebElement buttonExpandContentMailIfHidden;
    @FindBy(css="div[role='main'] table[role='presentation'] div[role='list']>div:last-child div[data-message-id] div[data-tooltip='Hide expanded content'] img")
    WebElement buttonExpandContentEmailIfShown;
    @FindBy(css="div[role='main'] table[role='presentation'] div[role='list']>div:last-child div[data-message-id] div[data-tooltip*='content'] img")
    WebElement buttonExpandedForAllCondition;
    String cssContentMail = "div[role='main'] table[role='presentation'] div[role='list']>div:last-child div[data-message-id] p";
    public void assertionEmailPengirimSubjekDanContentEmailSesuaiDenganDeskripsiPO(){
        waitingForPresenceOfElement(NamaPengirim,5000,100);
        waitingForPresenceOfElement(emailPengirim,5000,100);
        waitingForPresenceOfElement(buttonExpandedForAllCondition,3000,100);

        Assert.assertTrue(getText(NamaPengirim,5).contains("Flip"));
        Assert.assertTrue(getText(emailPengirim,5).contains("hello@flip.id"));

        if(waitingForPresenceOfElement(buttonExpandContentMailIfHidden, 1000,100)) click(buttonExpandContentMailIfHidden,3);

        List<WebElement> contents = getDriver().findElements(By.cssSelector(cssContentMail));
        String konten = "";
        for(WebElement content : contents){
            konten = konten+getText(content,5)+"\n";
        }

        String paragraf1 = "Halo Flip Tester,";
        String paragraf2 = "Klik link di bawah ini untuk mereset password:";
        String paragraf3 = "https://flip.id/reset-password?token=";
        Assert.assertTrue(konten.contains(paragraf1));
        Assert.assertTrue(konten.contains(paragraf2));
        Assert.assertTrue(konten.contains(paragraf3));
    }
}

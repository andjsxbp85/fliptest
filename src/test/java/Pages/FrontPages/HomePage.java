package Pages.FrontPages;

import Utils.WebExe;
import Utils.database;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends WebExe implements database {
    public void gotoFlipUrl(String url){
        getDriver().get(url);
        int i = 0;
        while (i<10 && !(getDriver().getCurrentUrl().equals(url) || getDriver().getCurrentUrl().equals(url.substring(0,url.length()-1)))){
            try{Thread.sleep(400);} catch (InterruptedException e){}
            i++;
        }

        //url.length()-1 untuk karakte / di akhir url
        Assert.assertTrue(getDriver().getCurrentUrl().equals(url) || getDriver().getCurrentUrl().equals(url.substring(0,url.length()-1)));
    }

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


    //======================================== SPECIAL CHATBOX >> IN MANY PAGES ========================================
    @FindBy(css="iframe#fc_widget") WebElement hotlineChatIcon;
    public void terdapatWidgetFloatingChatBox(){
        waitingForPresenceOfElement(hotlineChatIcon,6000,100);
        Assert.assertTrue(hotlineChatIcon.isDisplayed());
    }

    public void klikButtonFloatingChatBox(){
        waitingForPresenceOfElement(hotlineChatIcon,6000,100);
        click(hotlineChatIcon,5); int i = 0;

        getDriver().switchTo().frame(getDriver().findElement(By.cssSelector("iframe#fc_widget")));

        while (i<10 && !waitingForPresenceOfElement(buttonClose,1500,100)){
            try{Thread.sleep(250);} catch (InterruptedException e){}
            click(hotlineChatIcon,5);
            i++;
        }

        Assert.assertTrue(buttonClose.isDisplayed());
    }

    @FindBy(css="div.minimize")  WebElement buttonClose;
    public void menekanButtonXUntukFloatingChatBox(){
        //getDriver().switchTo().frame(getDriver().findElement(By.tagName("iframe"))); //karena masih fokus di iframe dari fungsi klikButtonFloatingChatBox();
        waitingForPresenceOfElement(buttonClose,3000,100);
        click(buttonClose,5);
        try{Thread.sleep(1000);}catch (InterruptedException e){}
        Assert.assertTrue(!waitingForPresenceOfElement(buttonClose,1000, 100));
        getDriver().switchTo().defaultContent();
    }

    String cssOfficerName = "div.home-content ul.channel-list li h1.channel-name";
    public void memilihCustomerServiceOfficer(String officerName){
        waitingForPresenceOfElement(channelListChatBox,3000,100);
        List<WebElement> officers = getDriver().findElements(By.cssSelector(cssOfficerName));
        for(WebElement officer : officers){
            if(getText(officer,5).equals(officerName)){ click(officer,5); break;}
        }
    }

    @FindBy(css="div.fc-conversation-view input[placeholder='Your email']") WebElement inputMailChatBpx;
    @FindBy(css="div.fc-conversation-view textarea") WebElement inputFieldChat;
    @FindBy(css="div.fc-conversation-view button.send-message") WebElement buttonSendChatBox;
    public void mengirimkanPesanDiChatBox(String mail, String chat){
        waitingForPresenceOfElement(inputMailChatBpx,1500,100);
        waitingForPresenceOfElement(inputFieldChat,1500,100);
        waitingForPresenceOfElement(buttonSendChatBox,1500,100);

        clear(inputMailChatBpx,4);
        sendKeys(inputMailChatBpx,mail,4);
        sendKeys(inputFieldChat,chat,4);
        click(buttonSendChatBox,4);
    }

    @FindBy(css="div.h-reply  div#app-conversation-editor>p") WebElement inputFieldReply;
    @FindBy(css="a.h-reply-smiley") WebElement buttonIconSmiley;
    @FindBy(css="input[placeholder='Search Emoji']") WebElement searchEmojiInputField;
    @FindBy(css="div#emojis-search div.fc-emoji-picker-emojis__list") WebElement searchEmojiBoxResult;
    String cssEmojiSearchResult = "div#emojis-search div.fc-emoji-picker-emojis__list>button>span";
    public void mengirimkanPesnDiChatBoxMelauiReplyInputFieldDenganEmoji(String chat, String emojiname){
        waitingForPresenceOfElement(inputFieldReply,3000,100);
        waitingForPresenceOfElement(buttonIconSmiley,1000,100);
        click(inputFieldReply,5);
        //sendKeys(inputFieldReply,chat+" ",5); //di komen karena error di webexe, di fieldnya gk ada balikan value sedang di fungsi webexe ada cek value
        //fungsi jaga jaga klo error sendkeys
        int i = 0;
        while (i<5){
            try{inputFieldReply.sendKeys(chat+" "); break;}catch (Exception e){ try{Thread.sleep(600);}catch (Exception e2){} i++;}
        }

        click(buttonIconSmiley,4);
        waitingForPresenceOfElement(searchEmojiInputField,2000,100);

        sendKeys(searchEmojiInputField,emojiname,4);
        waitingForPresenceOfElement(searchEmojiBoxResult,2000,100);
        List<WebElement> emojis = getDriver().findElements(By.cssSelector(cssEmojiSearchResult));
        click(emojis.get(0),5);

        try{Thread.sleep(500);}catch (InterruptedException e){}
        click(inputFieldReply,5);
        //sendKeys(inputFieldReply,"\n",4);
        i = 0;
        while (i<5){
            try{inputFieldReply.sendKeys("\n"); break;}catch (Exception e){ try{Thread.sleep(600);}catch (Exception e2){} i++;}
        }
    }

    public void mengirimkanPesnDiChatBoxMelauiReplyInputField(String chat){
        waitingForPresenceOfElement(inputFieldReply,3000,100);
        waitingForPresenceOfElement(buttonIconSmiley,1000,100);
        click(inputFieldReply,5);

        int i = 0;
        while (i<5){
            try{inputFieldReply.sendKeys(chat); break;}catch (Exception e){ try{Thread.sleep(600);}catch (Exception e2){} i++;}
        }
    }

    //=================================== SPECIAL ASSERTION CHATBOX >> IN MANY PAGES ===================================
    @FindBy(css="div.home-content") WebElement boxDialogChatBox;
    @FindBy(css="div.home-content div.logo>img") WebElement logoFlipChatDiBox;
    @FindBy(css="div.home-content div.list-sub-title") WebElement chatBoxTitle;
    @FindBy(css="div.home-content ul.channel-list") WebElement channelListChatBox;
    @FindBy(css="div.hotline-launcher div.footer-note") WebElement footerNote;
    public void assertionSeluruhElementPadaChatBoxDitampilkanSesuaiDenganDeskripsiPO(){
        waitingForPresenceOfElement(buttonClose,3000,100);
        waitingForPresenceOfElement(boxDialogChatBox,3000,100);
        waitingForPresenceOfElement(logoFlipChatDiBox,3000,100);
        waitingForPresenceOfElement(chatBoxTitle,3000,100);
        waitingForPresenceOfElement(channelListChatBox,3000,100);
        waitingForPresenceOfElement(footerNote,3000,100);

        Assert.assertTrue(buttonClose.isDisplayed());
        Assert.assertTrue(boxDialogChatBox.isDisplayed());
        Assert.assertTrue(logoFlipChatDiBox.isDisplayed());
        Assert.assertTrue(chatBoxTitle.isDisplayed());
        Assert.assertTrue(channelListChatBox.isDisplayed());
        Assert.assertTrue(footerNote.isDisplayed());

        Assert.assertTrue(getText(chatBoxTitle,5).equals("Message Us"));
        Assert.assertTrue(getText(footerNote,5).contains("Powered by"));
        Assert.assertTrue(getText(footerNote,5).contains("Freshworks"));
    }

    @FindBy(css="div.fc-conversation-view h1.channel-title") WebElement csOfficerNameTitle;
    public void assertionCustomerServiceOfficerNameYangTerpilihAdalah(String officerName){
        waitingForPresenceOfElement(csOfficerNameTitle,4000,100);
        Assert.assertTrue(csOfficerNameTitle.isDisplayed());
        Assert.assertTrue(getText(csOfficerNameTitle,5).equals(officerName));
    }

    String cssOurOwnChatAndMail = "div.fc-conversation-view div.h-conv-chat div.odd div.h-chat";
    public void assertionPesanChatDanEmailTerteraDiChatBoxDialog(String mail, String chat){
        try{Thread.sleep(1200);}catch (InterruptedException e){}
        List<WebElement> ourChats = getDriver().findElements(By.cssSelector(cssOurOwnChatAndMail));
        String ourLastChat = getText(ourChats.get(ourChats.size()-1),5);
        Assert.assertTrue(ourLastChat.contains(mail));
        Assert.assertTrue(ourLastChat.contains(chat));
    }

    String cssLastOurChatWithEmoji = "div.fc-conversation-view div.h-conv-chat div.odd div.h-chat div.h-message-text";
    public void assertionPesanChatDanEmojiTerteraDiChatBoxDialog(String chat){
        try{Thread.sleep(1000);}catch (InterruptedException e){}
        List<WebElement> ourChats = getDriver().findElements(By.cssSelector(cssLastOurChatWithEmoji));
        String ourLastChat = getText(ourChats.get(ourChats.size()-1),5);
        Assert.assertTrue(ourLastChat.contains(chat));
        Assert.assertTrue(ourLastChat.contains("\uD83D\uDE3AT"));
    }

    @FindBy(css="div.size-exceed-msg.position-message-over") WebElement warMsgChatBox;
    public void assertionMunculWarningErrorMessageChatBox(String notif){
        waitingForPresenceOfElement(warMsgChatBox,5000,100);
        Assert.assertTrue(warMsgChatBox.isDisplayed());
        System.out.println("warMsgChatBox ="+getText(warMsgChatBox,5));
        Assert.assertTrue(getText(warMsgChatBox,5).equals(notif));
    }
}

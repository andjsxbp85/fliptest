package Pages.RegistrasiUser;

import Utils.WebExe;
import Utils.database;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class VerifikasiNoHpPages extends WebExe implements database {
    //=============================================== BUTTON & ICON ===============================================
    public void klikVerifikasiButtonBy(boolean WA_False_or_SMS_True){
        if(WA_False_or_SMS_True){
            waitingForPresenceOfElement(buttonKirimViaSMS,1000,100);
            click(buttonKirimViaSMS,4);
        }else {
            waitingForPresenceOfElement(buttonKirimViaWhatsapp,1000,100);
            click(buttonKirimViaWhatsapp,4);
        }
    }
    //=============================================== ASSERTION FUNCTION ===============================================
    @FindBy(css="div.navbar-container img.navbar-brand__image") WebElement flipBrandIcon;
    @FindBy(css="div.navbar-container>div.flex-right div.navbar-nav a[href='/catatan-transaksi']") WebElement buttonCatatanTrx;
    @FindBy(css="div.navbar-container>div.flex-right div.navbar-nav div.dropdown a.dropdown-toggle") WebElement userProfileDorpDown;
    @FindBy(css="div.content-container>div:nth-child(1)") WebElement helperTextTitle;
    @FindBy(css="div.content-container>div>b") WebElement helperTextSubtitle;
    @FindBy(css="div.content-container div.card-body>button:nth-child(1)") WebElement buttonKirimViaWhatsapp;
    @FindBy(css="div.content-container div.card-body>button:nth-child(2)") WebElement buttonKirimViaSMS;
    @FindBy(css="div.content-container div.card-body>p") WebElement textNoHpSalah;
    @FindBy(css="div.content-container div.card-body>p>a") WebElement hyperlinkUbahNoHp;
    public void assertionUserAtPhoneNumberVerificationBySMSorWAPage(String countryCode, String phoneNumber){
        waitingForPresenceOfElement(buttonCatatanTrx,10000,100);
        waitingForPresenceOfElement(userProfileDorpDown,6000,100);
        waitingForPresenceOfElement(helperTextTitle,6000,100);
        waitingForPresenceOfElement(helperTextSubtitle,3000,100);
        waitingForPresenceOfElement(buttonKirimViaWhatsapp,2500,100);
        waitingForPresenceOfElement(buttonKirimViaSMS,2500,100);

        Assert.assertTrue(flipBrandIcon.isDisplayed());
        Assert.assertTrue(buttonCatatanTrx.isDisplayed());
        Assert.assertTrue(userProfileDorpDown.isDisplayed());
        Assert.assertTrue(helperTextTitle.isDisplayed());
        Assert.assertTrue(helperTextSubtitle.isDisplayed());
        Assert.assertTrue(buttonKirimViaWhatsapp.isDisplayed());
        Assert.assertTrue(buttonKirimViaSMS.isDisplayed());
        Assert.assertTrue(textNoHpSalah.isDisplayed());
        Assert.assertTrue(hyperlinkUbahNoHp.isDisplayed());

        Assert.assertTrue(getText(helperTextTitle,5).equals("Kode verifikasi akan kami kirim ke nomor berikut"));
        String no_hp_partial_hide = countryCode+phoneNumber.substring(1,5) +"XXXX"+phoneNumber.substring(phoneNumber.length()-3);
        Assert.assertTrue(getText(helperTextSubtitle,5).replaceAll("\\s+","").equals(no_hp_partial_hide));
        Assert.assertTrue(getText(buttonKirimViaWhatsapp,5).equals("Kirim lewat Whatsapp"));
        Assert.assertTrue(getText(buttonKirimViaSMS,5).equals("Kirim lewat SMS"));
        Assert.assertTrue(getText(textNoHpSalah,5).equals("Nomor HP salah? Ubah Nomor HP"));
        Assert.assertTrue(getText(hyperlinkUbahNoHp,5).equals("Ubah Nomor HP"));
        Assert.assertTrue(getAttribute(hyperlinkUbahNoHp, "href",5).equals("/signup/update-phone")
                || getAttribute(hyperlinkUbahNoHp, "href",5).equals("https://flip.id/signup/update-phone"));
    }

    @FindBy(css="div.content div.content__title-container h1") WebElement titleHeader;
    @FindBy(css="div.content div.content__title-container h4") WebElement subTitleHeader;
    @FindBy(css="input[name='otp']") WebElement inputFieldOTP;
    @FindBy(css="button.btn-primary") WebElement buttonVerifikasi;
    @FindBy(css="div.mt-2.verification-links") WebElement textUnderButtonVerifikasi;
    public void assertionUserAtPhoneNumberVerificationPageAkhir(String countryCode, String phoneNumber){
        waitingForPresenceOfElement(buttonCatatanTrx,10000,100);
        waitingForPresenceOfElement(userProfileDorpDown,6000,100);
        waitingForPresenceOfElement(inputFieldOTP,5000,100);
        waitingForPresenceOfElement(buttonVerifikasi,2000,100);
        waitingForPresenceOfElement(textUnderButtonVerifikasi,1000,100);

        Assert.assertTrue(titleHeader.isDisplayed());
        Assert.assertTrue(subTitleHeader.isDisplayed());
        Assert.assertTrue(flipBrandIcon.isDisplayed());
        Assert.assertTrue(buttonCatatanTrx.isDisplayed());
        Assert.assertTrue(userProfileDorpDown.isDisplayed());
        Assert.assertTrue(inputFieldOTP.isDisplayed());
        Assert.assertTrue(buttonVerifikasi.isDisplayed());
        Assert.assertTrue(textUnderButtonVerifikasi.isDisplayed());

        Assert.assertTrue(getText(titleHeader,4).equals("Verifikasi Nomor HP"));
        Assert.assertTrue(getText(subTitleHeader,4).contains("Masukkan kode verifikasi yang kami kirimkan ke"));

        String tempPhone = phoneNumber.substring(1); //jadi kalau +62 0813576720231 gagal >> dicoba ke nomor +62 813576720231
        System.out.println("getText(subTitleHeader,4) ="+getText(subTitleHeader,4));
        System.out.println("countryCode+phoneNumber ="+countryCode+phoneNumber);
        System.out.println("countryCode+tempPhone ="+countryCode+tempPhone);
        Assert.assertTrue(getText(subTitleHeader,4).contains(countryCode+phoneNumber)
                || getText(subTitleHeader,4).contains(countryCode+tempPhone));
    }
}

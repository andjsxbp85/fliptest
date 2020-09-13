package Steps;

import Pages.FrontPages.HomePage;
import Pages.FrontPages.LoginPage;
import Pages.ResetPassword.ResetPassEmailLink;
import Pages.ResetPassword.ResetPasswordPage;
import Pages.Gmail.GmailLoginForm;
import Pages.Gmail.GmailMainPage;
import Pages.Gmail.GmailRealPage;
import Utils.database;
import org.junit.Assert;

import java.util.List;

public class ForgetPasswordStep implements database {
    ResetPasswordPage ResetPasswordPage;
    HomePage HomePage;
    LoginPage LoginPage;
    GmailMainPage GmailMainPage;
    GmailLoginForm GmailLoginForm;
    GmailRealPage GmailRealPage;
    ResetPassEmailLink ResetPassEmailLink;

    //Scenario 1:
    public void user_dialihkan_ke_halaman_Lupa_Password_dengan_seluruh_element_halaman_ditampilkan_mengikuti_deskripsi_PO() {
        ResetPasswordPage.assertionAllElementsDisplayedFollowingPODescription();
    }

    //Scenario 2:
    public void user_berada_di_halaman_Reset_Password_Flip_ID() {
        HomePage.open();
        HomePage.menekanButtonMasuk();
        LoginPage.klikHyperLinkLupaPassword();
    }

    public void mengklik_kursor_di_input_field_email_tanpa_mengisinya_kemudian_melakukan_klik_di_sembarang_posisi() {
        ResetPasswordPage.klikOnInputFieldEmail();
        ResetPasswordPage.klikOnTitlePageLupaPassword();
    }

    public void user_mendapatkan_border_color_pada_field_input_email_berwarna_merah_dengan_notifikasi(String notif) {
        ResetPasswordPage.userMendapatkanInvalidEmailFieldNotification(notif);
        ResetPasswordPage.usermendapatkanBorderColorPadaInputFieldEmailBerwarnaMerah();
    }

    public void button_RESET_PASSWORD_menjadi_disabled() {
        ResetPasswordPage.assertionButtonDaftarMenjadiDisabled();
    }

    //Scenario 3:
    public void user_membiarkan_input_field_email_kosong_dan_langsung_menekan_button_RESET_PASSWORD() {
        ResetPasswordPage.klikButtonResetPassword();
    }

    public void user_tetap_berada_di_halaman_Reset_Passsword() {
        ResetPasswordPage.assertionUserTetapBeradaDiHalamanURL(_resetPassURL);
    }

    public void button_RESET_PASSWORD_berubah_menjadi_disabled() {
        ResetPasswordPage.assertionButtonDaftarMenjadiDisabled();
    }

    //Scenario 4:
    public void mengisi_input_field_email_dengan_format_yang_salah_mail_dan_mengklik_kursor_di_sembarang_posisi(String mail) {
        ResetPasswordPage.mengisiInputEmailField(mail);
    }

    //Scenario 5:
    public void mengisi_input_field_email_dengan_format_yang_salah_mail_dan_tetap_memfokuskan_kursor_di_field_email(String mail) {
        ResetPasswordPage.klikOnInputFieldEmail();
        ResetPasswordPage.mengisiInputEmailField(mail);
        ResetPasswordPage.klikOnInputFieldEmail();
    }

    public void ketka_user_tetap_berusaha_menekan_button_RESET_PASSWORD_user_tetap_di_halaman_yang_sama_tanpa_ada_perubahan() {
        ResetPasswordPage.klikButtonResetPassword();
        ResetPasswordPage.assertionUserTetapBeradaDiHalamanURL(_resetPassURL);
    }

    //Scneario 6:
    public void user_memasukkan_email_mail_yang_ingin_direset_passwordnya_pada_input_field_email(String mail) {
        ResetPasswordPage.mengisiInputEmailField(mail);
        ResetPasswordPage.klikButtonResetPassword();
    }

    public void user_akan_mendapatkan_email_notifikasi_untuk_reset_password_ketika_masuk_ke_akun_manajemen_emailnya_mail(String mail) {
        GmailMainPage.gotoGmailMainPage();
        GmailMainPage.klikButtonLoginDiTopNavBarPojokKananAtas();
        GmailLoginForm.mengisiInputFieldEmail(mail);
        GmailLoginForm.mengklikButtonBerikutnyaEmail();

        String pass = "";
        switch (mail){
            case _mail1: pass = _pass1; break;
            case _mail2: pass = _pass2; break;
            case _mailLoginError: pass = _passLoginError; break;
        }

        GmailLoginForm.mengisiInputFieldPassword(pass);
        GmailLoginForm.mengklikButtonBerikutnyaPassword();
        GmailRealPage.assertionUserAtGmailRealPage();
        GmailRealPage.mencariEmailDenganSearchFilter("Reset password akun Flip");

        List<String> dataMail = GmailRealPage.klikHasilPencarianPadaTableEmailListSearchResultKe(1);
        Assert.assertTrue(dataMail.get(0).equals("Flip"));
        Assert.assertTrue(dataMail.get(1).equals("Reset password akun Flip"));
    }

    //Scenario 7:
    public void user_telah_melakukan_request_untuk_reset_password_akun_flip_pada_email_mail(String mail) {
        user_berada_di_halaman_Reset_Password_Flip_ID();
        user_memasukkan_email_mail_yang_ingin_direset_passwordnya_pada_input_field_email(mail);
    }

    public void user_membuka_email_notifikasi_reset_password_akun_flip_untuk_email_mail(String mail) {
        user_akan_mendapatkan_email_notifikasi_untuk_reset_password_ketika_masuk_ke_akun_manajemen_emailnya_mail(mail);
    }

    public void didapatkan_seluruh_subjek_email_pengirim_dan_content_email_sesuai_dengan_deskripsi_PO() {
        GmailRealPage.assertionEmailPengirimSubjekDanContentEmailSesuaiDenganDeskripsiPO();
    }

    //Scenario 8:
    public void user_menekan_hyperlink_untuk_melkukan_reset_password_di_body_content_email() {
        GmailRealPage.klikHyperlinkUntukRedirectKeURLResetPasswordDenganToken();
        GmailRealPage.menggantiFokusTabBrowserMenujuTabKe(2); //ada 3 tab >> tab 2 ke tab terakhir
    }

    public void user_diarahkan_ke_laman_reset_password_yang_aktif_dan_seluruh_elemen_ditampilkan_sesuai_deskripsi_PO() {
        ResetPassEmailLink.assertionLamanRedirectResetPassWothTokenShowAllElementFollowingPODesc();
    }

    //Scenario 9:
    public void user_mengklik_icon_brand_Flip_ID_di_pojok_kiri_atas_halaman_Reset_Password() {
        ResetPasswordPage.klikFlipBrandIconButton();
    }
}

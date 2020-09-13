package Steps;

import Pages.Dashboard.BerandaPages;
import Pages.FrontPages.HomePage;
import Pages.FrontPages.LoginPage;
import Pages.RegistrasiUser.SignUpPage;
import Utils.database;

public class LoginFlipStep implements database {
    HomePage HomePage;
    LoginPage LoginPage;
    SignUpPage SignUpPage;
    BerandaPages BerandaPages;

    //Scenario 1:
    public void user_membuka_halaman_utama_Flip_ID() {
        HomePage.open();
    }

    public void user_menekan_button_Masuk_di_pojok_kanan_atas_halaman_utama() {
        HomePage.menekanButtonMasuk();
    }

    public void user_diarahkan_ke_halaman_login_Flip() {
        LoginPage.assertionUserBeradaDiHalamanURL(_loginURL);
    }

    public void seluruh_elemen_pada_halaman_login_ditampilkan_dan_sesuai_dengan_deskripsi_Product_Owner() {
        LoginPage.seluruhElemenPadaHalamanLoginPagesDitampilkan();
    }

    //Scenario 2:
    public void user_berada_di_halaman_Login_Flip_ID() {
        HomePage.open();
        HomePage.menekanButtonMasuk();
    }

    public void user_menekan_gambar_icon_Flip_di_pojok_kiri_atas_halaman_login() {
        LoginPage.klikFlipBrandIconButton();
    }

    public void user_akan_di_arahkan_ke_halaman_utama_Flip_ID() {
        HomePage.assertionUserOnHomePageFlipID();
    }


    //Scenario 3:
    public void user_menekan_button_Daftar_di_pojok_kanan_atas_halaman_login() {
        LoginPage.klikButtonDaftarDiPojokKananAtasHalaman();
    }

    public void user_akan_di_arahkan_ke_halaman_Sign_Up(){
        SignUpPage.assertionUserBeradaDiHalamanSignUpFlipID();
    }

    //Scenario 4:
    public void user_menekan_hyperlink_activelink_pada_halaman_login_Flip(String activelink) {
        switch (activelink){
            case "Lupa password?":
                LoginPage.klikHyperLinkLupaPassword();
                break;
            case "di sini":
                LoginPage.klikHyperLinkdisiniSignUp();
                break;
            case "Tutorial":
                LoginPage.klikHyperLinkTutorialFooter();
                break;
            case "Cara Kerja":
                LoginPage.klikHyperLinkCaraKerjaFooter();
                break;
            case "FAQ":
                LoginPage.klikHyperLinkFAQFooter();
                break;
        }
    }

    public void user_akan_diarahkan_ke_halaman_urlpages_dari_hyperlink_tersebut(String urlpages) {
        //LoginPage.switchToWindowTabBrowser(1); //Apabila PO menginginkan hyperlink text dibuka di tab baru
        LoginPage.assertionUserBeradaDiHalamanURL(urlpages); //FAQ open in new tab while the other doesnt
    }

    //Scenario 5:
    public void login_Flip_dengan_email_dan_password_yang_benar_dan_sesuai_logindata(String logindata) {
        switch (logindata){
            case "Flip Tester":
                LoginPage.mengisiInputFieldEmail(_mail1);
                LoginPage.mengisiInputFieldPassword(_pass1);
                break;
            case "Tester Flip":
                LoginPage.mengisiInputFieldEmail(_mail2);
                LoginPage.mengisiInputFieldPassword(_pass2);
                break;
            case "Flip Login Error":
                LoginPage.mengisiInputFieldEmail(_mailLoginError);
                LoginPage.mengisiInputFieldPassword(_passLoginError);
                break;
        }
        LoginPage.mengklikButtonMasuk();
    }

    public void user_akan_diarahkan_ke_halaman_beranda_flip_sebagai_logindata(String logindata) {
        BerandaPages.assertionUserBeradaDiHalamanBerandaDenganNamaUser(logindata);
    }

    //Scenario 6:
    public void user_mencoba_login_dengan_membiarkan_field_email_dan_password_kosong(){
        LoginPage.mengklikButtonMasuk();
    }

    public void user_tetap_berada_di_halaman_Login_Flip_ID(){
        LoginPage.assertionUserBeradaDiHalamanURL(_loginURL);
        LoginPage.seluruhElemenPadaHalamanLoginPagesDitampilkan();
    }

    public void border_line_pada_input_field_email_berwarna_merah_dengan_notifikasi(String notif) {
        LoginPage.assertionEmailInputFieldBorderBerwarnaMerahDenganNotifikasi(notif);
    }

    public void border_line_pada_input_field_password_berwarna_merah_dengan_notifikasi(String notif) {
        LoginPage.assertionPasswordInputFieldBorderBerwarnaMerahDenganNotifikasi(notif);
    }

    //Scenario 7:
    public void login_Flip_dengan_email_mail_dan_password_pass_yang_tidak_cocok(String mail, String pass) {
        LoginPage.mengisiInputFieldEmail(mail);
        if(pass.equals("RANDOM STRING")) pass = "A"+LoginPage.getCurrrentTimeMs()+ (char) LoginPage.randomizerInt(97,122);
        System.out.println("pass ="+pass);
        LoginPage.mengisiInputFieldPassword(pass);
        LoginPage.mengklikButtonMasuk();
    }

    public void box_error_message_gagal_login_karena_email_atau_password_salah_ditampilkan(){
        LoginPage.assertionWarnMessageGagalLoginDitampilkan("Error:\nEmail atau Password salah.");
    }

    //Scenario 8:
    String errMsg = "Error:\\s+Email atau Password salah.|Error:\\s+Kamu telah salah memasukkan password 3 kali\\. Silakan tunggu \\d+ menit untuk mencoba kembali atau reset password untuk membuat password baru\\.";
    String errMsg3Attempts = "Error:\\s+Kamu telah salah memasukkan password 3 kali\\. Silakan tunggu \\d+ menit untuk mencoba kembali atau reset password untuk membuat password baru\\.";
    public void login_Flip_dengan_email_mail_dan_password_pass_salah_lebih_dari_3kali(String mail, String pass, int num) {
        System.out.println("num ="+num);
        for(int i=0;i<num+1;i++){
            LoginPage.mengisiInputFieldEmail(mail);
            if(pass.equals("RANDOM STRING")) pass = "A"+LoginPage.getCurrrentTimeMs()+ (char) LoginPage.randomizerInt(97,122);
            LoginPage.mengisiInputFieldPassword(pass);
            LoginPage.mengklikButtonMasuk();
            LoginPage.assertionWarnMessageGagalLoginDitampilkanRegex(errMsg);
        }
    }

    public void box_error_message_gagal_login_lebih_dari_kali_berwarna_merah_ditampilkan() {
        LoginPage.assertionWarnMessageGagalLoginDitampilkanRegex(errMsg3Attempts);
    }

    //Background Scenario Login
    public void user_berhasil_login_Flip_ID_sebagai_user(String user) {
        HomePage.open();
        HomePage.menekanButtonMasuk();
        switch (user){
            case "Flip Tester":
                LoginPage.mengisiInputFieldEmail(_mail1);
                LoginPage.mengisiInputFieldPassword(_pass1);
                break;
            case "Tester Flip":
                LoginPage.mengisiInputFieldEmail(_mail2);
                LoginPage.mengisiInputFieldPassword(_pass2);
                break;
            case "Flip Login Error":
                LoginPage.mengisiInputFieldEmail(_mailLoginError);
                LoginPage.mengisiInputFieldPassword(_passLoginError);
                break;
        }
        LoginPage.mengklikButtonMasuk();
        LoginPage.assertionUserBeradaDiHalamanURL(_berandaURL);
    }
}

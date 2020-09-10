package Tests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import Steps.LoginFlipStep;

public class LoginFlip {
    @Steps LoginFlipStep LoginFlipStep;

    //Scenario 1:
    @Given("user membuka halaman utama Flip ID")
    public void user_membuka_halaman_utama_Flip_ID() {
        LoginFlipStep.user_membuka_halaman_utama_Flip_ID();
    }

    @When("user menekan button 'Masuk' di pojok kanan atas halaman utama")
    public void user_menekan_button_Masuk_di_pojok_kanan_atas_halaman_utama() {
        LoginFlipStep.user_menekan_button_Masuk_di_pojok_kanan_atas_halaman_utama();
    }

    @Then("user diarahkan ke halaman login Flip")
    public void user_diarahkan_ke_halaman_login_Flip() {
        LoginFlipStep.user_diarahkan_ke_halaman_login_Flip();
    }

    @Then("seluruh elemen pada halaman login ditampilkan dan sesuai dengan deskripsi Product Owner")
    public void seluruh_elemen_pada_halaman_login_ditampilkan_dan_sesuai_dengan_deskripsi_Product_Owner() {
        LoginFlipStep.seluruh_elemen_pada_halaman_login_ditampilkan_dan_sesuai_dengan_deskripsi_Product_Owner();
    }

    //Scenario 2:
    @Given("user berada di halaman login Flip ID")
    public void user_berada_di_halaman_login_Flip_ID() {
        LoginFlipStep.user_berada_di_halaman_login_Flip_ID();
    }

    @When("user menekan gambar icon Flip di pojok kiri atas halaman login")
    public void user_menekan_gambar_icon_Flip_di_pojok_kiri_atas_halaman_login() {
        LoginFlipStep.user_menekan_gambar_icon_Flip_di_pojok_kiri_atas_halaman_login();
    }

    @Then("user akan di arahkan ke halaman utama Flip ID")
    public void user_akan_di_arahkan_ke_halaman_utama_Flip_ID() {
        LoginFlipStep.user_akan_di_arahkan_ke_halaman_utama_Flip_ID();
    }


    //Scenario 3:
    @When("user menekan button 'Daftar' di pojok kanan atas halaman login")
    public void user_menekan_button_Daftar_di_pojok_kanan_atas_halaman_login() {
        LoginFlipStep.user_menekan_button_Daftar_di_pojok_kanan_atas_halaman_login();
    }

    @Then("user akan di arahkan ke halaman Sign Up")
    public void user_akan_di_arahkan_ke_halaman_Sign_Up(){
        LoginFlipStep.user_akan_di_arahkan_ke_halaman_Sign_Up();
    }

    //Scenario 4:
    @Given("user berada di halaman 'Login' Flip ID")
    public void user_berada_di_halaman_Login_Flip_ID() {
        LoginFlipStep.user_berada_di_halaman_Login_Flip_ID();
    }

    @When("user menekan hyperlink ([^\"]*) pada halaman login Flip")
    public void user_menekan_hyperlink_activelink_pada_halaman_login_Flip(String activelink) {
        LoginFlipStep.user_menekan_hyperlink_activelink_pada_halaman_login_Flip(activelink);
    }

    @Then("user akan diarahkan ke halaman ([^\"]*) dari hyperlink tersebut")
    public void user_akan_diarahkan_ke_halaman_urlpages_dari_hyperlink_tersebut(String urlpages) {
        LoginFlipStep.user_akan_diarahkan_ke_halaman_urlpages_dari_hyperlink_tersebut(urlpages);
    }

    //Scenario 5:
    @When("login Flip dengan email dan password yang benar dan sesuai ([^\"]*)")
    public void login_Flip_dengan_email_dan_password_yang_benar_dan_sesuai_logindata(String logindata) {
        LoginFlipStep.login_Flip_dengan_email_dan_password_yang_benar_dan_sesuai_logindata(logindata);
    }

    @Then("user akan diarahkan ke halaman dashboard flip")
    public void user_akan_diarahkan_ke_halaman_dashboard_flip() {
        LoginFlipStep.user_akan_diarahkan_ke_halaman_dashboard_flip();
    }

    //Scenario 6:
    @When("login Flip dengan email ([^\"]*) dan password ([^\"]*) yang tidak cocok")
    public void login_Flip_dengan_email_mail_dan_password_pass_yang_tidak_cocok(String mail, String pass) {
        LoginFlipStep.login_Flip_dengan_email_mail_dan_password_pass_yang_tidak_cocok(mail, pass);
    }

    //Scenario 7:
    @When("login Flip dengan email ([^\"]*) dan password ([^\"]*) salah lebih dari 3 kali")
    public void login_Flip_dengan_email_mail_dan_password_pass_salah_lebih_dari_kali(String mail, String pass) {
        LoginFlipStep.login_Flip_dengan_email_mail_dan_password_pass_salah_lebih_dari_kali(mail, pass);
    }

    @Then("user tetap berada di halaman 'Login' Flip ID")
    public void user_tetap_berada_di_halaman_Flip_ID() {
        LoginFlipStep.user_tetap_berada_di_halaman_Flip_ID();
    }

    @Then("box error message gagal login berwarna merah ditampilkan")
    public void box_error_message_gagal_login_berwarna_merah_ditampilkan() {
        LoginFlipStep.box_error_message_gagal_login_berwarna_merah_ditampilkan();
    }
}

package Tests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import Steps.ForgetPasswordStep;

public class ForgetPassword {
    @Steps ForgetPasswordStep ForgetPasswordStep;

    //Scenario 1:
    @Then("user dialihkan ke halaman 'Lupa Password' dengan seluruh element halaman ditampilkan mengikuti deskripsi PO")
    public void user_dialihkan_ke_halaman_Lupa_Password_dengan_seluruh_element_halaman_ditampilkan_mengikuti_deskripsi_PO() {
        ForgetPasswordStep.user_dialihkan_ke_halaman_Lupa_Password_dengan_seluruh_element_halaman_ditampilkan_mengikuti_deskripsi_PO();
    }

    //Scenario 2:
    @Given("user berada di halaman 'Reset Password' Flip ID")
    public void user_berada_di_halaman_Reset_Password_Flip_ID() {
        ForgetPasswordStep.user_berada_di_halaman_Reset_Password_Flip_ID();
    }

    @When("mengklik kursor di input field email tanpa mengisinya kemudian melakukan klik di sembarang posisi")
    public void mengklik_kursor_di_input_field_email_tanpa_mengisinya_kemudian_melakukan_klik_di_sembarang_posisi() {
        ForgetPasswordStep.mengklik_kursor_di_input_field_email_tanpa_mengisinya_kemudian_melakukan_klik_di_sembarang_posisi();
    }

    @Then("user mendapatkan border color pada field input email berwarna merah dengan notifikasi {string}")
    public void user_mendapatkan_border_color_pada_field_input_email_berwarna_merah_dengan_notifikasi(String notif) {
        ForgetPasswordStep.user_mendapatkan_border_color_pada_field_input_email_berwarna_merah_dengan_notifikasi(notif);
    }

    @Then("button 'RESET PASSWORD' menjadi disabled")
    public void button_RESET_PASSWORD_menjadi_disabled() {
        ForgetPasswordStep.button_RESET_PASSWORD_menjadi_disabled();
    }

    //Scenario 3:
    @When("user membiarkan input field email kosong dan langsung menekan button 'RESET PASSWORD'")
    public void user_membiarkan_input_field_email_kosong_dan_langsung_menekan_button_RESET_PASSWORD() {
        ForgetPasswordStep.user_membiarkan_input_field_email_kosong_dan_langsung_menekan_button_RESET_PASSWORD();
    }

    @Then("user tetap berada di halaman 'Reset Password'")
    public void user_tetap_berada_di_halaman_Reset_Passsword() {
        ForgetPasswordStep.user_tetap_berada_di_halaman_Reset_Passsword();
    }

    @Then("button 'RESET PASSWORD' berubah menjadi disabled")
    public void button_RESET_PASSWORD_berubah_menjadi_disabled() {
        ForgetPasswordStep.button_RESET_PASSWORD_berubah_menjadi_disabled();
    }

    //Scenario 4:
    @When("mengisi input field email dengan format yang salah ([^\"]*) dan mengklik kursor di sembarang posisi")
    public void mengisi_input_field_email_dengan_format_yang_salah_mail_dan_mengklik_kursor_di_sembarang_posisi(String mail) {
        ForgetPasswordStep.mengisi_input_field_email_dengan_format_yang_salah_mail_dan_mengklik_kursor_di_sembarang_posisi(mail);
    }

    //Scenario 5:
    @When("mengisi input field email dengan format yang salah ([^\"]*) dan tetap memfokuskan kursor di field email")
    public void mengisi_input_field_email_dengan_format_yang_salah_mail_dan_tetap_memfokuskan_kursor_di_field_email(String mail) {
        ForgetPasswordStep.mengisi_input_field_email_dengan_format_yang_salah_mail_dan_tetap_memfokuskan_kursor_di_field_email(mail);
    }

    @Then("ketka user tetap berusaha menekan button 'RESET PASSWORD', user tetap di halaman yang sama tanpa ada perubahan")
    public void ketka_user_tetap_berusaha_menekan_button_RESET_PASSWORD_user_tetap_di_halaman_yang_sama_tanpa_ada_perubahan() {
        ForgetPasswordStep.ketka_user_tetap_berusaha_menekan_button_RESET_PASSWORD_user_tetap_di_halaman_yang_sama_tanpa_ada_perubahan();
    }

    //Scneario 6:
    @When("user memasukkan email ([^\"]*) yang ingin direset passwordnya pada input field email")
    public void user_memasukkan_email_mail_yang_ingin_direset_passwordnya_pada_input_field_email(String mail) {
        ForgetPasswordStep.user_memasukkan_email_mail_yang_ingin_direset_passwordnya_pada_input_field_email(mail);
    }

    @Then("user akan mendapatkan email notifikasi untuk reset password ketika masuk ke akun manajemen emailnya ([^\"]*)")
    public void user_akan_mendapatkan_email_notifikasi_untuk_reset_password_ketika_masuk_ke_akun_manajemen_emailnya_mail(String mail) {
        ForgetPasswordStep.user_akan_mendapatkan_email_notifikasi_untuk_reset_password_ketika_masuk_ke_akun_manajemen_emailnya_mail(mail);
    }

    //Scenario 7:
    @Given("user telah melakukan request untuk reset password akun flip pada email ([^\"]*)")
    public void user_telah_melakukan_request_untuk_reset_password_akun_flip_pada_email_mail(String mail) {
        ForgetPasswordStep.user_telah_melakukan_request_untuk_reset_password_akun_flip_pada_email_mail(mail);
    }

    @When("user membuka email notifikasi reset password akun flip untuk email ([^\"]*)")
    public void user_membuka_email_notifikasi_reset_password_akun_flip_untuk_email_mail(String mail) {
        ForgetPasswordStep.user_membuka_email_notifikasi_reset_password_akun_flip_untuk_email_mail(mail);
    }

    @Then("didapatkan seluruh subjek, email pengirim, dan content email sesuai dengan deskripsi PO")
    public void didapatkan_seluruh_subjek_email_pengirim_dan_content_email_sesuai_dengan_deskripsi_PO() {
        ForgetPasswordStep.didapatkan_seluruh_subjek_email_pengirim_dan_content_email_sesuai_dengan_deskripsi_PO();
    }

    //Scenario 8:
    @When("user menekan hyperlink untuk melkukan reset password di body content email")
    public void user_menekan_hyperlink_untuk_melkukan_reset_password_di_body_content_email() {
        ForgetPasswordStep.user_menekan_hyperlink_untuk_melkukan_reset_password_di_body_content_email();
    }

    @Then("user diarahkan ke laman reset password yang aktif dan seluruh elemen ditampilkan sesuai deskripsi PO")
    public void user_diarahkan_ke_laman_reset_password_yang_aktif_dan_seluruh_elemen_ditampilkan_sesuai_deskripsi_PO() {
        ForgetPasswordStep.user_diarahkan_ke_laman_reset_password_yang_aktif_dan_seluruh_elemen_ditampilkan_sesuai_deskripsi_PO();
    }

    //Scenario 9:
    @When("user mengklik icon brand Flip ID di pojok kiri atas halaman 'Reset Password'")
    public void user_mengklik_icon_brand_Flip_ID_di_pojok_kiri_atas_halaman_Reset_Password() {
        ForgetPasswordStep.user_mengklik_icon_brand_Flip_ID_di_pojok_kiri_atas_halaman_Reset_Password();
    }
}

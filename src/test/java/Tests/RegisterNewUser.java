package Tests;

import Steps.RegisterNewUserStep;
import net.thucydides.core.annotations.Steps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterNewUser {
    @Steps RegisterNewUserStep RegisterNewUserStep;

    //Scenario 1:
    @Then("seluruh elemen pada halaman Sign Up ditampilkan dan sesuai dengan deskripsi Product Owner")
    public void seluruh_elemen_pada_halaman_Sign_Up_ditampilkan_dan_sesuai_dengan_deskripsi_Product_Owner() {
        RegisterNewUserStep.seluruh_elemen_pada_halaman_Sign_Up_ditampilkan_dan_sesuai_dengan_deskripsi_Product_Owner();
    }

    //Scenario 2:
    @Given("user berada di halaman 'Sign Up' Flip ID")
    public void user_berada_di_halaman_Sign_Up_Flip_ID() {
        RegisterNewUserStep.user_berada_di_halaman_Sign_Up_Flip_ID();
    }

    @When("user menekan button 'Daftar' di form sign up dengan membiarkan semua input fields kosong")
    public void user_menekan_button_Daftar_di_form_sign_up_dengan_membiarkan_semua_input_fields_kosong() {
        RegisterNewUserStep.user_menekan_button_Daftar_di_form_sign_up_dengan_membiarkan_semua_input_fields_kosong();
    }

    @Then("border color di semua input fields akan berwarna merah dengan notif text di bawah fields")
    public void border_color_di_semua_input_fields_akan_berwarna_merah_dengan_notif_text_di_bawah_fields() {
        RegisterNewUserStep.border_color_di_semua_input_fields_akan_berwarna_merah_dengan_notif_text_di_bawah_fields();
    }

    @Then("user tetap berada di halaman 'Sign Up'")
    public void user_tetap_berada_di_halaman_Sign_Up() {
        RegisterNewUserStep.user_tetap_berada_di_halaman_Sign_Up();
    }

    //Scenario 3:
    @When("user mendaftar dengan sebagian input fields terisi dan membiarkan sebagian lainya kosong")
    public void user_mendaftar_dengan_sebagian_input_fields_terisi_dan_membiarkan_sebagian_lainya_kosong() {
        RegisterNewUserStep.user_mendaftar_dengan_sebagian_input_fields_terisi_dan_membiarkan_sebagian_lainya_kosong();
    }

    @Then("setiap fields yang terisi kosong akan berwarna merah pada border color dengan notif text di bawah fields")
    public void setiap_fields_yang_terisi_kosong_akan_berwarna_merah_pada_border_color_dengan_notif_text_di_bawah_fields() {
        RegisterNewUserStep.setiap_fields_yang_terisi_kosong_akan_berwarna_merah_pada_border_color_dengan_notif_text_di_bawah_fields();
    }

    //Scenario 4:
    @When("user mengisi input field 'Nama' dengan campuran alphabet dan special character ([^\"]*)")
    public void user_mengisi_input_field_dengan_campuran_alphabet_dan_special_character_nama(String nama) {
        RegisterNewUserStep.user_mengisi_input_field_dengan_campuran_alphabet_dan_special_character_nama(nama);
    }

    @When("mengisi input field lainya dengan format yang benar")
    public void mengisi_input_field_lainya_dengan_format_yang_benar() {
        RegisterNewUserStep.mengisi_input_field_lainya_dengan_format_yang_benar();
    }

    @Then("user mendapatkan input field 'Nama' berwarna merah dengan notif text {string}")
    public void user_mendapatkan_input_field_berwarna_merah_dengan_notif_text(String notif) {
        RegisterNewUserStep.user_mendapatkan_input_field_berwarna_merah_dengan_notif_text(notif);
    }

    //Scenario 5:
    @When("user mengisi input field 'Nama' dengan alphabet saja namun didahului atau diakhiri oleh beberapa spasi ([^\"]*)")
    public void user_mengisi_input_field_dengan_alphabet_saja_namun_didahului_atau_diakhiri_oleh_beberapa_spasi_Anjas_Muhammad(String nama) {
        RegisterNewUserStep.user_mengisi_input_field_dengan_alphabet_saja_namun_didahului_atau_diakhiri_oleh_beberapa_spasi_Anjas_Muhammad(nama);
    }

    @When("melakukan kursor klik di sembarang input field lainya")
    public void melakukan_kursor_klik_di_sembarang_input_field_lainya() {
        RegisterNewUserStep.melakukan_kursor_klik_di_sembarang_input_field_lainya();
    }

    @Then("semua spasi setelah dan sebelum ([^\"]*) pada input field 'Nama' otomatis terhapus menjadi ([^\"]*) saja")
    public void semua_spasi_setelah_dan_sebelum_Anjas_Muhammad_pada_input_field_otomatis_terhapus_menjadi_Anjas_Muhammad_saja(String nama, String autoname) {
        RegisterNewUserStep.semua_spasi_setelah_dan_sebelum_Anjas_Muhammad_pada_input_field_otomatis_terhapus_menjadi_Anjas_Muhammad_saja(nama, autoname);
    }

    //Scenario 6:
    @When("user mengisi input field 'Email' ([^\"]*) dengan dengan format yang tidak sesuai")
    public void user_mengisi_input_field_Email_mail_dengan_dengan_format_yang_tidak_sesuai(String mail) {
        RegisterNewUserStep.user_mengisi_input_field_Email_mail_dengan_dengan_format_yang_tidak_sesuai(mail);
    }

    @When("ketika user melakukan kursor klik di sembarang input field lainya")
    public void ketika_user_melakukan_kursor_klik_di_sembarang_input_field_lainya() {
        RegisterNewUserStep.ketika_user_melakukan_kursor_klik_di_sembarang_input_field_lainya();
    }

    @Then("input field 'Email' akan berwarna merah dengan pesan notifikasi {string}")
    public void input_field_akan_berwarna_merah_dengan_pesan_notifikasi(String notif) {
        RegisterNewUserStep.input_field_akan_berwarna_merah_dengan_pesan_notifikasi(notif);
    }

    //Scenario 7:
    @When("user mengisi input field 'Email' ([^\"]*) dengan dengan beberapa sisipan karakter spasi")
    public void user_mengisi_input_field_Email_mail_dengan_dengan_beberapa_sisipan_karakter_spasi(String mail) {
        RegisterNewUserStep.user_mengisi_input_field_Email_mail_dengan_dengan_beberapa_sisipan_karakter_spasi(mail);
    }

    @Then("semua karakter spasi akan terhapus secara otomatis dan user tidak mendapatkan notifikasi error")
    public void semua_karakter_spasi_akan_terhapus_secara_otomatis_dan_user_tidak_mendapatkan_notifikasi_error() {
        RegisterNewUserStep.semua_karakter_spasi_akan_terhapus_secara_otomatis_dan_user_tidak_mendapatkan_notifikasi_error();
    }

    //Scenario 8:
    @When("user mengisi input field 'Password' kurang dari {int} karakter")
    public void user_mengisi_input_field_Password_pass_kurang_dari_n_karakter(Integer n) {
        RegisterNewUserStep.user_mengisi_input_field_Password_pass_kurang_dari_n_karakter(n);
    }

    @Then("user mendapati input field 'Password' berwarna merah dan notifikasi {string}")
    public void user_mendapati_input_field_Password_berwarna_merah_dan(String notif) {
        RegisterNewUserStep.user_mendapati_input_field_Password_berwarna_merah_dan(notif);
    }
}

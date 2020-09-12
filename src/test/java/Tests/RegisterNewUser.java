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
    @When("mengisi input field lainya dengan format yang benar dilanjutkan menekan button 'DAFTAR'")
    public void mengisi_input_field_lainya_dengan_format_yang_benar_dilanjutkan_menekan_button_DAFTAR() {
        RegisterNewUserStep.mengisi_input_field_lainya_dengan_format_yang_benar_dilanjutkan_menekan_button_DAFTAR();
    }

    @Then("user mendapatkan warn message box untuk error input field Name")
    public void user_mendapatkan_warn_message_box_untuk_error_input_field_Name() {
        RegisterNewUserStep.user_mendapatkan_warn_message_box_untuk_error_input_field_Name();
    }

    //Scenario 6:
    @When("user mengisi input field 'Nama' dengan alphabet saja namun didahului atau diakhiri oleh beberapa spasi ([^\"]*)")
    public void user_mengisi_input_field_dengan_alphabet_saja_namun_didahului_atau_diakhiri_oleh_beberapa_spasi_Anjas_Muhammad(String nama) {
        RegisterNewUserStep.user_mengisi_input_field_dengan_alphabet_saja_namun_didahului_atau_diakhiri_oleh_beberapa_spasi_Anjas_Muhammad(nama);
    }

    @When("melakukan kursor klik di sembarang input field lainya")
    public void melakukan_kursor_klik_di_sembarang_input_field_lainya() {
        RegisterNewUserStep.melakukan_kursor_klik_di_sembarang_input_field_lainya();
    }

    @Then("semua spasi setelah dan sebelum ([^\"]*) pada input field 'Nama' otomatis terhapus menjadi ([^\"]*) saja")
    public void semua_spasi_setelah_dan_sebelum_nama_pada_input_field_otomatis_terhapus_menjadi_autoname_saja(String nama, String autoname) {
        RegisterNewUserStep.semua_spasi_setelah_dan_sebelum_nama_pada_input_field_otomatis_terhapus_menjadi_autoname_saja(nama, autoname);
    }

    //Scenario 7:
    @When("user mengisi input field 'Email' ([^\"]*) dengan dengan format yang tidak sesuai")
    public void user_mengisi_input_field_Email_mail_dengan_dengan_format_yang_tidak_sesuai(String mail) {
        RegisterNewUserStep.user_mengisi_input_field_Email_mail_dengan_dengan_format_yang_tidak_sesuai(mail);
    }

    @Then("input field 'Email' akan berwarna merah dengan pesan notifikasi {string}")
    public void input_field_akan_berwarna_merah_dengan_pesan_notifikasi(String notif) {
        RegisterNewUserStep.input_field_akan_berwarna_merah_dengan_pesan_notifikasi(notif);
    }

    //Scenario 8:
    @When("user mengisi input field 'Email' ([^\"]*) dengan dengan beberapa sisipan karakter spasi")
    public void user_mengisi_input_field_Email_mail_dengan_dengan_beberapa_sisipan_karakter_spasi(String mail) {
        RegisterNewUserStep.user_mengisi_input_field_Email_mail_dengan_dengan_beberapa_sisipan_karakter_spasi(mail);
    }

    @Then("semua karakter spasi akan terhapus secara otomatis menjadi ([^\"]*) dan user tidak mendapatkan notifikasi error")
    public void semua_karakter_spasi_akan_terhapus_secara_otomatis_menjadi_automail_dan_user_tidak_mendapatkan_notifikasi_error(String automail) {
        RegisterNewUserStep.semua_karakter_spasi_akan_terhapus_secara_otomatis_menjadi_automail_dan_user_tidak_mendapatkan_notifikasi_error(automail);
    }

    //Scenario 9:
    @When("user mengisi input field 'Password' kurang dari {int} karakter")
    public void user_mengisi_input_field_Password_pass_kurang_dari_n_karakter(Integer n) {
        RegisterNewUserStep.user_mengisi_input_field_Password_pass_kurang_dari_n_karakter(n);
    }

    @Then("user mendapati input field 'Password' berwarna merah dan notifikasi {string}")
    public void user_mendapati_input_field_Password_berwarna_merah_dan(String notif) {
        RegisterNewUserStep.user_mendapati_input_field_Password_berwarna_merah_dan(notif);
    }

    //Scenario 10:
    @Given("mengisi input field lainya selain field password dengan format yang benar dilanjutkan menekan button 'DAFTAR'")
    public void mengisi_input_field_lainya_selain_field_password_dengan_format_yang_benar_dilanjutkan_menekan_button_DAFTAR() {
        RegisterNewUserStep.mengisi_input_field_lainya_selain_field_password_dengan_format_yang_benar_dilanjutkan_menekan_button_DAFTAR();
    }

    @Then("user mendapatkan warn message box untuk error input field Password")
    public void user_mendapatkan_warn_message_box_untuk_error_input_field_Password() {
        RegisterNewUserStep.user_mendapatkan_warn_message_box_untuk_error_input_field_Password();
    }

    //Scenario 11:
    @When("User mengklik button 'Masuk' yang ada di halaman 'SignUp'")
    public void user_mengklik_button_Masuk_yang_ada_di_halaman_SignUp() {
        RegisterNewUserStep.user_mengklik_button_Masuk_yang_ada_di_halaman_SignUp();
    }

    @Then("user diarahkan ke halaman 'Login' Flip ID")
    public void user_diarahkan_ke_halaman_Login_Flip_ID() {
        RegisterNewUserStep.user_diarahkan_ke_halaman_Login_Flip_ID();
    }

    //Scenario 12:
    @When("menekan button 'LIHAT' setelah mengisi input field 'Password' dengan beberapa karakter ([^\"]*)")
    public void user_menekan_button_LIHAT_setelah_mengisi_input_field_Password_dengan_beberapa_karakter_pass(String pass) {
        RegisterNewUserStep.user_menekan_button_LIHAT_setelah_mengisi_input_field_Password_dengan_beberapa_karakter_pass(pass);
    }

    @Then("text password yang diperlihatkan bukan bintang-bintang dan sesuai dengan yang diketik ([^\"]*)")
    public void text_password_yang_diperlihatkan_bukan_bintang_bintang_dan_sesuai_dengan_yang_diketik_pass(String pass) {
        RegisterNewUserStep.text_password_yang_diperlihatkan_bukan_bintang_bintang_dan_sesuai_dengan_yang_diketik_pass(pass);
    }

    @Then("text password akan kembali hidden dalam bentuk bintang-bintang apabila button 'SEMBUNYIKAN' diklik kembali")
    public void text_password_akan_kembali_hidden_dalam_bentuk_bintang_bintang_apabila_button_SEMBUNYIKAN_diklik_kembali(){
        RegisterNewUserStep.text_password_akan_kembali_hidden_dalam_bentuk_bintang_bintang_apabila_button_SEMBUNYIKAN_diklik_kembali();
    }

    //Scenario 13:
    @When("user menekan button flag country code di sebelah field phone number")
    public void user_menekan_button_flag_country_code_di_sebelah_field_phone_number() {
        RegisterNewUserStep.user_menekan_button_flag_country_code_di_sebelah_field_phone_number();
    }

    @Then("muncul pop up dialog 'Cari Kode Negara' dengan semua elemen ditampilkan sesuai deskripsi PO")
    public void muncul_pop_up_dialog_Cari_Kode_Negara_dengan_semua_elemen_ditampilkan_sesuai_deskripsi_PO() {
        RegisterNewUserStep.muncul_pop_up_dialog_Cari_Kode_Negara_dengan_semua_elemen_ditampilkan_sesuai_deskripsi_PO();
    }

    //Scenario 14:
    @When("user memilih kode negara dengan pencarian ([^\"]*) pada modal dialog di halaman 'SignUp'")
    public void user_memilih_kode_negara_dengan_pencarian_Singapore_pada_modal_dialog_di_halaman_SignUp(String country) {
        RegisterNewUserStep.user_memilih_kode_negara_dengan_pencarian_Singapore_pada_modal_dialog_di_halaman_SignUp(country);
    }

    @Then("modal dialog country code picker disembunyikan dan negara yang ditampilkan sesuai negara yang dipilih")
    public void modal_dialog_country_code_picker_disembunyikan_dan_negara_yang_ditampilkan_sesuai_negara_yang_dipilih() {
        RegisterNewUserStep.modal_dialog_country_code_picker_disembunyikan_dan_negara_yang_ditampilkan_sesuai_negara_yang_dipilih();
    }

    //Scenario 15:
    @When("user mencari nama negara ([^\"]*) di kotak pencarian dan mendata hasil pencarian")
    public void user_mencari_nama_negara_CName_di_kotak_pencarian_dan_mendata_hasil_pencarian(String CName) {
        RegisterNewUserStep.user_mencari_nama_negara_CName_di_kotak_pencarian_dan_mendata_hasil_pencarian(CName);
    }

    @When("user kembali mencari kode negara ([^\"]*) di kotak pencarian dan mendata hasil pencarian")
    public void user_kembali_mencari_kode_negara_CCode_di_kotak_pencarian_dan_mendata_hasil_pencarian(String CCode) {
        RegisterNewUserStep.user_kembali_mencari_kode_negara_CCode_di_kotak_pencarian_dan_mendata_hasil_pencarian(CCode);
    }

    @Then("didapatkan hasil pencarian dengan nama negara ([^\"]*) maupun kode negara ([^\"]*) adalah sama")
    public void didapatkan_hasil_pencarian_dengan_nama_negara_CName_maupun_kode_negara_CCodeadalah_sama(String CName, String CCode) {
        RegisterNewUserStep.didapatkan_hasil_pencarian_dengan_nama_negara_CName_maupun_kode_negara_CCodeadalah_sama(CName, CCode);
    }

    //Scenario 16:
    @When("user memilih kode negara dengan pencarian ([^\"]*) pada modal dialog di halaman SignUp")
    public void user_memilih_kode_negara_dengan_pencarian_country_pada_modal_dialog_di_halaman_SignUp(String country) {
        RegisterNewUserStep.user_memilih_kode_negara_dengan_pencarian_country_pada_modal_dialog_di_halaman_SignUp(country);
    }

    @When("user mengklik button flag country code kembali namun langsung menutup modal dialog yang muncul")
    public void user_mengklik_button_flag_country_code_kembali_namun_langsung_menutup_modal_dialog_yang_muncul() {
        RegisterNewUserStep.user_mengklik_button_flag_country_code_kembali_namun_langsung_menutup_modal_dialog_yang_muncul();
    }

    @Then("nilai value country saat ini adalah ([^\"]*) dan tidak berubah sesuai pilihan awal")
    public void nilai_value_country_saat_ini_adalah_country_dan_tidak_berubah_sesuai_pilihan_awal(String country) {
        RegisterNewUserStep.nilai_value_country_saat_ini_adalah_country_dan_tidak_berubah_sesuai_pilihan_awal(country);
    }

    //Scenario 17:
    @When("user mendaftar sebagai pengguna baru dengan nomor handphone yang telah terdaftar ([^\"]*)")
    public void user_mendaftar_sebagai_pengguna_baru_dengan_nomor_handphone_yang_telah_terdaftar_phoneNumber(String phonenumber) {
        RegisterNewUserStep.user_mendaftar_sebagai_pengguna_baru_dengan_nomor_handphone_yang_telah_terdaftar_phoneNumber(phonenumber);
    }

    @Then("didapatkan error box message dengan notifikasi {string}")
    public void didapatkan_error_box_message_dengan_notifikasi(String notif) {
        RegisterNewUserStep.didapatkan_error_box_message_dengan_notifikasi(notif);
    }

    //Scenario 18:
    @When("use mengklik icon brand Flip ID di pojok kiri atas halaman 'SignUp'")
    public void use_mengklik_icon_brand_Flip_ID_di_pojok_kiri_atas_halaman_SignUp() {
        RegisterNewUserStep.use_mengklik_icon_brand_Flip_ID_di_pojok_kiri_atas_halamanSignUp();
    }

    @Then("user akan diarahkan ke halaman utama Flip ID")
    public void user_akan_diarahkan_ke_halaman_utama_Flip_ID() {
        RegisterNewUserStep.user_akan_diarahkan_ke_halaman_utama_Flip_ID();
    }
}

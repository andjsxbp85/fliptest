package Steps;

import Pages.FrontPages.HomePage;
import Pages.FrontPages.LoginPage;
import Pages.RegistrasiUser.SignUpPage;
import Pages.RegistrasiUser.VerifikasiNoHpPages;
import Utils.database;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class RegisterNewUserStep implements database {
    SignUpPage SignUpPage;
    HomePage HomePage;
    LoginPage LoginPage;
    VerifikasiNoHpPages VerifikasiNoHpPages;

    public void seluruh_elemen_pada_halaman_Sign_Up_ditampilkan_dan_sesuai_dengan_deskripsi_Product_Owner() {
        SignUpPage.seluruhElemenPadaHalamanSignUpDitampilkan();
    }

    //Scenario 2:
    public void user_berada_di_halaman_Sign_Up_Flip_ID() {
        HomePage.open();
        HomePage.menekanButtonMasuk();
        LoginPage.klikButtonDaftarDiPojokKananAtasHalaman();
    }

    public void user_menekan_button_Daftar_di_form_sign_up_dengan_membiarkan_semua_input_fields_kosong() {
        //Langsung klik button 'DAFTAR' tanpa mengisi field manapun
        SignUpPage.mengklikButtonDAFTAR();
    }

    public void border_color_di_semua_input_fields_akan_berwarna_merah_dengan_notif_text_di_bawah_fields() {
        SignUpPage.assertionSemuaBorderColorPadaRequiredFieldAkanBerwarnaMerah();
    }

    public void user_tetap_berada_di_halaman_Sign_Up() {
        SignUpPage.assertionUserBeradaDiHalamanSignUpFlipID();
    }

    //Scenario 3:
    List<Integer> fields = new ArrayList<>(); //field-field mana saja yg gk terisi alias leave blank
    public void user_mendaftar_dengan_sebagian_input_fields_terisi_dan_membiarkan_sebagian_lainya_kosong() {
        //Menentukan berapa banyak field yang tidak akan diisi (karena ada 4 field input, maka 1 sd 3 agar pasti ada 1 field
        int numBlankField = SignUpPage.randomizerInt(1,3);
        fields.clear();
        fields = new ArrayList<>();
        while (fields.size()!=numBlankField){
            int newRand = SignUpPage.randomizerInt(1,4); // 4 agar menentukan dari ke 4 field mana yg tidak terisi
            if(!fields.contains(newRand)) fields.add(newRand);
        }

        //Mengisi input apabila tidak ada di fields list
        if(!fields.contains(1)) { SignUpPage.mengisiInputFieldNama("Coba An"+(char) SignUpPage.randomizerInt(97,122)); }
        if(!fields.contains(2)) { SignUpPage.mengisiInputFieldEmail("anjascoba"+ (char) SignUpPage.randomizerInt(97,122)+"@gmail.com"); }
        if(!fields.contains(3)) { SignUpPage.mengisiInputFieldPassword("inipassn"+SignUpPage.randomizerInt(97,122)+"word"); }
        if(!fields.contains(4)) { SignUpPage.mengisiInputFieldNoHP("085934527"+SignUpPage.randomizerInt(0,999)); }
        SignUpPage.mengklikButtonDAFTAR();
    }

    public void setiap_fields_yang_terisi_kosong_akan_berwarna_merah_pada_border_color_dengan_notif_text_di_bawah_fields() {
        SignUpPage.assertionBorderColorBerwarnaMerahDanInputFieldDitampilkanWarnNotificationUntukField(fields);
    }

    //Scenario 4:
    public void user_mengisi_input_field_dengan_campuran_alphabet_dan_special_character_nama(String nama) {
        SignUpPage.mengisiInputFieldNama(nama);
    }

    public void mengisi_input_field_lainya_dengan_format_yang_benar() {
        SignUpPage.mengisiInputFieldEmail("anjascoba"+ (char) SignUpPage.randomizerInt(97,122)+"@gmail.com");
        SignUpPage.mengisiInputFieldPassword("inipassn"+SignUpPage.randomizerInt(97,122)+"word");
        SignUpPage.mengisiInputFieldNoHP("085934527"+SignUpPage.randomizerInt(0,999));
    }

    public void user_mendapatkan_input_field_berwarna_merah_dengan_notif_text(String notif) {
        SignUpPage.klikJudulSelamatDatang();
        SignUpPage.teradapatWarnNotificationDanBorderColoerRedPadaInvalidFields(1, notif);
    }

    //Scenario 5:
    public void mengisi_input_field_lainya_dengan_format_yang_benar_dilanjutkan_menekan_button_DAFTAR() {
        SignUpPage.mengisiInputFieldEmail("anjascoba"+ (char) SignUpPage.randomizerInt(97,122)+"@gmail.com");
        SignUpPage.mengisiInputFieldPassword("inipassn"+SignUpPage.randomizerInt(97,122)+"word");
        SignUpPage.mengisiInputFieldNoHP("085934527"+SignUpPage.randomizerInt(0,999));
        SignUpPage.mengklikButtonDAFTAR();
    }

    public void user_mendapatkan_warn_message_box_untuk_error_input_field_Name() {
        SignUpPage.assertionBoxErroMassageKesalahanPenulisanFieldNamaDitampilkan("Error:\nonly letters (a-z), numbers (0-9), spaces ( ), periods (.), commas (,), apostrophes ('), and dashes (-) are allowed");
    }

    //Scenario 6:
    public void user_mengisi_input_field_dengan_alphabet_saja_namun_didahului_atau_diakhiri_oleh_beberapa_spasi_Anjas_Muhammad(String nama) {
        switch (nama){
            case "Anjas Muhammad": nama  = "                  Anjas Muhammad"; break;
            case "Anjas Bangun": nama = "Anjas Bangun   "; break;
            case "Anjas Muhammad Bangun": nama = "    Anjas Muhammad Bangun    "; break;
        }
        SignUpPage.mengisiInputFieldNama(nama);
    }

    public void melakukan_kursor_klik_di_sembarang_input_field_lainya() {
        SignUpPage.klikJudulSelamatDatang();
    }

    public void semua_spasi_setelah_dan_sebelum_nama_pada_input_field_otomatis_terhapus_menjadi_autoname_saja(String nama, String autoname) {
        Assert.assertTrue(SignUpPage.gettingCurrentNamaInputFieldValue().equals(autoname));
    }

    //Scenario 7:
    public void user_mengisi_input_field_Email_mail_dengan_dengan_format_yang_tidak_sesuai(String mail) {
        SignUpPage.mengisiInputFieldEmail(mail);
    }

    public void input_field_akan_berwarna_merah_dengan_pesan_notifikasi(String notif) {
        SignUpPage.teradapatWarnNotificationDanBorderColoerRedPadaInvalidFields(2,notif);
    }

    //Scenario 8:
    public void user_mengisi_input_field_Email_mail_dengan_dengan_beberapa_sisipan_karakter_spasi(String mail) {
        switch (mail){
            case "anjasmbangun@bangun.com": mail  = "                  anjasmbangun@bangun.com"; break;
            case "anjasmbangun@gmail.com": mail = "anjasmbangun@gmail.com     "; break;
            case "anjaskutest@bangun.com": mail = "         anjaskutest@bangun.com             "; break;
        }
        SignUpPage.mengisiInputFieldEmail(mail);
    }

    public void semua_karakter_spasi_akan_terhapus_secara_otomatis_menjadi_automail_dan_user_tidak_mendapatkan_notifikasi_error(String automail) {
        //Assert.assertTrue(SignUpPage.gettingCurrentEmailInputFieldValue().equals(automail));
        Assert.fail(); //karena value secara ui dan value secara html beda isinya
    }

    //Scenario 9:
    public void user_mengisi_input_field_Password_pass_kurang_dari_n_karakter(Integer n) {
        String pass = "";
        int numOfChar = SignUpPage.randomizerInt(1,n-1); //n = 8 >> jadi antara 1 sd 7 karakter
        for(int i=0;i<numOfChar;i++){
            pass = pass + (char) SignUpPage.randomizerInt(32,125); //ascii space sampai simbol )
        }
        SignUpPage.mengisiInputFieldPassword(pass);
    }

    public void user_mendapati_input_field_Password_berwarna_merah_dan(String notif) {
        SignUpPage.teradapatWarnNotificationDanBorderColoerRedPadaInvalidFields(3,notif);
    }

    //Scenario 10:
    public void mengisi_input_field_lainya_selain_field_password_dengan_format_yang_benar_dilanjutkan_menekan_button_DAFTAR() {
        SignUpPage.mengisiInputFieldNama("Coba An"+(char) SignUpPage.randomizerInt(97,122));
        SignUpPage.mengisiInputFieldEmail("anjascoba"+ (char) SignUpPage.randomizerInt(97,122)+"@gmail.com");
        SignUpPage.mengisiInputFieldNoHP("085934527"+SignUpPage.randomizerInt(0,999));
        SignUpPage.mengklikButtonDAFTAR();
    }

    public void user_mendapatkan_warn_message_box_untuk_error_input_field_Password() {
        SignUpPage.assertionBoxErroMassageKesalahanPenulisanFieldNamaDitampilkan("Error:\nPassword minimal 8 karakter");
    }

    //Scenario 11:
    public void user_mengklik_button_Masuk_yang_ada_di_halaman_SignUp() {
        SignUpPage.klikButtonMasukDiPojokKananAtasHalaman();
    }

    public void user_diarahkan_ke_halaman_Login_Flip_ID() {
        LoginPage.assertionUserBeradaDiHalamanURL(_loginURL);
    }

    //Scenario 12:
    public void user_menekan_button_LIHAT_setelah_mengisi_input_field_Password_dengan_beberapa_karakter_pass(String pass) {
        SignUpPage.mengisiInputFieldPassword(pass);
        SignUpPage.menekanButtonLihat();
    }

    public void text_password_yang_diperlihatkan_bukan_bintang_bintang_dan_sesuai_dengan_yang_diketik_pass(String pass) {
        SignUpPage.assertionTypeInputFieldPasswordAdalah("text");
        Assert.assertTrue(SignUpPage.gettingPasswordValue().equals(pass));
    }

    public void text_password_akan_kembali_hidden_dalam_bentuk_bintang_bintang_apabila_button_SEMBUNYIKAN_diklik_kembali(){
        SignUpPage.menekanButtonSembunyikan();
        SignUpPage.assertionTypeInputFieldPasswordAdalah("password");
    }

    //Scenario 13:
    public void user_menekan_button_flag_country_code_di_sebelah_field_phone_number() {
        SignUpPage.mengklikButtonFlagCountry();
    }

    public void muncul_pop_up_dialog_Cari_Kode_Negara_dengan_semua_elemen_ditampilkan_sesuai_deskripsi_PO() {
        SignUpPage.assertionAllElementOnModalCountryCodeDialogShown();
    }

    //Scenario 14:
    public void user_memilih_kode_negara_dengan_pencarian_Singapore_pada_modal_dialog_di_halaman_SignUp(String country) {
        SignUpPage.mengklikButtonFlagCountry();
        SignUpPage.memilihKodeNoHPNegaraAsal(country);
    }

    public void modal_dialog_country_code_picker_disembunyikan_dan_negara_yang_ditampilkan_sesuai_negara_yang_dipilih(String countryShortCode) {
        SignUpPage.modalDialogCountryCodePickerDisembunyikanSettelahMemilihNegaraDanNegaraYangDipilihSesuaiDenganHarapan(countryShortCode);
    }

    //Scenario 15:
    List<String> countryResult = new ArrayList<>(); //index 0 = ctryResult, index 1 = country short code (ctrySCResult), index 2 = country phone code (ctryPCResult)
    public void user_mencari_nama_negara_CName_di_kotak_pencarian_dan_mendata_hasil_pencarian(String CName) {
        SignUpPage.mengklikButtonFlagCountry();
        countryResult = SignUpPage.memilihKodeNoHPNegaraAsal(CName);
    }

    public void user_kembali_mencari_kode_negara_CCode_di_kotak_pencarian_dan_mendata_hasil_pencarian(String CCode) {
        SignUpPage.mengklikButtonFlagCountry();
    }

    public void didapatkan_hasil_pencarian_dengan_nama_negara_CName_maupun_kode_negara_CCodeadalah_sama(String CName, String CCode) {
        Assert.assertTrue(SignUpPage.memilihKodeNoHPNegaraAsal(CCode).equals(countryResult));
    }

    //Scenario 16:
    public void user_memilih_kode_negara_dengan_pencarian_country_pada_modal_dialog_di_halaman_SignUp(String country) {
        SignUpPage.mengklikButtonFlagCountry();
        SignUpPage.memilihKodeNoHPNegaraAsal(country);
    }

    public void user_mengklik_button_flag_country_code_kembali_namun_langsung_menutup_modal_dialog_yang_muncul() {
        SignUpPage.mengklikButtonFlagCountry();
        SignUpPage.menekanButtonTutupPadModalDialogCariKodeNegara();
    }

    public void nilai_value_country_saat_ini_adalah_country_dengan_short_code_SC_dan_tidak_berubah_sesuai_pilihan_awal(String country, String SC) {
        SignUpPage.modalDialogCountryCodePickerDisembunyikanSettelahMemilihNegaraDanNegaraYangDipilihSesuaiDenganHarapan(SC);
    }

    //Scenario 17:
    public void user_mendaftar_sebagai_pengguna_baru_dengan_nomor_handphone(String phonenumber) {
        int rand1 = SignUpPage.randomizerInt(1,10), rand2 = SignUpPage.randomizerInt(1,10);
        String nama1 = ""+(char) SignUpPage.randomizerInt(65,90);
        String nama2 = ""+(char) SignUpPage.randomizerInt(65,90);

        for(int i=0;i<2;i++){
            if(i==1) rand1 = rand2;
            for(int j=0;j<rand1;j++){
                if(i==0){
                    nama1 = nama1 + (char) SignUpPage.randomizerInt(97,122);
                }
                else {
                    nama2 = nama2 + (char) SignUpPage.randomizerInt(97,122);
                }
            }
        }

        SignUpPage.mengisiInputFieldNama(nama1+" "+nama2);
        SignUpPage.mengisiInputFieldEmail("anjas" + nama1.substring(1) + (char) SignUpPage.randomizerInt(97,122) + String.valueOf(SignUpPage.getCurrrentTimeMs()).substring(11) +"@gmail.com");
        SignUpPage.mengisiInputFieldPassword("pass"+SignUpPage.randomizerInt(97,122)+"word"+(char) SignUpPage.randomizerInt(97,122) + String.valueOf(SignUpPage.getCurrrentTimeMs()).substring(11));
        SignUpPage.mengisiInputFieldNoHP(phonenumber);

        SignUpPage.mengklikButtonDAFTAR();
    }

    public void didapatkan_error_box_message_dengan_notifikasi(String notif) {
        SignUpPage.assertionBoxErroMassageKesalahanPenulisanFieldNamaDitampilkan("Error:\n"+notif);
    }

    //Scenario 18:
    String nextHpNumber;
    public void registrasi_user_baru_dengan_nomor_handphone_yang_telah_terdaftar_phoneNumber_tetapi_beda_country_country(String noHP, String country) {
        SignUpPage.mengklikButtonFlagCountry();
        SignUpPage.memilihKodeNoHPNegaraAsal(country);
        //karena kalau duh pernah sampe tahap verifikasi daong sudah dianggap terdaftar dan gk bisa lagi dicoba
        nextHpNumber = noHP.substring(0,4) + String.valueOf(SignUpPage.getCurrrentTimeMs()).substring(5);
        user_mendaftar_sebagai_pengguna_baru_dengan_nomor_handphone(nextHpNumber);
    }

    public void user_akan_dialihkan_ke_halaman_verifikasi_nomor_handphone_dengan_nomor_tujuan_countryCode_ditambah_phoneNumber(String countryCode, String phoneNumber) {
        VerifikasiNoHpPages.assertionUserAtPhoneNumberVerificationPageAkhir(countryCode,nextHpNumber);
    }

    //Scenario 19:
    public void user_mengisi_seluruh_input_field_registrasi_dengan_baik_dan_benar_untuk_negara_Indonesia() {
        nextHpNumber = "081" + String.valueOf(SignUpPage.getCurrrentTimeMs()).substring(4);
        user_mendaftar_sebagai_pengguna_baru_dengan_nomor_handphone(nextHpNumber);
    }

    public void user_dialihkan_ke_halaman_pilihan_verifikasi_melalui_whatsapp_atau_sms() {
        VerifikasiNoHpPages.assertionUserAtPhoneNumberVerificationBySMSorWAPage("+62",nextHpNumber);
    }

    public void apabila_user_memilih_verifikasi_via_whatsapp_ataupun_sms_akan_dialihkan_lagi_ke_halaman_verifikasi_akhir_no_hp() {
        VerifikasiNoHpPages.klikVerifikasiButtonBy(true);
        VerifikasiNoHpPages.assertionUserAtPhoneNumberVerificationPageAkhir("+62",nextHpNumber);
    }

    //Scenario 20:
    public void use_mengklik_icon_brand_Flip_ID_di_pojok_kiri_atas_halamanSignUp() {
        SignUpPage.klikFlipBrandIconButton();
    }

    public void user_akan_diarahkan_ke_halaman_utama_Flip_ID() {
        LoginPage.assertionUserBeradaDiHalamanURL(_mainURL);
    }
}

package Tests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import Steps.FloatChatBoxStep;

public class FloatChatBox {
    @Steps FloatChatBoxStep FloatChatBoxStep;

    //Scenario 1:
    @When("user membuka halaman tertentu ([^\"]*) untuk url ([^\"]*)")
    public void user_membuka_halaman_tertentu_halaman_untuk_url_url(String halaman, String url) {
        FloatChatBoxStep.user_membuka_halaman_tertentu_halaman_untuk_url_url(halaman, url);
    }

    @Then("terdapat floating chat box di setiap  ([^\"]*) untuk url ([^\"]*) tersebut")
    public void terdapat_floating_chat_box_di_setiap_halaman_untuk_url_url_tersebut(String halaman, String url) {
        FloatChatBoxStep.terdapat_floating_chat_box_di_setiap_halaman_untuk_url_url_tersebut(halaman, url);
    }

    //Scenario 2:
    @Given("user ada di halaman 'Login' Flip ID dengan chat box form terbuka")
    public void user_ada_di_halaman_Login_Flip_ID_dengan_chat_box_form_terbuka() {
        FloatChatBoxStep.user_ada_di_halaman_Login_Flip_ID_dengan_chat_box_form_terbuka();
    }

    @When("user menekan button 'X' pada chatbox form")
    public void user_menekan_button_X_pada_chatbox_form() {
        FloatChatBoxStep.user_menekan_button_X_pada_chatbox_form();
    }

    @Then("chat box form akan tertutup kembali")
    public void chat_box_form_akan_tertutup_kembali() {
        FloatChatBoxStep.chat_box_form_akan_tertutup_kembali();
    }

    //Scenario 3:
    @When("user user menekan chatbox button di pojok kanan bawah halaman")
    public void user_user_menekan_chatbox_button_di_pojok_kanan_bawah_halaman() {
        FloatChatBoxStep.user_user_menekan_chatbox_button_di_pojok_kanan_bawah_halaman();
    }

    @Then("ditampilkan seluruh elemen chat box sesuai dengan deskripsi PO")
    public void ditampilkan_seluruh_elemen_chat_box_sesuai_dengan_deskripsi_PO() {
        FloatChatBoxStep.ditampilkan_seluruh_elemen_chat_box_sesuai_dengan_deskripsi_PO();
    }

    //Scenario 4:
    @Given("user membuka chat box di halaman 'Login' Flip ID")
    public void user_membuka_chat_box_di_halaman_Login_Flip_ID() {
        FloatChatBoxStep.user_membuka_chat_box_di_halaman_Login_Flip_ID();
    }

    @When("user memilih untuk meminta bantuan dengan ([^\"]*) di chatbox")
    public void user_memilih_untuk_meminta_bantuan_dengan_officer_di_chatbox(String officer) {
        FloatChatBoxStep.user_memilih_untuk_meminta_bantuan_dengan_officer_di_chatbox(officer);
    }

    @Then("customer service officer yang terpilih adalah ([^\"]*)")
    public void customer_service_officer_yang_terpilih_adalah_officer(String officer) {
        FloatChatBoxStep.customer_service_officer_yang_terpilih_adalah_officer(officer);
    }

    //Scenario 5:
    @When("user mengirim chat ([^\"]*) di chatbox dengan email ([^\"]*)")
    public void user_mengirim_chat_chat_di_chatbox_dengan_email_mail(String chat, String mail) {
        //FloatChatBoxStep.user_mengirim_chat_chat_di_chatbox_dengan_email_mail(chat, mail);
    }

    @Then("pesan ([^\"]*) beserta email ([^\"]*) yang telah kita kirim tetera di chat box dialog")
    public void pesan_chat_beserta_email_mail_yang_telah_kita_kirim_tetera_di_chat_box_dialog(String chat, String mail) {
        FloatChatBoxStep.pesan_chat_beserta_email_mail_yang_telah_kita_kirim_tetera_di_chat_box_dialog(chat, mail);
    }

    //Scenario 6:
    @Given("user mengirim kembali chat ([^\"]*) diikuti dengan emoji random")
    public void user_mengirim_kembali_chat_chat_diikuti_dengan_emoji_random(String chat) {
        FloatChatBoxStep.user_mengirim_kembali_chat_chat_diikuti_dengan_emoji_random(chat);
    }

    @Then("pesan ([^\"]*) dengan emoji yang telah kita kirim tetera di chat box dialog")
    public void pesan_chat_dengan_emoji_yang_telah_kita_kirim_tetera_di_chat_box_dialog(String chat) {
        FloatChatBoxStep.pesan_chat_dengan_emoji_yang_telah_kita_kirim_tetera_di_chat_box_dialog(chat);
    }

    //Scenario 7:
    @Given("user mengirim kembali chat di reply input field pada chatbox dengan String sangat panjang")
    public void user_mengirim_kembali_chat_di_reply_input_field_pada_chatbox_dengan_String_sangat_panjang() {
        FloatChatBoxStep.user_mengirim_kembali_chat_di_reply_input_field_pada_chatbox_dengan_String_sangat_panjang();
    }

    @Then("muncul notifikasi {string}")
    public void muncul_notifikasi(String notif) {
        FloatChatBoxStep.muncul_notifikasi(notif);
    }
}

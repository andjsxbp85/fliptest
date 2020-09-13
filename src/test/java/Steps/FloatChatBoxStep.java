package Steps;

import Pages.FrontPages.HomePage;
import Pages.FrontPages.LoginPage;
import Utils.database;

public class FloatChatBoxStep implements database {
    HomePage HomePage;
    LoginPage LoginPage;

    //Scenario 1:
    public void user_membuka_halaman_tertentu_halaman_untuk_url_url(String halaman, String url) {
        if(!url.equals(_mainURL)) HomePage.gotoFlipUrl(url);
    }

    public void terdapat_floating_chat_box_di_setiap_halaman_untuk_url_url_tersebut(String halaman, String url) {
        HomePage.terdapatWidgetFloatingChatBox();
    }

    //Scenario 2:
    public void user_ada_di_halaman_Login_Flip_ID_dengan_chat_box_form_terbuka() {
        HomePage.open();
        HomePage.menekanButtonMasuk();
        LoginPage.assertionUserBeradaDiHalamanURL(_loginURL);
        HomePage.klikButtonFloatingChatBox();
    }

    public void user_menekan_button_X_pada_chatbox_form() {
        HomePage.menekanButtonXUntukFloatingChatBox();
    }

    public void chat_box_form_akan_tertutup_kembali() {

    }

    //Scenario 3:
    public void user_user_menekan_chatbox_button_di_pojok_kanan_bawah_halaman() {
        HomePage.klikButtonFloatingChatBox();
    }

    public void ditampilkan_seluruh_elemen_chat_box_sesuai_dengan_deskripsi_PO() {
        HomePage.assertionSeluruhElementPadaChatBoxDitampilkanSesuaiDenganDeskripsiPO();
    }

    //Scenario 4:
    public void user_membuka_chat_box_di_halaman_Login_Flip_ID() {
        HomePage.open();
        HomePage.menekanButtonMasuk();
        LoginPage.assertionUserBeradaDiHalamanURL(_loginURL);
        HomePage.klikButtonFloatingChatBox();
    }

    public void user_memilih_untuk_meminta_bantuan_dengan_officer_di_chatbox(String officer) {
        HomePage.memilihCustomerServiceOfficer(officer);
    }

    public void customer_service_officer_yang_terpilih_adalah_officer(String officer) {
        HomePage.assertionCustomerServiceOfficerNameYangTerpilihAdalah(officer);
    }

    //Scenario 5:
    String chatSent;
    public void user_mengirim_chat_chat_di_chatbox_dengan_email_mail(String chat, String mail) {
        chatSent = chat+" "+HomePage.getCurrrentTimeMs();
        HomePage.mengirimkanPesanDiChatBox(mail,chatSent);
    }

    public void pesan_chat_beserta_email_mail_yang_telah_kita_kirim_tetera_di_chat_box_dialog(String chat, String mail) {
        HomePage.assertionPesanChatDanEmailTerteraDiChatBoxDialog(mail,chatSent);
    }

    //Scenario 6:
    public void user_mengirim_kembali_chat_chat_diikuti_dengan_emoji_random(String chat) {
        chatSent = "";
        chatSent = chat+" "+HomePage.getCurrrentTimeMs();
        HomePage.mengirimkanPesnDiChatBoxMelauiReplyInputFieldDenganEmoji(chatSent,"smiley_cat");
    }

    public void pesan_chat_dengan_emoji_yang_telah_kita_kirim_tetera_di_chat_box_dialog(String chat) {
        HomePage.assertionPesanChatDanEmojiTerteraDiChatBoxDialog(chatSent);
        //smiley cat code = \ uD83D\ uDE3AT   >>>> tanpa spasi setelah karakter \ >> dikasih spasi biar gk kebentuk emoji asli di IDE, biar ketulis kodenya
    }

    //Scenario 7:
    public void user_mengirim_kembali_chat_di_reply_input_field_pada_chatbox_dengan_String_sangat_panjang() {
        for (int i=0; i<10; i++){
            chatSent = "gkwlneglkwenglkwenglknwelkgnewlknglkwenglewnlgnewlkgngkwlneglkwenglkwenglknwelkgnewlknglkwenglewnlgnewlkgn"+
            "gkwlneglkwenglkwenglknwelkgnewlknglkwenglewnlgnewlkgngkwlneglkwenglkwenglknwelkgnewlknglkwenglewnlgnewlkgn";
            chatSent = chatSent+HomePage.getCurrrentTimeMs();
            HomePage.mengirimkanPesnDiChatBoxMelauiReplyInputField(chatSent);
        }
    }

    public void muncul_notifikasi(String notif) {
        HomePage.assertionMunculWarningErrorMessageChatBox(notif);
    }
}

package Steps;

import Pages.Dashboard.BerandaPages;
import Pages.FrontPages.LoginPage;
import Pages.SendMoney.SMDomesticPages;
import Utils.database;

public class TransactionSteps implements database {
    LoginPage LoginPage;
    BerandaPages BerandaPages;
    SMDomesticPages SMDomesticPages;

    //Scenario 1:
    public void user_berada_di_halaman_Dashboard_Flip_ID() {
        LoginPage.assertionUserBeradaDiHalamanURL(_berandaURL);
    }

    public void user_menekan_button_Kirim_Uang_berlogo_pesawat_terbang() {
        BerandaPages.klikButtonSendMoneyDomestic();
    }

    public void ditampilkan_modal_content_send_money_container() {
        BerandaPages.assertionDitampilkanModalContentSendMoney();
    }

    public void tedapat_button_Kirim_Uang_Tanpa_Verifikasi_dan_button_Verifikasi_Akun() {
        BerandaPages.assertionTerdapatButtonKirimUangDanVerifikasiAkun();
    }

    public void terdapat_button_TUTUP_pada_modal_content_send_money_container_tersebut() {
        BerandaPages.terdapatButtonTutupPadaModalDialogContainer();
    }

    //Scenario 2:
    public void user_telah_berhasil_membuka_modal_content_send_money_container() {
        BerandaPages.klikButtonSendMoneyDomestic();
    }

    public void user_menekan_button_Tutup() {
        BerandaPages.menekanButtonTutupPadaModalDialogSendMoney();
    }

    public void modal_content_send_money_container_tidak_ditampilkan_lagi() {
        BerandaPages.AssertionModalDialogSendMoneyTidakDitampilkanLagi();
    }

    //Scenario 3:
    public void user_menekan_button_Kirim_Uang_Tanpa_Verifikasi() {
        BerandaPages.klikButtonKirimUangTanpaVerifikasiDiMdoalDialogSendMoneyDomestic();
    }

    public void user_dialihkan_ke_halaman_Kirim_Uang() {
        SMDomesticPages.assertionUserBeradaDiHalamanURL(_sendMoneyDomestic);
        SMDomesticPages.kalauMunculPeringatanYakinMelanjutkanTransaksiDiluarJamOperationalKlikButton(true);
    }

    public void seluruh_element_yang_ditampilkan_mengikuti_deskripsi_PO() {
        SMDomesticPages.assertionSeluruhElementDitampilkanBerdasarkanDeskripsiPO();
    }

    //Scenario 4:
    public void user_berada_di_halaman_Kirim_Uang_Flip_ID() {
        BerandaPages.klikButtonSendMoneyDomestic();
        BerandaPages.klikButtonKirimUangTanpaVerifikasiDiMdoalDialogSendMoneyDomestic();
        SMDomesticPages.assertionUserBeradaDiHalamanURL(_sendMoneyDomestic);
        SMDomesticPages.kalauMunculPeringatanYakinMelanjutkanTransaksiDiluarJamOperationalKlikButton(true);
    }

    public void user_mengisi_semua_field_dengan_benar_dan_nominal_transfer_di_atas_5_ratus_ribu() {
        SMDomesticPages.mengisiSeluruhInputField("bri", "bca", String.valueOf(SMDomesticPages.getCurrrentTimeMs()),"10000000");
        SMDomesticPages.klikButtonOkDataSudahBenar();
    }

    public void user_akan_mendapatkan_error_dialog_notif(String notif) {
        SMDomesticPages.assertionUserMendapakanNotifikasiLimitTransaksi();
    }
}

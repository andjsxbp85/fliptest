package Tests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import Steps.TransactionSteps;

public class Transaction {
    @Steps TransactionSteps TransactionSteps;

    //Scenario 1:
    @Given("user berada di halaman 'Dashboard' Flip ID")
    public void user_berada_di_halaman_Dashboard_Flip_ID() {
        TransactionSteps.user_berada_di_halaman_Dashboard_Flip_ID();
    }

    @When("user menekan button 'Kirim Uang' berlogo pesawat terbang")
    public void user_menekan_button_Kirim_Uang_berlogo_pesawat_terbang() {
        TransactionSteps.user_menekan_button_Kirim_Uang_berlogo_pesawat_terbang();
    }

    @Then("ditampilkan modal content send money container")
    public void ditampilkan_modal_content_send_money_container() {
        TransactionSteps.ditampilkan_modal_content_send_money_container();
    }

    @Then("tedapat button 'Kirim Uang Tanpa Verifikasi' dan button 'Verifikasi Akun'")
    public void tedapat_button_Kirim_Uang_Tanpa_Verifikasi_dan_button_Verifikasi_Akun() {
        TransactionSteps.tedapat_button_Kirim_Uang_Tanpa_Verifikasi_dan_button_Verifikasi_Akun();
    }

    @Then("terdapat button 'TUTUP' pada modal content send money container tersebut")
    public void terdapat_button_TUTUP_pada_modal_content_send_money_container_tersebut() {
        TransactionSteps.terdapat_button_TUTUP_pada_modal_content_send_money_container_tersebut();
    }

    //Scenario 2:
    @Given("user telah berhasil membuka modal content send money container")
    public void user_telah_berhasil_membuka_modal_content_send_money_container() {
        TransactionSteps.user_telah_berhasil_membuka_modal_content_send_money_container();
    }

    @When("user menekan button 'TUTUP'")
    public void user_menekan_button_Tutup() {
        TransactionSteps.user_menekan_button_Tutup();
    }

    @Then("modal content send money container tidak ditampilkan lagi")
    public void modal_content_send_money_container_tidak_ditampilkan_lagi() {
        TransactionSteps.modal_content_send_money_container_tidak_ditampilkan_lagi();
    }

    //Scenario 3:
    @When("user menekan button 'Kirim Uang Tanpa Verifikasi'")
    public void user_menekan_button_Kirim_Uang_Tanpa_Verifikasi() {
        TransactionSteps.user_menekan_button_Kirim_Uang_Tanpa_Verifikasi();
    }

    @Then("user dialihkan ke halaman 'Kirim Uang'")
    public void user_dialihkan_ke_halaman_Kirim_Uang() {
        TransactionSteps.user_dialihkan_ke_halaman_Kirim_Uang();
    }

    @Then("seluruh element yang ditampilkan mengikuti deskripsi PO")
    public void seluruh_element_yang_ditampilkan_mengikuti_deskripsi_PO() {
        TransactionSteps.seluruh_element_yang_ditampilkan_mengikuti_deskripsi_PO();
    }

    //Scenario 4:
    @Given("user berada di halaman 'Kirim Uang' Flip ID")
    public void user_berada_di_halaman_Kirim_Uang_Flip_ID() {
        TransactionSteps.user_berada_di_halaman_Kirim_Uang_Flip_ID();
    }

    @When("user mengisi semua field dengan benar dan nominal transfer di atas 5 ratus ribu")
    public void user_mengisi_semua_field_dengan_benar_dan_nominal_transfer_di_atas_5_ratus_ribu() {
        TransactionSteps.user_mengisi_semua_field_dengan_benar_dan_nominal_transfer_di_atas_5_ratus_ribu();
    }

    @Then("user akan mendapatkan error dialog {string}")
    public void user_akan_mendapatkan_error_dialog_notif(String notif) {
        TransactionSteps.user_akan_mendapatkan_error_dialog_notif(notif);
    }
}

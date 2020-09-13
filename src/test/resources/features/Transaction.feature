@Transaction
Feature: Transaction
  As a User
  I want free interbank transfer
  So that i use flip and do transaction on it

  Background: Berhasil login sebagai Flip Tester dengan status Unverified Account di dashboard
    Given user berhasil login Flip ID sebagai Flip Tester

  @TestCaseKey=Flip-T48
  Scenario: 01 - Send money container exist when button 'Kirim Uang' at 'Dashboard' Page clicked using Unverified Account
    Given user berada di halaman 'Dashboard' Flip ID
    When user menekan button 'Kirim Uang' berlogo pesawat terbang
    Then ditampilkan modal content send money container
    And tedapat button 'Kirim Uang Tanpa Verifikasi' dan button 'Verifikasi Akun'
    And terdapat button 'TUTUP' pada modal content send money container tersebut

  @TestCaseKey=Flip-T49
  Scenario: 02 - Click button 'TUTUP' at 'Send Money' modal container
    Given user telah berhasil membuka modal content send money container
    When user menekan button 'TUTUP'
    Then modal content send money container tidak ditampilkan lagi

  @TestCaseKey=Flip-T50
  Scenario: 03 - All elements at 'Kirim Uang' pages is followig PO Description
    Given user telah berhasil membuka modal content send money container
    When user menekan button 'Kirim Uang Tanpa Verifikasi'
    Then user dialihkan ke halaman 'Kirim Uang'
    And seluruh element yang ditampilkan mengikuti deskripsi PO

  @TestCaseKey=Flip-T51
  Scenario: 04 - Forcing send money above 5 hundred thousand will get Limit Transaction Error
    Given user berada di halaman 'Kirim Uang' Flip ID
    When user mengisi semua field dengan benar dan nominal transfer di atas 5 ratus ribu
    Then user akan mendapatkan error dialog 'Limit Transaction'

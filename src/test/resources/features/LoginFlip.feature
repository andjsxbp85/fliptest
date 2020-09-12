@Login
Feature: Login Flip
  As a User
  I want login pages on flip web application
  So that I can access my account and do any activities on it

  @TestCaseKey=Flip-T1
  Scenario: 01 - Login Pages Exist
    Given user membuka halaman utama Flip ID
    When user menekan button 'Masuk' di pojok kanan atas halaman utama
    Then user diarahkan ke halaman login Flip
    And seluruh elemen pada halaman login ditampilkan dan sesuai dengan deskripsi Product Owner

   @TestCaseKey=Flip-T2
  Scenario: 02 - User will redirected to Flip main page if flip main icon clicked
    Given user berada di halaman 'Login' Flip ID
    When user menekan gambar icon Flip di pojok kiri atas halaman login
    Then user akan di arahkan ke halaman utama Flip ID

   @TestCaseKey=Flip-T3
  Scenario: 03 - User will redirected to "Sign Up" page if button "DAFTAR" clicked
    Given user berada di halaman 'Login' Flip ID
    When user menekan button 'Daftar' di pojok kanan atas halaman login
    Then user akan di arahkan ke halaman Sign Up

   @TestCaseKey=Flip-T4
  Scenario Outline: 04 - All hyperlink on Flip login pages exist
    Given user berada di halaman 'Login' Flip ID
    When user menekan hyperlink <activelink> pada halaman login Flip
    Then user akan diarahkan ke halaman <urlpages> dari hyperlink tersebut
    Examples:
    |activelink|urlpages|
    |Lupa password?|https://flip.id/lupa-password|
    |di sini|https://flip.id/signup|
    |Tutorial|https://flip.id/site/tutorial|
    |Cara Kerja|https://flip.id/start|
    |FAQ|https://flipid.zendesk.com/hc/id|

  @TestCaseKey=Flip-T5
  Scenario Outline: 05 - Success login with correct email and password
    Given user berada di halaman 'Login' Flip ID
    When login Flip dengan email dan password yang benar dan sesuai <logindata>
    Then user akan diarahkan ke halaman beranda flip sebagai <logindata>
    Examples:
    |logindata|
    |Flip Tester|
    #|Tester Flip|

  @TestCaseKey=Flip-T6
  Scenario: 06 - Attempt to login where user leaves email and password fields blank
    Given user berada di halaman 'Login' Flip ID
    When user mencoba login dengan membiarkan field email dan password kosong
    Then user tetap berada di halaman 'Login' Flip ID
    And border line pada input field email berwarna merah dengan notifikasi 'Email harus diisi'
    And border line pada input field password berwarna merah dengan notifikasi 'Password harus diisi'

  @TestCaseKey=Flip-T7
  Scenario Outline: 07 - Failed login Flip due to email and password doesnt match
    Given user berada di halaman 'Login' Flip ID
    When login Flip dengan email <mail> dan password <pass> yang tidak cocok
    Then box error message gagal login karena email atau password salah ditampilkan
    Examples:
    |mail|pass|
    |fliploginerror@gmail.com|RANDOM STRING|

  @TestCaseKey=Flip-T8
  Scenario Outline: 08 - Failed login Flip more than 3 times
    Given user berada di halaman 'Login' Flip ID
    When login Flip dengan email <mail> dan password <pass> salah lebih dari 3 kali
    Then user tetap berada di halaman 'Login' Flip ID
    And box error message gagal login lebih dari 3 kali berwarna merah ditampilkan
    Examples:
      |mail|pass|
      |anjasmuhamadb123@gmail.com|RANDOM STRING|

  Scenario Outline: X - Background success login
    Given user berhasil login Flip ID sebagai <user>
    Examples:
      |user|
      |Flip Tester|
      #|Tester Flip|
      #|Flip Login Error|
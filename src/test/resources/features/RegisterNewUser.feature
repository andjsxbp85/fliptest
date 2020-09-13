@Register
Feature: SignUp Flip
  As a User
  I want to create new user
  So that I can access Flip ID with my own account

  @TestCaseKey=Flip-T9
  Scenario: 01 - Sign Up Pages Exist
    Given user berada di halaman 'Login' Flip ID
    When user menekan button 'Daftar' di pojok kanan atas halaman login
    Then user akan di arahkan ke halaman Sign Up
    And seluruh elemen pada halaman Sign Up ditampilkan dan sesuai dengan deskripsi Product Owner

  @TestCaseKey=Flip-T10
  Scenario: 02 - All input fields left blank when user click "Daftar" button
    Given user berada di halaman 'Sign Up' Flip ID
    When user menekan button 'Daftar' di form sign up dengan membiarkan semua input fields kosong
    Then border color di semua input fields akan berwarna merah dengan notif text di bawah fields
    And user tetap berada di halaman 'Sign Up'

  @TestCaseKey=Flip-T11
  Scenario: 03 - Randomly left blank some input fields and the other fields filled in properly
    Given user berada di halaman 'Sign Up' Flip ID
    When user mendaftar dengan sebagian input fields terisi dan membiarkan sebagian lainya kosong
    Then setiap fields yang terisi kosong akan berwarna merah pada border color dengan notif text di bawah fields
    And user tetap berada di halaman 'Sign Up'

  @TestCaseKey=Flip-T12
  Scenario Outline: 04 - Fill in "Nama" field with alphabet and special character in combination (without click button 'DAFTAR')
    Given user berada di halaman 'Sign Up' Flip ID
    When user mengisi input field 'Nama' dengan campuran alphabet dan special character <nama>
    And mengisi input field lainya dengan format yang benar
    Then user mendapatkan input field 'Nama' berwarna merah dengan notif text 'Format nama tidak benar'
    Examples:
      |nama|
      |24234\\]{_)-|
      |2423[]][Anjas Muhammad 234|

  @TestCaseKey=Flip-T13
  Scenario Outline: 05 - Fill in "Nama" field with alphabet and special character in combination (validation after click button 'DAFTAR')
    Given user berada di halaman 'Sign Up' Flip ID
    When user mengisi input field 'Nama' dengan campuran alphabet dan special character <nama>
    And mengisi input field lainya dengan format yang benar dilanjutkan menekan button 'DAFTAR'
    Then user mendapatkan warn message box untuk error input field Name
    Examples:
      |nama|
      #|24234\\]{_)-| >> sudah dihold secara front end
      |2423[]][Anjas Muhammad 234|

  @TestCaseKey=Flip-T14
  Scenario Outline: 06 - Fill in "Nama" field with alphabetbet only but preceded or followed with some space character
    Given user berada di halaman 'Sign Up' Flip ID
    When user mengisi input field 'Nama' dengan alphabet saja namun didahului atau diakhiri oleh beberapa spasi <nama>
    And melakukan kursor klik di sembarang input field lainya
    Then semua spasi setelah dan sebelum <nama> pada input field 'Nama' otomatis terhapus menjadi <autoname> saja
    Examples:
      |nama|autoname|
      |                  Anjas Muhammad|Anjas Muhammad|
      |Anjas Bangun   |Anjas Bangun|
      |    Anjas Muhammad Bangun    |Anjas Muhammad Bangun|


  @TestCaseKey=Flip-T15
  Scenario Outline: 07 - Fill in "Email" field with incorrect mail format
    Given user berada di halaman 'Sign Up' Flip ID
    When user mengisi input field 'Email' <mail> dengan dengan format yang tidak sesuai
    And melakukan kursor klik di sembarang input field lainya
    Then input field 'Email' akan berwarna merah dengan pesan notifikasi 'Format email tidak benar'
    Examples:
      |mail|
      |anjas@@@@.com|
      |anjas@*bangun.com|
      |anjasku    test@bangun.com|

  @TestCaseKey=Flip-T16
  Scenario Outline: 08 - Fill in "Email" field with some space character
    Given user berada di halaman 'Sign Up' Flip ID
    When user mengisi input field 'Email' <mail> dengan dengan beberapa sisipan karakter spasi
    And melakukan kursor klik di sembarang input field lainya
    Then semua karakter spasi akan terhapus secara otomatis menjadi <automail> dan user tidak mendapatkan notifikasi error
    Examples:
      |mail|automail|
      |                  anjasmbangun@bangun.com|anjasmbangun@bangun.com|
      |anjasmbangun@gmail.com     |anjasmbangun@gmail.com|
      |         anjaskutest@bangun.com             |anjaskutest@bangun.com|

  @TestCaseKey=Flip-T17
  Scenario: 09 - Fill in "Password" field with less than 8 character (without click 'DAFTAR' Button)
    Given user berada di halaman 'Sign Up' Flip ID
    When user mengisi input field 'Password' kurang dari 8 karakter
    And melakukan kursor klik di sembarang input field lainya
    Then user mendapati input field 'Password' berwarna merah dan notifikasi 'Password minimal 8 karakter'

  @TestCaseKey=Flip-T18
  Scenario: 10 - Fill in "Password" field with less than 8 character (validation after click button 'DAFTAR')
    Given user berada di halaman 'Sign Up' Flip ID
    When user mengisi input field 'Password' kurang dari 8 karakter
    And  mengisi input field lainya selain field password dengan format yang benar dilanjutkan menekan button 'DAFTAR'
    Then user mendapatkan warn message box untuk error input field Password

  @TestCaseKey=Flip-T19
  Scenario: 11 - Pergi ke halaman Login dari button 'Masuk' pada halaman SigUp
    Given user berada di halaman 'Sign Up' Flip ID
    When  User mengklik button 'Masuk' yang ada di halaman 'SignUp'
    Then  user diarahkan ke halaman 'Login' Flip ID

  @TestCaseKey=Flip-T20
  Scenario Outline: 12 - Password will shown if button 'LIHAT' clicked once and hide again if button 'SEMBUNYIKAN' clicked after it
    Given user berada di halaman 'Sign Up' Flip ID
    When  menekan button 'LIHAT' setelah mengisi input field 'Password' dengan beberapa karakter <pass>
    Then  text password yang diperlihatkan bukan bintang-bintang dan sesuai dengan yang diketik <pass>
    And text password akan kembali hidden dalam bentuk bintang-bintang apabila button 'SEMBUNYIKAN' diklik kembali
    Examples:
      |pass|
      |1230|
      |SayaMenulisPassLebihDari8Char|

  @TestCaseKey=Flip-T21
  Scenario: 13 - Pop up search country code for Phone Number shown when user click cluntry flag
    Given user berada di halaman 'Sign Up' Flip ID
    When  user menekan button flag country code di sebelah field phone number
    Then  muncul pop up dialog 'Cari Kode Negara' dengan semua elemen ditampilkan sesuai deskripsi PO

  @TestCaseKey=Flip-T22
  Scenario Outline: 14 - Pick a country code from country picker modal dialog for phone number
    Given user berada di halaman 'Sign Up' Flip ID
    When  user memilih kode negara dengan pencarian <country> pada modal dialog di halaman 'SignUp'
    Then modal dialog country code picker disembunyikan dan negara yang ditampilkan sesuai negara yang dipilih <countryShortCode>
    Examples:
    |country|countryShortCode|
    |Singapore|SG|

  @TestCaseKey=Flip-T23
  Scenario Outline: 15 - Search country name and country code will get the same search result
    Given user berada di halaman 'Sign Up' Flip ID
    When  user mencari nama negara <CName> di kotak pencarian dan mendata hasil pencarian
    And user kembali mencari kode negara <CCode> di kotak pencarian dan mendata hasil pencarian
    Then didapatkan hasil pencarian dengan nama negara <CName> maupun kode negara <CCode> adalah sama
    Examples:
      |CName|CCode|
      |Indonesia|+62|
      |Singapore|+65|

  @TestCaseKey=Flip-T24
  Scenario Outline: 16 - Click button 'Tutup' at Country Search Dialog will not change the current country value
    Given user berada di halaman 'Sign Up' Flip ID
    When  user memilih kode negara dengan pencarian <country> pada modal dialog di halaman SignUp
    And user mengklik button flag country code kembali namun langsung menutup modal dialog yang muncul
    Then nilai value country saat ini adalah <country> dengan short code <SC> dan tidak berubah sesuai pilihan awal
    Examples:
      |country|SC|
      |Singapore|SG|

  @TestCaseKey=Flip-T25
  Scenario Outline: 17 - SignUp using registered phone number
    Given user berada di halaman 'Sign Up' Flip ID
    When user mendaftar sebagai pengguna baru dengan nomor handphone yang telah terdaftar <phoneNumber>
    Then didapatkan error box message dengan notifikasi "Nomor handphone sudah terdaftar. Silakan masuk dengan akun yang menggunakan nomor tersebut."
    Examples:
      |phoneNumber|
      |085934527543|

  @TestCaseKey=Flip-T26
  Scenario Outline: 18 - SignUp using registered phone number but different country code
    Given user berada di halaman 'Sign Up' Flip ID
    When registrasi user baru dengan nomor handphone yang telah terdaftar <phoneNumber> tetapi beda country <country>
    Then user akan dialihkan ke halaman verifikasi nomor handphone dengan nomor tujuan <countryCode> ditambah <phoneNumber>
    Examples:
      |phoneNumber|country|countryCode|
      |085934527543|Japan|+81|

  @TestCaseKey=Flip-T27
  Scenario: 19 - Sukses Registrasi pengguna baru hingga mengirim kode OTP via SMS atau Whatsapp untuk negara Indonesia
    Given user berada di halaman 'Sign Up' Flip ID
    When user mengisi seluruh input field registrasi dengan baik dan benar untuk negara Indonesia
    Then user dialihkan ke halaman pilihan verifikasi melalui whatsapp atau sms
    And apabila user memilih verifikasi via whatsapp ataupun sms, akan dialihkan lagi ke halaman verifikasi akhir no hp

  @TestCaseKey=Flip-T28
  Scenario: 20 - Click Flip ID brand icon will redirected user to home page
    Given user berada di halaman 'Sign Up' Flip ID
    When use mengklik icon brand Flip ID di pojok kiri atas halaman 'SignUp'
    Then user akan diarahkan ke halaman utama Flip ID

  @TestCaseKey=Flip-T29
  Scenario Outline: 21 - hyperlink di footer singup page
    Given user berada di halaman 'Sign Up' Flip ID
    When user menekan hyperlink <activelink> pada halaman login Flip
    Then user akan diarahkan ke halaman <urlpages> dari hyperlink tersebut
    Examples:
      |activelink|urlpages|
      |Tutorial|https://flip.id/site/tutorial|
      |Cara Kerja|https://flip.id/start|
      |FAQ|https://flipid.zendesk.com/hc/id|
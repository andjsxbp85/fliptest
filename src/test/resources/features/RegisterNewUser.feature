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

#  @TestCaseKey=Flip-T10
#  Scenario: 02 - All input fields left blank when user click "Daftar" button
#    Given user berada di halaman 'Sign Up' Flip ID
#    When user menekan button 'Daftar' di form sign up dengan membiarkan semua input fields kosong
#    Then border color di semua input fields akan berwarna merah dengan notif text di bawah fields
#    And user tetap berada di halaman 'Sign Up'
#
#  @TestCaseKey=Flip-T11
#  Scenario: 03 - Randomly left blank some input fields and the other fields filled in properly
#    Given user berada di halaman 'Sign Up' Flip ID
#    When user mendaftar dengan sebagian input fields terisi dan membiarkan sebagian lainya kosong
#    Then setiap fields yang terisi kosong akan berwarna merah pada border color dengan notif text di bawah fields
#    And user tetap berada di halaman 'Sign Up'
#
#  @TestCaseKey=Flip-T12
#  Scenario Outline: 04 - Fill in "Nama" field with alphabet and special character in combination
#    Given user berada di halaman 'Sign Up' Flip ID
#    When user mengisi input field 'Nama' dengan campuran alphabet dan special character <nama>
#    And mengisi input field lainya dengan format yang benar
#    Then user mendapatkan input field 'Nama' berwarna merah dengan notif text 'Format nama tidak benar'
#    Examples:
#      |nama|
#      |2423[]][Anjas Muhammad 234|
#
#  @TestCaseKey=Flip-T13
#  Scenario Outline: 05 - Fill in "Nama" field with alphabetbet only but preceded or followed with some space character
#    Given user berada di halaman 'Sign Up' Flip ID
#    When user mengisi input field 'Nama' dengan alphabet saja namun didahului atau diakhiri oleh beberapa spasi <nama>
#    And melakukan kursor klik di sembarang input field lainya
#    Then semua spasi setelah dan sebelum <nama> pada input field 'Nama' otomatis terhapus menjadi <autoname> saja
#    Examples:
#      |nama|autoname|
#      |   Anjas Muhammad|Anjas Muhammad|
#      |Anjas Bangun   |Anjas Bangun|
#      |    Anjas Muhammad Bangun    |Anjas Muhammad Bangun|
#
#
#  @TestCaseKey=Flip-T14
#  Scenario Outline: 06 - Fill in "Email" field with incorrect mail format
#    Given user berada di halaman 'Sign Up' Flip ID
#    When user mengisi input field 'Email' <mail> dengan dengan format yang tidak sesuai
#    And ketika user melakukan kursor klik di sembarang input field lainya
#    Then input field 'Email' akan berwarna merah dengan pesan notifikasi 'Format email tidak benar'
#    Examples:
#      |mail|
#      |anjas@@@@.com|
#      |anjas@*bangun.com|
#
#  Scenario Outline: 07 - Fill in "Email" field with some space character
#    Given user berada di halaman 'Sign Up' Flip ID
#    When user mengisi input field 'Email' <mail> dengan dengan beberapa sisipan karakter spasi
#    And ketika user melakukan kursor klik di sembarang input field lainya
#    Then semua karakter spasi akan terhapus secara otomatis dan user tidak mendapatkan notifikasi error
#    Examples:
#      |mail|
#      |   anjasmbangun@bangun.com|
#      |anjasmbangun@bangun.com     |
#      |anjasku    @bangun.com|
#
#  Scenario: 08 - Fill in "Password" field with less than 8 character (without click 'DAFTAR' Button)
#    Given user berada di halaman 'Sign Up' Flip ID
#    When user mengisi input field 'Password' kurang dari 8 karakter
#    And ketika user melakukan kursor klik di sembarang input field lainya
#    Then user mendapati input field 'Password' berwarna merah dan notifikasi 'Password minimal 8 karakter'
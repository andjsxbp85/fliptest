@Login
Feature: Login Flip
  As a User
  I want login pages on flip web application
  So that I can access my account and do any activities on it

  @TestCaseKey=Flip-T1
  Scenario: 01 - Login Pages Exist
    Given user membuka halaman utama Flip ID
    When user menekan button "Masuk" di pojok kanan atas halaman utama
    Then user diarahkan ke halaman login Flip
    And seluruh elemen pada halaman login ditampilkan dan sesuai dengan deskripsi Product Owner

  Scenario: 02 - User will redirected to Flip main page if flip main icon clicked
    Given user berada di halaman login Flip ID
    When user menekan gambar icon Flip di pojok kanan atas halaman login
    Then user akan di arahkan ke halaman utama Flip ID

  Scenario: 03 - User will redirected to "Sign Up" page if button "DAFTAR" clicked
    Given user berada di halaman login Flip ID
    When user menekan gambar icon Flip di pojok kanan atas halaman login
    Then user akan di arahkan ke halaman utama Flip ID

  Scenario Outline: 04 - All hyperlink on Flip lgin pages exist
    Given user berada di halaman "Login" Flip ID
    When user menekan hyperlink <activelink> pada halaman login Flip
    Then user akan diarahkan ke halaman <urlpages> dari hyperlink tersebut
    Examples:
    |activelink|urlpages|
    |Lupa password?|https://flip.id/lupa-password|
    |di sini|https://flip.id/signup|
    |Tutorial|https://flip.id/site/tutorial|
    |Cara Kerja|https://flip.id/start|
    |FAQ|https://flipid.zendesk.com/hc/id|

  Scenario Outline: 05 - Success login with correct email and password
    Given user berada di halaman "Login" Flip ID
    When login Flip dengan email dan password yang benar dan sesuai <logindata>
    Then user akan diarahkan ke halaman dashboard flip
    Examples:
    |logindata|
    |Flip Tester|
    |Tester Flip|

  Scenario Outline: 06 - Failed login Flip due to wrong email and password
    Given user berada di halaman "Login" Flip ID
    When login Flip dengan email <mail> dan password <pass> yang tidak cocok
    Then user akan diarahkan ke halaman dashboard flip
    Examples:
    |mail|pass|
    |flipidtester@gmail.com|FWEFewfweFWEF32423R|
    |testerflipid@gmail.com|wgweg23gsgg24SDFFB|
    |testerflipid@gmail.com|RANDOM STRING|

  Scenario Outline: 07 - Failed login Flip more than 3 times
    Given user berada di halaman "Login" Flip ID
    When login Flip dengan email <mail> dan password <pass> yang tidak cocok lebih dari 3 kali
    Then user tetap berada di halaman "Login" Flip ID
    And box error message gagal login berwarna merah ditampilkan
    Examples:
      |mail|pass|
      |flipidtester@gmail.com|FWEFewfweFWEF32423R|
# new feature
# Tags: optional

Feature: Forget Password
  As a User
  I want to reset my password due forgetfulness
  So that I can access back my forgotten account

#  @TestCaseKey=Flip-T30
#  Scenario: 01 - All elements at 'Lupa Password' page shown and following PO description
#    Given user berada di halaman 'Login' Flip ID
#    When user menekan hyperlink Lupa password? pada halaman login Flip
#    Then user dialihkan ke halaman 'Lupa Password' dengan seluruh element halaman ditampilkan mengikuti deskripsi PO
#
#  @TestCaseKey=Flip-T31
#  Scenario: 02 - User focusing cursor at email field then click on random random position
#    Given user berada di halaman 'Reset Password' Flip ID
#    When mengklik kursor di input field email tanpa mengisinya kemudian melakukan klik di sembarang posisi
#    Then user mendapatkan border color pada field input email berwarna merah dengan notifikasi 'Email harus diisi'
#    And button 'RESET PASSWORD' menjadi disabled
#
#  @TestCaseKey=Flip-T32
#  Scenario: 03 - User leaves input field email blank for reset password
#    Given user berada di halaman 'Reset Password' Flip ID
#    When user membiarkan input field email kosong dan langsung menekan button 'RESET PASSWORD'
#    Then user tetap berada di halaman 'Reset Password'
#    And user mendapatkan border color pada field input email berwarna merah dengan notifikasi 'Email harus diisi'
#    And button 'RESET PASSWORD' berubah menjadi disabled
#
#  @TestCaseKey=Flip-T33
#  Scenario Outline: 04 - User input wrong email format at input field email then click on random random position
#    Given user berada di halaman 'Reset Password' Flip ID
#    When mengisi input field email dengan format yang salah <mail> dan mengklik kursor di sembarang posisi
#    Then button 'RESET PASSWORD' berubah menjadi disabled
#    Examples:
#    |mail|
#    |wfwef   wefwef.com|
#
#  @TestCaseKey=Flip-T34
#  Scenario Outline: 05 - User fill in wrong email format then force click button 'RESET PASSWORD'
#    Given user berada di halaman 'Reset Password' Flip ID
#    When mengisi input field email dengan format yang salah <mail> dan tetap memfokuskan kursor di field email
#    Then button 'RESET PASSWORD' berubah menjadi disabled
#    And ketka user tetap berusaha menekan button 'RESET PASSWORD', user tetap di halaman yang sama tanpa ada perubahan
#    Examples:
#    |mail|
#    |wfwef   wefwef.com|

  @TestCaseKey=Flip-T35
  Scenario Outline: 06 - User will get email notification after reset password at 'Lupa Password' Page
    Given user berada di halaman 'Reset Password' Flip ID
    When user memasukkan email <mail> yang ingin direset passwordnya pada input field email
    Then user akan mendapatkan email notifikasi untuk reset password ketika masuk ke akun manajemen emailnya <mail>
    Examples:
    |mail|
    |flipidtester@gmail.com|

  @TestCaseKey=Flip-T36
  Scenario Outline: 07 - Subject and Content of email notification for reset password are correct
    Given user telah melakukan request untuk reset password akun flip pada email <mail>
    When user membuka email notifikasi reset password akun flip untuk email <mail>
    Then didapatkan seluruh subjek, email pengirim, dan content email sesuai dengan deskripsi PO
    Examples:
      |mail|
      |flipidtester@gmail.com|

  @TestCaseKey=Flip-T37
  Scenario Outline: 08 - Hyperlink for reset password at mail content can be accessed
    Given user telah melakukan request untuk reset password akun flip pada email <mail>
    When user membuka email notifikasi reset password akun flip untuk email <mail>
    And user menekan hyperlink untuk melkukan reset password di body content email
    Then user diarahkan ke laman reset password yang aktif dan seluruh elemen ditampilkan sesuai deskripsi PO
    Examples:
      |mail|
      |flipidtester@gmail.com|

  @TestCaseKey=Flip-T38
  Scenario: 09 - Click Flip ID brand icon will redirected user to home page
    Given user berada di halaman 'Reset Password' Flip ID
    When user mengklik icon brand Flip ID di pojok kiri atas halaman 'Reset Password'
    Then user akan diarahkan ke halaman utama Flip ID

  @TestCaseKey=Flip-T39
  Scenario Outline: 10 - hyperlink di footer singup page
    Given user berada di halaman 'Sign Up' Flip ID
    When user menekan hyperlink <activelink> pada halaman login Flip
    Then user akan diarahkan ke halaman <urlpages> dari hyperlink tersebut
    Examples:
      |activelink|urlpages|
      |Tutorial|https://flip.id/site/tutorial|
      |Cara Kerja|https://flip.id/start|
      |FAQ|https://flipid.zendesk.com/hc/id|
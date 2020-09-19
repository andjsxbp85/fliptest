@FloatChatBox
Feature: Floating Chat Box
  As a User
  I want a chat box helper
  So that I can get help from Flip officer

#  @TestCaseKey=Flip-T40
#  Scenario Outline: 01 - Float chat box exist and shown on bottom right corner of any pages
#    Given user membuka halaman utama Flip ID
#    When user membuka halaman tertentu <halaman> untuk url <url>
#    Then terdapat floating chat box di setiap  <halaman> untuk url <url> tersebut
#    Examples:
#    |halaman|url|
#    |Main Pages|https://flip.id/|
##    |Login Pages|https://flip.id/login/|
##    |SignUp Pages|https://flip.id/signup/|
##    |Biaya Pages|https://flip.id/biaya/|
##    |Bantuan Pages|https://flipid.zendesk.com/hc/id/|
##    |Lupa Password Pages|https://flip.id/lupa-password/|
##    |Tutorial Pages|https://flip.id/tutorial/|
##    |Cara Kerja pages|https://flip.id/start/|
##    |FAQ Pages|https://flipid.zendesk.com/hc/id/|
#
#  @TestCaseKey=Flip-T41
#  Scenario: 02 - Chat box form will closed if user click button 'X'
#    Given user ada di halaman 'Login' Flip ID dengan chat box form terbuka
#    When user menekan button 'X' pada chatbox form
#    Then chat box form akan tertutup kembali
#
#  @TestCaseKey=Flip-T42
#  Scenario: 03 - All chatbox element shown following PO Description
#    Given user berada di halaman 'Login' Flip ID
#    When user user menekan chatbox button di pojok kanan bawah halaman
#    Then ditampilkan seluruh elemen chat box sesuai dengan deskripsi PO
#
#  @TestCaseKey=Flip-T43
#  Scenario Outline: 04 - Selected Customer Service Officer is based on user desired click on "message us" form
#    Given user membuka chat box di halaman 'Login' Flip ID
#    When user memilih untuk meminta bantuan dengan <officer> di chatbox
#    Then customer service officer yang terpilih adalah <officer>
#    Examples:
#      |officer|
#      |Bantuan Akun|
#      |Bantuan Transaksi|
#      |Bantuan Pengguna Baru Flip|

  @TestCaseKey=Flip-T45
  Scenario Outline: 05 - Sending message on chatbox
    Given user membuka chat box di halaman 'Login' Flip ID
    When user memilih untuk meminta bantuan dengan <officer> di chatbox
    And user mengirim chat <chat> di chatbox dengan email <mail>
    Then pesan <chat> beserta email <mail> yang telah kita kirim tetera di chat box dialog
    Examples:
      |officer|mail|chat|
      |Bantuan Akun|anjasmuhamadb123@gmail.com|Test Chat Box Flip +RandomizerString|

  @TestCaseKey=Flip-T46
  Scenario Outline: 06 - Sending smiley emoticon on chat box
    Given user membuka chat box di halaman 'Login' Flip ID
    When user memilih untuk meminta bantuan dengan <officer> di chatbox
    And user mengirim chat <chat> di chatbox dengan email <mail>
    And user mengirim kembali chat <chat> diikuti dengan emoji random
    Then pesan <chat> dengan emoji yang telah kita kirim tetera di chat box dialog
    Examples:
      |officer|mail|chat|
      |Bantuan Akun|anjasmuhamadb123@gmail.com|Test Chat Emoji +RandomizerString +Emoji|

  @TestCaseKey=Flip-T47
  Scenario Outline: 07 - Sending very long message on chat box
    Given user membuka chat box di halaman 'Login' Flip ID
    When user memilih untuk meminta bantuan dengan <officer> di chatbox
    And user mengirim chat <chat> di chatbox dengan email <mail>
    And user mengirim kembali chat di reply input field pada chatbox dengan String sangat panjang
    Then muncul notifikasi 'Uh oh, this message is too long and will be sent as a .txt file instead.'
    Examples:
      |officer|mail|chat|
      |Bantuan Akun|anjasmuhamadb123@gmail.com|Test Chat Emoji +RandomizerString +Emoji|
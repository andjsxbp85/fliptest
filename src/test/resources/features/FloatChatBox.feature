@Login
Feature: Floating Chat Box
  As a User
  I want a chat box helper
  So that I can get help from Flip officer

  @TestCaseKey=Flip-T40
  Scenario Outline: 01 - Float chat box exist and shown on bottom right corner of any pages
    Given user membuka halaman utama Flip ID
    When user membuka halaman tertentu <halaman> untuk url <rl>
    Then terdapat floating chat box di setiap  <halaman> untuk url <rl> tersebut
    Examples:
    |halaman|url|
    |Main Pages|https://flip.id/|
    |Login Pages|https://flip.id/login|
    |SignUp Pages|https://flip.id/signup|
    |Biaya Pages|https://flip.id/site/biaya|
    |Bantuan Pages|https://flipid.zendesk.com/hc/id|
    |Lupa Password Pages|https://flip.id/lupa-password|
    |Tutorial Pages|https://flip.id/site/tutorial|
    |Cara Kerja pages|https://flip.id/start|
    |FAQ Pages|https://flipid.zendesk.com/hc/id|

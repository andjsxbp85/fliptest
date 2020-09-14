# Flip ID Automation Test
:art: Tes ini dibuat oleh Anjas Muhammad Bangun untuk tujuan proses recruitment di Flip ID sebagai Quality Assurance (Automation)

## Environment Test:
**Website https://flip.id/**

## Report Test
**Semua report test secara otomatis ada pada http://anjasmbangun.com/fliptest**
**Apabila link tersebut tidak dapat diakses, maka**
```
>Download file report di bit.ly/fliptestreport
>Extract file "Tes QA Engineer_(Anjas Muhammad Bangun).zip" ke dalam folder
>Buka folder extract tersebut dan carilah file index.html
>Buka file index.html dengan browser, semisal Google Chrome (double klik file index.html atau klik kanan file dan open with browser)
```

## Summary
**Jumlah Tes: 5 Fitur, 51 Test Case, dan 78 Scenario**

**Fitur yang dites:**
* (1) Login Flip ID
* (2) Sign Up New User Flip ID
* (3) Forget Password
* (4) Floating Chat Box
* (5) Transaction

```
Framework dan Utilitas yang digunakan: Java JDK 8, Maven, Cucumber, JUnit, Selenium, Serenity, Chrome Driver, Gherkin Syntax, BDD, JavaScript Executor
```

## Test Coverage
**68% Passed, 26% Failed, 6% Broken**

## Bug and Issues
> [MEDIUM] 1. Format nama tidak benar, belum sepenuhnya dapat dihandle secara front end. Nama yang tidak ada alphabet, 
misal nama “24234\\]{_)- “ sudah bisa dihandle fornt end, tapi nama terselip 1 alphabet saja seperti 2423[]][Anjas Muhammad23 
itu lolos pengecekan secara front end, tapi untungnya bisa dihandle secara back end setelah menekan button “DAFTAR”. 
Hal ini bisa menurunkan sedikit performa server
 
 > [LOW] 2. Belum ada syarat minimal karakter di field nama, diisi 1 karakter saja masih bisa (optional, bisa saja nama orang memang 1 huruf)
 
 > [MEDIUM] 3. Ketika user memasukan email dengan beberapa spasi di awal maupun diakhir email, misal "   anjasmuhamadb123@gmail.com" atau "anjasmuhamadb123@gmail.com    "
 maka belum ada fitur auto delete whitespace di sebelum dan sesudah email.
 
 > [LOW] 4. Icon flip di halaman login form masih mengarah ke halaman login, sehingga ketika ditekan tidak ada hasil apapun karena tetap di halaman yang 
 sama dan tidak ada interaktif web. Sebaiknya href di icon flip pojok kiri atas diarahkan ke halaman utama flip.
 
> [LOW] 5. Mengisi signup form passwrod kurang dari 8 karakter sebaiknya juga dihandle di proses front end, tidak di back end agar server bisa lebih optimal. 
Saat ini bila mengisi password kurang dari 8 karakter sebelum menekan button ‘Daftar’ (klik di sembarang posisi setelah mengisi input field password) atau 
ketika mengisi field passwor paling akhir setelah field lainya terisi, masih diproes secara back end, field lainya (mengisi no hp kurang dari 8 karakter) 
sudah dihandle secara front end (Medium)

> [LOW] 6. Mengisi input field email di Login Form dengan format tidak benar dan password kurang dari 8 karakter (karena saat daftar hanya diperbolehkan minimal 8 
karakter juga) saat sign in belum dihandle secara front end. Hal ini sebaiknya dilakukan agar server bisa optimal (saat terjadi kesalahan format input, 
tidak perlu koneksi ke server). Sepertinya sudah secara front end (karena tidak ada simbol loading di button box ‘MASUK’), 
tetapi notifikasinya kurang detail.

> [MEDIUM] 7. Ketika user mengisi form "Selamat Bergaung di Flip“ kemudian klik di sembarang titik di luar form, maka form otomatis terclose sendiri dan 
data tidak tersimpan (ketika ingin mengisi lagi, dengan klik button ‘Kirim Uang’ untuk memunculkan dan menampilkan kembali form tersebut, 
data hilang semua adn harus dimulai dari awal) >> secara ux sangat terkesan buruk karena setelah milih tanggal lahir yg pop up lumayan menutupi body, 
user akan lebih sering mengklik ke luar form, padahal ada button “NANTI SAJA” di bawah form untuk mengclose tanpa menyimmpan data

> [MEDIUM] 8.Ketika gagal login 3x, user disuruh menunggu 15 menit atau reset password. Saat sudah reset password dan mencoba login dengan pass baru, 
user tetap mendapatkan notif untuk menunggu 15 menit, padahal baru direset password. 

> [ISSUE] 9. ID html untuk icon no hp kode negara (flag), diberikan id = password yang kurang relevan

> [ISSUE] 10. kata-kata “Dengan mendaftar saya telah setuju dengan Syarat & Ketentuan serta Kebijakan Privasi yang ditetapkan oleh Flip” belum diberikan 
checkbox dan posisinya di bawah primary button ‘DAFTAR’ >> kurang tepat secara UI/UX

> [HIGH] 11. Pasti gagal load halaman verifikasi phone number (langsung blank page) apabila memilih kode negara selain indonesia, tetapi bisa diatasi dengan
reload page anual >> untuk sebagian besar user akan kesulitan dan tidak mengerti

> [ISSUE] 12. Ketika verifikasi no hp di awal (milih via wa atau sms), maka no hp disensor sebagian, tetapi di verifikasi akhir dan untuk verifikasi nomor dari
negara selain Indonesia, no hp ditunjukan dengan jelas

> [LOW] 13. RGB Color pada saat invalid email di page reset password berbeda dengan halaman lainya, dimana di halaman login dan register user saat terjadi 
invalid input rgb rednya adalah RGB((220, 53, 69), sedangkan di reset password, rgb nya adalah RGB(212, 26, 26) >> sebaiknya dibuat class interface untuk color 
agar seimbang dan sama di setiap halaman.

> [LOW] 14. Placeholder untuk input field email di halaman reset password belum ada, di halaman lain seperti login dan register sudah diterapkan

> [LOW] 15. placeholder untuk field input password dan konfirmasi password belum ada

> [ISSUE] 16. Terdapat 2 halaman dengan fitur yang sama namun berbeda url, yaitu halaman https://flip.id/site/biaya dan https://flip.id/biaya 


> [ISSUE] 17. Terdapat 2 halaman dengan fitur yang sama namun berbeda url, yaitu halaman https://flip.id/site/tutorial dan https://flip.id/tutorial/

> [LOW] 18. Icon brand flip pada halaman https://flipid.zendesk.com/hc/id apabila diklik, tidak ke halaman utama flip

> [ISSUE] 19. URL untuk halaman ‘FAQ’ dan ‘Bantuan’ sama, yaitu https://flipid.zendesk.com/hc/id


## Contributors and Helper
Credit:
> Anjas Muhammad Bangun

Special Thanks:
> Flip ID

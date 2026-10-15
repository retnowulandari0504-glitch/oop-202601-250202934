# Catatan Minggu 01: Paradigma Pemrograman dan Setup

## Yang saya kerjakan
Saya menginstal JDK 21 dan Maven, lalu menyiapkan repo dari template, dan menggunakan mahasiswa, properties saya dengan isi NIM serta nama. Ketiganya menghasilkan teks yang sama persis yaitu "Aset-Pinjam", nama, dan NIM dengan format yang sama. 

## Keputusan desain
Saya memilih kalimat sapaan "Aset-Pinjam | nama | nim",  karena sederhana, memuat tiga unsur yang diuji oleh Minggu01Test, dan mudah dibuat identik di ketiga gaya. Untuk gaya fungsional, saya menggunakan function<String,String> dengan closure yang menangkap nim dari parameter luar sehingga tidak ada state/objek yang berubah.

## Kendala
1. Versi Java di terminal tetap 25 padahal JAVA_HOME sudah diatur ke JDK 21, karena JDK 21 belum terpasang. Saya memasangnya lewat winget, dan sempat gagal (error 1602) karena jendela UAC tidak saya klik "Yes". Setelah dijalankan ulang dan menekan "Yes", instalasi berhasil.
2. Perintah mvn tidak dikenali karena folder bin Maven belum masuk PATH. Saya mencari mvn.cmd, ternyata Maven ada di folder Downloads, lalu mengatur MAVEN_HOME dan PATH.
3. scripts/uji.ps1 diblokir execution policy, saya jalankan dengan powershell -ExecutionPolicy Bypass -File.
4. Kode saya sempat gagal compile karena salah ketik (printiln, statis, retrun, nama konstruktor, kurung kurawal kurang). Saya perbaiki setelah membaca pesan error.

## Penggunaan AI
- Alat yang dipakai: Claude (Anthropic)
- Bagian yang dibantu AI: penyelesaian masalah install JDK 21 dan Maven beserta pengaturan PATH, pencarian salah ketik di HelloProsedural.sapa, HelloOOP.java
- Prompt utama: 
    a. Bagaimana cara mengganti Java ke versi 21? 
    b. Menempelkan format sapaan tidak konsisten, tes mengharapkan Aset-Pinjam | nama |nim
- Yang saya ubah atau tolak dari saran AI, dan alasannya: Saya memakai format sapaan "Aset-Pinjam | nama | NIM" supaya sederhana dan diubah setelah melihat hasil tes
- Satu hal yang saya pahami lebih baik sekarang: perbedaan nyata dan gaya fungsional dan OOP, supaya Java dan Maven tetap bisa dipakai di terminal baru, foldernya harus disimpan sebagai environment variable permanen dan folder bin-nya didaftarkan di PATH.

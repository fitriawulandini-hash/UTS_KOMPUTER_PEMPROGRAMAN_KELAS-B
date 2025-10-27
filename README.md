# Sistem Pemesanan Kamar Hotel (Java) kelompok 14 uts Komputer Pemrograman

Aplikasi console sederhana untuk simulasi pemesanan kamar hotel.

# Studi kasus
Hotel ingin membuat sistem untuk mengelola pemesanan kamar oleh tamu dengan berbagai tipe kamar.

# Anggota Kelompok
1. Fitria Wulandini (G1A025084)
2. ⁠Reyvano Arya Pulunggono (G1A022094)

# Struktur Kelas
- `Kamar`: nomorKamar, tipeKamar, hargaPerMalam, status; `pesanKamar()`, `kosongkanKamar()`
- `Tamu`: nama, durasiMenginap; constructor + getter/setter
- `Hotel`: `daftarKamar`, `cariKamarKosong(tipe)`, `hitungTotalBayar(tamu, kamar)`
- `Main`: simulasi pemesanan dan tampilan status kamar. Mendukung skenario interaktif.

## Overview
Studi kasus sistem pemesanan kamar hotel dalam Java ini mensimulasikan proses pengelolaan kamar menggunakan konsep OOP. Sistem terdiri dari kelas Kamar, Tamu, Hotel, dan Main. Kelas Kamar menyimpan data nomor, tipe, harga, dan status kamar; Tamu menyimpan nama serta durasi menginap; sedangkan Hotel mengelola daftar kamar, mencari kamar kosong, memesan, mengosongkan, dan menghitung total pembayaran. Kelas Main menjadi antarmuka interaktif berbasis konsol yang menampilkan menu untuk simulasi pemesanan dan status kamar. Program ini menekankan penerapan prinsip OOP seperti enkapsulasi dan komposisi dalam konteks manajemen kamar hotel yang sederhana namun fungsional.

## Prasyarat
- Windows + PowerShell
- JDK 21 (Temurin/Oracle). Cek dengan:
```powershell
java -version
javac -version
```
Jika belum ada, install cepat (winget):
```powershell
winget install EclipseAdoptium.Temurin.21.JDK --accept-source-agreements --accept-package-agreements
```

Jika sudah terpasang tetapi belum terdeteksi, set sementara untuk sesi saat ini:
```powershell
$jdk = "C:\Program Files\Eclipse Adoptium\jdk-21.0.8.9-hotspot"
$env:JAVA_HOME = $jdk
$env:Path = "$jdk\bin;$env:Path"
```

## Build & Run
Dari folder proyek (mis. `E:\UTS_PANOK`):
```powershell
mkdir out -Force
javac -d out src\*.java
java -cp out Main
```

## Mode Interaktif (Custom Skenario)
Saat program mulai, Anda akan ditanya apakah ingin menjalankan mode interaktif. Jika memilih `y`, Anda dapat:
- Menentukan jumlah kamar, tiap kamar berisi: nomor (int), tipe (String, mis. Single/Double/Suite), harga per malam (double)
- Menentukan jumlah tamu, tiap tamu berisi: nama (String), durasi menginap (int), tipe kamar yang diinginkan (String)

Program akan:
- Mengisi `Hotel` sesuai input Anda
- Mencari kamar kosong berdasarkan tipe yang diminta (if-else dalam looping)
- Menghitung total bayar = durasiMenginap × hargaPerMalam
- Menampilkan daftar kamar yang masih kosong dan yang sudah dipesan

## Contoh Tipe Kamar
- Single
- Double
- Suite

Anda bisa memakai tipe lain apa pun selama konsisten antara input dan pencarian.

## Troubleshooting
- `javac : The term 'javac' is not recognized` atau `java : The term 'java' is not recognized`
  - Artinya PATH belum berisi folder JDK. Gunakan salah satu opsi di bawah:

### Opsi 1 — Pakai path lengkap (tanpa ubah PATH)
Jalankan dari folder proyek:
```powershell
& "C:\Program Files\Eclipse Adoptium\jdk-21.0.8.9-hotspot\bin\javac.exe" -d out src\*.java
& "C:\Program Files\Eclipse Adoptium\jdk-21.0.8.9-hotspot\bin\java.exe" -cp out Main
```

### Opsi 2 — Set sementara untuk sesi PowerShell saat ini
```powershell
$env:JAVA_HOME = "C:\Program Files\Eclipse Adoptium\jdk-21.0.8.9-hotspot"
$env:Path = "$env:JAVA_HOME\bin;$env:Path"

mkdir out -Force
javac -d out src\*.java
java -cp out Main
```

### Opsi 3 — Set permanen (User PATH), lalu buka terminal baru
```powershell
[Environment]::SetEnvironmentVariable("JAVA_HOME","C:\\Program Files\\Eclipse Adoptium\\jdk-21.0.8.9-hotspot","User")
[Environment]::SetEnvironmentVariable("Path","C:\\Program Files\\Eclipse Adoptium\\jdk-21.0.8.9-hotspot\\bin;" + [Environment]::GetEnvironmentVariable("Path","User"),"User")
```
Tutup PowerShell, buka lagi, lalu verifikasi:
```powershell
java -version
javac -version
```

### Opsi 4 — Deteksi otomatis lokasi JDK
Jika versi/letak berbeda, deteksi otomatis lalu set untuk sesi saat ini:
```powershell
$javac = Get-ChildItem -Recurse -File -Filter javac.exe "C:\Program Files","C:\Program Files (x86)","C:\ProgramData" -ErrorAction SilentlyContinue | Select-Object -First 1 -Expand FullName
$bin = Split-Path $javac
$jdk = Split-Path $bin
$env:JAVA_HOME = $jdk
$env:Path = "$bin;$env:Path"
javac -version
```

### Catatan PowerShell (PSReadLine)
- Menggunakan piping input (mis. `echo Y | java ...`) dapat memicu bug PSReadLine pada beberapa versi. Jalankan `java -cp out Main` tanpa piping, lalu ketik input langsung di prompt program.


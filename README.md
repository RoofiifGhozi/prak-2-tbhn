# Praktikum PAPB - Modul 2

Repository tugas praktikum mata kuliah **Pengembangan Aplikasi Perangkat Bergerak (PAPB)**.  
Topik: **Activity Lifecycle, Composable Layout, dan Modifier**.

---

## Identitas Mahasiswa
- **Nama:** Muhammad Roofiif Ghozi
- **NIM:** 245150200111048

---

## Deskripsi Aplikasi
Aplikasi Android ini dibangun menggunakan **Jetpack Compose** untuk mengimplementasikan:
1. Pengaturan tata letak deklaratif menggunakan `Column`, `Row`, dan `Box`.
2. Penerapan konsep **Modifier Chaining** (urutan pemanggilan modifier yang mempengaruhi hasil render visual).
3. Pemicuan aplikasi eksternal melalui **Implicit Intent**.
4. Pemantauan transisi **Activity Lifecycle** melalui Logcat.

---

## Cara Kerja & Alur Aplikasi

1. **Inisialisasi & Tampilan Utama (`MainActivity.kt`)**
   - Saat aplikasi pertama kali dibuka, sistem memanggil callback `onCreate()`, `onStart()`, dan `onResume()`. Masing-masing mencetak log dengan tag `LIFECYCLE_TEST`.
   - Di dalam method `setContent`, dipanggil composable `HalamanUtama()`.

2. **Komponen Profil Mahasiswa (`ProfilMahasiswa.kt`)**
   - Menampilkan avatar profil dan teks identitas mahasiswa.
   - Menggunakan `Row` yang membungkus komponen avatar di sisi kiri dan kolom teks (Nama & NIM) di sisi kanan.
   - Avatar memanfaatkan `Box` berisikan dua ikon: `Icons.Default.Person` (ikon utama) dan `Icons.Default.Edit` (badge di pojok kanan atas).
   - Menerapkan modifier chaining `.size(48.dp).clip(CircleShape).background(Color.Cyan)` pada ikon person sehingga batas elemen dipotong membulat terlebih dahulu sebelum diwarnai Cyan (*Order Matters*).

3. **Integrasi Intent WhatsApp (`HalamanUtama.kt`)**
   - Menyusun `ProfilMahasiswa`, `Spacer`, dan `Button` secara vertikal di tengah layar menggunakan layout `Column`.
   - Tombol **"Hubungi via WhatsApp"** memiliki aksi `onClick` yang memicu `Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/..."))`.
   - Jika aplikasi dijalankan di perangkat fisik yang memiliki WhatsApp, tautan langsung diarahkan ke aplikasi WhatsApp. Jika di emulator tanpa WhatsApp, sistem otomatis membukanya melalui Google Chrome.

4. **Observasi Activity Lifecycle (Logcat)**
   - Saat tombol WhatsApp diklik dan aplikasi WhatsApp/Chrome terbuka di layar:
     - Aplikasi kita kehilangan fokus dan masuk ke latar belakang.
     - Callback `onPause()` dan `onStop()` dieksekusi secara berurutan.
   - Saat pengguna menekan tombol **Back** untuk kembali ke aplikasi:
     - Callback `onStart()` dan `onResume()` kembali dipanggil, menandakan Activity kembali aktif di latar depan (*foreground*).

---

## Struktur File Utama

```text
app/src/main/java/com/example/android_prak_2/
├── MainActivity.kt        # Entry point aplikasi & override callback lifecycle
├── HalamanUtama.kt        # Layout utama aplikasi & handler Intent WhatsApp
├── ProfilMahasiswa.kt     # Composable avatar profil (Modifier Chaining) & identitas
└── ContactUsScreen.kt     # Komponen halaman bantuan praktikum
```

---

## Cara Menjalankan

1. Clone repositori ini:
   ```bash
   git clone https://github.com/RoofiifGhozi/prak-2-tbhn.git
   ```
2. Buka folder proyek di **Android Studio**.
3. Tunggu proses **Gradle Sync** hingga selesai.
4. Pilih target emulator atau perangkat fisik (USB Debugging).
5. Klik **Run 'app'** (`Shift + F10`).
6. Untuk memantau siklus hidup, buka jendela **Logcat** dan ketik filter pencarian:
   ```text
   tag:LIFECYCLE_TEST
   ```

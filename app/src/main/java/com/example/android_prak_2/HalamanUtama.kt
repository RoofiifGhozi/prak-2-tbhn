package com.example.android_prak_2

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HalamanUtama() {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // ProfilMahasiswa dari Praktikum 2 dengan ikon profil lingkaran
        ProfilMahasiswa(
            modifier = Modifier.padding(16.dp)
        )

        // Spacer untuk memberi jarak antar komponen
        Spacer(modifier = Modifier.height(16.dp))

        // Tombol Intent WhatsApp dari Praktikum 1
        Button(
            onClick = {
                val url = "https://wa.me/6281234567890"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                context.startActivity(intent)
            }
        ) {
            Text("Hubungi via WhatsApp")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHalamanUtama() {
    HalamanUtama()
}

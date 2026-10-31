package com.example.statelist.feature.produk

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.statelist.data.model.Produk
import com.example.statelist.ui.theme.StateListTheme

@Composable
fun ItemProdukCard(
    produk: Produk,
    onDeleteClick: () -> Unit = {}, // Callback State Hoisting untuk Event Hapus
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Informasi Produk
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = produk.nama,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Harga: Rp ${produk.harga}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            // Tombol Hapus Data (Soal Latihan)
            IconButton(onClick = onDeleteClick) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Hapus Produk",
                    tint = MaterialTheme.colorScheme.error
                )
            }
        }
    }
}

@Preview(name = "Light Mode - Item Card", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "Dark Mode - Item Card", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ItemProdukCardPreview() {
    StateListTheme {
        Surface {
            ItemProdukCard(
                produk = Produk(id = 1, nama = "Mouse Wireless", harga = 150000)
            )
        }
    }
}
package com.dicoding.picodiploma.loginwithanimation.ui.view.history

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dicoding.picodiploma.loginwithanimation.R
import com.dicoding.picodiploma.loginwithanimation.ui.theme.LightYellow

@Composable
fun HistoryScreen(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
    ) {
        BannerHistory()
        HistoryCard()
        HistoryCard()
        HistoryCard()
    }
}

@Composable
fun BannerHistory(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(R.drawable.image_banner_history),
            contentDescription = "Banner Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
        )
        Text(
            text = "Riwayat Transaksi",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun HistoryCard(modifier: Modifier = Modifier) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        ),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 20.dp)
    ) {
        Column(modifier = modifier.padding(10.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth().padding(bottom = 10.dp), verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(8.dp))
                Image(
                    painter = painterResource(R.drawable.empty_expression),
                    contentDescription = "Banner Image",
                    modifier = Modifier.size(45.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column(Modifier.weight(1f)) {
                    Text(
                        text = "Ayu Wardani M.Psi",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    Row(modifier = modifier.padding(top = 5.dp, end = 10.dp)) {
                        Image(
                            painter = painterResource(R.drawable.ic_baseline_calendar),
                            contentDescription = "Banner Image",
                        )
                        Text(
                            text = "14 Jun 2023",
                            fontSize = 10.sp,
                        )
                        Spacer(modifier = Modifier.width(20.dp))
                        Image(
                            painter = painterResource(R.drawable.ic_baseline_clock),
                            contentDescription = "Banner Image",
                        )
                        Text(
                            text = "19.00 - 20.00",
                            fontSize = 10.sp,
                        )
                    }
                    TagLine(modifier, "Manajemen Waktu")
                }
            }
            ButtonHistory()
        }
    }
}

@Composable
fun TagLine(modifier: Modifier = Modifier, tagLine: String) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = LightYellow
        ),
        shape = RoundedCornerShape(30.dp),
        modifier = Modifier
            .height(20.dp)
            .width(95.dp)
            .padding(top = 5.dp)
    ) {
        Box(modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center) {
            Text(
                text = tagLine,
                fontSize = 10.sp,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

@Composable
fun ButtonHistory(modifier: Modifier = Modifier) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = LightYellow
        ),
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .height(50.dp)
    ) {
        Box(modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center) {
            Text(
                text = "Konsultasi Lagi",
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun ButtonHistoryPreview() {
    ButtonHistory()
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun HistoryCardPreview() {
    HistoryCard()
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun JetCoffeeAppPreview() {
    HistoryScreen()
}
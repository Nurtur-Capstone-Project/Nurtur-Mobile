package com.dicoding.picodiploma.loginwithanimation.ui.view.consultation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dicoding.picodiploma.loginwithanimation.R
import com.dicoding.picodiploma.loginwithanimation.ui.theme.PrimaryColor
import com.dicoding.picodiploma.loginwithanimation.widget.CustomButton

@Composable
fun ConsultationReservationScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        TopSection()
        SectionText("Pilih Tanggal")
        DateColumn()
        SectionText("Pilih Waktu (durasi 1 jam)")
        TimeColumn()
        SectionText("Metode")
        MethodColumn()
    }
}

@Composable
fun DateColumn() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        DateRow()
        DateRow()
        DateRow()
        DateRow()
    }
}

@Composable
fun TimeColumn() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TimeRow()
        TimeRow()
        TimeRow()
    }
}

@Composable
fun MethodColumn() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        MethodRow()
        CustomButton(
            Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            "Selanjutnya",
            PrimaryColor
        )
    }
}

@Composable
fun TopSection(modifier: Modifier = Modifier) {
    Box(modifier = Modifier
        .padding(horizontal = 16.dp, vertical = 8.dp)){
        Image(
            painter = painterResource(R.drawable.ic_baseline_arrow_back_24),
            contentDescription = "Banner Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.requiredSize(24.dp).fillMaxWidth()
        )
        Row(
            horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()
        ) {
//        Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Buat Appointment",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
            )

        }
    }
}

@Composable
fun SectionText(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.headlineSmall.copy(
            fontWeight = FontWeight.ExtraBold,
            fontSize = 16.sp,
        ),
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
    )
}

@Composable
fun DateRow(
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        DateCard()
        DateCard()
    }
}

@Composable
fun DateCard(modifier: Modifier = Modifier) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        ),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(10.dp)
            .height(52.dp)
            .width(167.dp)
    ) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Senin, 12 Juni 2023",
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
fun TimeCard() {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        ),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(10.dp)
            .height(52.dp)
            .width(106.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "09.00 WIB",
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
fun TimeRow(
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        TimeCard()
        TimeCard()
        TimeCard()
    }
}

@Composable
fun MethodCard(title: String) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        ),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(10.dp)
            .height(52.dp)
            .width(167.dp)
    ) {
        Row(
            modifier = Modifier.padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.ic_baseline_clock),
                contentDescription = null,
                modifier = Modifier
                    .padding(10.dp)
                    .requiredSize(30.dp)
                    .clip(CircleShape)
            )
            Text(
                text = title,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
fun MethodRow(
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        MethodCard("Chat")
        MethodCard("Telepon")
    }
}

@Composable
@Preview(showBackground = true)
fun DateCardPreview() {
    DateCard()
}

@Composable
@Preview(showBackground = true)
fun MethodCardPreview() {
    MethodCard("Chat")
}

@Composable
@Preview(showBackground = true)
fun ConsultationReservationScreenPreview() {
    ConsultationReservationScreen()
}
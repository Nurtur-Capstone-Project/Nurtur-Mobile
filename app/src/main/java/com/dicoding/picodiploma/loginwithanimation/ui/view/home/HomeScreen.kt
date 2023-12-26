package com.dicoding.picodiploma.loginwithanimation.ui.view.home

import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dicoding.picodiploma.loginwithanimation.R
import coil.compose.AsyncImage
import com.dicoding.picodiploma.loginwithanimation.data.Article
import com.dicoding.picodiploma.loginwithanimation.data.MenuConsultationData
import com.dicoding.picodiploma.loginwithanimation.data.databaseDailyMood.HistoryDailyMood
import com.dicoding.picodiploma.loginwithanimation.data.pref.MenuConsultationModel
import com.dicoding.picodiploma.loginwithanimation.ui.theme.BlueKids
import com.dicoding.picodiploma.loginwithanimation.ui.theme.LightYellow
import com.dicoding.picodiploma.loginwithanimation.ui.theme.PinkFamily
import com.dicoding.picodiploma.loginwithanimation.ui.theme.PurpleimeManagement
import com.dicoding.picodiploma.loginwithanimation.ui.theme.YellowEmotion
import com.dicoding.picodiploma.loginwithanimation.ui.theme.PrimaryColor
import com.dicoding.picodiploma.loginwithanimation.ui.theme.YellowArrow
import com.dicoding.picodiploma.loginwithanimation.ui.theme.BlueArrow
import com.dicoding.picodiploma.loginwithanimation.ui.theme.PinkArrow
import com.dicoding.picodiploma.loginwithanimation.ui.view.article.ArticleScreen
import com.dicoding.picodiploma.loginwithanimation.ui.view.article.ArticleViewModel
import com.dicoding.picodiploma.loginwithanimation.ui.view.changePassword.ChangePasswordActivity
import com.dicoding.picodiploma.loginwithanimation.ui.view.dailyMood.DailyMoodViewModel
import com.dicoding.picodiploma.loginwithanimation.ui.view.dailyMood.UploadFaceMoodActivity
import com.dicoding.picodiploma.loginwithanimation.ui.view.main.MainViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(
    mainViewModel: MainViewModel,
    resultDailyMoodViewModel: DailyMoodViewModel,
    navigateToConsultation: (Int) -> Unit,
    navigateToArticle: (Int) -> Unit,
    navigateToDetail: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val data = resultDailyMoodViewModel.getDailyToday.observeAsState()
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding()
    ) {
        BannerHome(mainViewModel, navigateToConsultation, navigateToArticle, navigateToDetail, data?.value)
    }

}

@Composable
fun BannerHome(
    mainViewModel: MainViewModel,
    navigateToConsultation: (Int) -> Unit,
    navigateToArticle: (Int) -> Unit,
    navigateToDetail: (Int) -> Unit,
    dataToday: HistoryDailyMood?,
    modifier: Modifier = Modifier
) {
    val articleViewModel: ArticleViewModel = ArticleViewModel()
    val currentUser = mainViewModel.currentUser.observeAsState()

    Box(modifier = modifier) {
        Image(
            painter = painterResource(R.drawable.image_banner_home_article),
            contentDescription = "Banner Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
        )
//        Search()
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(20.dp)
        ) {
            TopSection(currentUser.value?.message?.name ?: "-")
            DailyMoodSection(dataToday)
            ConsultationSection(Modifier.clickable { navigateToConsultation(0) })
            TitleSection("Konsultasi", "Lihat Semua", navigateToConsultation)

            LazyRow(
                contentPadding = PaddingValues(horizontal = 10.dp)
            ) {
                items(MenuConsultationData.consultations, key = { it.id }) { consultation ->
                    MenuConsultation(
                        modifier,
                        consultation.cardColor,
                        consultation.arrowColor,
                        painterResource(consultation.icon),
                        consultation.name
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                }
            }
            TitleSection("Artikel terbaru", "Lihat Semua", navigateToArticle)
            LazyRow(
                contentPadding = PaddingValues(horizontal = 10.dp)
            ) {
                items(articleViewModel.articles, key = { it.id }) { article ->
                    MenuArticle(article, navigateToDetail)
                    Spacer(modifier = Modifier.width(10.dp))
                }
            }
        }
    }
}

@Composable
fun TopSection(name: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(Modifier.weight(1f)) {
            Text(
                text = "Hai ibu hebat,"
            )
            Text(
                text = name,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
            )
        }
        Image(
            painter = painterResource(R.drawable.ic_baseline_notifications_24),
            contentDescription = "Banner Image",
        )
        AsyncImage(
            model = "https://cdn1-production-images-kly.akamaized.net/BKIJ0cG2lP0STNO9Wo6q9TLH-14=/1200x675/smart/filters:quality(75):strip_icc():format(jpeg)/kly-media-production/medias/3347268/original/062679200_1610453928-KOMENG.jpg",
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(30.dp)
                .clip(CircleShape)
        )
    }
}

@Composable
fun DailyMoodSection(dataToday: HistoryDailyMood?) {
    val context = LocalContext.current

    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        ),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(top = 20.dp)
            .clickable {
                context.startActivity(
                    Intent(context, UploadFaceMoodActivity::class.java)
                )
            }
    ) {
        Row(
            modifier = Modifier
                .height(52.dp)
                .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(8.dp))
            if(dataToday != null){
                if(dataToday.hasil == "Mood Baik"){
                    Image(
                        painter = painterResource(R.drawable.happy_reaction),
                        contentDescription = "Banner Image",
                        modifier = Modifier.size(45.dp)
                    )
                }
                else if(dataToday.hasil == "Mood Sedang"){
                    Image(
                        painter = painterResource(R.drawable.flat_reaction),
                        contentDescription = "Banner Image",
                        modifier = Modifier.size(45.dp)
                    )
                }
                else{
                    Image(
                        painter = painterResource(R.drawable.angry_reaction),
                        contentDescription = "Banner Image",
                        modifier = Modifier.size(45.dp)
                    )
                }

            }
            else{
                Image(
                    painter = painterResource(R.drawable.empty_expression),
                    contentDescription = "Banner Image",
                    modifier = Modifier.size(45.dp)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column(Modifier.weight(1f)) {
                Text(
                    text = "Anda telah mengisi",
                    fontSize = 14.sp,
                )
                Text(
                    text = "Mood Buruk",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
            Spacer(modifier = Modifier.width(50.dp))
            Image(
                painter = painterResource(R.drawable.ic_baseline_arrow_forward_24),
                contentDescription = "Banner Image",
                colorFilter = ColorFilter.tint(color = Color.Gray),
            )
        }
    }
}

@Composable
fun TitleSection(name: String, action: String, navigate: (Int) -> Unit) {
    Row(
        modifier = Modifier
            .padding(top = 40.dp)
    ) {
        Text(
            text = name,
            fontSize = 14.sp,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = action,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = PrimaryColor,
            modifier = Modifier.clickable { navigate(0) }
        )
    }
}

@Composable
fun ConsultationSection(modifier: Modifier) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = LightYellow
        ),
        shape = RoundedCornerShape(8.dp),
        modifier = modifier.padding(top = 20.dp)
    ) {
        Row(
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(8.dp))
            Image(
                painter = painterResource(R.drawable.image_consultation_home_section),
                contentDescription = "Banner Image",
                modifier = Modifier.size(60.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(Modifier.weight(1f)) {
                Text(
                    text = "Butuh teman cerita?",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = "Tenang, kamu gak sendirian kok. Ada kami yang siap mendengar ceritamu.",
                    fontSize = 14.sp,
                    maxLines = 3,
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Image(
                painter = painterResource(R.drawable.ic_baseline_arrow_forward_24),
                contentDescription = "Banner Image",
                colorFilter = ColorFilter.tint(color = Color.Gray),
            )
        }
    }
}

@Composable
fun MenuConsultation(
    modifier: Modifier = Modifier,
    cardColor: Color,
    arrowColor: Color,
    icon: Painter,
    name: String?
) {
    ElevatedCard(
        modifier = modifier
            .padding(top = 20.dp)
            .width(160.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = cardColor
        ),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier.padding(10.dp)) {

            Column(Modifier.weight(1f)) {
                Image(
                    painter = icon,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(50.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = name ?: "-",
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.ExtraBold
                    ),
                )
            }
            Image(
                painter = painterResource(R.drawable.arrow_consultation_menu),
                contentDescription = "Banner Image",
                colorFilter = ColorFilter.tint(color = arrowColor),
                modifier = modifier.size(30.dp)
            )
        }
    }
}

@Composable
fun MenuArticle(
    article: Article,
    navigateToDetail: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    ElevatedCard(
        modifier = modifier
            .width(260.dp)
            .clickable { navigateToDetail(article.id) },
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background,
        ),
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            AsyncImage(
                model = article.thumbnail,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Text(
                text = article.title,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.ExtraBold
                ),
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
    }
}

@Composable
@Preview(showBackground = true)
fun MenuArticlePreview() {
    MaterialTheme {
//        MenuArticle(
//            modifier = Modifier.padding(8.dp)
//        )
    }
}

@Composable
@Preview(showBackground = true)
fun MenuConsultationPreview() {
    MaterialTheme {
        MenuConsultation(
            modifier = Modifier.padding(8.dp),
            PurpleimeManagement,
            PrimaryColor,
            painterResource(R.drawable.clock_consultation_menu),
            "Manajemen Waktu"
        )
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun DailyMoodSectionPreview() {
//    DailyMoodSection()
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun ConsultationSectionPreview() {
    ConsultationSection(Modifier)
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun JetCoffeeAppPreview() {
//    HomeScreen()
}
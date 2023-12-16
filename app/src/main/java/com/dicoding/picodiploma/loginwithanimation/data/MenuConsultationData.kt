package com.dicoding.picodiploma.loginwithanimation.data

import android.media.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.dicoding.picodiploma.loginwithanimation.R
import com.dicoding.picodiploma.loginwithanimation.ui.theme.BlueArrow
import com.dicoding.picodiploma.loginwithanimation.ui.theme.BlueKids
import com.dicoding.picodiploma.loginwithanimation.ui.theme.PinkArrow
import com.dicoding.picodiploma.loginwithanimation.ui.theme.PinkFamily
import com.dicoding.picodiploma.loginwithanimation.ui.theme.PrimaryColor
import com.dicoding.picodiploma.loginwithanimation.ui.theme.PurpleimeManagement
import com.dicoding.picodiploma.loginwithanimation.ui.theme.YellowArrow
import com.dicoding.picodiploma.loginwithanimation.ui.theme.YellowEmotion

object MenuConsultationData {
    val consultations = listOf(
        MenuConsultation(
            1,
            PurpleimeManagement,
            PrimaryColor,
            R.drawable.clock_consultation_menu,
            "Manajemen Waktu"
        ),
        MenuConsultation(
            2,
            YellowEmotion,
            YellowArrow,
            R.drawable.emotion_consultation_menu,
            "Emosi dan Pikiran"
        ),
        MenuConsultation(
            3,
            BlueKids,
            BlueArrow,
            R.drawable.child_consultation_menu,
            "Mengasuh Anak"
        ),
        MenuConsultation(
            4,
            PinkFamily,
            PinkArrow,
            R.drawable.family_consultation_menu,
            "Masalah Keluarga"
        )
    )
}
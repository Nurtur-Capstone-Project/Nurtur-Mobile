package com.dicoding.picodiploma.loginwithanimation.ui.view.article

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.picodiploma.loginwithanimation.data.Article
import com.dicoding.picodiploma.loginwithanimation.data.ArticleData

class ArticleViewModel() : ViewModel() {

    val articles = ArticleData.articles
}
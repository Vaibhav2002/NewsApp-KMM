package dev.vaibhav.newsapp.android.presentation.screens.navigation

import android.net.Uri
import dev.vaibhav.newsapp.android.util.fromHtml
import dev.vaibhav.newsapp.domain.models.Article
import dev.vaibhav.newsapp.utils.serialize.JsonSerializer

sealed class Screens(val route: String) {
    object Home : Screens("homeScreen")

    object ArticleDetail : Screens("articleDetail/{article}") {
        const val articleArg = "article"

        fun createRoute(article: Article): String {
            return article.copy(
                content = article.content.fromHtml(),
                description = article.content.fromHtml()
            ).let {
                route.replace("{$articleArg}", Uri.encode(JsonSerializer.serialize(it)))
            }
        }
    }

    object SavedArticles : Screens("savedArticles")

    object Search : Screens("searchScreen")
}

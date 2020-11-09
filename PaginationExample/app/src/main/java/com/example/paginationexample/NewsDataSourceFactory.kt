package com.example.paginationexample

import androidx.lifecycle.MutableLiveData
import io.reactivex.disposables.CompositeDisposable
import javax.sql.DataSource

class NewsDataSourceFactory(
    private val compositeDisposable: CompositeDisposable,
    private val networkService: NetworkService)
    : DataSource.Factory<Int, News>() {

    val newsDataSourceLiveData = MutableLiveData<NewsDataSource>()

    override fun create(): DataSource<Int, News> {
        val newsDataSource = NewsDataSource(networkService, compositeDisposable)
        newsDataSourceLiveData.postValue(newsDataSource)
        return newsDataSource
    }
}
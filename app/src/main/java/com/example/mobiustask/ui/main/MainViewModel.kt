package com.example.mobiustask.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mobiustask.model.DataModel
import com.example.mobiustask.networking.NewsRepository

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private var mutableLiveData: MutableLiveData<DataModel>? = null
    private var newsRepository: NewsRepository? = null

    fun init() {
        if (mutableLiveData != null) {
            return
        }
        newsRepository = NewsRepository.getInstance()
        mutableLiveData = newsRepository!!.getNews()

    }

    fun getNewsRepository(): LiveData<DataModel>? {
        return mutableLiveData
    }

}

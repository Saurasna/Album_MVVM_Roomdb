package com.myalbum.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.myalbum.data.AlbumRepository
import com.myalbum.data.AlbumModel

class AlbumViewModel(application: Application): AndroidViewModel(application){

    private var albumRepository: AlbumRepository?=null
    var albumModelListLiveData : LiveData<List<AlbumModel>>?=null

    init {
        albumRepository = AlbumRepository()
        albumModelListLiveData = MutableLiveData()
    }

    fun fetchAllPosts(){
        albumModelListLiveData = albumRepository?.fetchAllPosts()
    }

}
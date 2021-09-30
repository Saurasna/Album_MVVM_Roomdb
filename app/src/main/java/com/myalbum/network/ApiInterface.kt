package com.myalbum.network

import com.myalbum.data.AlbumModel
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    @GET("albums")
    fun fetchAllPosts(): Call<List<AlbumModel>>

}
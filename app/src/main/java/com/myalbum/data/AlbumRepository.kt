package com.myalbum.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.myalbum.network.ApiClient
import com.myalbum.network.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AlbumRepository {

    private var apiInterface: ApiInterface?=null

    init {
        apiInterface = ApiClient.getApiClient().create(ApiInterface::class.java)
    }

    fun fetchAllPosts():LiveData<List<AlbumModel>>{
        val data = MutableLiveData<List<AlbumModel>>()

        apiInterface?.fetchAllPosts()?.enqueue(object : Callback<List<AlbumModel>>{

            override fun onFailure(call: Call<List<AlbumModel>>, t: Throwable) {
                data.value = null
            }

            override fun onResponse(
                call: Call<List<AlbumModel>>,
                response: Response<List<AlbumModel>>
            ) {

                val res = response.body()
                if (response.code() == 200 &&  res!=null){
                    data.value = sortAlphabetically(res)
                }else{
                    data.value = null
                }

            }
        })

        return data

    }

    fun sortAlphabetically(arrayList: List<AlbumModel>?): ArrayList<AlbumModel>{
        var returnList: ArrayList<AlbumModel> = arrayListOf()
        var list = arrayList as MutableList<AlbumModel>
        list.sortWith(Comparator { o1: AlbumModel, o2: AlbumModel ->
            o1.title!!.compareTo(o2.title!!)
        })
        returnList = list as ArrayList< AlbumModel >
        return returnList
    }

}
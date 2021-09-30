package com.myalbum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.myalbum.data.AlbumModel
import com.myalbum.view.AlbumAdapter
import com.myalbum.viewmodel.AlbumViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"


    private lateinit var vm:AlbumViewModel
    private lateinit var adapter: AlbumAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vm = ViewModelProvider(this)[AlbumViewModel::class.java]
        initAdapter()

        vm.fetchAllPosts()

        vm.albumModelListLiveData?.observe(this, Observer {
            if (it!=null){
                recyclerview.visibility = View.VISIBLE
                adapter.setData(it as ArrayList<AlbumModel>)
            }else{
                showToast("Something went wrong")
            }
            progress_home.visibility = View.GONE
        })
    }



    private fun initAdapter() {
        adapter = AlbumAdapter()
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = adapter
    }


    private fun showToast(msg:String){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }


}
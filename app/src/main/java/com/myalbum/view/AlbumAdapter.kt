package com.myalbum.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myalbum.R
import com.myalbum.data.AlbumModel
import kotlinx.android.synthetic.main.adapter_album.view.*

class AlbumAdapter() : RecyclerView.Adapter<AlbumAdapter.HomeViewHolder>(){

    private var data : ArrayList<AlbumModel>?=null
    fun setData(list: ArrayList<AlbumModel>){
        data = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_album, parent, false))
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val item = data?.get(position)
        holder.bindView(item)
    }

    class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindView(item: AlbumModel?) {
            itemView.tv_title.text = item?.title
        }

    }

}
package com.myalbum.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.myalbum.data.db.entities.Post

@Dao
interface AlbumDao{
    @Query("SELECT * FROM post")
    fun getPosts() : LiveData<List<Post>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addPost(post : Post)

}
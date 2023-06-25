package com.example.myapplication.data.myscreen.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.data.myscreen.cache.model.MyScreenEntity

@Dao
interface MyScreenDao {

    @Query("SELECT * FROM MyScreen WHERE id = :screenId")
    suspend fun getScreenById(screenId: Long): MyScreenEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertScreen(myScreenEntity: MyScreenEntity): Long
}

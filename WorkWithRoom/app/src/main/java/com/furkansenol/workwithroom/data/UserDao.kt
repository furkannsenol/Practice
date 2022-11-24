package com.furkansenol.workwithroom.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.furkansenol.workwithroom.model.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user_table ORDER BY id ASC")
     fun readAllData():LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.IGNORE) //user yoksa işlemi iptal ediyoruz
    suspend fun addUser(user: User)

    //@Query("SELECT * FROM user_table WHERE id= :userId")
    //suspend fun getUser(userId:Int):User

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("DELETE FROM user_table")
    suspend fun deleteAllUsers()

}
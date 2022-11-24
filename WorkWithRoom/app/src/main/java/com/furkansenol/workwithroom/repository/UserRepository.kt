package com.furkansenol.workwithroom.repository

import androidx.lifecycle.LiveData
import com.furkansenol.workwithroom.model.User
import com.furkansenol.workwithroom.data.UserDao

class UserRepository(private val userDao: UserDao) {

    //Havuz sınıfı, birden çok veri kaynağına erişimi soyutlar
    //ViewModel'de kullanmak için aradaki bağlantı görevini sağlıyor

    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }

    suspend fun updateUser(user: User){
        userDao.updateUser(user)
    }

    suspend fun deleteUser(user: User){
        userDao.deleteUser(user)
    }

    suspend fun deleteAllUsers(){
        userDao.deleteAllUsers()
    }

}
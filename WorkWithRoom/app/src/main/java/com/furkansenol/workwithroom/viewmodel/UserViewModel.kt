package com.furkansenol.workwithroom.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.furkansenol.workwithroom.model.User
import com.furkansenol.workwithroom.data.UserDatabase
import com.furkansenol.workwithroom.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {
    // Kullanıcı arayüzüne veri sağlamak ve yapılandırma değişikliklerinden sağ çıkmaktır.
    // Havuz ve Kullanıcı arabirimi arasında bir iletişim merkezi görevi görür

    val readAllData: LiveData<List<User>>
    private val repository: UserRepository

    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository= UserRepository(userDao)
        readAllData=repository.readAllData
    }

    fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO) { //Asenkron işlemler
            repository.addUser(user)
        }
    }

    fun updateUser(user:User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateUser(user)
        }
    }

    fun deleteUser(user:User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteUser(user)
        }
    }

    fun deleteAllUsers(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllUsers()
        }
    }
}
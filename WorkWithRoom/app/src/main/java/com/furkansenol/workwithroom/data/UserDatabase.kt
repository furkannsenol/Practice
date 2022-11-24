package com.furkansenol.workwithroom.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.furkansenol.workwithroom.model.User

@Database(
    entities = [User::class],
    version = 1,
    exportSchema = false
)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    //Singleton

    companion object { //Kotlin'de bir sınıfın bütün instance'larının otomatik olarak sahip olacağı tek bir nesne tanımlamak için
        @Volatile //thread açar olası bir hata durumunda projenin çökmesine engel olur
        private var INSTANCE: UserDatabase? = null //UserDatabase sınıfından türetilen nesnedir

        fun getDatabase(context: Context): UserDatabase {

            var tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
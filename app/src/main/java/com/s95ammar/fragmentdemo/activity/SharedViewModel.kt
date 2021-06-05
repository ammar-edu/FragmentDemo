package com.s95ammar.fragmentdemo.activity

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.s95ammar.fragmentdemo.models.User

class SharedViewModel : ViewModel() {

    private val _user = MutableLiveData<User>()

    val user: LiveData<User> = _user

    init {
        _user.value = User("Vlad", 25)
        Log.d("SharedViewModel", "init")
    }

    fun setUserData(name: String, age: String) {
        // validate input
        _user.value = User(name, age.toInt())
    }
}